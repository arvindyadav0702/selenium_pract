package testingPractice;

import org.testng.annotations.Test;

import java.util.*;

public class HashMapAndOthersPractice {

    public static void main(String[] args) {

        mapEntry();
        duplicateCharacters();

    }


    public static void mapEntry() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("a", "12");
        hs.put("b", "124");
        hs.put("c", "13");
        hs.put("d", "1456");
        hs.put("e", "1111");

        for (Map.Entry<String, String> mapEle : hs.entrySet()) {

            String Name = mapEle.getKey();
            String Price = mapEle.getValue();
            System.out.println(hs);
            System.out.println("The key is " + Name);
            System.out.println("The value is " + Price);
        }

    }

    public static void duplicateCharacters() {

        String str = "testtest123";

        char[] charStr = str.toCharArray();
        int counter;
        for (int i = 0; i < charStr.length; i++) {
            counter = 1;
            for (int j = i + 1; j < charStr.length; j++) {
                if (charStr[i] == charStr[j]) {
                    counter++;
                }
            }
            if (counter > 1 && charStr[i] != 0) {
                System.out.println(charStr[i]);
            }


        }

    }

    @Test
    public static void set() {

        Set<String> hs = new TreeSet<>(Arrays.asList("adasdad", "fsdfsdff", "adasdad"));

//        hs.removeAll(1,2,3);
        hs.add("1212143443");

        System.out.println(hs);

    }

    @Test
    public static void Maps() {

        Map<Integer, String> hs = new HashMap<>();
        hs.put(1, null);
        hs.put(null, null);
        hs.put(3, "arv2");
        hs.replace(3, "new Replaced");

        System.out.println(hs.get(1) + "\n********************");
        for (Map.Entry<Integer, String> str : hs.entrySet()) {
            Integer name = str.getKey();
            String name2 = str.getValue();

            System.out.println(name);
            System.out.println(name2);

        }
    }


}
