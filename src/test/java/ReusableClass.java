import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;

public class ReusableClass {

    public static JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);

        return js;
    }


    @DataProvider(name = "ID")
    public static Object[][] getData() {

        return new String[][]{
                {"Data Structures & Algorithms",
                        "Programming & Logic"},                       // row 1

                {"Thermodynamics", "Metallurgy",
                        "Machine Drawing"},                             // row2

                {"Signals and Systems", "Digital Electronics"}           // row3
        };


    }
}
