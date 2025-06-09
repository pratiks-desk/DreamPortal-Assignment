package com.dreamportal.tests;

import com.dreamportal.pages.DreamsDiaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DreamsDiaryTest {

	private WebDriver driver;
	private DreamsDiaryPage diaryPage;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

		diaryPage = new DreamsDiaryPage(driver);
	}

	@Test(priority = 1)
	public void verifyDreamEntriesCount() {
		System.out.println("-----------------------------------------------------------------\n");

		int totalEntries = diaryPage.getDreamEntriesCount();
		System.out.println("Total dream entries: " + totalEntries);
		Assert.assertEquals(totalEntries, 10, "❌ There should be exactly 10 dream entries.");
		if (totalEntries == 10) {
			System.out.println("✅ There are exactly 10 dream entries");

		} else {
			System.out.println("❌ These are not 10 dreams in entries.");
		}
		System.out.println("-----------------------------------------------------------------\n");
	}

	@Test(priority = 2)
	public void verifyDreamTypesValidity() {
		boolean validTypes = diaryPage.areDreamTypesValid();
		Assert.assertTrue(validTypes, "❌ Some dream types are not 'Good' or 'Bad'.");
		// Validate dream types
		if (diaryPage.areDreamTypesValid()) {
			System.out.println("✅ Valid dream types. As they are only Good or Bad. ");
		} else
			System.out.println("❌ Some dream types are invalid.");
		System.out.println("-----------------------------------------------------------------\n");
	}

	@Test(priority = 3)
	public void verifyAllColumnsAreFilled() {
		boolean allFilled = diaryPage.areAllColumnsFilled();
		Assert.assertTrue(allFilled, "❌ Some dream entries have empty columns.");
		// Validate all columns are filled
		if (diaryPage.areAllColumnsFilled()) {
			System.out.println("✅ All rows have all filled columns.");
		} else {
			System.out.println("❌ Some rows have empty columns.");
		}
		System.out.println("-----------------------------------------------------------------\n");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
