package com.fasesoft.tests.ejb.manejadores;

import static com.fasesoft.modelo.entidades.FasPermisos.ENTIDAD_FAS_PERMISOS_FAS_ACCESOS_ID_ACCESO;
import static com.fasesoft.modelo.entidades.FasPermisos.ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL;
import static com.fasesoft.modelo.entidades.FasPermisos.ENTIDAD_FAS_PERMISOS_PK;
import static com.fasesoft.modelo.utils.UtilOperaciones.convertirListaObjetosAString;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.fasesoft.modelo.entidades.FasPermisos;
import com.fasesoft.modelo.enums.FuncionAgrupamientoJPQL;
import com.fasesoft.modelo.enums.TipoFiltro;
import com.fasesoft.modelo.manejadores.ManejadorFasPermisos;
import com.fasesoft.modelo.manejadores.utils.InformacionAgrupamiento;
import com.fasesoft.modelo.manejadores.utils.InformacionAsignacion;
import com.fasesoft.modelo.manejadores.utils.InformacionFiltro;
import com.fasesoft.modelo.manejadores.utils.ManejadorPersistencia;
import com.fasesoft.modelo.manejadores.utils.RangoConsulta;
import com.fasesoft.modelo.utils.UtilConstantes;
import com.fasesoft.tests.ejb.excepciones.TestException;

import junit.framework.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de los métodos expuestos por el ManejadorFasPermisos
 *
 * @author GeneradorCRUD
 */
@RunWith(Arquillian.class)
public class ManejadorFasPermisosTest {

	public static final String DEPLOY = "Prueba";
	// Debe ser mayor o igual a 2
	private static final int REGISTROS_A_CREAR = 10;

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ManejadorFasPermisosTest.class.getName());

	// Arreglo con los posibles valores de descripción fijos a insertar en el
	// atributo descripción para la prueba de consultaLista
	private static final BigDecimal[] VALORES_FASPERFILESIDPERFIL = { new BigDecimal(111.11d), new BigDecimal(222.22d),
			new BigDecimal(333.33d) };

	@Inject
	private ManejadorFasPermisos manejador;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	// Generador de datos Podam que usa el default Random Data Provider Strategy
	private final PodamFactory factory = new PodamFactoryImpl();

	// Lista de instancias de FasPermisos generadas aleatoriamente por PODAM
	private final List<FasPermisos> data = new ArrayList<>();

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar").addPackage(ManejadorFasPermisos.class.getPackage())
				.addPackage(ManejadorPersistencia.class.getPackage()).addPackage(FasPermisos.class.getPackage())
				.addPackage(UtilConstantes.class.getPackage()).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource(
						new FileAsset(new File("src/test/resources/META-INF/test-derby-persistence.xml")),
						"persistence.xml");
	}

	@Before
	public void configTest() throws Exception {
		logger.debug("Configurando Test " + ManejadorFasPermisosTest.class.getName());
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
		FasPermisos entidad = data.get(0);
		FasPermisos entidadConsultada = manejador.buscar(entidad.getIdPermiso());

		Assert.assertEquals(entidad, entidadConsultada);
	}

	@Test
	public void eliminarTest() {
		FasPermisos entidad = data.get(0);
		manejador.eliminar(entidad);
		FasPermisos deleted = em.find(FasPermisos.class, entidad.getIdPermiso());

		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorIdTest() {
		FasPermisos entidad = data.get(0);
		manejador.eliminarPorId(entidad.getIdPermiso());
		FasPermisos deleted = em.find(FasPermisos.class, entidad.getIdPermiso());
		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorFiltroTest() {
		FasPermisos entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERMISOS_PK, entidad.getIdPermiso(),
				ENTIDAD_FAS_PERMISOS_PK));
		manejador.eliminarPorFiltro(filtros);
		FasPermisos deleted = em.find(FasPermisos.class, entidad.getIdPermiso());
		Assert.assertNull(deleted);
	}

	@Test
	public void crearTest() {
		FasPermisos entidad = generarFasPermisos();
		manejador.crear(entidad);
		FasPermisos creada = em.find(FasPermisos.class, entidad.getIdPermiso());
		Assert.assertNotNull(creada);
	}

	@Test
	public void actualizarTest() {
		FasPermisos entidad = data.get(0);
		Integer idEntidad = entidad.getIdPermiso();
		FasPermisos entidad2 = data.get(1);
		copiarPropiedades(entidad, entidad2);
		entidad.setIdPermiso(idEntidad);
		manejador.actualizar(entidad);
		FasPermisos entidadDB = em.find(FasPermisos.class, idEntidad);
		Assert.assertEquals(entidadDB, entidad);
	}

	@Test
	public void actualizarPorFiltrosTest() {

		// Entidad (1) a actualizar
		FasPermisos entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERMISOS_PK, entidad.getIdPermiso(),
				ENTIDAD_FAS_PERMISOS_PK));

		// Entidad con los valores a setear en la entidad (1)
		FasPermisos entidad2 = data.get(1);
		List<InformacionAsignacion> asignaciones = new ArrayList<>();
		asignaciones.add(new InformacionAsignacion(ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL,
				entidad2.getFasPerfilesIdPerfil()));

		manejador.actualizarPorFiltros(asignaciones, filtros);

		FasPermisos entidadActualizada = em.find(FasPermisos.class, entidad.getIdPermiso());

		Assert.assertEquals(entidadActualizada.getFasPerfilesIdPerfil(), entidad2.getFasPerfilesIdPerfil());
	}

	@Test
	public void consultarTodosTest() {
		List<FasPermisos> listaConsulta = manejador.consultar(null, null, null);

		Assert.assertEquals(listaConsulta.size(), data.size());
		for (FasPermisos instancia : listaConsulta) {
			if (!data.contains(instancia)) {
				Assert.fail("Se consulto un elemento que no estaba en la base de datos");
			}
		}

	}

	@Test
	public void consultarConFiltroPKTest() {
		FasPermisos entidad = data.get(0);

		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERMISOS_PK, entidad.getIdPermiso(),
				ENTIDAD_FAS_PERMISOS_PK));
		List<FasPermisos> listaConsulta = manejador.consultar(filtros, null, null);

		Assert.assertEquals(entidad, listaConsulta.get(0));
	}

	@Test
	public void consultarConDosFiltrosTest() {

		FasPermisos entidad = data.get(0);

		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL,
				entidad.getFasPerfilesIdPerfil(), ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL));
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_PERMISOS_FAS_ACCESOS_ID_ACCESO,
				entidad.getFasAccesosIdAcceso(), ENTIDAD_FAS_PERMISOS_FAS_ACCESOS_ID_ACCESO));

		List<FasPermisos> listaConsulta = manejador.consultar(filtros, null, null);

		Assert.assertEquals(entidad, listaConsulta.get(0));
	}

	@Test
	public void consultarConOrdenamientoTest() {
		/**
		 * Este método se genero vacío porque no se requiere que la entidad tenga por lo
		 * menos un atributo simple y que para su tipo se pueda generar un set de datos
		 * aleatorios. (Aquellos que hacen parte del PK ni de las relaciones de la
		 * entidad)
		 */
	}

	@Test
	public void consultarConRangoTest() {
		RangoConsulta rango = new RangoConsulta(0, REGISTROS_A_CREAR - 2);

		List<FasPermisos> listaConsulta = manejador.consultar(null, null, rango);

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
				ENTIDAD_FAS_PERMISOS_FAS_PERFILES_ID_PERFIL);

		List<String> lista = convertirListaObjetosAString(manejador.consultarLista(null, null, infoAgrupamiento));

		Assert.assertTrue(lista.size() <= VALORES_FASPERFILESIDPERFIL.length);
		Assert.assertTrue(lista.size() > 0);
		for (String valor : lista) {
			Assert.assertTrue(Arrays.asList(VALORES_FASPERFILESIDPERFIL).contains(valor));
		}

	}

	private void insertData() {
		try {
			utx.begin();
			em.joinTransaction();
			// Luego, se generan 5 datos de prueba diferentes
			for (int i = 0; i < REGISTROS_A_CREAR; i++) {
				FasPermisos entity = generarFasPermisos();
				// Persiste el objeto en base de datos
				em.persist(entity);
				// Se añade a la lista del oráculo
				data.add(entity);
				logger.debug("Se inserto FasPermisos: " + entity.toString());
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
	 * Genera una nueva instancia de FasPermisos cuyo id no se encuentre ya en la
	 * base de datos.
	 * 
	 * @param factory La fábrica podam para generar POJOS
	 * @return Una instancia de categoría
	 */
	private FasPermisos generarFasPermisos() {
		FasPermisos entity = null;
		while (entity == null) {
			entity = factory.manufacturePojo(FasPermisos.class);
			// protected region atributos adicionales on begin
			// Escriba en esta sección sus modificaciones

			// protected region atributos adicionales end
			if (em.find(FasPermisos.class, entity.getIdPermiso()) != null) {
				entity = null;
				logger.debug("Se genero id repetido. Reintentando creación");
			}
		}
		return entity;
	}

	/**
	 * Elimina todos los registros en base de datos de la tabla correspondiente a la
	 * entidad FasPermisos, también elimina la lista correspondiente a estos
	 * registros que se almacenan en esta instancia de test.
	 */
	private void clearData() throws TestException {
		try {
			utx.begin();
			em.joinTransaction();
			em.createQuery("DELETE FROM FasPermisos").executeUpdate();
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

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
}
