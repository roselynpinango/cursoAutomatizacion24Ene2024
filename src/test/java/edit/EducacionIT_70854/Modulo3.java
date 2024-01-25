package edit.EducacionIT_70854;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.CapturaEvidencia;

public class Modulo3 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	String dirEvidencias = "..\\EducacionIT-70854\\Evidencias\\";
	String nombreDocumento = "Evidencias - AutomationPractice.docx";
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01- Ir a Contactanos", priority=3)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Capturar Evidencias
		CapturaEvidencia.escribirTituloEnDocumento(
				dirEvidencias + nombreDocumento,
				"Documento de Evidencias AutomationPractice",
				22);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 1 - Acceder a AutomationPractice");
		
		// 1) Clic en Sign In
		WebElement lnkSign = driver.findElement(By.partialLinkText("Contact"));
		lnkSign.click();
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 2 - Al hacer clic en Sign In");
		
		// 2) Completar el formulario de Contacto
		// Campo Subject
		Select lstSubject = new Select(driver.findElement(By.tagName("select")));
		lstSubject.selectByVisibleText("Webmaster");
		
		// Campo Email
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo01@gmail.com");
		
		// Campo Orden
		WebElement txtOrder = driver.findElement(By.name("id_order"));
		txtOrder.sendKeys("1ABC");
		
		// Campo para adjuntar archivo (deo inspeccionar el campo input type="file")
		WebElement fileAdjunto = driver.findElement(By.name("fileUpload"));
		fileAdjunto.sendKeys("C:\\AddIntegerData.txt");
		
		// Campo Message
		WebElement txtMessage = driver.findElement(By.cssSelector("#message"));
		txtMessage.sendKeys("Comentario de Contacto");
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 3 - Al completar el formulario");
		
		// 3) Hacer clic en Send
		WebElement btnSend = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		btnSend.click();
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				dirEvidencias + "img.jpg",
				dirEvidencias + nombreDocumento,
				"Paso 4 - Al enviar el formulario de contacto");
	}
	
	@Test(description="CP02 - Buscar palabra", priority=1)
	public void buscarPalabra() throws IOException {
		// Capturar Evidencia
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "01_PantallaPrincipal.jpg"));
		
		driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
		
		// Capturar Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "02_PalabraABuscar.jpg"));
		
		driver.findElement(By.name("submit_search")).click();
		
		// Capturar Evidencia
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "03_ResultadoBusqueda.jpg"));
		
		// Validar que el título sea "Search - My Shop"
		Assert.assertEquals("Search - My Shop", driver.getTitle());
		
		/*
		 * Diferentes Asserts que podemos utilizar:
			Assert.assertNotEquals("A", "B"); // validar que dos valores son distintos
			Assert.assertTrue(true); // Validar que la expresión sea verdadera
			Assert.assertFalse(false);
			Assert.assertNull(null);
			Assert.assertNotNull(driver);
		*/
		
		// Chequeo no restrictivo: que no aborte en caso de fallar
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Search - My Shop", driver.getTitle());
		
		// Validar que la URL sea http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=
		String urlActual = driver.getCurrentUrl();
		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		
		Assert.assertEquals(urlEsperada, urlActual);
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
