package data_providers;

import org.testng.annotations.DataProvider;

public class StandardUserCredentials {

    @DataProvider(name = "standard credentials")
    public Object[][] sendStandardCredentials() {
        Object [][] data = {{"standard_user", "secret_sauce"}};
        return data;

        }
    }




