package models;

/*
    Class describes Task model
 */
public class Task {
    public static final int STATUS_NEW = 0;
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_COMPLETED = 2;

    private int id;
    private String name;
    private String description;
    private int status;

    public Task() {
    }

    public Task(String name, String description, int status) {
        this.name = name;
        this.description = description;

        //TODO: status value check
        this.status = status % 3;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
