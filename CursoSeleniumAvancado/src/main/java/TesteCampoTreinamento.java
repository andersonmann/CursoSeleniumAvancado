import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson Mann");
		assertEquals("Anderson Mann", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	@Test
	public void deveInteragirComTextArea() throws InterruptedException {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	public void deveInteragirComRadioButton() throws InterruptedException {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	@Test
	public void deveInteragirComCheckBox() throws InterruptedException {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	public void deveInteragirComCombo() throws InterruptedException {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		assertTrue(encontrou);
	}

	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectOptins = combo.getAllSelectedOptions();
		assertEquals(3, allSelectOptins.size());

		combo.deselectByVisibleText("Corrida");
		allSelectOptins = combo.getAllSelectedOptions();
		assertEquals(2, allSelectOptins.size());
	}

	@Test
	public void deveInteragirComBotoes() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	public void deveInteragirComLinks() {
		driver.findElement(By.linkText("Voltar")).click();
		assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	// Div, span
	@Test
	public void deveBuscarTextosNaPagina() {
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));
		assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
	}

}
