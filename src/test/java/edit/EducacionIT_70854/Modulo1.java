package edit.EducacionIT_70854;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Modulo1 {
	
	// Método de prueba "Buscar Palabra"
	@Test
	public void buscarPalabraEdge() {
		// 1) Definir qué navegador quiero utilizar
		WebDriver navegador = new EdgeDriver();
		
		// 2) Abrir la página de prueba
		navegador.get("http://www.automationpractice.pl");
		
		System.out.println("Titulo de la Página: " + navegador.getTitle());
		
		// Maximiza la ventana del navegador
		navegador.manage().window().maximize();
		
		// Limpiar las cookies
		navegador.manage().deleteAllCookies();
		
		// 3) Escribir la palabra que se quiere buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Presionar Enter
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Cerrar el navegador
		//navegador.close();
	}
	
	@Test
	public void buscarPalabraFirefox() {
		// 1) Definir qué navegador quiero utilizar
		WebDriver navegador = new FirefoxDriver();
		
		// 2) Abrir la página de prueba
		navegador.get("http://www.automationpractice.pl");
		
		// 3) Escribir la palabra que se quiere buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Presionar Enter
		txtBuscador.sendKeys(Keys.ENTER);
		
	}
}
