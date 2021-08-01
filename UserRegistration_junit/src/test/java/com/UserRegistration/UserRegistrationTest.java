package com.UserRegistration;

import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {

    UserRegistration validator = new UserRegistration();

    // Test cases to validate First Name.
    @Test
    public void givenFirstName_WhenValid_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateName("Vivek"));
    }

    @Test
    public void givenFirstName_WhenStartingNotCapital_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("vivek"));
    }

    @Test
    public void givenFirstName_WhenShort_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("vmk"));
    }

    @Test
    public void givenFirstName_WithNumberOrSpecialChar_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("$am18"));
    }

    // Test cases for last name.
    @Test
    public void givenLastName_WhenValid_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateName("Bms"));
    }

    @Test
    public void givenLastName_WhenStartingNotCapital_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("bms"));
    }

    @Test
    public void givenLastName_WhenShort_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("Bm"));
    }

    @Test
    public void givenLastName_WithNumberOrSpecialChar_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateName("Bm$18"));
    }

    // Test cases to validate email.

    @Test
    public void givenMail_WhenValid_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateEmail("abc@yahoo.com"));
    }

    @Test
    public void givenMail_WithoutAtTheRate_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateEmail("abc.com"));
    }

    @Test
    public void givenMail_WithoutUserName_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateEmail("@gmail.com"));
    }

    @Test
    public void givenMail_WithoutDomainName_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateEmail("abc@.com"));
    }

    @Test
    public void givenMail_WithoutMainTld_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateEmail("abc@gmail.com"));
    }

    @Test
    public void givenMail_WithOptionalTld_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateEmail("abc@yahoo.co.in"));
    }

    @Test
    public void givenMail_WithOptionalUserName_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateEmail("abc+100@yahoo.co.in"));
    }

    // Test cases to validate Mobile number.


    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue() {
        Assert.assertTrue(validator.validateMobileNumber("91 9686762778"));
    }

    @Test
    public void givenMobileNumber_WhenNoSpaceAfterCode_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateMobileNumber("919686762778"));
    }

    @Test
    public void givenMobileNumber_WhenNoCountryCode_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateMobileNumber("9686762778"));
    }

    @Test
    public void givenMobileNumber_WhenShort_ShouldReturnFalse() {
        Assert.assertFalse(validator.validateMobileNumber("919686762"));
    }

    // Test Cases to validate Password.
    @Test
    public void givenPassword_WhenValid_ShouldReturnTrue() {
        Assert.assertTrue(validator.validatePassword("Abc$def18"));
    }

    @Test
    public void givenPassword_WhenShort_ShouldReturnFalse() {
        Assert.assertFalse(validator.validatePassword("Abc$11"));
    }

    @Test
    public void givenPassword_WhenNoUpperCase_ShouldReturnFalse() {
        Assert.assertFalse(validator.validatePassword("abc$defog18"));
    }

    @Test
    public void givenPassword_WhenNoNumber_ShouldReturnFalse() {
        Assert.assertFalse(validator.validatePassword("Abc$de"));
    }

    @Test
    public void givenPassword_With2SpecialChar_ShouldReturnFalse() {
        Assert.assertFalse(validator.validatePassword("Abc$$defer1"));
    }

    @Test
    public void givenFirstName_WhenNull_ShouldReturnException() {
        try {
            validator.validateName(null);
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    // Using exceptions.
    @Test
    public void givenFirstName_WhenEmpty_ShouldReturnException() {
        try {
            validator.validateName("");
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenLastName_WhenNull_ShouldReturnException() {
        try {
            validator.validateName(null);
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenLastName_WhenEmpty_ShouldReturnException() {
        try {
            validator.validateName("");
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenEmail_WhenNull_ShouldReturnException() {
        try {
            validator.validateEmail(null);
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenEmail_WhenEmpty_ShouldReturnException() {
        try {
            validator.validateEmail("");
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenPhoneNumber_WhenNull_ShouldReturnException() {
        try {
            validator.validateMobileNumber(null);
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenPhoneNumber_WhenEmpty_ShouldReturnException() {
        try {
            validator.validateMobileNumber("");
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenPassword_WhenNull_ShouldReturnException() {
        try {
            validator.validatePassword(null);
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenPassword_WhenEmpty_ShouldReturnException() {
        try {
            validator.validatePassword("");
        } catch (userRegistrationException e) {
            Assert.assertEquals(userRegistrationException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }
}
