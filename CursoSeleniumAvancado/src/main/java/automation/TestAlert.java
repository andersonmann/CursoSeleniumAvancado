package automation;

import static automation.core.DriverFactory.getDriver;
import static automation.core.DriverFactory.killDriver;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import automation.core.DSL;

/**
 * @author Anderson
 *
 */
public class TestAlert {
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}

	@Test
	public void deveInteragirComAlertSimples() {
		dsl.clicarBotao("alert");
		String texto = dsl.alertaObterTextoEAceita();
		assertEquals("Alert Simples", texto);

		dsl.escrever("elementosForm:nome", texto);
	}

	@Test
	public void deveInteragirComAlertConfirm() {
		dsl.clicarBotao("confirm");
		assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

		dsl.clicarBotao("confirm");
		assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		assertEquals("Negado", dsl.alertaObterTextoENega());
	}

	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicarBotao("prompt");
		assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		assertEquals(":D", dsl.alertaObterTextoEAceita());
	}
}
