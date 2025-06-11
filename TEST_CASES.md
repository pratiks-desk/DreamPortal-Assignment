# 🧪 Test Cases for Dream Portal UI Automation

## Summary of Test Scenarios

### 🏠 `index.html` — Dream Portal Home
- Loading animation appears and disappears (~3 seconds)
- Main content and "My Dreams" button become visible
- Clicking "My Dreams" opens `dreams-diary.html` and `dreams-total.html` in new tabs/windows

### 📘 `dreams-diary.html` — Dream Log Table
- Exactly 10 dream entries present
- Dream types are only “Good” or “Bad”
- Each row has Dream Name, Days Ago, and Dream Type columns filled

### 📊 `dreams-total.html` — Summary Statistics
- Good Dreams: 6
- Bad Dreams: 4
- Total Dreams: 10
- Recurring Dreams: 2
- Recurring dreams include “Flying over mountains” and “Lost in maze”

---

## Detailed Test Cases

### 🏠 index.html — Dream Portal Home

| Test Case ID | Description                         | Steps                                                                 | Expected Result                                             | Status  |
|--------------|-----------------------------------|----------------------------------------------------------------------|-------------------------------------------------------------|---------|
| TC_INDEX_01  | Verify loading animation duration | 1. Open `index.html` <br> 2. Observe loading animation visibility    | Loading animation appears and disappears in ~3 seconds       | Passed  |
| TC_INDEX_02  | Verify main content visibility    | 1. Wait for loading to finish <br> 2. Check if main content is shown | Main content and "My Dreams" button are visible              | Passed  |
| TC_INDEX_03  | Verify "My Dreams" button action  | 1. Click "My Dreams" button                                           | Opens `dreams-diary.html` and `dreams-total.html` in new tabs | Passed  |

---

### 📘 dreams-diary.html — Dream Log Table

| Test Case ID  | Description                         | Steps                                                         | Expected Result                                      | Status  |
|---------------|-----------------------------------|--------------------------------------------------------------|----------------------------------------------------|---------|
| TC_DIARY_01   | Verify dream entries count         | 1. Open `dreams-diary.html` <br> 2. Count dream entries      | Exactly 10 dream entries present                     | Passed  |
| TC_DIARY_02   | Validate dream types               | 1. Check all dream type cells                                | Only "Good" or "Bad" values                          | Passed  |
| TC_DIARY_03   | Validate all columns are filled   | 1. Verify Dream Name, Days Ago, Dream Type columns filled   | No empty columns in any row                          | Passed  |

---

### 📊 dreams-total.html — Summary Statistics

| Test Case ID  | Description                        | Steps                                                        | Expected Result                                      | Status  |
|---------------|----------------------------------|--------------------------------------------------------------|----------------------------------------------------|---------|
| TC_TOTAL_01   | Verify good dreams count          | 1. Open `dreams-total.html` <br> 2. Fetch Good Dreams stat   | Good Dreams count = 6                                | Passed  |
| TC_TOTAL_02   | Verify bad dreams count           | 1. Fetch Bad Dreams stat                                     | Bad Dreams count = 4                                 | Passed  |
| TC_TOTAL_03   | Verify total dreams count         | 1. Fetch Total Dreams stat                                   | Total Dreams count = 10                              | Passed  |
| TC_TOTAL_04   | Verify recurring dreams count     | 1. Fetch Recurring Dreams stat                               | Recurring Dreams count = 2                           | Passed  |
| TC_TOTAL_05   | Verify recurring dreams names     | 1. Check recurring dreams names                              | "Flying over mountains" and "Lost in maze" present | Passed  |

---

### Notes

- Status marked “Passed” based on test runs with TestNG automation.
- Pop-up blockers may affect tests opening new tabs/windows; disable them for reliable runs.
- Tests can be executed via `testng.xml` suite .
