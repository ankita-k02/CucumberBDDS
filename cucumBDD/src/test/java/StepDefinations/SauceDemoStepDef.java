package StepDefinations;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.CheckoutYourInfoPage;
import Pages.SauceLabLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoStepDef {
	WebDriver driver;
	SauceLabLoginPage page;

	CheckoutYourInfoPage cpage;

	@Given("I Browse and navigate to the Sauce Demo url")
	public void OpenAppandNavigate() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		page = new SauceLabLoginPage(driver);

	}

	@When("I Login using {string} and {string}")
	public void LoginSauceLab(String uname, String pname) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		page.enterUname(uname);
		page.enterPassword(pname);
		page.loginClick();

	}

	@Then("I verify the login")
	public void loginVerification() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		page.verifyProductPage();
	}

	@And("I place an order {string} , {string} and {string}")
	public void OrderBackPack(String firstName, String LastName, String zipcode) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		page.addingBackPack();
		page.shoppingCartClick();
		page.verifyAddedItem();
		page.checkoutClick();

		cpage = new CheckoutYourInfoPage(driver);
		cpage.enterFirstName(firstName);
		cpage.enterLastName(LastName);
		cpage.enterZipcode(zipcode);
		cpage.continueBtnClick();
		cpage.verifyCheckoutOverviewPage();
		cpage.finishBtnClick();
		cpage.confirmOrder();
		driver.close();
	}

}
