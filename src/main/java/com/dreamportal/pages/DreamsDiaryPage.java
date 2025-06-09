package com.dreamportal.pages;

import org.openqa.selenium.By;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DreamsDiaryPage {

	private WebDriver driver;

	// Locator for the dream entries table rows
	private By dreamRows = By.cssSelector("#dreamsDiary > tbody > tr");
	// Adjust selector as per your actual HTML

	public DreamsDiaryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Get total number of dream entries (rows)
	public int getDreamEntriesCount() {
		List<WebElement> rows = driver.findElements(dreamRows);
		return rows.size();
	}

	// Check if all dream types are "Good" or "Bad"
	public boolean areDreamTypesValid() {
		List<WebElement> rows = driver.findElements(dreamRows);
		for (WebElement row : rows) {
			String dreamType = row.findElement(By.xpath("./td[3]")).getText().trim();
			if (!(dreamType.equalsIgnoreCase("Good") || dreamType.equalsIgnoreCase("Bad"))) {
				return false; // invalid dream type found
			}
		}
		return true; // all dream types valid
	}

	// Verify all three columns are filled for each row
	public boolean areAllColumnsFilled() {
		List<WebElement> rows = driver.findElements(dreamRows);
		for (WebElement row : rows) {
			for (int i = 1; i <= 3; i++) {
				String cellText = row.findElement(By.xpath("./td[" + i + "]")).getText().trim();
				if (cellText.isEmpty()) {
					return false; // empty cell found
				}
			}
		}
		return true; // all cells filled
	}

	// Locator for all dream name cells in the diary table
	private By diaryDreamNames = By.xpath("//table[@id='dreamsDiary']//tbody//tr//td[1]");

	// This method returns a map of dream name -> count for all dreams
	public Map<String, Integer> getDreamNameCounts() {
		List<WebElement> dreamElements = driver.findElements(diaryDreamNames);
		Map<String, Integer> dreamCounts = new HashMap<>();

		for (WebElement elem : dreamElements) {
			String dreamName = elem.getText().trim();
			dreamCounts.put(dreamName, dreamCounts.getOrDefault(dreamName, 0) + 1);
		}
		return dreamCounts;
	}
	  private By diaryRows = By.cssSelector("#dreamsDiary tbody tr");
	  public List<String> getAllDreamNames() {
	        List<WebElement> rows = driver.findElements(diaryRows);
	        List<String> dreamNames = new ArrayList<>();

	        for (WebElement row : rows) {
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            if (!columns.isEmpty()) {
	                String dreamName = columns.get(0).getText().trim().toLowerCase();
	                dreamNames.add(dreamName);
	            }
	        }

	        return dreamNames;
	    }
	  
	  public Map<String, Integer> getRecurringDreamsCount() {
	        List<WebElement> rows = driver.findElements(diaryRows);
	        Map<String, Integer> dreamCountMap = new HashMap<>();

	        for (WebElement row : rows) {
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            if (cells.size() > 0) {
	                String dreamName = cells.get(0).getText().trim();
	                dreamCountMap.put(dreamName, dreamCountMap.getOrDefault(dreamName, 0) + 1);
	            }
	        }

	        // Filter to only recurring dreams (appear 2 or more times)
	        Map<String, Integer> recurringDreams = new HashMap<>();
	        for (Map.Entry<String, Integer> entry : dreamCountMap.entrySet()) {
	            if (entry.getValue() >= 2) {
	                recurringDreams.put(entry.getKey(), entry.getValue());
	            }
	        }

	        return recurringDreams;
	    }
	
	
}
