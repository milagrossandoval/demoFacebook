package pe.com.test.demoFacebook.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pe.com.test.demoFacebook.driver.demoDriver;

public class PublicarPage {
	
	private WebDriver webDriver = null;
	
	public PublicarPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	
	public Boolean publicar(String post) throws InterruptedException{
		Boolean rpta = false;
		WebElement txtPubli = this.webDriver.findElement(By.xpath("//*[@name='xhpc_message']"));
		Thread.sleep(2000);	
		txtPubli.click();
		txtPubli.sendKeys(post);
		Thread.sleep(3000);	
		WebElement btnPubli = this.webDriver.findElement(By.cssSelector("._1mf7._4r1q._4jy0._4jy3._4jy1._51sy.selected._42ft"));
		if(btnPubli.isEnabled())
		{
			System.out.println("Publicando");
			btnPubli.click();
			rpta = true;
		}
		Thread.sleep(2000);	
		return rpta;
	}
	
	public void cerrarPagina(){
		demoDriver.cerrarPagina(webDriver);
	}
}
