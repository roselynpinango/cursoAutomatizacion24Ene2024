package edit.EducacionIT_70854;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Modulo4 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void setUp(String navegador) {
		if (navegador.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (navegador.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}		
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
	}
}
