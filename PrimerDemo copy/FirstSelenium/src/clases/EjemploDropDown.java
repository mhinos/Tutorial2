package clases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EjemploDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/mfhv/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://codepen.io/hubspot/pen/WNpyJdM");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//div[contains(@class, 'input-group')]/span")).click();
		//primero debemos entrar al iframe para poder usarlo
		WebElement iframe = driver.findElement(By.cssSelector("#result_div>iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//select[contains(@name, 'dog-names')]")).click();
		Select selector = new Select(driver.findElement(By.xpath("//select[contains(@name, 'dog-names')]")));
		//Son 3 metodos, selectByIndex, selectByValue, selectByVisibleText
		selector.selectByValue("dave");
		
		System.out.println("Script termino satisfactoriamente");
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
