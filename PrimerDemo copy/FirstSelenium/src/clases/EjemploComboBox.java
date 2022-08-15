package clases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EjemploComboBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/mfhv/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://designsystem.digital.gov/components/combo-box/");
		driver.manage().window().maximize();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//div[contains(@class, 'input-group')]/span")).click();
		driver.findElement(By.xpath("//div[contains(@class, 'usa-combo-box')]/select"));
		Select selector = new Select(driver.findElement(By.xpath("//div[contains(@class, 'usa-combo-box')]/select")));
		//Son 3 metodos, selectByIndex, selectByValue, selectByVisibleText
		//selector.selectByValue("cantaloupe");
		selector.selectByIndex(1);
		Thread.sleep(3000);
		
		//verificar q se muestre la X para cancelar/borrar la seleccion
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'usa-combo-box__clear-input')]")));
		System.out.println("Script termino satisfactoriamente");
		driver.close();
	}

}
