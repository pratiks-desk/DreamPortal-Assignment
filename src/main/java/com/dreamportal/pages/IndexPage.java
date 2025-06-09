package com.dreamportal.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

	private WebDriver driver;

	// Locators
	private By loadingAnimation = By.id("loadingAnimation");
	private By mainContent = By.id("mainContent"); // This will need to be confirmed from HTML
	private By myDreamsButton = By.id("dreamButton"); // This will need to be confirmed from HTML

	// Constructor
	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions

	public boolean isLoadingAnimationVisible() {
		return driver.findElement(loadingAnimation).isDisplayed();
	}
  

	public void waitForLoadingToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingAnimation));
	}

	public boolean isMainContentVisible() {
		return driver.findElement(mainContent).isDisplayed();
	}

	public boolean isMyDreamsButtonVisible() {
		return driver.findElement(myDreamsButton).isDisplayed();
	}

	public void clickMyDreamsButton() {
		driver.findElement(myDreamsButton).click();
	}

	// Optional - To verify page title
	public String getPageTitle() {
		return driver.getTitle();
	}

}
