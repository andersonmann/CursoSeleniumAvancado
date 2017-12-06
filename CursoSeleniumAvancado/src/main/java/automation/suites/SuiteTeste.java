/**
 * 
 */
package automation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import automation.test.TesteCadastro;
import automation.test.TesteCampoTreinamento;
import automation.test.TesteRegrasCadastro;

/**
 * @author Anderson
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteRegrasCadastro.class, TesteCampoTreinamento.class })

public class SuiteTeste {

}
