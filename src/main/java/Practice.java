
import java.io.*;
import java.util.*;

public class Practice {
    public Practice() throws FileNotFoundException {
    }

//        Scanner reader = new Scanner(System.in);
//
//        System.out.print("Enter a number: ");
//        int num = reader.nextInt();
//
//        if(num % 2 == 0)
//            System.out.println(num + " is even");
//        else
//            System.out.println(num + " is odd");

//        ===================


//        Map<String, Integer> hm
//                = new HashMap<String, Integer>();
//
//        // Inserting pairs in above Map
//        // using put() method
//        hm.put("a", 100);
//        hm.put("b", 200);
//        hm.put("c", 300);
//        hm.put("d", 400);
//
//        // Traversing through Map using for-each loop
//        for (Map.Entry<String, Integer> me :
//                hm.entrySet()) {
//
//            // Printing keys
//            System.out.print(me.getKey() + ":");
//            System.out.println(me.getValue());
//        }


    // Function to remove duplicates from an ArrayList
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }

    // Driver code
    public static void main(String args[]) throws IOException {

//        // Get the ArrayList with duplicate values
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
//
//        // Print the Arraylist
//        System.out.println("ArrayList with duplicates: " + list);
//
//        // Remove duplicates
//        ArrayList<Integer> newList = removeDuplicates(list);
//
//        // Print the ArrayList with duplicates removed
//        System.out.println("ArrayList with duplicates removed: " + newList);
//
//
//        File newFile = new File("user.dir");
//
//        //create BufferedReader object from the File
//        BufferedReader br = null;
//        br = new BufferedReader(new FileReader(newFile));
//
//        String line = null;
//
//        //read file line by line
//        while ((line = br.readLine()) != null) {
//
//            //split the line by :
//            String[] parts = line.split(":");
//
//        }
         File filepath = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\prop.properties");
        FileReader file = new FileReader(filepath);
//        Properties prop = new Properties(file);
        Properties prop = new Properties();
        prop.load(file);

        System.out.println(prop.getProperty("browser"));


    }
}
