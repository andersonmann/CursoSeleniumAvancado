import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://google.com");
		assertEquals("Google", driver.getTitle());
	}

}
