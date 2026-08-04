# Playwright Java Automation Framework

A scalable UI automation framework built using **Playwright**, **Java**, and **TestNG** following the **Page Object Model (POM)** design pattern.

This project demonstrates how to build a reusable Playwright automation framework from scratch with clean architecture and reusable components.

---

## Tech Stack

- Java 17
- Playwright Java
- TestNG
- Maven
- Page Object Model (POM)

---

## Project Structure

```
Playwright_Java
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │     ├── PlaywrightFactory.java
│   │   │   │     └── BasePage.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │     └── LoginPage.java
│   │   │   │
│   │   │   ├── utils
│   │   │   │     └── ConfigReader.java
│   │   │   │
│   │   │   └── api
│   │   │
│   │   └── resources
│   │         └── config.properties
│   │
│   └── test
│       ├── java
│       │     ├── base
│       │     │     └── BaseTest.java
│       │     │
│       │     ├── tests
│       │     │     └── LoginTest.java
│       │     │
│       │     ├── hooks
│       │     ├── runner
│       │     └── stepdefinitions
│       │
│       └── resources
│             └── features
│
└── pom.xml
```

---

## Framework Features

- Playwright browser automation
- Java-based automation framework
- TestNG integration
- Page Object Model (POM)
- Reusable BasePage
- Browser lifecycle management using PlaywrightFactory
- ThreadLocal support for browser objects
- Cross-browser ready (Chromium, Firefox, WebKit)
- Clean and modular framework structure

---

## Test Scenario Implemented

### Login Test

- Launch Browser
- Navigate to OrangeHRM Demo
- Enter Username
- Enter Password
- Click Login
- Verify Dashboard
- Close Browser

---

## Design Pattern

This framework follows the **Page Object Model (POM)** design pattern.

```
LoginTest
      │
      ▼
LoginPage
      │
      ▼
BasePage
      │
      ▼
PlaywrightFactory
      │
      ▼
Playwright Browser
```

---

## How to Run

Clone the repository

```
git clone https://github.com/PranavJ247/Playwright_Java.git
```

Navigate to the project

```
cd Playwright_Java
```

Install dependencies

```
mvn clean install
```

Run the tests

```
mvn test
```

---

## Future Enhancements

- Configuration Management
- Screenshot Utility
- Wait Utility
- Extent Reports
- Log4j2 Logging
- Excel Data-Driven Framework
- API Automation
- Cucumber BDD Integration
- Parallel Execution
- Retry Analyzer
- CI/CD Integration using GitHub Actions

---

## Author

**Pranav Jadhav**

GitHub:
https://github.com/PranavJ247
