import java.util.Scanner;
import java.util.Arrays;
class ConverterRunner
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        if((!choice.equals("2")) && (!choice.equals("8")) && (!choice.equals("10")) && (!choice.equals("16")))
        {
            System.out.println("You did not enter a correct base.");
        }
        else
        {
            int base = Integer.parseInt(choice);

            System.out.print("Enter your number: ");
            String number = s.nextLine();

            s.close();

            boolean isValidNumber = true;
            for(int i = 0; i < number.length(); i++)
            {
                String digit = String.valueOf(number.charAt(i));
                if(base == 2)
                {
                    if((!digit.equals("0")) && (!digit.equals("1")))
                    {
                        isValidNumber = false;
                    }
                }
                if(base == 8)
                {
                    if((!Character.isDigit(number.charAt(i))) || (digit.equals("8")) || (digit.equals("9")))
                    {
                        isValidNumber = false;
                    }
                }
                if(base == 10)
                {
                    if(!Character.isDigit(number.charAt(i)))
                    {
                        isValidNumber = false;
                    }
                }
                if(base == 16)
                {
                    if((!Character.isDigit(number.charAt(i))) && (!digit.equals("A")) && (!digit.equals("B")) && (!digit.equals("C")) && (!digit.equals("D")) && (!digit.equals("E")) && (!digit.equals("F")))
                    {
                        isValidNumber = false;
                    }
                }
            }

            if(!isValidNumber)
            {
                System.out.println("You did not enter a valid number for this base.");
            }
            else
            {
                NumberConverter nc = new NumberConverter(number, base);
                String[] digits = nc.getDigits();
                System.out.println("\n\nDigit array: " + Arrays.toString(digits));
                System.out.println("Number: " + nc.displayOriginalNumber());

                System.out.println();

                if(base != 2)
                {
                    int[] binaryDigits = nc.convertToBinary();
                    String binaryNumber = "";
                    for(int digit : binaryDigits)
                    {
                        binaryNumber += digit;
                    }
                    System.out.println("Binary number: " + binaryNumber);
                }
                if(base != 8)
                {
                    int[] octalDigits = nc.convertToOctal();
                    String octalNumber = "";
                    for(int digit : octalDigits)
                    {
                        octalNumber += digit;
                    }
                    System.out.println("Octal number: " + octalNumber);
                }
                if(base != 10)
                {
                    int[] decimalDigits = nc.convertToDecimal();
                    String decimalNumber = "";
                    for(int digit : decimalDigits)
                    {
                        decimalNumber += digit;
                    }
                    System.out.println("Decimal number: " + decimalNumber);
                }
                if(base != 16)
                {
                    String[] hexadecimalDigits = nc.convertToHexadecimal();
                    String hexadecimalNumber = "";
                    for(String digit : hexadecimalDigits)
                    {
                        hexadecimalNumber += digit;
                    }
                    System.out.println("Hexadecimal number: " + hexadecimalNumber);
                }
            }
        }
    }
}