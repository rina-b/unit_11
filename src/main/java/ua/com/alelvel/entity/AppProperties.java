package ua.com.alelvel.entity;

import ua.com.alelvel.annotation.PropertyKey;

public class AppProperties {

    @PropertyKey("connections.limit")
    public int maxConnections;

    @PropertyKey("url")
    public String dbURL;

    @PropertyKey("name")
    public String name;

    @PropertyKey("age")
    public int age;

    @PropertyKey("default.state")
    public boolean inRelationship;


}
