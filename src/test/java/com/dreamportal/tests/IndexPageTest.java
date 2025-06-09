package com.dreamportal.tests;

import com.dreamportal.pages.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class IndexPageTest {

	private WebDriver driver;
	private IndexPage indexPage;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void testLoadingAnimationDuration() {

		driver.get("https://arjitnigam.github.io/myDreams/index.html");
		System.out.println("\n--------------------------------------------------------------------");
		indexPage = new IndexPage(driver);
		// Wait for loading animation to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loadingAnimation")));
		long startTime = System.currentTimeMillis();
		System.out.println("✅ Loading animation appeared correctly.");

		// Wait for loading animation to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingAnimation")));
		long endTime = System.currentTimeMillis();
		System.out.println("✅ Loading animation disappeared correctly.");

		long durationSeconds = (endTime - startTime) / 1000;
		System.out.println("Loading animation disappeared after: " + durationSeconds + " seconds.");

		System.out.println("--------------------------------------------------------------------\n");

		// Assert the duration is approximately 3 seconds (between 2 and 4)
		Assert.assertTrue(durationSeconds >= 2 && durationSeconds <= 4,
				"❌ Loading animation duration should be approximately 3 seconds, but was " + durationSeconds
						+ " seconds.");

	}

	@Test(priority = 2, dependsOnMethods = "testLoadingAnimationDuration")
	public void testMainContentAndButtonVisibility() throws InterruptedException {
		driver.get("https://arjitnigam.github.io/myDreams/index.html");
		indexPage = new IndexPage(driver);

		// We assume already on index page after previous test or navigate again if
		// needed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for tabs to open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainContent")));
		Assert.assertTrue(indexPage.isMainContentVisible(), "Main content should be visible.");
		Assert.assertTrue(indexPage.isMyDreamsButtonVisible(), "'My Dreams' button should be visible.");
		if (indexPage.isMainContentVisible() && indexPage.isMyDreamsButtonVisible()) {
			System.out.println("✅ The main content and My Dreams button is visible now");
		} else {
			System.out.println("❌ The main content and My Dreams button is  not visible");
		}
		System.out.println("--------------------------------------------------------------------\n");

	}

	@Test(priority = 3, dependsOnMethods = "testMainContentAndButtonVisibility")
	public void testMyDreamsButtonOpensTabs() throws InterruptedException {
		driver.get("https://arjitnigam.github.io/myDreams/index.html");
		indexPage = new IndexPage(driver);
		String originalWindow = driver.getWindowHandle();
		Set<String> windowsBeforeClick = driver.getWindowHandles();
		Thread.sleep(Duration.ofSeconds(3));
		indexPage.clickMyDreamsButton();
		System.out.println("My Dreams button clicked.!");

		Thread.sleep(2000); // Wait for tabs to open

		Set<String> windowsAfterClick = driver.getWindowHandles();
		Thread.sleep(2000); // Wait for tabs to open

		int tabsOpened = windowsAfterClick.size() - windowsBeforeClick.size();
		Assert.assertEquals(tabsOpened, 2, "'My Dreams' button should open 2 new tabs.");
		if (tabsOpened == 2) {
			System.out.println("2 new tabs opened.");

		}

		// Optional: print URLs of all tabs
		for (String windowHandle : windowsAfterClick) {
			driver.switchTo().window(windowHandle);
			String currentUrl = driver.getCurrentUrl();
			String lastSegment = currentUrl.substring(currentUrl.lastIndexOf("/") + 1);
			System.out.println("Opened tab: " + lastSegment);
		}
		System.out.println("--------------------------------------------------------------------\n");
		// Switch back to original window
		driver.switchTo().window(originalWindow);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
