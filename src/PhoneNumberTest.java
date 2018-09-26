// ldelamotte17@georgefox.edu

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class PhoneNumberTest {

    // initializes constants that represent various parts of a PhoneNumber
    private static final String VALID_AREA_CODE = "503";
    private static final String VALID_PREFIX = "860";
    private static final String VALID_LINE_NUMBER = "5147";
    private static final String VALID_PHONE_NUMBER_DIGITS = "5038605147";
    private static final String VALID_PHONE_NUMBER_STRING = "503-860-5147";

    // initializes constants that represent various parts of a 
    // second PhoneNumber
    private static final String SECOND_VALID_AREA_CODE = "503";
    private static final String SECOND_VALID_PREFIX = "913";
    private static final String SECOND_VALID_LINE_NUMBER = "9992";

    // initializes a constant of an invalid PhoneNumber String
    private static final String INVALID_PHONE_NUMBER_STRING_WITH_CHARACTERS
        = "ABC-DEF-GHIJ";
    private static final String INVALID_PHONE_NUMBER_STRING_TOO_LONG
        = "4565-3743-84038";
    private static final String INVALID_PHONE_NUMBER_STRING_TOO_SHORT
        = "34-56-456";
    private static final String INVALID_PHONE_NUMBER_STRING = "000-111-2222";
    // ADD MESSAGES TO TESTS ------------------------------------------------------------------------------------------------------------------
    // I COULD POTENTIALLY ADD SOME STUFF HERE AND DO MORE THINGS WITH PARSEPHONENUM --------------------------------------------------

    // initializes constant that represent various invalid inputs
    private static final String CHARACTERS_IN_AREA_CODE = "Yo!";
    private static final String CHARACTERS_IN_PREFIX = "#Um";
    private static final String CHARACTERS_IN_LINE_NUMBER = "@Hi";
    private static final String AREA_CODE_TOO_LONG = "1234";
    private static final String PREFIX_TOO_LONG = "1234";
    private static final String LINE_NUMBER_TOO_LONG = "12345";
    private static final String AREA_CODE_TOO_SHORT = "12";
    private static final String PREFIX_TOO_SHORT = "12";
    private static final String LINE_NUMBER_TOO_SHORT = "123";
    private static final String INVALID_AREA_CODE = "000";
    private static final String INVALID_PREFIX = "111";

    // declares two valid PhoneNumber objects
    private static PhoneNumber _firstPhoneNumber;
    private static PhoneNumber _secondPhoneNumber;


    public static void main(String[] args) {

        System.out.format("Unit tests:%n%n");
        // calls all tests
        org.junit.runner.JUnitCore.main("PhoneNumberTest");

    }


    /**
     * Initializes two valid PhoneNumber objects
     */
    @BeforeClass
    public static void setUp() {

        _firstPhoneNumber = new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX, 
                VALID_LINE_NUMBER);
        _secondPhoneNumber = new PhoneNumber(SECOND_VALID_AREA_CODE, 
                SECOND_VALID_PREFIX, SECOND_VALID_LINE_NUMBER);

    }


    /**
     * Tests construction of a valid PhoneNumber
     */
    @Test
    public void test_PhoneNumber_validInput() {

        assertThat(_firstPhoneNumber, instanceOf(PhoneNumber.class));

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to null area code
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_nullAreaCode() {

        new PhoneNumber(null, VALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to null prefix
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_nullPrefix() {

        new PhoneNumber(VALID_AREA_CODE, null, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to null line number
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_nullLineNumber() {

        new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX, null);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to area code being
     *  too short
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_areaCodeTooShort() {

        new PhoneNumber(AREA_CODE_TOO_SHORT, VALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to prefix being
     *  too short
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_prefixTooShort() {

        new PhoneNumber(VALID_AREA_CODE, PREFIX_TOO_SHORT, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to line number being
     *  too short
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_lineNumberTooShort() {

        new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX, LINE_NUMBER_TOO_SHORT);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to area code being
     *  too long
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_areaCodeTooLong() {

        new PhoneNumber(AREA_CODE_TOO_LONG, VALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to prefix being
     *  too long
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_prefixTooLong() {

        new PhoneNumber(VALID_AREA_CODE, PREFIX_TOO_LONG, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to line number being
     *  too long
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_lineNumberTooLong() {

        new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX, LINE_NUMBER_TOO_LONG);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to characters in
     *  area code
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_charactersInAreaCode() {

        new PhoneNumber(CHARACTERS_IN_AREA_CODE, VALID_PREFIX,
                VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to characters
     *  in prefix
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_charactersInPrefix() {

        new PhoneNumber(VALID_AREA_CODE, CHARACTERS_IN_PREFIX,
                VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to characters in
     *  line number
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_charactersInLineNumber() {

        new PhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                CHARACTERS_IN_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to invalid area code
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_invalidAreaCode() {

        new PhoneNumber(INVALID_AREA_CODE, VALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     *  Tests the blocked construction of a PhoneNumber due to invalid prefix
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_invalidPrefix() {

        new PhoneNumber(VALID_AREA_CODE, INVALID_PREFIX, VALID_LINE_NUMBER);

    }


    /**
     * Tests the getter method for the area code
     */
    @Test
    public void test_PhoneNumber_getAreaCode() {

        assertThat("The area code not valid.", _firstPhoneNumber.getAreaCode(),
                equalTo(VALID_AREA_CODE));

    }


    /**
     * Tests the getter method for the prefix
     */
    @Test
    public void test_PhoneNumer_getPrefix() {

        assertThat("The prefix is not valid.", _firstPhoneNumber.getPrefix(),
                equalTo(VALID_PREFIX));

    }


    /**
     * Tests the getter method for the line number
     */
    @Test
    public void test_PhoneNumer_getLineNumber() {

        assertThat("The line number is not valid.",
                _firstPhoneNumber.getLineNumber(), equalTo(VALID_LINE_NUMBER));

    }


    /**
     * Tests the getter method for all ten digits
     */
    @Test
    public void test_PhoneNumer_getDigits() {

        assertThat(_firstPhoneNumber.getDigits(),
                equalTo(VALID_PHONE_NUMBER_DIGITS));

    }


    /**
     * Tests the conversion of a PhoneNumber to a String
     */
    @Test
    public void test_PhoneNumber_toString() {

        assertThat(_firstPhoneNumber.toString(),
                equalTo(VALID_PHONE_NUMBER_STRING));

    }


    /**
     * Tests the comparison of two of the same PhoneNumbers
     */
    @Test
    public void test_PhoneNumber_compareTo_samePhoneNumber() {

        assertTrue(_firstPhoneNumber.compareTo(_firstPhoneNumber) == 0);

    }


    /**
     * Tests the comparison of two different PhoneNumbers
     */
    @Test
    public void test_PhoneNumber_compareTo_diffPhoneNumber() {

        assertTrue(_firstPhoneNumber.compareTo(_secondPhoneNumber) < 0);

    }


    /**
     *  Tests the validation of a valid PhoneNumber object
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_validInput() {

        assertTrue(PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of null area code
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullAreaCode() {

        assertFalse("The area code is null.",
                PhoneNumber.isValidPhoneNumber(null, VALID_PREFIX,
                        VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of null prefix
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullPrefix() {

        assertFalse("The prefix is null.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, null,
                        VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of null line number
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_nullLineNumber() {

        assertFalse("The line number is null.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                        null));

    }


    /**
     *  Tests the validation of input with characters in the area code
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_charactersInAreaCode() {

        assertFalse("There are invalid characters in the area code.",
                PhoneNumber.isValidPhoneNumber(CHARACTERS_IN_AREA_CODE,
                        VALID_PREFIX, VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input with characters in the prefix
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_charactersInPrefix() {

        assertFalse("There are invalid characters in the prefix.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE,
                        CHARACTERS_IN_PREFIX, VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input with characters in the line number
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_charactersInLineNumber() {

        assertFalse("There are invalid characters in the line number.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                        CHARACTERS_IN_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the area code is too long
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_areaCodeTooLong() {

        assertFalse("The area code is too long.",
                PhoneNumber.isValidPhoneNumber(AREA_CODE_TOO_LONG, VALID_PREFIX,
                        VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the prefix is too long
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_prefixTooLong() {

        assertFalse("The prefix is too long.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, PREFIX_TOO_LONG,
                        VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the line number is too long
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_lineNumberTooLong() {

        assertFalse("The line number is too long.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                        LINE_NUMBER_TOO_LONG));

    }


    /**
     *  Tests the validation of input where the area code is too short
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_areaCodeTooShort() {

        assertFalse("The area code is too short.",
                PhoneNumber.isValidPhoneNumber(AREA_CODE_TOO_SHORT,
                        VALID_PREFIX, VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the prefix is too short
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_prefixTooShort() {

        assertFalse("The prefix is too short.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE,
                        PREFIX_TOO_SHORT, VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the line number is too short
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_lineNumberTooShort() {

        assertFalse("The line number is too short.",
                PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE, VALID_PREFIX,
                        LINE_NUMBER_TOO_SHORT));

    }


    /**
     *  Tests the validation of input where the area code does not meet
     *  PhoneNumber specifications
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidAreaCode() {

        assertFalse("The area code does not meet spec.",
                PhoneNumber.isValidPhoneNumber(INVALID_AREA_CODE, VALID_PREFIX,
                        VALID_LINE_NUMBER));

    }


    /**
     *  Tests the validation of input where the prefix does not meet
     *  PhoneNumber specifications
     */
    @Test
    public void test_PhoneNumber_isValidPhoneNumber_invalidPrefix() {

        assertFalse(PhoneNumber.isValidPhoneNumber(VALID_AREA_CODE,
                INVALID_PREFIX, VALID_LINE_NUMBER));

    }


    /**
     * Tests the accuracy of turning a valid phone number String into a
     * PhoneNumber object
     */
    @Test
    public void test_PhoneNumber_parsePhoneNumber_validInputWithDashes() {

        assertTrue(PhoneNumber.parsePhoneNumber(VALID_PHONE_NUMBER_STRING)
                instanceof PhoneNumber);

    }


    /**
     * Tests the accuracy of turning an invalid String of digits into a
     * PhoneNumber object
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_parsePhoneNumber_invalidInput() {

        assertFalse(PhoneNumber.parsePhoneNumber(INVALID_PHONE_NUMBER_STRING)
                instanceof PhoneNumber);

    }


    /**
     * Tests the accuracy of turning an invalid String of digits with characters
     * into a PhoneNumber object
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_parsePhoneNumber_charactersInString() {

        assertFalse(PhoneNumber.parsePhoneNumber
                (INVALID_PHONE_NUMBER_STRING_WITH_CHARACTERS)
                instanceof PhoneNumber);

    }


    /**
     * Tests the accuracy of turning an invalid String of digits because it is
     * too long into a PhoneNumber object
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_parsePhoneNumber_stringTooLong() {

        assertFalse(PhoneNumber.parsePhoneNumber
                (INVALID_PHONE_NUMBER_STRING_TOO_LONG)
                instanceof PhoneNumber);

    }


    /**
     * Tests the accuracy of turning an invalid String of digits because it is
     * too short into a PhoneNumber object
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_PhoneNumber_parsePhoneNumber_stringTooShort() {

        assertFalse
            (PhoneNumber.parsePhoneNumber(INVALID_PHONE_NUMBER_STRING_TOO_SHORT)
                instanceof PhoneNumber);

    }

}