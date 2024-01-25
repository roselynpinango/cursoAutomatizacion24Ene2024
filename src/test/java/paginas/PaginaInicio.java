package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos Web de la página a probar
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	// Constructor del objeto
	public PaginaInicio(WebDriver driver) {
		// Inicializar los elementos web de este objeto en el navegador de prueba
		PageFactory.initElements(driver, this);
	}
	
	// Acciones que se pueden hacer sobre los elementos web a probar
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
}
