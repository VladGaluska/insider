package org.dxworks.dxplatform.plugins.insider.configuration;

import org.dxworks.dxplatform.plugins.insider.constants.InsiderConstants;

import java.util.Properties;

public class InsiderConfiguration {

    private static InsiderConfiguration ourInstance = new InsiderConfiguration();
    private Properties config;

    private InsiderConfiguration() {
    }

    public static InsiderConfiguration getInstance() {
        return ourInstance;
    }

    public String getRootFolder() {
        String property = getProperty(InsiderConstants.ROOT_FOLDER);
        if (property.endsWith("\\") || property.endsWith("/")) {
            property = property.substring(0, property.length() - 1);
        }

        return property;
    }

    public static void loadProperties(Properties properties) {
        if (ourInstance.config == null)
            ourInstance.config = properties;
    }

    public String getProperty(String property) {
        return config.getProperty(property);
    }
}