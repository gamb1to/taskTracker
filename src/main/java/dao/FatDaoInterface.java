package dao;


import models.Task;
import models.User;

import java.util.List;

/*
    Interface describes functionality of DAO to operate with Database
 */
public interface FatDaoInterface {
    /*
        Check if user is in database
     */
    boolean validUser(User user);

    /*
        Check if task is in database
     */
    boolean validTask(int taskId);

    /*
        Save a task in the database
     */
    void saveTask(Task task, int userId);

    /*
        Get a list of tasks of user with UserId  with status taskStatus
     */
    List<Task> getTasks(int userId, int taskStatus);

    /*
        Delete a task from the database
     */
    void deleteTask(int taskId);
}
