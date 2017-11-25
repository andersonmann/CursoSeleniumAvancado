package automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
	private WebDriver driver;
	private DSL dsl;	
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Anderson");
		page.setSobrenome("Mann");
		page.setSexoMasculino();
		page.setComidaFavoritaPizza();
		page.setEscolaridade("Mestrado");
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.clicarBotao("elementosForm:cadastrar");

		assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		assertTrue(dsl.obterTexto("descNome").endsWith("Wagner"));
		assertEquals("Sobrenome: Costa", dsl.obterTexto("descSobrenome"));
		assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
		assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
		assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
		assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
	}

	@Test
	public void deveValidarNomeObrigatorio() {
		dsl.clicarBotao("elementosForm:cadastrar");
		assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSobrenomeObrigatorio() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSexoObrigatorio() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarComidaVegetariana() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes", "Karate");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}

}
