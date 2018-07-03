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

	//@Test
	public void moreThan5000Characters() {
		objectToTestBingTranslator.checkingForLargeNumbers();
	}
	@Test
	public void dropdownPresentAndExpandablre() {
		objectToTestBingTranslator.DropDownIsPresentAndExpandable();
	}
	@Test
	public void whetherBoxIsEditable() throws InterruptedException {
		objectToTestBingTranslator.checkForEditableBox();
	}
	@Test
	public void whetherBoxIsNonEditable() {
		objectToTestBingTranslator.checkForNonEditableBox();
	}
	@Test
	public void swapButtonFuctionality() {
		objectToTestBingTranslator.checkForNonEditableBox();
	}
	/*@Test
	public void cleanButtonFunctionality() {
		objectToTestBingTranslator.checkForCleanButton();
	}
	*/
	@BeforeMethod
	public void beforeMethod() {
		objectToTestBingTranslator=new FunctionsToTestBing(driver);
	}

	/*@AfterClass
	public void afterClass() {
		driver.quit();
	}*/

}
