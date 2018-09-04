package my.creditcardverification;

/**
 * Class that stores account numbers
 * 
 * @author Kikki Beltz, Zalak Pandya
 * @version August 2018
 */
public class Account {
    
    private final String accountNumber;
    
    /**
     * Constructor for objects of class Account
     * 
     * @param accountNumber 
     */
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /**
     * Accessor method to return account number
     * 
     * @return accountNumber
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    /**
     * Method that uses the Luhn formula to determine if a credit card number is valid
     * 
     * @return boolean that indicates whether or not the account number is valid
     */
    public boolean validate() {
        // Initialize counter and luhn variables
        int counter = 1;
        int luhnValue = 0;
        // Starts at the end of the account number and moves backward
        for (int i=this.accountNumber.length()-1; i>=0; i--) {
            char c = this.accountNumber.charAt(i);
            // If the character at the current index is a digit, get the numberic value
            if (Character.isDigit(c)) {
               int j = Character.getNumericValue(c); 
               // Double every other number, starting with the second number from the right (counter%2==0)
               if (counter%2==0) {
                   j = 2*j;
                   // If a number has two digits, add them together
                   if (String.valueOf(j).length()>1) {
                       j = j%10 + j/10;
                   }
               } 
               // Add the value of the current digit to the luhn value
               luhnValue = luhnValue+j;
            // If the current character is a space, decrement the counter to keep the index accurate and don't add to the luhn value
            } else if (String.valueOf(c).equals(" ")) {
                counter--;
            // If the current character is not a digit or a space, return false
            } else {
                return false;
            }
            counter++;
        }
        String validityCheck = String.valueOf(luhnValue);
        char d = validityCheck.charAt(validityCheck.length()-1);
        // if the last digit is 0, return true, else return false
        return Character.getNumericValue(d)==0;
    }
}
