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
        String regex = "^[A-Z]{1}[a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);

        // Returns false if user does not enter any name.
        if (name.isEmpty())
            return false;

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

    /*
     * Purpose: Boolean method to validate mail ID of user.
     *
     * @param mail: mail to validate.
     */
    public boolean validateEmail(String mail) {
        String regex = "^[0-9A-Za-z]+(([._+-]{0,1})[0-9A-Za-z]+)*@[0-9A-Za-z]+.[a-z]{2,4}.([a-z]{2,3})*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    /*
     * Purpose: Boolean method to validate user's mobile number.
     * Condition 1: Mobile number should start with 91
     * Condition 2: Mobile number should have 10 numbers.
     *
     * @param mobileNumber: mobile number to validate.
     */
    public boolean validateMobileNumber(String mobileNumber) {
        // Space is not used, as console wont accept space.
        String regex = "^(91)[\\s][0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
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
        String regex = ("^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
