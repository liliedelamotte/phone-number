// ldelamotte17@georgefox.edu
// Program 2
// 2018-09-13

/**
 * This class creates an instance of a phone number that adheres to the North American Numbering Plan.
 */
public class PhoneNumber implements Comparable<PhoneNumber> {


    private String _areaCode;
    private String _prefix;
    private String _lineNumber;


    /**
     * The PhoneNumber constructor method. Takes in the area code, prefix,
     * and line number of a phone number. All three parts of the phone number
     * are sent in separately. The area code and prefix are each 3 digits
     * long and allow [2-9][0-9][0-9], and the line number is 4 digits long
     * and allows [0–9] for each of the four digits.
     *
     * @param areaCode, the first three digits of a PhoneNumber object.
     * @param prefix, the second three digits of a PhoneNumber object.
     * @param lineNumber, the last four digits of a PhoneNumber object.
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber) {

        _areaCode = areaCode;
        _prefix = prefix;
        _lineNumber = lineNumber;

    }


    /**
     * Returns the area code of the phone number object.
     *
     * @return the area code of the phone number object.
     */
    public String getAreaCode() {

        return _areaCode;

    }


    /**
     * Returns the prefix of the phone number object.
     *
     * @return the prefix of the phone number object.
     */
    public String getPrefix() {

        return _prefix;

    }


    /**
     * Returns the line number of the phone number object.
     *
     * @return the line number of the phone number object.
     */
    public String getLineNumber() {

        return _lineNumber;

    }


    /**
     * Returns a String of all the phone number digits in XXXXXXXXXX format.
     *
     * @return a String of all the phone number digits in XXXXXXXXXX format.
     */
    public String getDigits() {

        return (_areaCode + _prefix + _lineNumber);

    }


    /**
     * Returns a String of the full phone number in XXX-XXX-XXXX format.
     *
     * @return a String of the full phone number in XXX-XXX-XXXX format.
     */
    @Override
    public String toString() {

        return (_areaCode + '-' + _prefix + '-' + _lineNumber);

    }


    /**
     * Takes in a PhoneNumber object and compares it to the PhoneNumber object the
     * method was called on. A number less than 0 will be returned if the objects
     * do not match and 0 will be returned if the objects match exactly.
     *
     * @param o, a PhoneNumber object.
     *
     * @return an integer that is the result of comparing two phone numbers.
     */
    @Override
    public int compareTo(PhoneNumber o) {

        return (this.getDigits().compareTo(o.getDigits()));

    }


    /**
     * Evaluates whether or not all digits in a given PhoneNumber are in the correct 
     * numerical range for a U.S. phone number. The digits of the area code and prefix 
     * should be in the range of [2-9][0-9][0-9] and all digits in the line number are 
     * in the range of [0-9].
     *
     * @param areaCode, the first three digits of a PhoneNumber object.
     * @param prefix, the second three digits of a PhoneNumber object.
     * @param lineNumber, the last four digits of a PhoneNumber object.
     *
     * @return a boolean value to represent whether or not all digits 
     * in a given PhoneNumber are in the correct numerical range.
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {

        return (areaCode.matches("[2-9][0-9][0-9]")
                && prefix.matches("[2-9][0-9][0-9]")
                && lineNumber.matches("[0-9][0-9][0-9][0-9]")
                && areaCode != null
                && prefix != null
                && lineNumber != null);

    }


    /**
     * Takes in an array of Strings containing each section of the PhoneNumber and makes
     * sure that there are exactly three parts (area code, prefix, and line number), no
     * more or less.
     *
     * @param parsedPhoneNumber, the array of Strings containing each section of PhoneNumber.
     *
     * @return a true or false value representing whether or not PhoneNumber meets specification.
     */
    private static boolean isValidPhoneNumber(String[] parsedPhoneNumber) {

        return (parsedPhoneNumber.length == 3);

    }


    /**
     * Takes in a String of ten digits in XXX-XXX-XXXX format that represents 
     * a phone number. Given phone number is then removed of dashes and then 
     * checked for validity. If the number is valid, a new PhoneNumber object 
     * is returned. If not, an Illegal Argument Exception is thrown.
     *
     * @param phoneNumber, a String of ten digits in XXX-XXX-XXXX format
     *
     * @return a new PhoneNumber object assuming the phone number was valid
     */
    public static PhoneNumber parsePhoneNumber(String phoneNumber) throws IllegalArgumentException {

        String[] parsedPhoneNumber = phoneNumber.split("-");

        // checks to see if the phone number is valid or not
        if (!isValidPhoneNumber(parsedPhoneNumber)
                || !isValidPhoneNumber(parsedPhoneNumber[0], parsedPhoneNumber[1], parsedPhoneNumber[2])) {
            throw new IllegalArgumentException("Sorry, one or more of the phone number(s) is not a "
                    + "valid phone number! Make sure that the phone number(s) sent in are in "
                    + "XXX-XXX-XXXX format, that the area code and prefix are each 3 digits "
                    + "long and allow [2-9][0-9][0-9], and that the line number is 4 "
                    + "digits long and allows [0–9] for each of the four digits.\n");
        }

        // if phone number is valid, a new phone number object is created
        else {
            return (new PhoneNumber(parsedPhoneNumber[0], parsedPhoneNumber[1], parsedPhoneNumber[2]));
        }

    }

}