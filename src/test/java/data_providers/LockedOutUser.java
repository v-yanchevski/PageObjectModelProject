package data_providers;

import org.testng.annotations.DataProvider;

public class LockedOutUser {

    @DataProvider(name = "locked user")
    public Object[][] lockedOutCredentials() {
        Object [][] data = {{"locked_out_user", "secret_sauce"}};
        return data;

    }
}
