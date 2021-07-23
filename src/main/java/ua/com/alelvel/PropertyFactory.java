package ua.com.alelvel;

import ua.com.alelvel.annotation.PropertyKey;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PropertyFactory {
    public <T> T init(Class<T> tClass) {
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties properties = propertyLoader.properties("/app.properties");
        try {
            T inst = tClass.getConstructor().newInstance();
            for (Field field : tClass.getFields()) {
                if (field.isAnnotationPresent(PropertyKey.class)) {
                    String key = field.getAnnotation(PropertyKey.class).value();
                    String value = properties.getProperty(key);
                    Class<?> type = field.getType();
                    if (type == byte.class || type == Byte.class) {
                        field.set(inst, Byte.parseByte(value));
                    } else if (type == short.class || type == Short.class) {
                        field.set(inst, Short.parseShort(value));
                    } else if (type == int.class || type == Integer.class) {
                        field.set(inst, Integer.parseInt(value));
                    } else if (type == long.class || type == Long.class) {
                        field.set(inst, Long.parseLong(value));
                    } else if (type == float.class || type == Float.class) {
                        field.set(inst, Float.parseFloat(value));
                    } else if (type == double.class || type == Double.class) {
                        field.set(inst, Double.parseDouble(value));
                    } else if (type == boolean.class || type == Boolean.class) {
                        field.set(inst, Boolean.parseBoolean(value));
                    } else if (type == char.class || type == Character.class) {
                        field.set(inst, value.charAt(0));
                    } else if (type == String.class) {
                        field.set(inst, value);
                    } else if (type.isEnum()) {
                        field.set(inst, Enum.valueOf((Class<? extends Enum>) type, value));
                    }
                }
            }
            return inst;
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException ex){
            throw new RuntimeException(ex);
        }
    }
}
