
/**
 * VerifyFloat will accept a string value and determine if the input is a valid floating type. 
 * The float number can also be inputted in scientific notation (using E). 
 * 
 * @author Joshua Lee
 * @version 10/11/2015
 */
public class VerifyFloat
{
    // Field to store the user inputted number
    private String floatNumber;

    /**
     * Constructor for objects of class VerifyFloat
     */
    public VerifyFloat()
    {
        // initialise instance variables
        floatNumber = "";
    }
    
    public VerifyFloat(String number){
        // set the field to be equal to the parameter
        floatNumber = number;
    }
    
    public boolean verify(String number){
        // Local variables to keep track of substring and index of e to create the substring
        int eIndex = 0;
        String preENum, postENum;
        
        /* The first check is to see if the number is in scientific notation or not
         * Then check to see if the positive or negative sign is only at the beginning or missing
         * Then make sure there is only one decimal
         * Then make sure that all the characters are digits (skipping the decimals
         */
        if (this.isScientific(number) == false){ // Series of checks for when the string is not in scientific notation
            if (this.oneDecimal(number) == true)
                if (this.signAtBeginning(number) == true)
                    if (this.allInt(number) == true)
                        return true;
        }
        else{ // Series of checks for when the string is in scientific notation
            if (this.oneE(number) == true)
                if (this.oneDecimal(number) == true){
                    eIndex = this.indexE(number); // Find the index value of the e
                    // Using the index value of e split the string into two substrings
                    preENum = number.substring(0,eIndex); // The number before the e
                    postENum = number.substring(eIndex+1); // The number after the e
                    if (this.signAtBeginning(preENum) == true && this.signAtBeginning(postENum) == true)
                        if (this.allInt(preENum) == true && (this.allInt(postENum) == true))
                            return true;
                }
        }
        
        // This series of ifs is to check if the number is in scientific notation using the same methods as above
        
        return false;
    }
    
    private boolean isScientific(String number){
        for (int i=0; i < number.length(); i++){
            if (number.charAt(i) == 'e' || number.charAt(i) == 'E')
                return true;
        }
        return false;
    }
    
    private boolean signAtBeginning(String number){
        if (number.lastIndexOf('+') < 1 && number.lastIndexOf('-') < 1)
            return true;
        return false;
    }
    
    private boolean oneDecimal(String number){
        int numDec = 0;
        for (int i=0; i < number.length(); i++){
            if (number.charAt(i) == '.')
                numDec++;
        }
        if (numDec < 2)
            return true;
        return false;
    }
    
    private boolean allInt(String number){        
        for (int i=0; i < number.length(); i++){
            if (Character.isDigit(number.charAt(i)) == false ){
                if (number.charAt(i) == '.' || number.charAt(i) == '+' || number.charAt(i) == '-'){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean oneE(String number){
        int numE = 0;
        for (int i=0; i < number.length(); i++){
            if (number.charAt(i) == 'e' || number.charAt(i) == 'E')
                numE++;
        }
        if (numE < 2)
            return true;
        return false;
    }
    
    private int indexE(String number){
        int index = 0;
        for (int i=0; i < number.length(); i++){
            if (number.charAt(i) == 'e' || number.charAt(i) == 'E')
                return index;
            index++;
        }
        return index;
    }
}
