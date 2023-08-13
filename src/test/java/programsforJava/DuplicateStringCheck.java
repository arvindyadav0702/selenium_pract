package programsforJava;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class DuplicateStringCheck {

    @Test
    public static void getJsonString() {
        String str = "{\t\r\n    \"base\": {\r\n        \"symbol\": \"SAR\",\r\n        \"name\": \"Saudi Riyal\",\r\n        \"code\": \"SAR\"\r\n    },\r\n    \"equivalent\": [\r\n        {\r\n            \"symbol\": \"SAR\",\r\n            \"name\": \"Saudi Riyal\",\r\n            \"name_ar\": \"\\u0631\",\r\n            \"decimal_digits\": 2,\r\n            \"rounding\": 0,\r\n            \"code\": \"SAR\",\r\n            \"name_plural\": \"Saudi riyals\",\r\n            \"rate\": 1,\r\n            \"date\": \"2023-06-10 08:41:04\"\r\n        },\r\n        {\r\n            \"symbol\": \"AED\",\r\n            \"name\": \"United Arab Emirates Dirham\",\r\n            \"name_ar\": \"\\u062f\",\r\n            \"decimal_digits\": 2,\r\n            \"rounding\": 0,\r\n            \"code\": \"AED\",\r\n            \"name_plural\": \"UAE dirhams\",\r\n            \"rate\": 0.979142,\r\n            \"date\": \"2023-06-10 08:42:03\"\r\n        }\r\n    ],\r\n    \"failed\": []\r\n}";

        JsonPath js = new JsonPath(str);

        String rate1 = js.getString("equivalent[0].rate");
        String rate2 = js.getString("equivalent[1].rate");

        System.out.println(Double.parseDouble(rate1) + Double.parseDouble(rate2));
    }


    public static void main(String[] args) {
        String sen = "test";
        char[] chars = sen.toCharArray();
        for (Character string : chars) {
            int counter = 1;
            for (Character value : chars) {
                if (string == value) {
                    counter++;
                }

            }

            if (counter > 1) {
                System.out.println("Duplicate word is " + string + " and has repeated " + counter + " times");
            }

        }
//
//
//        int count;
//
//        //Converts given string into character array
//        char[] string = sen.toCharArray();
//
//        System.out.println("Duplicate characters in a given string: ");
//        //Counts each character present in the string
//        for(int i = 0; i <string.length; i++) {
//            count = 1;
//            for(int j = i+1; j <string.length; j++) {
//                if(string[i] == string[j] && string[i] != ' ') {
//                    count++;
//                    //Set string[j] to 0 to avoid printing visited character
//                    string[j] = '0';
//                }
//            }
//            //A character is considered as duplicate if count is greater than 1
//            if(count > 1 && string[i] != '0')
//                System.out.println(string[i]);
//        }
//
//
//
//    }


//    static void removeDuplicates(String str)
//    {
//        //Create LinkedHashSet of type character
//        LinkedHashSet<Character> set = new LinkedHashSet<>();
//        //Add each character of the string into LinkedHashSet
//        for(int i=0;i<str.length();i++)
//            set.add(str.charAt(i));
//
//        // print the string after removing duplicate characters
//        for(Character ch : set)
//            System.out.print(ch);
//    }
//
//    //main() method start
//    public static void main(String[] args)
//    {
//        //Create string variable with default value
//        String str = "test123test";
//        //removeDuplicates() method by passing the string as an argument
//        removeDuplicates(str);
//    }
    }
}




