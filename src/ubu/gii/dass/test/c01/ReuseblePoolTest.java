/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReuseblePoolTest {
	ReusablePool reusablePool;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reusablePool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		reusablePool = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * Casos de prueba para el método getInstance de ReusablePool
	 */
	@Test
	public void testGetInstance() {

		Assert.assertNotNull(
				"El reusablePool no debe de ser nulo. Entrada: reusablePool. Salida esperada: True.",
				reusablePool);

		Assert.assertTrue(
				"El reusablePool tiene que ser de tipo ReusablePool. Entrada: reusablePool. Salida esperada: True.",
				reusablePool.getClass().equals(ReusablePool.class));

		ReusablePool reusablePool2 = ReusablePool.getInstance();
		Assert.assertEquals(
				"La instancia de reusablePool debe ser unica. Entrada: reusablePool y reusablePool2. Salida esperada: True.",
				reusablePool, reusablePool2);

	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
	@Test (expected=NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
		Reusable reusable0= reusablePool.acquireReusable();
		Reusable reusable1= reusablePool.acquireReusable();
		Reusable reusable2= reusablePool.acquireReusable();
		
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}
	 * .
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
