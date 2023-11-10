//package utils.factoryMethod;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//public class PropertiesFileReader implements Reader {
//    public static Properties properties;
//
//    static {
//        properties = new Properties();
//        InputStream inputStream = PropertiesFileReader.class.getResourceAsStream("/config.properties");
//        try {
//            properties.load(inputStream);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public String getData(String propertyName) {
//        return properties.getProperty(propertyName);
//    }
//}