package ua.com.alelvel;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertyLoader {
    public Properties properties(String prop){
        Properties properties = new Properties();
        try (InputStream stream = getClass().getResourceAsStream( prop)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }
}
