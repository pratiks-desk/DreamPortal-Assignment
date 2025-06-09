package com.dreamportal.tests;

import com.dreamportal.pages.DreamsTotalPage;
import com.dreamportal.pages.DreamsDiaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class DreamsTotalTest {

	private WebDriver driver;
	private DreamsTotalPage dreamsTotalPage;
	private DreamsDiaryPage dreamsDiaryPage;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	public void verifyDreamsSummaryStatsAndRecurringLogic() {
		// Step 1: Go to summary page
		driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");

		dreamsTotalPage = new DreamsTotalPage(driver);

		// Step 2: Fetch stats dynamically
		int goodDreamsCount = dreamsTotalPage.getGoodDreamsCount();
		int badDreamsCount = dreamsTotalPage.getBadDreamsCount();
		int totalDreamsCount = dreamsTotalPage.getTotalDreamsCount();
		int recurringDreamsCount = dreamsTotalPage.getRecurringDreamsCount();

		System.out.println("✅ Verified Stats:");
		System.out.println("Good Dreams: " + goodDreamsCount);
		System.out.println("Bad Dreams: " + badDreamsCount);
		System.out.println("Total Dreams: " + totalDreamsCount);
		System.out.println("Recurring Dreams: " + recurringDreamsCount);

		// Step 3: Go to diary page
		driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");

		// Step 4: Get actual recurring dreams logic from diary
		dreamsDiaryPage = new DreamsDiaryPage(driver);
		Map<String, Integer> recurringDreamsMap = dreamsDiaryPage.getRecurringDreamsCount();

		System.out.println("\n✅ Recurring dreams and their counts:");
		for (Map.Entry<String, Integer> entry : recurringDreamsMap.entrySet()) {
			System.out.println("Dream: " + entry.getKey() + " — Count: " + entry.getValue());
		}

		// Step 5: Assertions
		Assert.assertTrue(recurringDreamsMap.containsKey("Flying over mountains"),
				"❌ 'Flying over mountains' not found as recurring.");
		Assert.assertTrue(recurringDreamsMap.containsKey("Lost in maze"), "❌ 'Lost in maze' not found as recurring.");

		Assert.assertEquals(recurringDreamsCount, recurringDreamsMap.size(),
				"❌ Recurring dreams count on summary page does not match diary logic.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
