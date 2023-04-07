package entity;

import java.util.UUID;

public abstract class Person {

    private final String id;
    private String name;

    public Person( String name) {
        this.id =UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
