package amazontest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		WebDriver driver= new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.click();
		searchbox.sendKeys("samsung mobile");

		WebElement searchclick = driver.findElement(By.id("nav-search-submit-button"));
		searchclick.click();
		Thread.sleep(5000);	

		List<WebElement> product_names= driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		System.out.println(product_names.size());
		List<WebElement> product_price= driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));

		List<WebElement> currency_symbol = driver.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-symbol']"));



		for (int i = 0; i < product_names.size(); i++) {

		System.out.println((product_names.get(i)).getText() + " " + currency_symbol.get(i).getText() + (product_price.get(i).getText()));

		}
		
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File fileobj =tsobj.getScreenshotAs(OutputType.FILE);
		
		//size of png is less, so it is advisable to use png 
		
		File screenshot = new File ("amazon_samsung.png");
		FileUtils.copyFile(fileobj, screenshot);
		driver.close();


		}

	}
