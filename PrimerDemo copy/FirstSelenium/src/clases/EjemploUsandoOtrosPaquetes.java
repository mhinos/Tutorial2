package clases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//aca hago referencia a otro package para poder usar los elementos
import Elements.ElementsFromWebsite;

public class EjemploUsandoOtrosPaquetes {
//en este ejemplo, uso el paquete Elements y su clase java para obtener los elementos
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/mfhv/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://codepen.io/bbodine1/pen/DqdMRy");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//primero debemos entrar al iframe para poder usarlo
		//parece ser que para el elemnto del frame, es # + "id del div" + iframe
		WebElement iframe = driver.findElement(By.cssSelector("#result_div>iframe"));
		driver.switchTo().frame(iframe);
		//Hacer click al elemento correcto, en esta pagina es el label, no es el click al div o al input. 
		String checkbox2 = ElementsFromWebsite.checkbox2();
		driver.findElement(By.xpath(checkbox2)).click();
		//Luego de hacer click, verificar el estado. esto si se ve en el input
		//Boolean estadocheckbox = driver.findElement(By.xpath("//div[contains(@class, 'ondisplay')]/section[2]/div/input")).isSelected();
		Boolean estadocheckbox = driver.findElement(By.xpath(ElementsFromWebsite.estadoCheckBox2())).isSelected();
		
		System.out.println(estadocheckbox);
		System.out.println("Script termino satisfactoriamente");
		driver.switchTo().defaultContent();
		driver.quit();

	}

}
