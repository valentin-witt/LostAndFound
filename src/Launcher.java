import Config.Properties;
import Config.PropertiesReader;
import Screens.Startscreen;

public class Launcher {

    public static void main(String[] args) {

        // Read command line arguments to configure pathToPropertiesFile
        String pathToPropertiesFile;
        if (args != null && args.length == 1) {
            pathToPropertiesFile = args[0];
        } else {
            pathToPropertiesFile = "/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json";
        }

        // Read properties file and convert JSON to POJO "Properties"
        PropertiesReader reader = new PropertiesReader();
        Properties properties = reader.readPropertiesFile(pathToPropertiesFile);

        // Create new instance of "Startscreen"
        Startscreen startscreen = new Startscreen(properties);


    }
}
