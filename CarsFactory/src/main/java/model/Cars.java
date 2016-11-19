package model;

public class Cars {
    private int id;
    private String name;
    private Owner aOwner;

    public Cars(int id, String name, Owner aOwner) {
        this.id = id;
        this.name = name;
        this.aOwner = aOwner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Owner getaOwner() {
        return aOwner;
    }
}
