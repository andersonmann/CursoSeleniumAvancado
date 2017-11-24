import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class TesteCadastro {

	@Test
	public void cadastrar() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Anderson");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(" Mann");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Anderson"));
		assertEquals("Sobrenome: Mann", driver.findElement(By.id("descSobrenome")).getText());
		assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
		assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());

		driver.quit();

	}
}
