import java.util.*;
/**
 * Write a description of class Driver here.
 * 
 * @author Joshua Lee
 * @version 10/11/2015
 */
public class Driver
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        VerifyFloat number;
        String input;
        boolean validFloat;
        char repeat = 'n';
        
        do{
            System.out.print("Enter a number to test if it's a valid floating point number: ");
            input = keyboard.next();
            number = new VerifyFloat(input);
            validFloat = number.verify(input);
            
            if (validFloat == true)
                System.out.println("That is a valid floating number.");
            else
                System.out.println("That is not a valid floating number.");
            
            System.out.print("Enter a y to test another number: ");
            repeat = keyboard.next().charAt(0);
        }while(repeat == 'y' || repeat == 'Y');
        
        System.out.println("Goodbye");
    }
}
