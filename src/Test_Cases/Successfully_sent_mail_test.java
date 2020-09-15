package Test_Cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import base.WDFunctions;
import page_helper.locators_values;
import run_code.run_codes;

public class Successfully_sent_mail_test {
	public class Sign_in_test extends Config {
		locators_values loc=new locators_values();

		@Test
		public void Sucessfully_sent_mail_Test() throws InterruptedException {
			System.out.println("Sucessfully sent mail Test Start");
			Thread.sleep(2000);
			clickByXpath(loc.signInLinkLoc)	;
			typeByXpath(loc.emailLoc, loc.emailValue);
			Thread.sleep(2000);
			clickByCss(loc.nextButtonLoc);
			typeByXpath(loc.passwordLoc,loc.passValue);
			clickByXpath(loc.nextButtonloc);

			clickByXpath(loc.maillinkloc);
			Thread.sleep(1000);
			clickByXpath(loc.Composelink);
			Thread.sleep(9000);
			sendKeyForDataFromDataFile(loc.Email_compose_field,WDFunctions.st);
			typeByXpath(loc.To_link,loc.writeTolink);
			Thread.sleep(2000);
			typeByXpath(loc.Subject_link,loc.writesublink);
			Thread.sleep(2000);

			clickByXpath(loc.Send_button);
			String act = driver.findElement(By.xpath(loc.successfully_mail_sent)).getText(); 
			// act is coming from Domain -- the one developer build and release
			String exp = "Your message has been sent.";
			// exp is coming from Requirement or Mock-up
			Assert.assertEquals(act, exp);

		}
	}
}