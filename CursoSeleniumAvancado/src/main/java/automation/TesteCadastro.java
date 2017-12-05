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

	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSobrenomeObrigatorio() {
		page.setNome("Nome qualquer");
		page.cadastrar();
		assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.cadastrar();
		assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarComidaVegetariana() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaFavoritaCarne();
		page.setComidaFavoritaVegetariano();
		page.cadastrar();
		assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaFavoritaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();
		assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
