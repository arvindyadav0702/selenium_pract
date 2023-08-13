package APITests;

public class Payload {

    public static String addBook() {

        String payload = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bcd\",\n" +
                "\"aisle\":\"2926\",\n" +
                "\"author\":\"John foer\"\n" +
                "}\n";

        return payload;
    }
}
