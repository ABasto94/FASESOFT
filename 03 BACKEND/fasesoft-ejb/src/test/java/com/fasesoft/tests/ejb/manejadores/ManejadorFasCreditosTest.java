package com.fasesoft.tests.ejb.manejadores;

import static com.fasesoft.modelo.entidades.FasCreditos.ENTIDAD_FAS_CREDITOS_MONTO;
import static com.fasesoft.modelo.entidades.FasCreditos.ENTIDAD_FAS_CREDITOS_PK;
import static com.fasesoft.modelo.entidades.FasCreditos.ENTIDAD_FAS_CREDITOS_TASA_REAL;
import static com.fasesoft.modelo.utils.UtilOperaciones.convertirListaObjetosAString;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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

import com.fasesoft.modelo.entidades.FasCreditos;
import com.fasesoft.modelo.enums.FuncionAgrupamientoJPQL;
import com.fasesoft.modelo.enums.TipoFiltro;
import com.fasesoft.modelo.enums.TipoOrdenamiento;
import com.fasesoft.modelo.manejadores.ManejadorFasCreditos;
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
 * Pruebas de los métodos expuestos por el ManejadorFasCreditos
 *
 * @author GeneradorCRUD
 */
@RunWith(Arquillian.class)
public class ManejadorFasCreditosTest {

	public static final String DEPLOY = "Prueba";
	// Debe ser mayor o igual a 2
	private static final int REGISTROS_A_CREAR = 10;

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ManejadorFasCreditosTest.class.getName());

	// Arreglo con los posibles valores de descripción fijos a insertar en el
	// atributo descripción para la prueba de consultaLista
	private static final BigDecimal[] VALORES_TASAREAL = { new BigDecimal(111.11d), new BigDecimal(222.22d),
			new BigDecimal(333.33d) };

	@Inject
	private ManejadorFasCreditos manejador;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	// Generador de datos Podam que usa el default Random Data Provider Strategy
	private final PodamFactory factory = new PodamFactoryImpl();

	// Lista de instancias de FasCreditos generadas aleatoriamente por PODAM
	private final List<FasCreditos> data = new ArrayList<>();

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap.create(JavaArchive.class, DEPLOY + ".jar").addPackage(ManejadorFasCreditos.class.getPackage())
				.addPackage(ManejadorPersistencia.class.getPackage()).addPackage(FasCreditos.class.getPackage())
				.addPackage(UtilConstantes.class.getPackage()).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource(
						new FileAsset(new File("src/test/resources/META-INF/test-derby-persistence.xml")),
						"persistence.xml");
	}

	@Before
	public void configTest() throws Exception {
		logger.debug("Configurando Test " + ManejadorFasCreditosTest.class.getName());
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
		FasCreditos entidad = data.get(0);
		FasCreditos entidadConsultada = manejador.buscar(entidad.getIdCredito());

		Assert.assertEquals(entidad, entidadConsultada);
	}

	@Test
	public void eliminarTest() {
		FasCreditos entidad = data.get(0);
		manejador.eliminar(entidad);
		FasCreditos deleted = em.find(FasCreditos.class, entidad.getIdCredito());

		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorIdTest() {
		FasCreditos entidad = data.get(0);
		manejador.eliminarPorId(entidad.getIdCredito());
		FasCreditos deleted = em.find(FasCreditos.class, entidad.getIdCredito());
		Assert.assertNull(deleted);
	}

	@Test
	public void eliminarPorFiltroTest() {
		FasCreditos entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_CREDITOS_PK, entidad.getIdCredito(),
				ENTIDAD_FAS_CREDITOS_PK));
		manejador.eliminarPorFiltro(filtros);
		FasCreditos deleted = em.find(FasCreditos.class, entidad.getIdCredito());
		Assert.assertNull(deleted);
	}

	@Test
	public void crearTest() {
		FasCreditos entidad = generarFasCreditos();
		manejador.crear(entidad);
		FasCreditos creada = em.find(FasCreditos.class, entidad.getIdCredito());
		Assert.assertNotNull(creada);
	}

	@Test
	public void actualizarTest() {
		FasCreditos entidad = data.get(0);
		Integer idEntidad = entidad.getIdCredito();
		FasCreditos entidad2 = data.get(1);
		copiarPropiedades(entidad, entidad2);
		entidad.setIdCredito(idEntidad);
		manejador.actualizar(entidad);
		FasCreditos entidadDB = em.find(FasCreditos.class, idEntidad);
		Assert.assertEquals(entidadDB, entidad);
	}

	@Test
	public void actualizarPorFiltrosTest() {

		// Entidad (1) a actualizar
		FasCreditos entidad = data.get(0);
		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_CREDITOS_PK, entidad.getIdCredito(),
				ENTIDAD_FAS_CREDITOS_PK));

		// Entidad con los valores a setear en la entidad (1)
		FasCreditos entidad2 = data.get(1);
		List<InformacionAsignacion> asignaciones = new ArrayList<>();
		asignaciones.add(new InformacionAsignacion(ENTIDAD_FAS_CREDITOS_TASA_REAL, entidad2.getTasaReal()));

		manejador.actualizarPorFiltros(asignaciones, filtros);

		FasCreditos entidadActualizada = em.find(FasCreditos.class, entidad.getIdCredito());

		Assert.assertEquals(entidadActualizada.getTasaReal(), entidad2.getTasaReal());
	}

	@Test
	public void consultarTodosTest() {
		List<FasCreditos> listaConsulta = manejador.consultar(null, null, null);

		Assert.assertEquals(listaConsulta.size(), data.size());
		for (FasCreditos instancia : listaConsulta) {
			if (!data.contains(instancia)) {
				Assert.fail("Se consulto un elemento que no estaba en la base de datos");
			}
		}

	}

	@Test
	public void consultarConFiltroPKTest() {
		FasCreditos entidad = data.get(0);

		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_CREDITOS_PK, entidad.getIdCredito(),
				ENTIDAD_FAS_CREDITOS_PK));
		List<FasCreditos> listaConsulta = manejador.consultar(filtros, null, null);

		Assert.assertEquals(entidad, listaConsulta.get(0));
	}

	@Test
	public void consultarConDosFiltrosTest() {

		FasCreditos entidad = data.get(0);

		List<InformacionFiltro> filtros = new ArrayList<>();
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_CREDITOS_TASA_REAL, entidad.getTasaReal(),
				ENTIDAD_FAS_CREDITOS_TASA_REAL));
		filtros.add(new InformacionFiltro(TipoFiltro.EXACTO, ENTIDAD_FAS_CREDITOS_MONTO, entidad.getMonto(),
				ENTIDAD_FAS_CREDITOS_MONTO));

		List<FasCreditos> listaConsulta = manejador.consultar(filtros, null, null);

		Assert.assertEquals(entidad, listaConsulta.get(0));
	}

	@Test
	public void consultarConOrdenamientoTest() {
		List<FasCreditos> listaOrdenada = data;
		Collections.sort(listaOrdenada, new TasaRealComparator());

		List<InformacionOrdenamiento> ordenamiento = new ArrayList<>();
		ordenamiento.add(new InformacionOrdenamiento(TipoOrdenamiento.ASCENDENTE, ENTIDAD_FAS_CREDITOS_TASA_REAL));

		List<FasCreditos> listaConsulta = manejador.consultar(null, ordenamiento, null);

		Assert.assertEquals(listaConsulta, listaOrdenada);
	}

	@Test
	public void consultarConRangoTest() {
		RangoConsulta rango = new RangoConsulta(0, REGISTROS_A_CREAR - 2);

		List<FasCreditos> listaConsulta = manejador.consultar(null, null, rango);

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
				ENTIDAD_FAS_CREDITOS_TASA_REAL);

		List<String> lista = convertirListaObjetosAString(manejador.consultarLista(null, null, infoAgrupamiento));

		Assert.assertTrue(lista.size() <= VALORES_TASAREAL.length);
		Assert.assertTrue(lista.size() > 0);
		for (String valor : lista) {
			Assert.assertTrue(Arrays.asList(VALORES_TASAREAL).contains(valor));
		}

	}

	private void insertData() {
		try {
			utx.begin();
			em.joinTransaction();
			// Luego, se generan 5 datos de prueba diferentes
			for (int i = 0; i < REGISTROS_A_CREAR; i++) {
				FasCreditos entity = generarFasCreditos();
				// Persiste el objeto en base de datos
				em.persist(entity);
				// Se añade a la lista del oráculo
				data.add(entity);
				logger.debug("Se inserto FasCreditos: " + entity.toString());
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
	 * Genera una nueva instancia de FasCreditos cuyo id no se encuentre ya en la
	 * base de datos.
	 * 
	 * @param factory La fábrica podam para generar POJOS
	 * @return Una instancia de categoría
	 */
	private FasCreditos generarFasCreditos() {
		FasCreditos entity = null;
		while (entity == null) {
			entity = factory.manufacturePojo(FasCreditos.class);
			// protected region atributos adicionales on begin
			// Escriba en esta sección sus modificaciones

			// protected region atributos adicionales end
			// Este valor se setea para el test de agrupamiento
			entity.setTasaReal(obtenerTasaRealAleatoria());
			if (em.find(FasCreditos.class, entity.getIdCredito()) != null) {
				entity = null;
				logger.debug("Se genero id repetido. Reintentando creación");
			}
		}
		return entity;
	}

	/**
	 * Elimina todos los registros en base de datos de la tabla correspondiente a la
	 * entidad FasCreditos, también elimina la lista correspondiente a estos
	 * registros que se almacenan en esta instancia de test.
	 */
	private void clearData() throws TestException {
		try {
			utx.begin();
			em.joinTransaction();
			em.createQuery("DELETE FROM FasCreditos").executeUpdate();
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

	private static class TasaRealComparator implements Comparator<FasCreditos> {

		@Override
		public int compare(FasCreditos instancia1, FasCreditos instancia2) {
			return instancia1.getTasaReal().compareTo(instancia2.getTasaReal());
		}
	}

	private static BigDecimal obtenerTasaRealAleatoria() {
		Random generator = new Random();
		int index = generator.nextInt(VALORES_TASAREAL.length);

		return VALORES_TASAREAL[index];
	}

	// protected region atributos adicionales on begin
	// Escriba en esta sección sus modificaciones

	// protected region atributos adicionales end
}
