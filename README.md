# ipresence_practicaltest

## Test cases

####TC-001
*Description:* User is able to successfully book a tour using Credit Card

| **Step** | **Expected result** |
|----------|---------------------|
|||

---

####TC-002
*Description:* User is able to successfully book a tour using PayPal

| **Step** | **Expected result** |
|----------|---------------------|
|||

---


#### TC-003
*Description:* Payment page shows the correct information 

| **Step** | **Expected result** |
|----------|---------------------|
|Check the right side menu|1. The tour name, date, time, and number of people displayed are the ones that were selected<br>2. The "Add promo code" link is displayed<br>3. The "Book Now" button is displayed|
|Check the Traveler details section|Lead Traveler First Name and Lead Traveler fields are displayed |
|Check the Experience details section| Special Requirements field is displayed|
|Check the Payment details section| 1. Credit Card and PayPal radio buttons are displayed<br>2. Credit Card option is selected by default<br>3. Credit card details fields are displayed|
|Check the Contact information details|1. Email Address and Phone Number fields are displayed<br>2. The SMS option and the subscription checkboxes are selected by default|

---

#### TC-004
*Description:* Traveler details fields (first name and last name) are required

| **Step** | **Expected result** |
|----------|---------------------|
|Leave the first name and last name fields empty|        |
|Click on the "Book Now" button on the right side |1. First and last name fields are highlighted in red<br>2. The text "Traveler first/last name is required" is displayed below each field|
|Click on the "Book Now" button at the bottom|1. First and last name fields are highlighted in red<br>2. The text "Traveler first/last name is required" is displayed below each field|

---

#### TC-005
*Description:* Traveler details fields (first name and last name) data validation

| **Step** | **Expected result** |
|----------|---------------------|
|Set the first name field with a name of 15 characters||
|First name more than 15 characters||
|First name contains one of the following <code>^<>%;"0-9~`!@#$%&*()_+=</code>||
|Last name 35 characters||
|Last name more than 35 characters||
|Last name contains one of the following <code>^<>%;"0-9~`!@#$%&*()_+=</code>||

---

#### TC-006
*Description:* Contact information fields (email and phone number) are required

| **Step** | **Expected result** |
|----------|---------------------|
|Leave the email address field and the phone number field empty|                  |
|Click on the "Book Now" button on the right side |1. Email and phone number fields are highlighted in red<br>2. The text "Email address/Phone number is required" is displayed below each field|
|Click on the "Book Now" button at the bottom|1. Email and phone number fields are highlighted in red<br>2. The text "Email address/Phone number is required" is displayed below each field|

---

#### TC-007
*Description:* Contact information fields (email and phone number) data validation

| **Step** | **Expected result** |
|----------|---------------------|
|Type non-numeric characters in the phone number field|No characters are input|
|Select Spain (e.g.)||
|Short number||
|Long number||
|Invalid number||
|example.com (no @ character)||
|A@b@c@domain.com (only one @ is allowed outside quotation marks)||
|a”b(c)d,e:f;gi[j\k]l@domain.com (none of the special characters in this local part are allowed outside quotation marks).||
|abc”test”email@domain.com (quoted strings must be dot separated or the only element making up the local part).||
|abc is”not\valid@domain.com (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash).||
|abc\ is\”not\valid@domain.com (even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained in quotes).||
|test@domain..com (double dot after @).||
|a valid address with a leading space.||
|a valid address with a trailing space.||

---

#### TC-008
*Description:* "Cardholder Name" field is required when choosing "Credit card" as payment method

| **Step** | **Expected result** |
|----------|---------------------|
|Select "Credit card" as the payment method | Credit card details fields are displayed|
|Fill the form, but leave the "Cardholder Name" field empty|                  |
|Click on the "Book Now" button on the right side |"Cardholder Name" field is highlighted in red, and the text "Credit card full name is required." is displayed below each field|
|Click on the "Book Now" button at the bottom|"Cardholder Name" field is highlighted in red, and the text "Credit card full name is required." is displayed below each field|

---

#### TC-009
*Description:* "Cardholder Name" field data validation

| **Step** | **Expected result** |
|----------|---------------------|
|Name that contains <code>^<>%;"0-9~`!@#$%&*()_+=</code>||
|Name with 2 characters||
|Name with 3 characters||

---

#### TC-010
*Description:* Credit card details are compulsory when choosing "Credit card" as payment method

| **Step** | **Expected result** |
|----------|---------------------|
|Select "Credit card" as the payment method | Credit card details fields are displayed|
|Fill the form, but leave the "Credit Card Number", "Expiration Date" and "Security Code" fields empty|                  |
|Click on the "Book Now" button on the right side |The blank fields are highlighted in red, and the text "Enter a valid card number/security code" are displayed|
|Click on the "Book Now" button at the bottom|The blank fields are highlighted in red, and the text "Enter a valid card number/security code" are displayed|

---

#### TC-011
*Description:* Credit card details data validation

| **Step** | **Expected result** |
|----------|---------------------|
|Try to input non-numeric chars in number||
|After four digits, adds -||
|Valid card number||
|Send 23 characters||
|CSV 2 chars||
|CSV 3 chars||
|CSV 4 chars|| 

---

#### TC-012
*Description:* Login component

| **Step** | **Expected result** |
|----------|---------------------|
|Click on "Sign in to book faster" link|The following elements are displayed:<br>1. Email and Password fields<br>2."Forgot password link"<br>3. "Show password" button<br>4. Log in button|
|Fill the Password field and click on the "Show password" button|The password entered is displayed|
|Enter wrong credentials and click on "Log in" button| An error message is displayed over the login component|

---

#### TC-013
*Description:* Clicking on the "Chat Now" link opens the "Help Center"

| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Chat now" button at the bottom of the right side menu|The "Help Center" shell is displayed over the right side menu|

---

#### TC-014
*Description:* Selecting PayPal/Credit card as payment method

| **Step** | **Expected result** |
|----------|---------------------|
|Check the Payment details section|By default, the Credit Card radio button is selected, and the Credit card details are displayed|
|Select the PayPal radio button|1. Credit card details are hidden<br>2. "Book Now" buttons are replaced with "Pay with PayPal" buttons on the right side menu and on the bottom of the page|
|Select the Credit Card radio button|1. Credit card details are shown again<br>2. "Pay with PayPal" buttons are replaced with "Book Now" buttons on the right side menu and on the bottom of the page|

---

#### TC-015
*Description:* "Promo code" section (invalid code)

| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Add promo code" link|1. The "Promo code" field is displayed<br> 2. The Apply button is displayed and disabled|
|Enter an invalid code|The "Apply" button gets enabled|
|Click on the "Apply" button|1. The "Promo code" field is highlighted in red<br>2. The following message is displayed: "Sorry, this promo code is expired or invalid. Please enter a different code or proceed to checkout."|

---

#### TC-016
*Description:* "Promo code" section (valid code)

| **Step** | **Expected result** |
|----------|---------------------|
|Click on the "Add promo code" link|1. The "Promo code" field is displayed<br> 2. The Apply button is displayed and disabled|
|Enter a valid code|The "Apply" button gets enabled|
|Click on the "Apply" button|The corresponding promo should be applied|