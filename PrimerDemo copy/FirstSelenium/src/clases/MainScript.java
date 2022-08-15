package clases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainScript {
/*
 * Configurar java 1.8, no corre con Java 15
 * Configurar JAR de Selenium en Build Path
 * Verificar la ruta del driver. En mac se puede jalar el archivo al terminal para obtener la ruta
 * en Windows no olvidar variables de entorno
*/
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/mfhv/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/");
		driver.manage().window().maximize();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//entrar texto de busqueda
		driver.findElement(By.xpath("//div[contains(@class, 'input-group')]/input")).sendKeys("Miguel");
		//click al boton d buscar
		driver.findElement(By.xpath("//div[contains(@class, 'input-group')]/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Search')]")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'section-title')]")));
		Thread.sleep(3000); 
		//limpiar y escribir otro texto para realizar otra busqueda
		driver.findElement(By.xpath("//form[contains(@class, 'search-form clearfix')]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//form[contains(@class, 'search-form clearfix')]/div/div/div/input")).sendKeys("xpath");
		//en lugar de hacer click, apretar enter
		driver.findElement(By.xpath("//form[contains(@class, 'search-form clearfix')]/div/div/div/input")).sendKeys(Keys.RETURN);
		//esperar que cargue las busquedas
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[contains(@class,'search-results node-results')]")));
		//capturar la cantidad de Li. Imprimir el texto de los titulos
		
		List<WebElement> listaElementosporClase = driver.findElements(By.xpath("//li[contains(@class,'search-result')]/h3/a"));
		int Contador = 0;
	      for (WebElement Lista : listaElementosporClase)
	      {
	    	  String tempTexto = Lista.getText();
	    	  
	          Contador = Contador +1;
	          System.out.println(Contador);
	          System.out.println(tempTexto);

	      }
		
		//capturar el texto de la busqueda para poder compararlo en el resultado
		String TextoBusqueda = driver.findElement(By.xpath("//ol[contains(@class,'search-results node-results')]/li[1]/h3/a")).getText();
		driver.findElement(By.xpath("//ol[contains(@class,'search-results node-results')]/li[1]/h3/a")).click();
		//esperar que cargue pagina de resultados
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'section-title')]")));
		//verificar que sea correcto
		String TextoResultado = driver.findElement(By.xpath("//div[contains(@class,'section-title')]/h1")).getText();
		System.out.println(TextoBusqueda);
		System.out.println(TextoResultado);
		if(TextoBusqueda.equals(TextoResultado) ) {
			System.out.println("The expected heading is same as actual heading ");
		}else {
			System.out.println("The expected heading doesn't match the actual heading --- ");
		}
		
		Thread.sleep(3000); 
		driver.close();
		//falta git push request
		//falta ejemplo obteniendo datos de un excel/sql
		// falta imprimir pantalla
	}

}
