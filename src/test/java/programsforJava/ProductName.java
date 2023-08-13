package programsforJava;

import java.util.Arrays;
import java.util.Comparator;

public class ProductName {
    //Creating properties of Product class
    private int id;
    private String name;
    private int price;

    //Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\"Product [ProductId " + id + ", programsforJava.ProductName = " + name + ", ProductPrice = " + price + "]";
    }


    public static void main(String[] args0) {

        String validate = "this is a new string and validate the string has duplicates";

        String[] str = validate.split(" ");

        String min = Arrays.stream(str).min(Comparator.comparingInt(String::length)).orElse(null);
        String max = Arrays.stream(str).max(Comparator.comparingInt(String::length)).orElse(null);

        System.out.println(min);
        System.out.println(max);

        // not via collection
        String minimum = str[0];
        String maximum = str[0];
        String currentword;

        for (int i = 1; i < str.length; i++) {
            currentword = str[i];

            if (currentword.length() > maximum.length()) {
                maximum = currentword;

            } else if (currentword.length() < minimum.length()) {
                minimum = currentword;

            }
        }

        System.out.println(minimum);
        System.out.println(maximum);
    }
}

