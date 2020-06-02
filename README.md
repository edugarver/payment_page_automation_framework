# ipresence_practicaltest

The iPresence practical test consisted on writing a series of Test Cases and automating some of them.
The Test cases can be found at the end of this document.<br>
For the automation of the TCs, you can find in this repository an automation framework that was written using the Page Object Model design pattern; it's a maven project that uses Java, JUnit and Selenium.

## Prerequisites
In order to execute the TCs, the following has to be installed:
1. maven: the tests are executed as a maven goal, so it's compulsory to have it installed
2. (Optional) selenium grid: the hub and a node need to be running in order to execute the TCs there
3. (Optional) chromedriver

## Structure of the project
`src/main/java/pages` contains all the classes that model the pages of the application. The main classes are `PaymentPage` and `NavigationPage`. Inside this package we can also find the package `payment`, which contains other three classes that model different sections of the Payment page<br>
`src/main/java/utils` contains two utility classes: `BrowserDriver`, which is in charge of creating the webdriver instances, and `TestData`, which models the test data provided via the `testdata.properties` file
`src/main/resources` contains two chromedriver executables (one for mac and other for windows), as well as a properties file with the data that will be used in the Test cases
`src/test/java` contains the class `TestBase`, which is the class that has all the automated test cases

## Configuration of framework
The testdata.properties file contains a property called driver.location. This property is then used by the BrowserDriver class to create a local webdriver or a remote webdriver, on Selenium Grid.
By default, I included the following:
```properties
# Driver properties - uncomment the driver location that will be used for the execution
# local driver
driver.location=src/main/resources/chromedriver
#remote driver
#driver.location=http://localhost:4444/wd/hub
```
The uncommented driver.location points to the chromedriver that is included on this repo. Please, note that it is the macOS version of chrome driver.<br>
The commented driver.location points to the default location from Selenium Hub.<br>
This property can be changed to point at whichever chromedriver or Selenium Hub location that is needed.

## Execution of Test Cases
1. On a terminal, navigate to the folder of the project
2. Type `mvn clean test` on the terminal
<br>
That should run all the test cases in `TestBase`<br>

The following test cases were automated:<br>
TC-001: User is able to successfully book a tour using Credit Card<br>
TC-003: Payment page shows the correct fields and tour information<br>
TC-004: Traveler details fields (first name and last name) are required<br>
TC-005: Traveler details fields (first name and last name) data validation<br>
TC-012: Login link and login component basic functionality<br>
TC-013: Clicking on the "Chat Now" link opens the "Help Center"<br>
TC-014: Selecting PayPal/Credit card as payment method<br>
TC-015: "Promo code" section (invalid code)<br>

---

## Test cases

####TC-001: User is able to successfully book a tour using Credit Card
| **Step** | **Expected result** |
|----------|---------------------|
|Fill the form with valid data|No error message should be displayed on any field|
|Click on "Book Now" button|User should be redirected to the next page|

---

####TC-002: User is able to successfully book a tour using PayPal
| **Step** | **Expected result** |
|----------|---------------------|
|Select "PayPal" as payment method|1. "Credit card details" fields should be hidden<br>2. "Book Now" buttons are replaced with "Pay with PayPal" buttons|
|Fill the form with valid data|No error message should be displayed on any field|
|Click on "Pay with PayPal" button|"PayPal checkout" overlay is displayed|

---


#### TC-003: Payment page shows the correct fields and tour information 
| **Step** | **Expected result** |
|----------|---------------------|
|Check the right side menu|1. The tour name, date, time, and number of people displayed are the ones that were selected<br>2. The "Add promo code" link is displayed<br>3. The "Book Now" button is displayed|
|Check the "Traveler details" section|"Lead Traveler First Name" and "Lead Traveler Last Name" fields are displayed |
|Check the "Experience details" section| "Special Requirements" field is displayed|
|Check the "Payment details" section| 1. "Credit Card" and "PayPal" radio buttons are displayed<br>2. "Credit Card" option is selected by default<br>3. "Credit card details" fields are displayed|
|Check the "Contact information" details|1. "Email Address" and "Phone Number" fields are displayed<br>2. The SMS option and the subscription checkboxes are selected by default|

---

#### TC-004: Traveler details fields (first name and last name) are required
| **Step** | **Expected result** |
|----------|---------------------|
|Leave the "first name" and "last name" fields empty|        |
|Click on the "Book Now" button at the bottom|1. "First name" and "last name" fields are highlighted in red<br>2. The message "Traveler first/last name is required" is displayed below each field|

---

#### TC-005: Traveler details fields (first name and last name) data validation
| **Step** | **Expected result** |
|----------|---------------------|
|Set the "first name" field with an alphabetic string of 15 characters (max length)|The "first name" appears as valid|
|Set the "first name" field with an alphabetic string of more than 15 characters|1. Field is highlighted in red<br>2. The message "Traveler first name is too long" is displayed below the field|
|Set the "first name" field with a string containing a digit and/or one of the following characters <code>^<>%;"~`!@#$%&*()_+=</code>|1. Field is highlighted in red<br>2. The message "Traveler first name is invalid" is displayed below the field|
|Set the "last name" field with an alphabetic string of 35 characters (max length)|The "last name" appears as valid|
|Set the "last name" field with an alphabetic string of more than 35 characters|1. Field is highlighted in red<br>2. The message "Traveler last name is too long" is displayed below the field|
|Set the "last name" field with a string containing a digit and/or one of the following characters <code>^<>%;"~`!@#$%&*()_+=</code>|1. Field is highlighted in red<br>2. The message "Traveler last name is invalid" is displayed below the field|
---

#### TC-006: Contact information fields (email and phone number) are required
| **Step** | **Expected result** |
|----------|---------------------|
|Leave the "email address" field and the "phone number" field empty|                  |
|Click on the "Book Now" button on the right side |1. "Email" and "phone number" fields are highlighted in red<br>2. The text "Email address/Phone number is required" is displayed below each field|
|Click on the "Book Now" button at the bottom|1. "Email" and "phone number" fields are highlighted in red<br>2. The text "Email address/Phone number is required" is displayed below each field|

---

#### TC-007: Contact information fields (email and phone number) data validation
| **Step** | **Expected result** |
|----------|---------------------|
|Type non-numeric characters in the phone number field|No characters are input|
|Set the "phone number" field with a number with less digits than valid (this depends on the selected country)|1. The field is highlighted in red<br>2. The message "Phone number is invalid" is displayed below the field|
|Set the "phone number" field with a number with more digits than valid|1. The field is highlighted in red<br>2. The message "Phone number is invalid" is displayed below the field|
|Set the "phone number" field with an invalid number|1. The field is highlighted in red<br>2. The message "Phone number is invalid" is displayed below the field|
|Set the "email" field with an invalid value|1. The field is highlighted in red<br>2. The message "The email address you have entered is not valid. Please re-enter your email address." is displayed below the field|

---

#### TC-008: "Cardholder Name" field is required when choosing "Credit card" as payment method
| **Step** | **Expected result** |
|----------|---------------------|
|Select "Credit card" as the payment method | "Credit card details" fields are displayed|
|Fill the form, but leave the "Cardholder Name" field empty|                  |
|Click on the "Book Now" button on the right side |"Cardholder Name" field is highlighted in red, and the text "Credit card full name is required." is displayed below each field|
|Click on the "Book Now" button at the bottom|"Cardholder Name" field is highlighted in red, and the text "Credit card full name is required." is displayed below each field|

---

#### TC-009: "Cardholder Name" field data validation
| **Step** | **Expected result** |
|----------|---------------------|
|Set the "Cardholder Name" field with a string containing a digit and/or one of the following characters <code>^<>%;"0-9~`!@#$%&*()_+=</code>|1. The field is highlighted in red<br>2. The message "Credit card full name is invalid" is displayed below the field|
|Set the "Cardholder Name" field with a string with 2 characters|1. The field is highlighted in red<br>2. The message "This value is too short. It should have 3 characters or more." is displayed below the field|
|Set the "Cardholder Name" field with a string with 3 characters|The "Cardholder name" field appears as valid|

---

#### TC-010: Credit card details are compulsory when choosing "Credit card" as payment method
| **Step** | **Expected result** |
|----------|---------------------|
|Select "Credit card" as the payment method | "Credit card details" fields are displayed|
|Fill the form, but leave the "Credit Card Number", "Expiration Date" and "Security Code" fields empty|                  |
|Click on the "Book Now" button on the right side |The blank fields are highlighted in red, and the text "Enter a valid card number/security code" is displayed displayed below each field|
|Click on the "Book Now" button at the bottom|The blank fields are highlighted in red, and the text "Enter a valid card number/security code" is displayed below each field|

---

#### TC-011: Credit card details data validation
| **Step** | **Expected result** |
|----------|---------------------|
|Try to input non-numeric chars in the "Credit Card Number" field|No characters are inputted|
|Try to write more than 19 characters (without counting the - character)|No more than 19 characters (plus 4 - characters) are allowed|
|Set the "Security code" field with 2 digits|1. The field is highlighted in red<br>2. The message "Enter a valid security code" is displayed below the field|
|Set the "Security code" field with 3 or 4 digits|The "Security code" field appears as valid|
|Try to input more than 4 digits in the "Security code" field|No characters are inputted| 
|Try to input non-numeric chars in the "Security code" field|No characters are inputted|

---

#### TC-012: Login link and login component basic functionality
| **Step** | **Expected result** |
|----------|---------------------|
|Click on "Sign in to book faster" link|The following elements are displayed:<br>1. "Email" and "Password" fields<br>2."Forgot password" link<br>3. "Show password" button<br>4. "Log in" button|
|Fill the "Password" field and click on the "Show password" button|The password entered is displayed|
|Enter wrong credentials and click on "Log in" button| An error message is displayed over the login component|
|Enter correct credentials and click on "Log in" button"|User is correctly logged in|

---

#### TC-013: Clicking on the "Chat Now" link opens the "Help Center"
| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Chat now" button at the bottom of the right side menu|The "Help Center" shell is displayed over the right side menu|

---

#### TC-014: Selecting PayPal/Credit card as payment method
| **Step** | **Expected result** |
|----------|---------------------|
|Check the "Payment details" section|By default, the "Credit Card" radio button is selected, and the "Credit card details" fields are displayed|
|Select the "PayPal" radio button|1. "Credit card details" fields are hidden<br>2. "Book Now" buttons are replaced with "Pay with PayPal" buttons on the right side menu and on the bottom of the page|
|Select the "Credit Card" radio button|1. "Credit card details" fields are shown again<br>2. "Pay with PayPal" buttons are replaced with "Book Now" buttons on the right side menu and on the bottom of the page|

---

#### TC-015: "Promo code" section (invalid code)
| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Add promo code" link|1. The "Promo code" field is displayed<br> 2. The "Apply" button is displayed and disabled|
|Enter an invalid code|The "Apply" button gets enabled|
|Click on the "Apply" button|1. The "Promo code" field is highlighted in red<br>2. The following message is displayed: "Sorry, this promo code is expired or invalid. Please enter a different code or proceed to checkout."|

---

#### TC-016: "Promo code" section (valid code)
| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Add promo code" link|1. The "Promo code" field is displayed<br> 2. The "Apply" button is displayed and disabled|
|Enter a valid code|The "Apply" button gets enabled|
|Click on the "Apply" button|The corresponding promo should be applied|