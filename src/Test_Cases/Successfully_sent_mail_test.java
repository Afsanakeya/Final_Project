package Test_Cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.run_codes;
import base.Config;
import base.WDFunctions;
import page_helper.locators_values;

public class Successfully_sent_mail_test {
	public class Sign_in_test extends Config {
		locators_values loc=new locators_values();

		@Test
		public void Sucessfully_sent_mail_Test() throws InterruptedException {
			System.out.println("Sucessfully sent mail Test Start");
			time();
			clickByXpath(loc.signInLinkLoc)	;
			typeByXpath(loc.emailLoc, loc.emailValue);
			time();
			clickByCss(loc.nextButtonLoc);
			typeByXpath(loc.passwordLoc,loc.passValue);
			clickByXpath(loc.nextButtonloc);

			clickByXpath(loc.maillinkloc);
			time();
			clickByXpath(loc.Composelink);
			time();
			sendKeyForDataFromDataFile(loc.Email_compose_field,WDFunctions.st);
			typeByXpath(loc.To_link,loc.writeTolink);
			time();
			typeByXpath(loc.Subject_link,loc.writesublink);
			time();
			clickByXpath(loc.Send_button);
			String act = driver.findElement(By.xpath(loc.successfully_mail_sent)).getText(); 
			// act is coming from Domain -- the one developer build and release
			String exp = "Your message has been sent.";
			// exp is coming from Requirement or Mock-up
			Assert.assertEquals(act, exp);

		}
	}
}