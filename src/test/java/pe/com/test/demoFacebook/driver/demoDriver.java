package pe.com.test.demoFacebook.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class demoDriver {
	public static WebDriver inicializarDriver(String navegador, boolean remoto) {
		WebDriver webDriver = null;
		
		System.out.println("Ejecución Remota: " + (remoto ? "SI" : "NO"));
		switch (navegador) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "libs/geckodriver.exe");
			webDriver = new FirefoxDriver();
			break;
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);			
			webDriver = new ChromeDriver(options);
			webDriver.manage().window().maximize();
			break;
		}
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return webDriver;
	}

	public static void cerrarPagina(WebDriver webDriver) {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
