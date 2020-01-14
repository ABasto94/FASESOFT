package com.fasesoft.tests.ejb.manejadores;

import static com.fasesoft.modelo.entidades.FasPerfiles.ENTIDAD_FAS_PERFILES_PK;
import static com.fasesoft.modelo.entidades.FasPerfiles.ENTIDAD_FAS_PERFILES_TIPO;
import static com.fasesoft.modelo.utils.UtilOperaciones.convertirListaObjetosAString;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.fasesoft.modelo.entidades.FasPerfiles;
import com.fasesoft.modelo.enums.FuncionAgrupamientoJPQL;
import com.fasesoft.modelo.enums.TipoFiltro;
import com.fasesoft.modelo.enums.TipoOrdenamiento;
import com.fasesoft.modelo.manejadores.ManejadorFasPerfiles;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionAsignacion;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.InformacionOrdenamiento;
import com.fasesoft.modelo.manejadores.utils.ManejadorPersistencia;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.utils.UtilConstantes;
import com.fasesoft.tests.ejb.excepciones.TestException;

import junit.framework.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de los métodos expuestos por el ManejadorFasPerfiles
 *
 * @author GeneradorCRUD
 */
@RunWith(Arquillian.class)
public class ManejadorFasPerfilesTest {

	public static final String DEPLOY = "Prueba";
	// Debe ser mayor o igual a 2
	private static final int REGISTROS_A_CREAR = 10;

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ManejadorFasPerfilesTest.class.getName());

	// Arreglo con los posibles valores de descripción fijos a insertar en el
	// atributo descripción para la prueba de consultaLista
	private static final String[] VALORES_TIPO = { "Descripcion1", "Descripcion2", "Descripcion3" };

	@Inject
	private ManejadorFasPerfiles manejador;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	// Generador de datos Podam que usa el default Random Data Provider Strategy
	private final PodamFactory factory = new PodamFactoryImpl();

	// Lista de instancias de FasPerfiles generadas aleatoriamente por PODAM
	private final List<FasPerfiles> data = new ArrayList<>();

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar").addPackage(ManejadorFasPerfiles.class.getPackage())
				.addPackage(ManejadorPersistencia.class.getPackage()).addPackage(FasPerfiles.class.getPackage())
				.addPackage(UtilConstantes.class.getPackage()).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource(
						new FileAsset(new File("src/test/resources/META-INF/test-derby-persistence.xml")),
						"persistence.xml");
	}

	@Before
	public void configTest() throws Exception {
		logger.debug("Configurando Test " + ManejadorFasPerfilesTest.class.getName());
		clearData();
		insertData();
		startTransaction();
	}

	@After
	public void commitTransaction() throws Exception {
		utx.commit();
	}

	@Test
	public void buscarObjectTest() {
		FasPerfiles entidad = data.get(0);
		FasPerfiles entidadConsultada = manejador.buscar(entidad.getIdPerfil());

		Assert.assertEquals(entidad, entidadConsultada);
	}

	@Test
	public void eliminarTest() {
		FasPerfiles entidad = data.get(0);
		manejador.eliminar(entidad);
		FasPerfiles deleted = em.find(FasPerfiles.class, entidad.getIdPerfil());

		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorIdTest() {
		FasPerfiles entidad = data.get(0);
		manejador.eliminarPorId(entidad.getIdPerfil());
		FasPerfiles deleted = em.find(FasPerfiles.class, entidad.getIdPerfil());
		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorFiltroTest() {
		FasPerfiles entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERFILES_PK, entidad.getIdPerfil(),
				ENTIDAD_FAS_PERFILES_PK));
		manejador.eliminarPorFiltro(filtros);
		FasPerfiles deleted = em.find(FasPerfiles.class, entidad.getIdPerfil());
		Assert.assertNull(deleted);
	}

	@Test
	public void crearTest() {
		FasPerfiles entidad = generarFasPerfiles();
		manejador.crear(entidad);
		FasPerfiles creada = em.find(FasPerfiles.class, entidad.getIdPerfil());
		Assert.assertNotNull(creada);
	}

	@Test
	public void actualizarTest() {
		FasPerfiles entidad = data.get(0);
		Integer idEntidad = entidad.getIdPerfil();
		FasPerfiles entidad2 = data.get(1);
		copiarPropiedades(entidad, entidad2);
		entidad.setIdPerfil(idEntidad);
		manejador.actualizar(entidad);
		FasPerfiles entidadDB = em.find(FasPerfiles.class, idEntidad);
		Assert.assertEquals(entidadDB, entidad);
	}

	@Test
	public void actualizarPorFiltrosTest() {

		// Entidad (1) a actualizar
		FasPerfiles entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERFILES_PK, entidad.getIdPerfil(),
				ENTIDAD_FAS_PERFILES_PK));

		// Entidad con los valores a setear en la entidad (1)
		FasPerfiles entidad2 = data.get(1);
		List<InformacionAsignacion> asignaciones = new ArrayList<>();
		asignaciones.add(new InformacionAsignacion(ENTIDAD_FAS_PERFILES_TIPO, entidad2.getTipo()));

		manejador.actualizarPorFiltros(asignaciones, filtros);

		FasPerfiles entidadActualizada = em.find(FasPerfiles.class, entidad.getIdPerfil());

		Assert.assertEquals(entidadActualizada.getTipo(), entidad2.getTipo());
	}

	@Test
	public void consultarTodosTest() {
		List<FasPerfiles> listaConsulta = manejador.consultar(null, null, null);

		Assert.assertEquals(listaConsulta.size(), data.size());
		for (FasPerfiles instancia : listaConsulta) {
			if (!data.contains(instancia)) {
				Assert.fail("Se consulto un elemento que no estaba en la base de datos");
			}
		}

	}

	@Test
	public void consultarConFiltroPKTest() {
		FasPerfiles entidad = data.get(0);

		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERFILES_PK, entidad.getIdPerfil(),
				ENTIDAD_FAS_PERFILES_PK));
		List<FasPerfiles> listaConsulta = manejador.consultar(filtros, null, null);

		Assert.assertEquals(entidad, listaConsulta.get(0));
	}

	@Test
	public void consultarConDosFiltrosTest() {

		/**
		 * Este método se genero vacío porque no se requiere que la entidad tenga por lo
		 * menos dos atributos simples. (Aquellos no que hacen parte del PK ni de las
		 * relaciones de la entidad)
		 */
	}

	@Test
	public void consultarConOrdenamientoTest() {
		List<FasPerfiles> listaOrdenada = data;
		Collections.sort(listaOrdenada, new TipoComparator());

		List<InformacionOrdenamiento> ordenamiento = new ArrayList<>();
		ordenamiento.add(new InformacionOrdenamiento(TipoOrdenamiento.ASCENDENTE, ENTIDAD_FAS_PERFILES_TIPO));

		List<FasPerfiles> listaConsulta = manejador.consultar(null, ordenamiento, null);

		Assert.assertEquals(listaConsulta, listaOrdenada);
	}

	@Test
	public void consultarConRangoTest() {
		RangoConsulta rango = new RangoConsulta(0, REGISTROS_A_CREAR - 2);

		List<FasPerfiles> listaConsulta = manejador.consultar(null, null, rango);

		Assert.assertEquals(REGISTROS_A_CREAR - 1, listaConsulta.size());
	}

	@Test
	public void contarTest() {
		int num = manejador.consultarTotalRegistros(null, null);
		Assert.assertEquals(num, data.size());
	}

	@Test
	public void consultarListaTest() {
		InformacionAgrupamiento infoAgrupamiento = new InformacionAgrupamiento(FuncionAgrupamientoJPQL.DISTINCT,
				ENTIDAD_FAS_PERFILES_TIPO);

		List<String> lista = convertirListaObjetosAString(manejador.consultarLista(null, null, infoAgrupamiento));

		Assert.assertTrue(lista.size() <= VALORES_TIPO.length);
		Assert.assertTrue(lista.size() > 0);
		for (String valor : lista) {
			Assert.assertTrue(Arrays.asList(VALORES_TIPO).contains(valor));
		}

	}

	private void insertData() {
		try {
			utx.begin();
			em.joinTransaction();
			// Luego, se generan 5 datos de prueba diferentes
			for (int i = 0; i < REGISTROS_A_CREAR; i++) {
				FasPerfiles entity = generarFasPerfiles();
				// Persiste el objeto en base de datos
				em.persist(entity);
				// Se añade a la lista del oráculo
				data.add(entity);
				logger.debug("Se inserto FasPerfiles: " + entity.toString());
			}
			utx.commit();
			// clear the persistence context (first-level cache)
			em.clear();
		} catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException | SecurityException | IllegalStateException ex) {
			logger.debug(ex.getMessage());
			throw new TestException("Se produjo un error limpiando la tabla de la base de datos");
		}

	}

	/**
	 * Genera una nueva instancia de FasPerfiles cuyo id no se encuentre ya en la
	 * base de datos.
	 * 
	 * @param factory La fábrica podam para generar POJOS
	 * @return Una instancia de categoría
	 */
	private FasPerfiles generarFasPerfiles() {
		FasPerfiles entity = null;
		while (entity == null) {
			entity = factory.manufacturePojo(FasPerfiles.class);
			// protected region atributos adicionales on begin
			// Escriba en esta sección sus modificaciones

			// protected region atributos adicionales end
			// Este valor se setea para el test de agrupamiento
			entity.setTipo(obtenerTipoAleatoria());
			if (em.find(FasPerfiles.class, entity.getIdPerfil()) != null) {
				entity = null;
				logger.debug("Se genero id repetido. Reintentando creación");
			}
		}
		return entity;
	}

	/**
	 * Elimina todos los registros en base de datos de la tabla correspondiente a la
	 * entidad FasPerfiles, también elimina la lista correspondiente a estos
	 * registros que se almacenan en esta instancia de test.
	 */
	private void clearData() throws TestException {
		try {
			utx.begin();
			em.joinTransaction();
			em.createQuery("DELETE FROM FasPerfiles").executeUpdate();
			data.clear();
			utx.commit();
		} catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException
				| HeuristicRollbackException | SecurityException | IllegalStateException e) {
			data.clear();
			logger.debug(e.getMessage());
			throw new TestException("Se produjo un error limpiando la tabla de la base de datos");
		}

	}

	/**
	 * Copia el valor que contienen los atributos del objeto fuente a los atributos
	 * del objeto destino cuyos nombres sean exactamente iguales. Los atributos que
	 * no coinciden se omiten (Se dejan tal cual como estaban en el objeto destino).
	 * 
	 * @param destino objeto al que se le van a setear los valores de sus atributos
	 * @param fuente  objeto del que se copian los valores de los atributos
	 */
	protected void copiarPropiedades(Object destino, Object fuente) {

		try {
			BeanUtils.copyProperties(destino, fuente);
		} catch (IllegalAccessException | InvocationTargetException ex) {
			logger.error(ex);
			throw new TestException("Hubo un problema copiando info de entidades.");
		}

	}

	private void startTransaction() throws Exception {
		utx.begin();
		em.joinTransaction();
	}

	private static class TipoComparator implements Comparator<FasPerfiles> {

		@Override
		public int compare(FasPerfiles instancia1, FasPerfiles instancia2) {
			return instancia1.getTipo().compareTo(instancia2.getTipo());
		}
	}

	private static String obtenerTipoAleatoria() {
		Random generator = new Random();
		int index = generator.nextInt(VALORES_TIPO.length);

		return VALORES_TIPO[index];
	}

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
}
