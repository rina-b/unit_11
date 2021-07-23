package ua.com.alelvel;

import ua.com.alelvel.entity.AppProperties;

public class ReflectionMain {
    public static void main(String[] args) {
        PropertyFactory propertyFactory = new PropertyFactory();
        propertyFactory.init(AppProperties.class);
    }
}