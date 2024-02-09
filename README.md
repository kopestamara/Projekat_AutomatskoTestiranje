# SauceDemo

SauceDemo is a website for testing purposes where the main goal is to add items to cart and finish shopping

## Dependencies
* Run on Windows 10/11 OS
* IDE for this project is IntelliJ Idea Community Edition 2023.2.5
* Browsers needed is Chrome

## Instalation

Open terminal in IDE and git clone the repository

```
git clone https://github.com/kopestamara/Projekat_AutomatskoTestiranje.git
```
* java version `21.0.1`
* Apache Maven `4.0.0`

## Executing program
Run all tests from terminal with:
```
mvn test
```
Run specific class from terminal with:
```
mvn test -Dtest="HomePage_Login_Test"
```
Run specific xml file from terminal with:
```
mvn clean test -DsuiteXmlFile="testng.xml"
```
## Framework Walkthorugh
Packages:
* Base - Contains classes used through the app
* Utils - Contains excel and test helpers
* Pages - Contains classes for each page
* Tests - Contains test classes

Files:
* pom.xml - Contains all dependencies used in the project (last updated: 09.02.2024.)
* Credentials.xlsx - Excel file used to read some data for DDT
* .gitignore - File used to store all items that are not pushed to github

## Naming convention
* Classes are written in camel case with first character in upper case
* Methods are written in camel case with first character in lower case
* Class objects are named the same as a class name with lower case for first character

## Other
* Test methods are kept clean
* Priorities are set with 10 increment, if higher priority occurs later in testing, priority of such tests are placed between the two priorities