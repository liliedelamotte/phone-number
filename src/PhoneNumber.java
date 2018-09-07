
public class PhoneNumber {
    
    private String _areaCode;
    private String _prefix;
    private String _lineNumber;

    public PhoneNumber(String areaCode, String prefix, String lineNumber) {
        
    }
    
    public String getAreaCode() {
        return _areaCode;
    }
    
    public String getPrefix() {
        return _prefix;
    }
    
    public String getLineNumber() {
        return _lineNumber;
    }
    
    public String getDigits() {
        return "";
    }
    
    public int compareTo(Object PhoneNumber) {
        return 1;
    }
    
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber) {
        return true;
    }
    
    public static PhoneNumber parsePhoneNumber(String phoneNumber) {
        
    }
    
}
