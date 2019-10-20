package pe.com.test.demoFacebook.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pe.com.test.demoFacebook.driver.*;

public class LoginPage {

	private By txtEmail = By.id("email");
	private By txtPass = By.id("pass");
	private By btnLogin = By.id("loginbutton");
	private String urlInicial;
	private WebDriver webDriver = null;
	
	
	public LoginPage(String navegador, String url, boolean remoto) {
		this.webDriver = demoDriver.inicializarDriver(navegador, remoto);
		this.urlInicial = url;
	}
	
	public void ingresar(String email, String pass){	
        
		this.webDriver.get(urlInicial);
		this.webDriver.findElement(txtEmail).sendKeys(email);
		this.webDriver.findElement(txtPass).sendKeys(pass);
		this.webDriver.findElement(btnLogin).click();
	}
	
	
	public void cerrarPagina(){
		demoDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
