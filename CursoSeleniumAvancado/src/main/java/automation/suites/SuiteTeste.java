/**
 * 
 */
package automation.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.test.TesteCadastro;
import automation.test.TesteRegrasCadastro;

import static automation.core.DriverFactory.killDriver;

/**
 * @author Anderson
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteRegrasCadastro.class })

public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		killDriver();

	}

}
