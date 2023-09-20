package utils;

import java.util.ResourceBundle;

import static tests.TestSetup.reader;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(reader.getData("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
