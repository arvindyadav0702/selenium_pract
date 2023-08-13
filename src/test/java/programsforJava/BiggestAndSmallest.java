package programsforJava;

import org.testng.annotations.Test;

import java.util.*;

public class BiggestAndSmallest {

    public static void main(String[] args) {

        String str = "this is a new wonderful string and we need to find this is new string string string string";
        String[] words = str.split(" ");

        Map<String, Integer> hashMap = new HashMap<>();

        for (String word : words) {
            hashMap.merge(word, 1, Integer::sum);
        }

        System.out.println("************************" + hashMap);

//if we want to print only the duplicate words
        final Set<String> set = hashMap.keySet();
        for (String word : set) {
            if (hashMap.get(word) > 1) {
                System.out.println(word + " is repeated " + hashMap.get(word) + " times");

            }
        }
    }


    @Test
    public void arraysStreamMethods() {
        String str = "this is a new wonderful string and we need to find this is new string";
        String[] string = str.split(" ");

        String min = Arrays.stream(string).min(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("this is the smallest word " + min);

        String max = Arrays.stream(string).max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("this is the largest word " + max);
    }

    @Test
    public void withoutStreamMethods() {
        String str = "this is a new wonderful string and we need to find this is new string";
        String[] string = str.split(" ");

        String largest = string[0];
        String smallest = string[0];
        String currentword;

        for (int i = 1; i < string.length; i++) {
            currentword = string[i];

            if (currentword.length() > largest.length()) {
                largest = currentword;

            } else if ((currentword.length() < smallest.length())) {
                smallest = currentword;
            }
        }
        System.out.println(largest);
        System.out.println(smallest);

    }


// Java Program to Remove Duplicate Elements
// From the Array using Set


    @Test
    // Function to remove duplicate from array
    public static void removeDuplicates() {
        int[] a = {5, 2, 6, 8, 6, 7, 5, 2, 8};
        Set<Integer> set = new HashSet<>();

        // adding elements to LinkedHashSet
        for (int j : a) {
            set.add(j);
        }

        // Print the elements of LinkedHashSet
        System.out.print(set);
    }


}

