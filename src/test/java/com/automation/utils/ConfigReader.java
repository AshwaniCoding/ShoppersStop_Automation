package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
    static Properties props;

    public static void initReader() {
        props = new Properties();
        try {
            String env = System.getProperty("env", "dev");
            props.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfigValue(String key) {
        return props.getProperty(key);
    }

    public static void setConfigValue(String key, String value) {
        props.setProperty(key, value);
    }

    public static Object getObject(Object key) {
        return props.get(key);
    }

    public static void setObject(Object key, Object value) {
        props.put(key, value);
    }

    public static List getPropertyByPartialKey(String partialKey) {
        List<String> list = new ArrayList<>();
        for (String key : props.stringPropertyNames()) {
            if (key.contains(partialKey)) {
                list.add(key);
            }
        }
        return list;
    }
}
