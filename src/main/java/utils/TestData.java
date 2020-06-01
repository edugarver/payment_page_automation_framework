package utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class that models the test data that comes in the testdata.properties file
 */
public class TestData {
    private String url;
    private String tourInformation;
    private String wrongDataEmail;
    private String wrongDataPassword;
    private String wrongDataPromoCode;
    private String validDataFirstName;
    private String validDataLastName;
    private String validDataEmail;
    private String validDataPhoneNumber;
    private String validCountryCode;
    private String validCreditCardNumber;
    private String validExpiryDateMonth;
    private String validExpiryDateYear;
    private String validSecurityCode;
    private String validDataFirstNameMaxLength;
    private String validDataLastNameMaxLength;
    private String invalidDataCharacters;
    private String invalidDataFirstNameLength;
    private String invalidDataLastNameLength;

    public String getUrl() {
        return url;
    }

    public String getTourInformation() {
        return tourInformation;
    }

    public String getWrongDataEmail() {
        return wrongDataEmail;
    }

    public String getWrongDataPassword() {
        return wrongDataPassword;
    }

    public String getWrongDataPromoCode() {
        return wrongDataPromoCode;
    }

    public String getValidDataFirstName() {
        return validDataFirstName;
    }

    public String getValidDataLastName() {
        return validDataLastName;
    }

    public String getValidDataEmail() {
        return validDataEmail;
    }

    public String getValidDataPhoneNumber() {
        return validDataPhoneNumber;
    }

    public String getValidCountryCode() {
        return validCountryCode;
    }

    public String getValidDataFirstNameMaxLength() {
        return validDataFirstNameMaxLength;
    }

    public String getValidDataLastNameMaxLength() {
        return validDataLastNameMaxLength;
    }

    public String getInvalidDataCharacters() {
        return invalidDataCharacters;
    }

    public String getInvalidDataFirstNameLength() {
        return invalidDataFirstNameLength;
    }

    public String getInvalidDataLastNameLength() {
        return invalidDataLastNameLength;
    }

    public String getValidCreditCardNumber() {
        return validCreditCardNumber;
    }

    public String getValidExpiryDateMonth() {
        return validExpiryDateMonth;
    }

    public String getValidExpiryDateYear() {
        return validExpiryDateYear;
    }

    public String getValidSecurityCode() {
        return validSecurityCode;
    }

    public TestData(String propFileName) {
        try {
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException();
            }
            this.url = properties.getProperty("url");
            this.tourInformation = properties.getProperty("tourInformation");
            this.wrongDataEmail = properties.getProperty("wrongData.email");
            this.wrongDataPassword = properties.getProperty("wrongData.password");
            this.wrongDataPromoCode = properties.getProperty("wrongData.promoCode");
            this.validDataFirstName = properties.getProperty("validData.firstName");
            this.validDataLastName = properties.getProperty("validData.lastName");
            this.validDataEmail = properties.getProperty("validData.email");
            this.validDataPhoneNumber = properties.getProperty("validData.phoneNumber");
            this.validCountryCode = properties.getProperty("validData.countryCode");
            this.validCreditCardNumber = properties.getProperty("validData.creditCardNumber");
            this.validExpiryDateMonth = properties.getProperty("validData.expiryDateMonth");
            this.validExpiryDateYear = properties.getProperty("validData.expiryDateYear");
            this.validSecurityCode = properties.getProperty("validData.securityCode");
            this.validDataFirstNameMaxLength = properties.getProperty("validData.firstNameMaxLength");
            this.validDataLastNameMaxLength = properties.getProperty("validData.lastNameMaxLength");
            this.invalidDataCharacters = properties.getProperty("invalidData.characters");
            this.invalidDataFirstNameLength = properties.getProperty("invalidData.firstNameLength");
            this.invalidDataLastNameLength = properties.getProperty("invalidData.lastNameLength");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
