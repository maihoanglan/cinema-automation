package utils;

import java.time.Duration;
import java.util.Properties;

public class ConfigReader {
    Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrlHome() {
        return properties.getProperty("urlHome");
    }

    public String getUrlDashboard() {
        return properties.getProperty("urlDashboard");
    }

    public Duration getTimeOut() {
        return Duration.ofSeconds(
                Long.parseLong(
                        properties.getProperty("timeout")
                )
        );
    }
}

