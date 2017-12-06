/**
 * 
 */
package automation.core;

import static automation.core.DriverFactory.killDriver;

import org.junit.After;

/**
 * @author Anderson
 *
 */
public class BaseTest {

	@After
	public void finaliza() {
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
