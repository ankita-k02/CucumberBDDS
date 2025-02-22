package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPages {
	WebDriver driver;
	By username=By.name("username");
	By password=By.name("password");
	By loginbtn= By.xpath("//button[@type='submit']");
	By dashboard= By.xpath("//h6[text()='Dashboard']");
	
	
	public LoginPages(WebDriver driver) {
		this.driver=driver;
		}
	
	public void enterUserName(String name) {
		driver.findElement(username).sendKeys(name);
	}
	public void enterPassword(String pwd) {
		
		driver.findElement(password).sendKeys(pwd);
	}
	public void submitBtn() {
		driver.findElement(loginbtn).click();
	}
	public void dashboardVerification() {
		String t= driver.findElement(dashboard).getText();
//		Assert.assertEquals("Dashboard", t);
		SoftAssert st= new SoftAssert();
		st.assertEquals("Dashboardww", t);
		
	}
	
}
