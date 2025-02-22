package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage {
	WebDriver driver;
	By recruitment=By.xpath("//span[text()='Recruitment']");
	By jobTitle= By.xpath("//div[text()='Automation Tester']");
	By vaccancy= By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	By hiringManager= By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]");
	By status = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[4]");
	By candidateName= By.xpath("//label[text()='Candidate Name']/following::div[contains(@class,\"input--active\")]");
	
	public  RecruitmentPage(WebDriver driver) {
     this.driver = driver;
    }
	public void RecruiterNavigate()
	{
		driver.findElement(recruitment).click();
	}
	public void rectruitSearch() {
		driver.findElement(jobTitle).click();
	}
}
