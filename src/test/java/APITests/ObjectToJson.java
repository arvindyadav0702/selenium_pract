package APITests;

import com.fasterxml.jackson.databind.ObjectMapper;
import programsforJava.ProductName;

public class ObjectToJson {

    public static void main(String[] args) {

        ProductName prod = new ProductName();
        prod = getObjectData(prod);


        ObjectMapper mapper = new ObjectMapper();
        try {

            String values = mapper.writeValueAsString(prod);
            System.out.println(values + "&**************************");

            //reading data
            getJSONtoString(prod);


        } catch (Exception e) {

            e.printStackTrace();

        }


    }


    public static ProductName getObjectData(ProductName productName) {
        productName.setName("Arvind");
        productName.setId(123);
        productName.setPrice(999);

        return productName;

    }

    public static void getJSONtoString(ProductName productName) {
        System.out.println(productName.getName());
        System.out.println(productName.getPrice());

    }


}

