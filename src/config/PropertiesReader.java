package config;

import config.Properties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PropertiesReader {

    private Properties properties;

    public Properties readPropertiesFile(String pathOfPropertiesFile){
        this.properties = new Properties();

        if (pathOfPropertiesFile != null && pathOfPropertiesFile.length()>0) {

            ObjectMapper mapper = new ObjectMapper();

            //JSON file to Java object
            try {
                this.properties = mapper.readValue(new File(pathOfPropertiesFile), Properties.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return properties;
    }
}
