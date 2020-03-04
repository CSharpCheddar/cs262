
/**
 * Calculates a numerical value from something of the format <operand> <operator> <operand>.
 * Note: Only takes +, -, *, and / as operators, and only takes integers as operands.
 *
 * @author Martin Mueller
 * @version 03/07/2018
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    public static void main(String args[]) {
        //declare and initialize needed variables
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        //print a start up message
        System.out.println("Starting Calculator v1.0; Enter an expression or Q to quit");
        while(isRunning) {
            //print initial default characters
            System.out.print(">> ");
            //gather the user's input
            String input = scanner.nextLine();
            //process it
            if(!input.equals("Q")) {
                try {
                    String array[] = makeArray(input);
                    int answer = getAnswer(array);
                    printAnswerMessage(array, answer);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid operand. Operand must be an integer");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid operator. Operators must be one of +,-,* or /");
                } catch (ArithmeticException e) {
                    System.out.println("Division by zero is not allowed");
                }
            } else { //if they entered "Q" and want to quit...
                isRunning = false;
            }
        }
        System.out.println("Goodbye!");
    }
    //splits one string into an operand, operator, then an operand into an array of size 3
    public static String[] makeArray(String input) throws InputMismatchException {
        String array[] = input.split(" ");
        //check to see if we have 2 operands and an operator
        if(array.length != 3) {
            throw new InputMismatchException();
        }
        //check to see if the operands and operator are correct
        checkOperands(array[0], array[2]);
        checkOperator(array[1]);
        //return the array if everything is okay
        return array;
    }
    //checks to see if the operands are valid integers
    public static void checkOperands(String operand1, String operand2) throws InputMismatchException {
        if(!operand1.matches("\\d+") || !operand2.matches("\\d+")) {
            throw new InputMismatchException();
        }
    }
    //checks to see if the operator is valid
    public static void checkOperator(String operator) throws IllegalArgumentException {
        if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new IllegalArgumentException();
        }
    }
    //computes an answer for a given arithmetic expression
    public static int getAnswer(String array[]) {
        int answer = 0;
        if(array[1].equals("+")) {
            answer = Integer.parseInt(array[0]) + Integer.parseInt(array[2]);
        } else if(array[1].equals("-")) {
            answer = Integer.parseInt(array[0]) - Integer.parseInt(array[2]);
        } else if(array[1].equals("*")) {
            answer = Integer.parseInt(array[0]) * Integer.parseInt(array[2]);
        } else if(array[1].equals("/")) {
            answer = Integer.parseInt(array[0]) / Integer.parseInt(array[2]);
        }
        return answer;
    }
    //prints out the answer message if the input was valid
    public static void printAnswerMessage(String array[], int answer) {
        if(array[1].equals("+")) {
            System.out.println(array[0]+" plus "+array[2]+" is "+answer);
        } else if(array[1].equals("-")) {
            System.out.println(array[0]+" minus "+array[2]+" is "+answer);
        } else if(array[1].equals("*")) {
            System.out.println(array[0]+" multiplied by "+array[2]+" is "+answer);
        } else if(array[1].equals("/")) {
            System.out.println(array[0]+" divided by "+array[2]+" is "+answer);
        }
    }
}
