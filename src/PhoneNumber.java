// ldelamotte17@georgefox.edu

/**
 * 
 *
 */
public class PhoneNumber implements Comparable<PhoneNumber> {
    
    
    private String _areaCode;
    private String _prefix;
    private String _lineNumber;
    
    private static String _parsedPhoneNumber;
    private static String _parsedPhoneNumberAreaCode;
    private static String _parsedPhoneNumberPrefix;
    private static String _parsedPhoneNumberLineNumber;
    private static boolean _parsedPhoneNumberIsValid;
    private static boolean _isValidPhoneNumber;
    
    private static int _digit1;
    private static int _digit2;
    private static int _digit3;
    private static int _digit4;
    private static int _digit5;
    private static int _digit6;
    private static int _digit7;
    private static int _digit8;
    private static int _digit9;
    private static int _digit10;
    

    
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
     * TODO--------------------------------------------------------------------------------------------------------------------------------------------
     */
    public int compareTo(PhoneNumber o) {
        return 1;
    }
    
    
    /**
     * 
     * TODO--------------------------------------------------------------------------------------------------------------------------------------------
     * 
     * @param areaCode
     * @param prefix
     * @param lineNumber
     * @return
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {
        
        _digit1 = Integer.parseInt(areaCode.substring(0, 1));
        _digit2 = Integer.parseInt(areaCode.substring(1, 2));
        _digit3 = Integer.parseInt(areaCode.substring(2, 3));
        _digit4 = Integer.parseInt(prefix.substring(0, 1));
        _digit5 = Integer.parseInt(prefix.substring(1, 2));
        _digit6 = Integer.parseInt(prefix.substring(2, 3));
        _digit7 = Integer.parseInt(lineNumber.substring(0, 1));
        _digit8 = Integer.parseInt(lineNumber.substring(1, 2));
        _digit9 = Integer.parseInt(lineNumber.substring(2, 3));
        _digit10 = Integer.parseInt(lineNumber.substring(3, 4));
        
        
        if (_digit1 < 2 || _digit4 < 2) {
            _isValidPhoneNumber = false;
        }
        
        
        return _isValidPhoneNumber;
        
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
        
        // rids phone number of dashes and from these digits creates an area code, prefix, and line number. 
        _parsedPhoneNumber = phoneNumber.replace('-', '\0');
        _parsedPhoneNumberAreaCode = _parsedPhoneNumber.substring(0, 3);
        _parsedPhoneNumberPrefix = _parsedPhoneNumber.substring(3, 6);
        _parsedPhoneNumberLineNumber = _parsedPhoneNumber.substring(6, 9);
        
        // checks to see if the phone number is valid or not
        _parsedPhoneNumberIsValid = isValidPhoneNumber(_parsedPhoneNumberAreaCode, 
                _parsedPhoneNumberPrefix, _parsedPhoneNumberLineNumber);
        
        // returns a new phone number if the phone number is valid
        if (_parsedPhoneNumberIsValid) {
            return (new PhoneNumber(_parsedPhoneNumberAreaCode, 
                    _parsedPhoneNumberPrefix, _parsedPhoneNumberLineNumber));
        }
        
        // throws an illegal argument exception if the phone number is not valid
        else {
            throw new IllegalArgumentException("That's not a valid phone number!");
        }
        

    }
    
}
