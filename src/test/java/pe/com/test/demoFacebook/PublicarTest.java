package pe.com.test.demoFacebook;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pe.com.test.demoFacebook.page.LoginPage;
import pe.com.test.demoFacebook.page.PublicarPage;

public class PublicarTest {

	private String urlInicial = "https://www.facebook.com/";
	private LoginPage loginPage;
	private PublicarPage publicarPage;

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		loginPage = new LoginPage(navegador, urlInicial, false);
		publicarPage = new PublicarPage(loginPage.getWebDriver());
	}

	@Test
	public void publicarPost() {
		try {
			
			loginPage.ingresar("mily_piscis15@hotmail.com", "mi3tai");
			Assert.assertTrue(publicarPage.publicar("Probando selenium"));
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@AfterTest
	public void tearDown() throws Exception {
		loginPage.cerrarPagina();
	}
}
