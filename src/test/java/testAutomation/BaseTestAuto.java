package testAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactoryImp.ApplPageElements;
import utilityAss.ConstantsAss;

public class BaseTestAuto {

	public WebDriver driver;

	public ApplPageElements pf;

	@BeforeTest

	public void launchApp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(ConstantsAss.ass_app);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		pf = new ApplPageElements(driver);

	}

	@AfterTest

	public void closeApp() throws Exception {

		driver.close();

		driver.quit();

	}
}
