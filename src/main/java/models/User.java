package models;

/*
    Class describes User model
 */
public class User {
    private int id;
    private String name;
    private String hashedPassword;

    public User() {
    }

    public User(String name, String hashedPassword) {
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
