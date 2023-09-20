package utils.factoryMethod;

public class CommandLineReader implements Reader {

    public String getData(String propertyName) {
        return System.getProperty(propertyName);
    }
}