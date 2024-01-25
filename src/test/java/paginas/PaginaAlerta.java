package paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlerta {
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	@FindBy(xpath="//button[@id='timerAlertButton']")
	WebElement btnEspera;
	
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnEspera() {
		btnEspera.click();
	}
	
	public Alert obtenerAlerta(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void aceptarAlerta(Alert a) {
		a.accept();
	}
	
	public void cancelarAlerta(Alert a) {
		a.dismiss();
	}
	
	public void escribirAlerta(Alert a, String palabra) {
		a.sendKeys(palabra);
	}
}
