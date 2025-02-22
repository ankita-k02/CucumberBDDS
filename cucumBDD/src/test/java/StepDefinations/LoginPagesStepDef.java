package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.LoginPages;
import Pages.RecruitmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPagesStepDef {
	WebDriver driver;
	LoginPages pages ;
	RecruitmentPage rp;
	
	@Given("I open Browser and navigated to the url")
	
	public void OpenAndNavigate() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		this.driver.manage().window().maximize();
	    this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    pages = new LoginPages(driver);
       }
  
	@And("I login to the application using {string} and {string}")
	public void LoginPage(String username,String password) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		
		pages.enterUserName(username);
		pages.enterPassword(password);
		pages.submitBtn();
	}

	@When("I logged in sucessfully")
	public void loginVerify() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	    pages.dashboardVerification();
	}

	@Then("I sucessfully navigated to the dashboard")
	public void closeBrowser() {
//	    driver.quit();
		System.out.println("closebrowser");
	}

	@And("I navigate to recruitement section")
	public void Recruitmentsection()
	{	
		rp=new RecruitmentPage(driver);
		rp.RecruiterNavigate();
		rp.rectruitSearch();
	}
	
	}
	


