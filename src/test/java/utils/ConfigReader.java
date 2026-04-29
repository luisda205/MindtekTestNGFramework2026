package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * This class read the configuration.properties file.
     *
     */
    private static FileInputStream input;
    private static Properties properties;

    static {
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\configurations\\Configuration.properties";
        try {
            input = new FileInputStream(path);      // opens string to the file
            properties = new Properties();          //loads the file
            properties.load(input);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Path to properties file is invalid or the file is missing");
        } catch (IOException e) {
            System.out.println("failed to load properties file");
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("filed to close FileInputStream");
            }
        }
    }
    /**
     * This methods accepts Keys from properties file parameter
     * And return correponding values as string
     * @param key
     * @return
     */
    public static  String getProperty(String key){
        return properties.getProperty(key);
    }
}
