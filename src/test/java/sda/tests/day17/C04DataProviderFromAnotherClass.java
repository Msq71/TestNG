package sda.tests.day17;

import org.testng.annotations.Test;

public class C04DataProviderFromAnotherClass {
    /*
        We can use our data by retrieving it from a different class; for this, we need to properly integrate the
        data provider method as a parameter into the test method.
        */

    @Test(dataProvider = "invalidCredentials", dataProviderClass = C02DataProvider02.class)
    public void printCredentialsTest(String username, String password) {
        System.out.println("Username : " + username + "Password :" + password);
    }
}
