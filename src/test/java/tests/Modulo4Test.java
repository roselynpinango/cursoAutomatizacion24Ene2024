package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Modulo4Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); // modo de abrir el navegador
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iniciarSesion() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo01@gmail.com");
		login.escribirPassword("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabraABuscar("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
