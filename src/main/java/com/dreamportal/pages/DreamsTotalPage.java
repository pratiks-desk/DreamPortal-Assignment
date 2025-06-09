package com.dreamportal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DreamsTotalPage {

    private WebDriver driver;

    private By goodDreamsCount = By.xpath("//table[@id='dreamsTotal']//td[text()='Good Dreams']/following-sibling::td");
    private By badDreamsCount = By.xpath("//table[@id='dreamsTotal']//td[text()='Bad Dreams']/following-sibling::td");
    private By totalDreamsCount = By.xpath("//table[@id='dreamsTotal']//td[text()='Total Dreams']/following-sibling::td");
    private By recurringDreamsCount = By.xpath("//table[@id='dreamsTotal']//td[text()='Recurring Dreams']/following-sibling::td");

    public DreamsTotalPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getGoodDreamsCount() {
        return Integer.parseInt(driver.findElement(goodDreamsCount).getText().trim());
    }

    public int getBadDreamsCount() {
        return Integer.parseInt(driver.findElement(badDreamsCount).getText().trim());
    }

    public int getTotalDreamsCount() {
        return Integer.parseInt(driver.findElement(totalDreamsCount).getText().trim());
    }

    public int getRecurringDreamsCount() {
        return Integer.parseInt(driver.findElement(recurringDreamsCount).getText().trim());
    }
}
