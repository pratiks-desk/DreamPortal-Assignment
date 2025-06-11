# 🧠 Dream Portal Assignment

This repository contains the completed UI automation assignment for a software internship opportunity, based on the Dream Portal interface.

---

## ✅ Assignment Objective

Automate and validate the **Dream Portal** UI using **Java**, **Selenium WebDriver**, and **TestNG**, covering the following pages:

1. `index.html` — Dream Portal Home  
2. `dreams-diary.html` — Dream Log Table  
3. `dreams-total.html` — Summary Statistics

---

## 🔍 Test Scenarios

### 🏠 index.html
- Loading animation appears and disappears after ~3 seconds
- Main content and "My Dreams" button become visible
- Clicking "My Dreams" opens `dreams-diary.html` and `dreams-total.html` in new tabs

### 📘 dreams-diary.html
- Exactly 10 dream entries present
- Validates all dream types are either "Good" or "Bad"
- Ensures each row contains Dream Name, Days Ago, and Dream Type

### 📊 dreams-total.html
- Verifies summary stats:  
  - Good Dreams: 6  
  - Bad Dreams: 4  
  - Total Dreams: 10  
  - Recurring Dreams: 2  
- Asserts recurring dreams:  
  - “Flying over mountains”  
  - “Lost in maze”

---

## 🧪 Tools & Technologies

- Java (JDK 17)  
- Selenium WebDriver  
- TestNG  
- ChromeDriver  
- Eclipse IDE  
- Maven  
- Git & GitHub

---

## 🚀 How to Run Tests

1. Clone the repository:  
`https://github.com/pratiks-desk/DreamPortal-Assignment.git`

2. Open the project in Eclipse or IntelliJ IDEA

3. Ensure ChromeDriver is installed and available in system path

4. Run tests via `testng.xml` or by right-clicking test classes and selecting **Run As → TestNG Test**

## ✅ Test Results

All test cases executed successfully using TestNG.  
Assertions confirm UI correctness and data validation across the tested pages.

---

## 👨‍💻 Author

**Pratik Joshi**  
 [![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:connect.pratikjoshi@gmail.com)   
 [![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/pratiks-desk) 
 [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pratiks-desk/) 
 
---
