package TestTranslation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBingTranslator {
	WebDriver driver;
	FunctionsToTestBing objectToTestBingTranslator;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		objectToTestBingTranslator = new FunctionsToTestBing(driver);
	}

	@Test
	public void autoDetecting() {
		objectToTestBingTranslator.gettingLanguage();
	}
	
	@Test(dependsOnMethods="autoDetecting")
	public void properTranslation() throws InterruptedException {
		objectToTestBingTranslator.getConvertedLanguage();
	}

	@Test
	public void moreThan5000Characters() {
		objectToTestBingTranslator.checkingForLargeNumbers();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.bing.com/translator");
		objectToTestBingTranslator=new FunctionsToTestBing(driver);
	}

	/*@AfterClass
	public void afterClass() {
		driver.quit();
	}*/

}
