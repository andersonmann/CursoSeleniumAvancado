package automation;

import static automation.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteCadastro {
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}

	@After
	public void finaliza() {
		
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Anderson");
		page.setSobrenome("Mann");
		page.setSexoMasculino();
		page.setComidaFavoritaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();

		assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		assertTrue(page.obterNomeCadastro().endsWith("Anderson"));
		assertEquals("Sobrenome: Mann", page.obterSobrenomeCadastro());
		assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		assertEquals("Comida: Pizza", page.obterComidaCadastro());
		assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
	}

}
