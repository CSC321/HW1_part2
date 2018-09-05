package my.creditcardverification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class that stores information on accounts
 * 
 * @author Kikki Beltz
 * @version September 2018
 */
public class AccountLookup {
    
    private ArrayList<Account> accounts;
    
    /**
     * Constructor of an AccountLookup object with data from the specified file
     * 
     * @param fileName
     * @return result as string to GUI
     */
    public String accountLookup(String fileName) {
        this.accounts = new ArrayList<Account>();
        // Initialize separate ArrayLists for valid and invalid accounts
        ArrayList validAccounts = new ArrayList<Account>();
        ArrayList invalidAccounts = new ArrayList<Account>();
        
        try {
            Scanner infile = new Scanner(new File(fileName));
            while (infile.hasNextLine()) {
                String accountNumber = infile.nextLine().trim();
                // Create new Account object
                Account newAccount = new Account(accountNumber);
                boolean isValid = newAccount.validate();
                if (isValid) {
                    validAccounts.add(newAccount);
                } else {
                    invalidAccounts.add(newAccount);
                }
            }
            infile.close();
            String validOutput = "VALID\n";
            Collections.sort(validAccounts);
            for (int i=0; i<validAccounts.size();i++) {
                Account account = (Account)validAccounts.get(i);
                validOutput+=account.getAccountNumber()+"\n";
            }
            String invalidOutput = "\nINVALID \n";
            Collections.sort(invalidAccounts);
            for (int i=0; i<invalidAccounts.size();i++) {
                Account account = (Account)invalidAccounts.get(i);
                invalidOutput+=account.getAccountNumber()+"\n";
            }
            return validOutput + invalidOutput;    
        } catch (FileNotFoundException ex) {
            return "No such file: " + fileName;
        }
    }
    
}
