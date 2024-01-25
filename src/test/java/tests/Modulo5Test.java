package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaAlerta;

public class Modulo5Test {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnNotificacion();
		
		Alert alerta = pagina.obtenerAlerta(driver);
		pagina.aceptarAlerta(alerta);
	}
	
	@Test
	public void alertaEspera() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnEspera();
		
		// Hay que agregar una espera: 5 segundos de demora
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta = pagina.obtenerAlerta(driver);
		pagina.aceptarAlerta(alerta);
	}
}
