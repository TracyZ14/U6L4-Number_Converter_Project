public class NumberConverter
{
    String[] digits;
    int base;

    public NumberConverter(String number, int base)
    {
        digits = new String[number.length()];
        for(int i = 0; i < number.length(); i++)
        {
            String single = number.substring(i, i + 1);
            digits[i] = single;
        }
        this.base = base;
    }

    public String displayOriginalNumber()
    {
        String o = "";
        for(int i = 0; i < digits.length; i++)
        {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits()
    {
        return digits;
    }

    public int[] convertToDecimal()
    {
        int decimal = 0;
        int power = digits.length - 1;
        String[] numberDigit = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int[] numberValue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for(int i = 0; i < digits.length; i++)
        {
            int value = 0;
            for(int j = 0; j < numberDigit.length; j++)
            {
                if(digits[i].equals(numberDigit[j]))
                {
                    value = numberValue[j];
                }
            }
            decimal += (value * (int) (Math.pow(base, power)));
            power--;
        }
        String decimalString = Integer.toString(decimal);
        int[] decimalDigits = new int[decimalString.length()];
        for(int i = 0; i < decimalString.length(); i++)
        {
            decimalDigits[i] = Character.getNumericValue(decimalString.charAt(i));
        }
        return decimalDigits;
    }

    public int[] convertToBinary()
    {
        int[] decimalDigits = convertToDecimal();
        String decimalNumber = "";
        for(int decimal : decimalDigits)
        {
            decimalNumber += decimal;
        }
        int decimal = Integer.parseInt(decimalNumber);
        String binaryNumber = "";
        boolean isLessThanTwo = false;
        while(!isLessThanTwo)
        {
            int[] zeroToOne = {0, 1};
            for(int number : zeroToOne)
            {
                if(decimal == number)
                {
                    isLessThanTwo = true;
                }
            }
            binaryNumber = "" + (decimal % 2) + binaryNumber;
            decimal /= 2;
        }
        int[] binaryDigits = new int[binaryNumber.length()];
        for(int i = 0; i < binaryDigits.length; i++)
        {
            binaryDigits[i] = Character.getNumericValue(binaryNumber.charAt(i));
        }
        return binaryDigits;
    }

    public int[] convertToOctal()
    {
        int[] decimalDigits = convertToDecimal();
        String decimalNumber = "";
        for(int decimal : decimalDigits)
        {
            decimalNumber += decimal;
        }
        int decimal = Integer.parseInt(decimalNumber);
        String octalNumber = "";
        boolean isLessThanEight = false;
        while(!isLessThanEight)
        {
            int[] zeroToSeven = {0, 1, 2, 3, 4, 5, 6, 7};
            for(int number : zeroToSeven)
            {
                if(decimal == number)
                {
                    isLessThanEight = true;
                }
            }
            octalNumber = "" + (decimal % 8) + octalNumber;
            decimal /= 8;
        }
        int[] octalDigits = new int[octalNumber.length()];
        for(int i = 0; i < octalDigits.length; i++)
        {
            octalDigits[i] = Character.getNumericValue(octalNumber.charAt(i));
        }
        return octalDigits;
    }

    public String[] convertToHexadecimal()
    {
        int[] decimalDigits = convertToDecimal();
        String decimalNumber = "";
        for(int decimal : decimalDigits)
        {
            decimalNumber += decimal;
        }
        int decimal = Integer.parseInt(decimalNumber);
        String hexadecimalNumber = "";
        boolean isLessThanSixteen = false;
        while(!isLessThanSixteen)
        {
            int[] zeroToFifteen = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            for(int number : zeroToFifteen)
            {
                if(decimal == number)
                {
                    isLessThanSixteen = true;
                }
            }
            String digit = Integer.toString(decimal % 16);
            String[] hexadecimalValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
            String[] hexadecimalDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
            for(int i = 0; i < hexadecimalValue.length; i++)
            {
                if(digit.equals(hexadecimalValue[i]))
                {
                    digit = hexadecimalDigits[i];
                }
            }
            hexadecimalNumber = digit + hexadecimalNumber;
            decimal /= 16;
        }
        String[] hexadecimalDigits = new String[hexadecimalNumber.length()];
        for(int i = 0; i < hexadecimalDigits.length; i++)
        {
            hexadecimalDigits[i] = String.valueOf(hexadecimalNumber.charAt(i));
        }
        return hexadecimalDigits;
    }
}