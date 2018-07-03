package TestTranslation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FunctionsToTestBing {
	WebDriver driver;
	JavascriptExecutor js;

	public FunctionsToTestBing(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		driver.get("https://www.bing.com/translator");
		Assert.assertEquals("Bing Microsoft Translator", driver.getTitle());
	}
	public WebElement getLeftLanguageDropDown() {
		return driver.findElement(By.id("t_sl"));
	}

	public WebElement getRightLanguageDropDown() {
		return driver.findElement(By.id("t_tl"));
	}

	public WebElement getSwapButtonLocator() {
		return driver.findElement(By.id("t_revIcon"));
	}
	
	public WebElement getTextFromFirstBox() {
		return driver.findElement(By.id("t_sv"));
	}
	
	public WebElement getCleanButton() {
		return driver.findElement(By.xpath("//*[@id=\"t_edc\"]"));
	}
	public WebElement getTextFromSecondBox() {
		return driver.findElement(By.id("t_tv"));
	}
	public void DropDownIsPresentAndExpandable() {
	    Assert.assertTrue(driver.findElements(By.id("t_sl")).size() > 0 ? true : false);
	}
	public void checkForEditableBox() throws InterruptedException {
		Thread.sleep(2000);
		getTextFromFirstBox().sendKeys("Gracias");
		String textBox1Data = (String) js.executeScript("return document.getElementById(\"t_sv\").value");
		Assert.assertEquals("Gracias", textBox1Data);
	}
	public void checkForCleanButton() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getCleanButton().click();
		String textBox1Data = (String) js.executeScript("return document.getElementById(\"t_sv\").value");
		Assert.assertEquals("", textBox1Data);
	}
	public void checkForNonEditableBox() {	
		getTextFromSecondBox().sendKeys("Gracias");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String textBox2Data = (String) js.executeScript("return document.getElementById(\"t_tv\").value");
		Assert.assertTrue(!textBox2Data.equals("Gracias"));
	}
	public void checkForSwapButtonWorking() {
		String textBox1Data = (String) js.executeScript("return document.getElementById(\"t_sv\").value");
		String textBox2Data = (String) js.executeScript("return document.getElementById(\"t_tv\").value");
		getSwapButtonLocator().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String textBox1DataAfterSwap = (String) js.executeScript("return document.getElementById(\"t_sv\").value");
		String textBox2DataAfterSwap = (String) js.executeScript("return document.getElementById(\"t_tv\").value");
		Assert.assertEquals(textBox1Data,textBox2DataAfterSwap);
		Assert.assertEquals(textBox2Data,textBox1DataAfterSwap);
	}
	public void gettingLanguage() {
		getTextFromFirstBox().sendKeys("hi");
		Thread thread = new Thread();
		try {
			thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Select dropdown = new Select(getLeftLanguageDropDown());
		WebElement option = dropdown.getFirstSelectedOption();
		String selectedItem = option.getText();
		Assert.assertTrue(selectedItem.contains("English"));
	}
	public void getConvertedLanguage() throws InterruptedException {
		getTextFromFirstBox().sendKeys("gracias");
		Thread thread = new Thread();
		Select dropdown = new Select(getRightLanguageDropDown());
		dropdown.selectByVisibleText("English");
		try {
			thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String textBox2Data = (String) js.executeScript("return document.getElementById(\"t_tv\").value");
		Assert.assertTrue(textBox2Data.equals("Thank you"));

	}
	public void checkingForLargeNumbers() {
		String sentence = "Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented,[15] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA),[16] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[17] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture. As of 2016, Java is one of the most popular programming languages in use,[18][19][20][21] particularly for client-server web applications, with a reported 9 million developers.[22] Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them.\r\n"
				+ "\r\n"
				+ "The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun relicensed most of its Java technologies under the GNU General Public License. Others have also developed alternative implementations of these Sun technologies, such as the GNU Compiler for Java (bytecode compiler), GNU Classpath (standard libraries), and IcedTea-Web (browser plugin for applets).\r\n"
				+ "\r\n"
				+ "The latest version is Java 10, released on March 20, 2018,[23] which follows Java 9 after only six months[24] in line with the new release schedule. Java 8 is still supported but there will be no more security updates for Java 9.[25] Versions earlier than Java 8 are supported by companies on a commercial basis; e.g. by Oracle back to Java 6 as of October 2017 (while they still \"highly recommend that you uninstall\"[26] pre-Java 8 from at least Windows computers).\r\n"
				+ "Duke, the Java mascot\r\n" + "\r\n" + "James Gosling, the creator of Java (2008)\r\n" + "\r\n"
				+ "The TIOBE programming language popularity index graph from 2002 to 2015. Over the course of a decade Java (blue) and C (black) competed for the top position.\r\n"
				+ "James Gosling, Mike Sheridan, and Patrick Naughton initiated the Java language project in June 1991.[27] Java was originally designed for interactive television, but it was too advanced for the digital cable television industry at the time.[28] The language was initially called Oak after an oak tree that stood outside Gosling's office. Later the project went by the name Green and was finally renamed Java, from Java coffee.[29] Gosling designed Java with a C/C++-style syntax that system and application programmers would find familiar.[30]\r\n"
				+ "\r\n"
				+ "Sun Microsystems released the first public implementation as Java 1.0 in 1996.[31] It promised \"Write Once, Run Anywhere\" (WORA), providing no-cost run-times on popular platforms. Fairly secure and featuring configurable security, it allowed network- and file-access restrictions. Major web browsers soon incorporated the ability to run Java applets within web pages, and Java quickly became popular. The Java 1.0 compiler was re-written in Java by Arthur van Hoff to comply strictly with the Java 1.0 language specification.[32] With the advent of Java 2 (released initially as J2SE 1.2 in December 1998 – 1999), new versions had multiple configurations built for different types of platforms. J2EE included technologies and APIs for enterprise applications typically run in server environments, while J2ME featured APIs optimized for mobile applications. The desktop version was renamed J2SE. In 2006, for marketing purposes, Sun renamed new J2 versions as Java EE, Java ME, and Java SE, respectively.\r\n"
				+ "\r\n"
				+ "In 1997, Sun Microsystems approached the ISO/IEC JTC 1 standards body and later the Ecma International to formalize Java, but it soon withdrew from the process.[33][34][35] Java remains a de facto standard, controlled through the Java Community Process.[36] At one time, Sun made most of its Java implementations available without charge, despite their proprietary software status. Sun generated revenue from Java through the selling of licenses for specialized products such as the Java Enterprise System.\r\n"
				+ "\r\n"
				+ "On November 13, 2006, Sun released much of its Java virtual machine (JVM) as free and open-source software, (FOSS), under the terms of the GNU General Public License (GPL). On May 8, 2007, Sun finished the process, making all of its JVM's core code available under free software/open-source distribution terms, aside from a small portion of code to which Sun did not hold the copyright.[37]\r\n"
				+ "\r\n"
				+ "Sun's vice-president Rich Green said that Sun's ideal role with regard to Java was as an \"evangelist\".[38] Following Oracle Corporation's acquisition of Sun Microsystems in 2009–10, Oracle has described itself as the \"steward of Java technology with a relentless commitment to fostering a community of participation and transparency\".[39] This did not prevent Oracle from filing a lawsuit against Google shortly after that for using Java inside the Android SDK (see Google section below). Java software runs on everything from laptops to data centers, game consoles to scientific supercomputers.[40] On April 2, 2010, James Gosling resigned from Oracle.[41]\r\n"
				+ "\r\n"
				+ "In January 2016, Oracle announced that Java runtime environments based on JDK 9 will discontinue the browser plugin.[42]";
		getTextFromFirstBox().sendKeys(sentence);
		Thread thread = new Thread();
		try {
			thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String textBox2Data = driver.findElement(By.xpath("//div[@class='t_long b_secondaryFocus']")).getText();
		Assert.assertTrue(textBox2Data.contains("too much text"));
	}
}
