package models;

/*
    Class describes model containing both User and Task models
 */
public class TaskUser {
    private String userName;
    private String userPassword;
    private String taskName;
    private String taskDescription;
    private int taskStatus;

    public User getUser() {
        return new User(userName, userPassword);
    }

    public Task getTask() {
        return new Task(taskName, taskDescription, taskStatus);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }
}
