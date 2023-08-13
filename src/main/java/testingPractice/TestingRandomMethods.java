package testingPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestingRandomMethods extends HashMapAndOthersPractice {

//    public static void main(String args[])
//    {
//        double a, b,c;
//        a = 3.0/0;
//        b = 0/4.0;
//        c=0/0.0;
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//    }

    public static void main(String[] args) {


//        String str1 = "Saket Saurav        is an Autom ation Engi ne      er";
//
//        char[] arr1 = str1.toCharArray();
//
//        for (char c : arr1) {
//
//            if (c != ' ') {
//                System.out.print(c);
//
//            }
//
//        }
//
//        String str="Hello world I am here";
//
//        String newstring = str.replaceAll(" ", "");
//                System.out.print(newstring);

//        In a given string, extract only the first name from the list in alphabetic descending order. It’s just an example. Not given exactly these inputs
//        Input: Virat Kohli
//        Input: Sachin Tendulkar
//        Outputs: Virat Sachin

        String str1 = "Virat Kohli";
        String str2 = "Sachin Tendulkar";


        String[] newStr1 = str1.split(" ");
        String[] newStr2 = str2.split(" ");

        List<String> INPUT_NAMES = Arrays.asList(newStr1[0], newStr2[0]);

        Collections.sort(INPUT_NAMES);
        System.out.println(INPUT_NAMES + "dfdfsffsff");
//        Comparator<String> reverseComparator = Comparator.reverseOrder();
        INPUT_NAMES.sort(Comparator.reverseOrder());
        System.out.println(INPUT_NAMES);


    }


}







