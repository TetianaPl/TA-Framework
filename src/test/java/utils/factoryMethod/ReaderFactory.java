package utils.factoryMethod;

public class ReaderFactory {
    public Reader getReader(ReaderType readerType) {
        Reader reader;
        switch (readerType) {
            case COMMAND_LINE:
                reader = new CommandLineReader();
                break;
            case PROPERTIES_FILE:
                reader = new PropertiesFileReader();
                break;
            default:
                throw new IllegalArgumentException("Cannot create reader for type: " + readerType);
        }
        return reader;
    }
}
