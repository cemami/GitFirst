//package com.company;
import java.util.Scanner; //import Scanner

public class HexAndBinaryDecoder {
    //https://www.asciitable.com/
    public static long hexStringDecode(String hex) //Decode whole hex string
    {
        //can be of form FFFFFFFF or ffffffff
        //read string input and cut off first two values to leave last six characters
        //long decimal;//number from hex reading multiplied by hex power to achieve decimal value
        //indexed character from hex input
        long number = 0;//hex converted to a number
        //String reverse;
        String reverse = "";
        for (int i = hex.length() - 1; i >= 0; i--) {
            reverse = reverse + hex.charAt(i);
        }
        for (int i = 0; i <= reverse.length()-1; i++)//reads position in string of input
        //for(int i = hex.length()-1;i >=0; i--)
        {

            char value = reverse.charAt(i);//grab specific value in hex string
            short shortNumber = hexCharDecode(value);
            double hexDub =   shortNumber*Math.pow(16,i);
            long hexConv = (long) hexDub;
            //long hexConv = (new Double(hexDub)).longValue();//http://www.java67.com/2014/11/how-to-convert-double-to-long-in-java-example.html
            number = number + hexConv;
        }
//change for lab 3
        //yes
        return number;


    }

    public static short hexCharDecode(char hexChar) //Decode single character
    {
        //ASCii
        //char to int cast
        //boolean lower = Character.isLowerCase(hexChar);
        //if lower case returns true
        // if (lower true){
        //replace lower case with upper case
        // }
        //System.out.println(lower);
        int shexVal = hexChar;//char to int casting
        //if x or X
        if ( shexVal == 88)
        {
            shexVal = shexVal - 88;
        }
        else if (shexVal == 120)
        {
            shexVal = shexVal - 120;
        }
        //if between 0 and 9
        else if (48 <= shexVal && shexVal <= 57)
        {
            shexVal = shexVal - 48; //9
        }
        //if between 65 and 70 (A or F)
        else if(65 <= shexVal && shexVal <= 70)
        {
            shexVal = shexVal - 55;
        }
        //if between a or f
        else if(97 <= shexVal && shexVal <= 102)
        {
            shexVal = shexVal - 87;
        }
        short hexVal = (short) shexVal;
        return hexVal;
    }


    public static long binaryStringDecode(String bin) //Decode binary string
    {
        //depending on the placement in the string, raise it to that certain value starting from 0 to 5 and add all values in the string
        long Binumber = 0;//hex converted to a number
        //String reverse;
        String reverse = "";
        for (int i = bin.length() - 1; i >= 0; i--) {
            reverse = reverse + bin.charAt(i);
        }
        for (int i = 0; i <= reverse.length() - 1; i++)//reads position in string of input
        //for(int i = hex.length()-1;i >=0; i--)
        {

            char value = reverse.charAt(i);//grab specific value in binary string
            int binVal = value;//char to int casting
            if (48 == binVal || binVal == 49)
            {
                binVal = binVal - 48;
            }
            else if (binVal == 98)
            {
                binVal = binVal - 98;
            }
            // short shortNumber = hexCharDecode(value);

            double binDub = binVal * Math.pow(2, i);
            //long binConv = (new Double(binDub)).longValue();//http://www.java67.com/2014/11/how-to-convert-double-to-long-in-java-example.html
            long binConv = (long)binDub;
            Binumber = Binumber + binConv;

        }
        return Binumber;
    }

    public static void main(String[] args)
    {
        int response = 0;
        int counter = 0;
        //double result = 0;
        while(true) {
            Scanner sc = new Scanner(System.in);


            System.out.println("Choose an option:");
            System.out.println("1. Decode a hex string.");
            System.out.println("2. Decode a binary string.");
            System.out.println("3. Convert binary to hex.");
            System.out.println("4. Quit.");

            response = sc.nextInt();  //scanner read input
            //double response.
            if (response == 1) {
                System.out.println("Please enter the hex string:");
                String opt = sc.next();

                long longNumber = hexStringDecode(opt);//decoding into a value from hex input
                System.out.println("Result: "+longNumber);
                System.out.println("Choose an option:");
                System.out.println("1. Decode a hex string.");
                System.out.println("2. Decode a binary string.");
                System.out.println("3. Convert binary to hex.");
                System.out.println("4. Quit.");
                System.out.println("Quitting program.");
                System.exit(0);

            } else if (response == 2) {
                System.out.println("Please enter the binary string:");
                String binary = sc.next();
                //  double result = binaryStringDecode(binary);
                //System.out.println(result);
                long longNumber = binaryStringDecode(binary);//decoding into a value from hex input
                System.out.println("Result: "+longNumber);
                System.out.println("Choose an option:");
                System.out.println("1. Decode a hex string.");
                System.out.println("2. Decode a binary string.");
                System.out.println("3. Convert binary to hex.");
                System.out.println("4. Quit.");
                System.out.println("4. Quit.");
                System.out.println("Quitting program.");
                System.exit(0);
            } else if (response == 3) {
                System.out.println("Please enter the binary string:");
                String binary = sc.next();


            } else if (response == 4) {
                System.out.println("Quitting program.");
                System.exit(0);
            }
        }

    }
}

