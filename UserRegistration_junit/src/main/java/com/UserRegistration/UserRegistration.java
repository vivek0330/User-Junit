/*
 * <h1>"Welcome to the user registration problem !!"</h1>
 * The Data Structure Program implements an application that
 * simply displays ""Welcome to the user registration problem !!"" to the standard output.
 *
 * @author Official_vk
 * @version 1.0
 * @since 2021-07-29
 */
package com.UserRegistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    /*
     * Purpose: Boolean method to validate first and last name.
     * Condition for regex is, first name and last name should start
     * with capital letter and name should have minimum 3 letters.
     *
     * @param name: First and last name to validate.
     */
    public boolean validateName(String name) {
        try {
            if (name.length() == 0) {
                throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_EMPTY, "First name cannot be empty");
            }
            boolean isMatched = Pattern.compile("^[A-Z]{1}[a-z]{2,}$").matcher(name).matches();
            checkValid(isMatched);
            return isMatched;
        } catch (NullPointerException e) {
            throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_NULL, "First name cannot be empty");
        }
    }

    /*
     * Purpose: Boolean method to validate mail ID of user.
     *
     * @param mail: mail to validate.
     */
    public boolean validateEmail(String mail) {
        try {
            if (mail.length() == 0) {
                throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_EMPTY, "Email cannot be empty");
            }
            boolean isMatched = Pattern.compile(
                    "^[0-9A-Za-z]+(([._+-]{0,1})[0-9A-Za-z]+)*@[0-9A-Za-z]+.[a-z]{2,4}.([a-z]{2,3})*$")
                    .matcher(mail).matches();
            checkValid(isMatched);
            return isMatched;

        } catch (NullPointerException e) {
            throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_NULL, "email cannot be empty");
        }
    }

    /*
     * Purpose: Boolean method to validate user's mobile number.
     * Condition 1: Mobile number should start with 91
     * Condition 2: Mobile number should have 10 numbers.
     *
     * @param mobileNumber: mobile number to validate.
     */
    public boolean validateMobileNumber(String mobileNumber) {
        try {
            if (mobileNumber.length() == 0) {
                throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_EMPTY, "Phone Number cannot be empty");
            }
            boolean isMatched = Pattern.compile("^(91)[\\s][0-9]{10}$").matcher(mobileNumber).matches();
            checkValid(isMatched);
            return isMatched;
        } catch (NullPointerException e) {
            throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_NULL, "Phone number cannot be empty");
        }
    }

    /*
     * Purpose: Boolean method to validate user's password.
     * Rule 1: Password should have minimum 8 characters.
     * Rule 2: Password should have at least one upper-case.
     * Rule 3: Password should have at least one numeric value.
     * Rule 4: Password should have only one special character.
     *
     * @param password: Password to validate.
     */
    public boolean validatePassword(String password) {
        try {
            if (password.length() == 0) {
                throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_EMPTY, "Password cannot be empty");
            }
            boolean isMatched = Pattern.compile("^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
                    .matcher(password).matches();
            checkValid(isMatched);
            return isMatched;
        } catch (NullPointerException e) {
            throw new userRegistrationException(userRegistrationException.ExceptionType.ENTERED_NULL, "Password cannot be empty");
        }
    }

    /* Purpose: Method to check whether result is valid or invalid*/
    public void checkValid(boolean isMatched) {
        if (isMatched) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }

}
