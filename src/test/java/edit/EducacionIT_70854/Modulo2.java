package edit.EducacionIT_70854;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Modulo2 {
	String url = "http://www.automationpractice.pl/";
	
	@Test
	public void registrarUsuario() {
		// 1) Definir el navegador
		WebDriver driver = new EdgeDriver();
				
		// 2) Acceder a la página web
		driver.navigate().to(url); // = a driver.get(url);
		
		// 3) Maximizar la pantalla
		driver.manage().window().maximize();
		
		// 4) Hacer clic en Sign In
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		// 5) Ingresar un correo electronico
		driver.findElement(By.id("email_create")).sendKeys("correo10Ene@gmail.com");;
		
		// 6) Hacer clic en Create an Account
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Es necesaria una espera!!!
		// Opción 1: Espera Implícita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Opción 2: Espera Explícita
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		// 7) Completar el formulario
		// Seleccionar el campo Title (Mr.)
		driver.findElement(By.cssSelector("#id_gender1")).click();
		
		// Escribir el nombre
		WebElement txtFirstName = driver.findElement(By.name("customer_firstname"));
		txtFirstName.sendKeys("Roman");
		
		// Escribir el apellido
		WebElement txtLastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		txtLastName.sendKeys("Jimenez"); 
		
		// Modificar el correo
		WebElement txtEmail = driver.findElement(By.cssSelector("#email"));
		txtEmail.clear();
		
		// Opción 1: Utilizar un correo aleatorio (modo simple)
		//String email = "correo" + Math.random() + "@gmail.com";
		// Opción 2: Utilizar un correo aleatorio (modo genius - Java Faker)
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		txtEmail.sendKeys(email); // Escribo un correo aleatorio
		
		// Escribir la contraseña
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		// Seleccionar la fecha de nacimiento (día, mes, año)
		Select lstDias = new Select(driver.findElement(By.name("days")));
		lstDias.selectByValue("18");
		
		Select lstMeses = new Select(driver.findElement(By.id("months")));
		lstMeses.selectByVisibleText("June ");
		
		Select lstAnios = new Select(driver.findElement(By.cssSelector("#years")));
		lstAnios.selectByIndex(30);
		
		// Hacer clic en el check box
		WebElement chkNews = driver.findElement(By.xpath("//input[@id='newsletter']"));
		chkNews.click();
		
		// Hacer clic en el botón REGISTER
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
	}
}
