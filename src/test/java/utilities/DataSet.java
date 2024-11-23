package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object InvalidUserCredentials(){

        Object[][] data ={
                {"xikolek393@cironex", "145", "Your email or password is incorrect!", ""},
                {"xikolek393@cironex", "12345", "Your email or password is incorrect!", ""},
                {"xikolek393@cironex.com", "12", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill out this field"},
                {"xikolek393@cironex.com", "", "Your email or password is incorrect!", ""},
                {"", "12345", "Your email or password is incorrect!", ""}
        };
        return data;
    }
}
