package com.meetup.contactmanager.validators;

public class DataValidator {
    /**
     * Validates input data and returns true if all values are valid
     * @param data
     * @return True if valid and false if invalid
     */
    public static boolean validate(String[] data) {
        boolean isValid = true;
        if (data.length == 20) {
            if (data[19].length() != 7 && data[19].length() != 10) {
                isValid = false;
            }
        }
        return isValid;
    }
}
