package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Modulo5bTest {
	String url = "http://www.automationpractice.pl";
	String dirDatos = "..\\EducacionIT-70854\\Datos\\";
	String nombreArchivoExcel = "Clase6_DatosLogin.xlsx";
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
	
	@Test(dataProvider="Datos Login Excel")
	public void iniciarSesion(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDataExcel() throws Exception {
		// Lea un archivo excel 
		// Convierta los datos en una matriz bidimensional
		return DatosExcel.leerExcel(dirDatos + nombreArchivoExcel, "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerData() {
		// Construye una matriz bidimensional con los datos de prueba
		Object[][] arreglo = new Object[3][2];
		
		arreglo[0][0] = "abc@gmail.com"; // email
		arreglo[0][1] = "re3rwafwa3"; // password
		
		arreglo[1][0] = "def@gmail.com"; // email
		arreglo[1][1] = "4r3wr3w4"; // password
		
		arreglo[2][0] = "ghi@gmail.com"; // email
		arreglo[2][1] = "r4erf4s4e"; // password
		
		return arreglo;
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
