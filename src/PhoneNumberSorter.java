// ldelamotte17@georgefox.edu
// Program 2
// 2018-09-13

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class takes in phone number arguments (in XXX-XXX-XXXX format) and then 
 * prints them out one per line in ascending numerical order. Exceptions are caught 
 * for invalid phone numbers and are printed as well.
 */
public class PhoneNumberSorter {

    /**
     * Takes in phone number arguments (in XXX-XXX-XXXX format) and then prints them 
     * out one per line in ascending numerical order. Exceptions are caught for 
     * invalid phone numbers and are printed as well.
     * 
     * @param args, phone numbers in XXX-XXX-XXXX format.
     */
    public static void main(String[] args) {
                
        // create new ArrayList of PhoneNumber objects to add arguments to
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
        // creates a variable to keep track of number of exceptions
        int numberOfExceptions = 0;
        int exitStatusCode;
        
        try {
            for (String s: args) {
                phoneNumbers.add(PhoneNumber.parsePhoneNumber(s));
            }
        }
        
        catch (IllegalArgumentException e){
            System.out.print(e);
            numberOfExceptions++;
        }
        
        // sorts PhoneNumber objects in ascending order
        Collections.sort(phoneNumbers);
        
        // determines exit code
        exitStatusCode = determineExitStatusCode(numberOfExceptions, phoneNumbers);
        
        // prints phone numbers out one per line if all phone numbers are valid
        if (exitStatusCode == 0) {
            for (PhoneNumber phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber);
            }
        }
        
        System.exit(exitStatusCode);

    }
    
    /**
     * This method takes in the number of exception that have been caught in the main and the list
     * of phone numbers that have been passed in via command line to determine the appropriate exit
     * code the program should relay to the user.
     * 
     * @param numberOfExceptions, the number of exceptions that have been caught in the main.
     * @param phoneNumbers, the list of phoneNumbers used to determine whether or not arguments 
     * have been passed in.
     * 
     * @return the exit status code the main should relay to user.
     */
    private static int determineExitStatusCode(int numberOfExceptions, 
            ArrayList<PhoneNumber> phoneNumbers) {
        
        int exitStatusCode;
        
        if (numberOfExceptions > 0) {
            exitStatusCode = 2;
        }
        
        else if (phoneNumbers.size() < 1) {
            exitStatusCode = 1;
        }
        
        else {
            exitStatusCode = 0;
        }
        
        return exitStatusCode;
    }

}
