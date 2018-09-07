// ldelamotte17@georgefox.edu

/**
 * 
 *
 */
public class PhoneNumber implements Comparable {
    
    
    private String _areaCode;
    private String _prefix;
    private String _lineNumber;

    
    /**
     * 
     * @param areaCode
     * @param prefix
     * @param lineNumber
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber) {
        
    }
    
    
    /**
     * 
     * @return
     */
    public String getAreaCode() {
        return _areaCode;
    }
    
    
    /**
     * 
     * @return
     */
    public String getPrefix() {
        return _prefix;
    }
    
    
    /**
     * 
     * @return
     */
    public String getLineNumber() {
        return _lineNumber;
    }
    
    
    /**
     * 
     * @return
     */
    public String getDigits() {
        return "";
    }
    
    
    /**
     * 
     */
    public int compareTo(Object PhoneNumber) {
        return 1;
    }
    
    
    /**
     * 
     * @param areaCode
     * @param prefix
     * @param lineNumber
     * @return
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {
        return true;
    }
    
    
    /**
     * 
     * @param phoneNumber
     * @return
     */
    public static PhoneNumber parsePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumber;
    }
    
}
