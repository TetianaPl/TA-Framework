package cucumber.hooks;

import io.cucumber.java.After;

import static tests.TestSetup.driver;

public class Hooks {
    @After("@RegularTest")
    public void tearDown() {
        driver.quit();
        driver = null;
        System.out.println("**********************After in HOOKS");
    }
}
