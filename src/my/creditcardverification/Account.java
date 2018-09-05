package my.creditcardverification;

/**
 * Class that stores account numbers
 * 
 * @author Kikki Beltz
 * @version September 2018
 */
public class Account implements Comparable<Account> {
    
    private String accountNumber;
    
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
        int counter = 1;
        int luhnValue = 0;
        int numCorrupt = 0;
        for (int i=this.accountNumber.length()-1; i>=0; i--) {
            char c = this.accountNumber.charAt(i);
            if (Character.isDigit(c)) {
               int j = Character.getNumericValue(c); 
               if (counter%2==0) {
                   j = 2*j;
                   if (String.valueOf(j).length()>1) {
                       j = j%10 + j/10;
                   }
               } 
               luhnValue = luhnValue+j;
            } else if (String.valueOf(c).equals("?")) {
                numCorrupt++;
            } else if (String.valueOf(c).equals(" ")) {
                counter--;
            } else {
                return false;
            }
            counter++;
        }
        if (numCorrupt == 1) {
            int x;
            int length = this.accountNumber.length();
            int index = this.accountNumber.indexOf('?');
            if ((length%2==0 && index%2!=0)||(length%2!=0 && index%2==0)) {
                x = 10-luhnValue%10;
                luhnValue = luhnValue+x;
                System.out.println(luhnValue);
            } else {
                x = (10-luhnValue%10)/2;
                System.out.println(luhnValue);
                luhnValue = luhnValue+2*x;
                System.out.println(luhnValue);
            }
//            System.out.println(index);
//            System.out.println(length);
            System.out.println(x);
            // TODO: these need to be checked
            String newAccountNumber = this.accountNumber.replace("?", Integer.toString(x));
            System.out.println(newAccountNumber);
            this.accountNumber = newAccountNumber;
//            System.out.println(luhnValue);
        }
        // if the last digit is 0, return true, else return false
        return luhnValue%10==0;
    }

    @Override
    public int compareTo(Account other) {
        String str1 = this.accountNumber.replaceAll("[^0-9]", "");
        String str2 = other.getAccountNumber().replaceAll("[^0-9]", "");
        return str1.compareTo(str2);
    }
}
