import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class PhoneNumberTest {

    private static final String VALID_AREA_CODE = "503";
    private static final String VALID_PREFIX = "860";
    private static final String VALID_LINE_NUMBER = "5147";
    private static final String VALID_PHONE_NUMBER_DIGITS = "5038605147";
    private static final String VALID_PHONE_NUMBER_STRING = "503-860-5147";

    private static final String INVALID_AREA_CODE = "000";
    private static final String INVALID_PREFIX = "100";
    private static final String INVALID_LINE_NUMBER = "00000";

    private static PhoneNumber _phoneNumber;
    private static PhoneNumber _invalidPhoneNumber;

    private ExpectedException thrown = ExpectedException.none();

    public static void main(String[] args) {

        System.out.format("Unit tests:%n%n");
        // calls all tests below
        org.junit.runner.JUnitCore.main("PhoneNumberTest");

    }


    /**
     * 
     */
    @BeforeClass
    public static void setUp() {

        _phoneNumber = new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     * Tests construction of a valid PhoneNumber.
     */
    @Test
    public void test_PhoneNumber() {

        assertThat(_phoneNumber, notNullValue());
        assertThat(_phoneNumber, instanceOf(PhoneNumber.class));
        // DO I NEED TO USE A CONSTRUCTOR TEST ON MY INVALID PHONE NUMBER? --------------------------------------------------------------

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to invalid arguments.
     */
    @Test
    public void throwsExceptionWithSpecifiedType() {

        // IS THE CREATION OF THE INVALID PHONE NUMBER SUPPOSED TO BE HERE? -------------------------------------------------------------
        // _invalidPhoneNumber = new PhoneNumber(INVALID_AREA_CODE, INVALID_PREFIX, INVALID_LINE_NUMBER);
        thrown.expect(IllegalArgumentException.class);

    }


    /**
     * Tests the getter method for the area code.
     */
    @Test
    public void test_PhoneNumber_getAreaCode() {

        assertThat("The area code not valid.", _phoneNumber.getAreaCode(), equalTo(VALID_AREA_CODE));
        assertThat(VALID_AREA_CODE, notNullValue());

    }


    /**
     * Tests the getter method for the prefix.
     */
    @Test
    public void test_PhoneNumer_getPrefix() {

        assertThat("The prefix is not valid.", _phoneNumber.getPrefix(), equalTo(VALID_PREFIX));
        assertThat(VALID_PREFIX, notNullValue());

    }


    /**
     * Tests the getter method for the line number.
     */
    @Test
    public void test_PhoneNumer_getLineNumber() {

        assertThat("The line number is not valid.", _phoneNumber.getLineNumber(), equalTo(VALID_LINE_NUMBER));
        assertThat(VALID_LINE_NUMBER, notNullValue());

    }


    /**
     * Tests the getter method for all ten digits.
     */
    @Test
    public void test_PhoneNumer_getDigits() {

        assertThat(_phoneNumber.getDigits(), equalTo(VALID_PHONE_NUMBER_DIGITS));
        assertThat(VALID_PHONE_NUMBER_DIGITS, notNullValue());

    }


    /**
     * Tests the conversion of a PhoneNumber to a String.
     */
    @Test
    public void test_PhoneNumber_toString() {

        assertThat(_phoneNumber.toString(), equalTo(VALID_PHONE_NUMBER_STRING));
        assertThat(VALID_PHONE_NUMBER_STRING, notNullValue());

    }


    /**
     * Tests the comparison of two PhoneNumbers.
     */
    @Test
    public void test_PhoneNumber_compareTo() {

        assertTrue(_phoneNumber.compareTo(_phoneNumber) == 0);

    }
}
