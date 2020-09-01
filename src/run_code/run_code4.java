package run_code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class run_code4 {
	public static void user_clicks_on(String element) throws Throwable {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com");
		String locator = null;

		try{

			WebElement ele = driver.findElement(run_code4.getby(element));

			ele.click();


		}

		catch(Exception e) {
		
		}
	
	
	}
	
	public static By getby(String locator) {
		
		By locatorObj = null;
		
		String locatorType ="";
		
		/*


		if (locator !=null && locator.split(":").length >1) {


			locatorType = locator.split(":")[0]; 





		}


		 */
		
		switch (locatorType) {
		
		case "id":
			locatorObj = By.id(locator.replaceFirst(locatorType + ":", ""));


			break;





		case "name":


			locatorObj = By.name(locator.replaceFirst(locatorType + ":", ""));


			break;	





		case "css":


			locatorObj = By.cssSelector(locator.replaceFirst(locatorType + ":", ""));


			break;





		case "className":


			locatorObj = By.className(locator.replaceFirst(locatorType + ":", ""));


			break;





		case "xpath": 


			locatorObj = By.xpath(locator.replaceFirst(locatorType + ":", ""));


			break;	


		default:


			locatorObj = By.xpath(locator);


			break;


		}


		return locatorObj;

	}


}
