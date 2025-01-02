# MyCucumber Automation Testing Project

## Overview
The **MyCucumber** project is an automation testing suite designed to test the functionality and security of the ParaBank demo application. It leverages Cucumber for behavior-driven development (BDD) and Selenium for browser-based testing. The project also includes custom Java utilities to simplify and enhance the automation framework. I built this framework to practice my Cucumber and Selenium testing techniques.

## Features

### 1. **Login Functionality**
- Tests login with valid credentials to ensure successful authentication.
- Tests login with invalid credentials to verify error handling and messaging.

### 2. **Account Summary**
- Verifies that logged-in users can view account balances and details.
- Ensures accurate display of account information.

### 3. **Fund Transfers**
- Automates transferring funds between accounts.
- Includes edge case testing, such as invalid or missing input.

### 4. **Bill Payment**
- Simulates paying external payees using the ParaBank Bill Payment feature.
- Validates the input form, payment confirmation, and error handling.

### 5. **Transaction History**
- Verifies users can view and filter their transaction history.
- Tests error handling for invalid filter criteria.

### 6. **SQL Injection Testing**
- Focuses on identifying SQL injection vulnerabilities in input fields.
- Tests for malicious SQL payloads in login, payee name, and other fields.

## Project Structure
```
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- org.example
|   |   |       |-- BrowserUtility.java
|   |   |       |-- LoginUtility.java
|   |   |       |-- Main.java
|   |-- test
|       |-- java
|       |   |-- StepDefinitions
|       |       |-- AccountSummarySteps.java
|       |       |-- BillPaymentSteps.java
|       |       |-- FundTransferSteps.java
|       |       |-- LoginSteps.java
|       |       |-- SQLInjectionSteps.java
|       |       |-- TransactionHistorySteps.java
|       |-- resources
|           |-- features
|               |-- account_summary.feature
|               |-- bill_payment.feature
|               |-- fund_transfer.feature
|               |-- login.feature
|               |-- sql_injection.feature
|               |-- transaction_history.feature
```

## Technologies Used
- **Programming Language**: Java
- **Testing Framework**: Cucumber, Selenium
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **Test Framework**: JUnit

## Setup and Execution

### Prerequisites
1. Install **Java JDK** (version 8 or higher).
2. Install **Maven**.
3. Download and configure the appropriate **ChromeDriver** for your Chrome browser version.

### Steps to Run Tests
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd MyCucumber
   ```
3. Execute the tests using Maven:
   ```bash
   mvn test
   ```

### Viewing Test Reports
- Cucumber HTML reports are generated in the `target/cucumber-html-reports` directory.
- Detailed test logs and results are available in the `target/surefire-reports` directory.

## Key Files

### **Utilities**
- **BrowserUtility.java**: Handles browser setup and teardown.
- **LoginUtility.java**: Provides reusable methods for login operations.

### **Feature Files**
- **`login.feature`**: Contains scenarios for testing login functionality.
- **`account_summary.feature`**: Verifies account details are displayed correctly.
- **`fund_transfer.feature`**: Automates fund transfers between accounts.
- **`bill_payment.feature`**: Tests the Bill Payment feature.
- **`transaction_history.feature`**: Verifies transaction history functionality.
- **`sql_injection.feature`**: Tests for SQL injection vulnerabilities.

### **Step Definitions**
- **AccountSummarySteps.java**: Step definitions for account summary scenarios.
- **BillPaymentSteps.java**: Step definitions for bill payment scenarios.
- **FundTransferSteps.java**: Step definitions for fund transfer scenarios.
- **LoginSteps.java**: Step definitions for login scenarios.
- **SQLInjectionSteps.java**: Step definitions for SQL injection testing.
- **TransactionHistorySteps.java**: Step definitions for transaction history scenarios.


## Acknowledgments
This project was built using the ParaBank demo application, provided by Parasoft, as a learning and testing platform for automation testing enthusiasts.

---

