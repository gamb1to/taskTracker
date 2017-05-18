package dao;

import models.Task;
import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


/*
    Class implemets Dao functionality to operate with Database
    (Now it works with sqlite)

    Note: this class is a Singleton: to get its object use static method getInstance()
 */
public class FatDao implements FatDaoInterface {
    private static final String URL = "jdbc:sqlite:new.db";
    private static FatDao instance = null;

    private JdbcTemplate jdbcTemplate;

    public static FatDao getInstance() {
        if (instance == null)
            instance = new FatDao();

        return instance;
    }

    /*
        Creates a connection with database
        Fixes tables in database
     */
    private  FatDao() {
        DataSource ds = new DriverManagerDataSource(URL);
        jdbcTemplate = new JdbcTemplate(ds);

        // drop tables if they exists
        jdbcTemplate.update("drop table if exists users");
        jdbcTemplate.update("drop table if exists tasks");

        // create tables users and tasks
        // create two users
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, hashedPassword TEXT);").
                append("CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, ").
                append("status INTEGER, user_id INTEGER);").
                append("INSERT INTO users(name, hashedPassword) VALUES ('user1', 'pass1');").
                append("INSERT INTO users(name, hashedPassword) VALUES ('user2', 'pass2');");

        jdbcTemplate.update(sql.toString());

    }


    /*
        Note: this method places found user.id in user object
     */
    @Override
    public boolean validUser(User user) {
        String sql = "SELECT COUNT(*) as num FROM users WHERE name = ? and hashedPassword = ?;";

        int num = jdbcTemplate.query(sql, new Object[]{user.getName(), user.getHashedPassword()},
                resultSet -> {
            return resultSet.getInt("num");
        });

        if (num != 1)
            return false;

        sql = "SELECT id FROM users WHERE name = ? and hashedPassword = ?;";

        int id = jdbcTemplate.query(sql, new Object[]{user.getName(), user.getHashedPassword()},
                resultSet -> {
                    return resultSet.getInt("id");
                });

        user.setId(id);
        return true;
    }

    @Override
    public boolean validTask(int taskId) {
        String sql = "SELECT COUNT(*) as num FROM tasks WHERE id = ?;";

        int num = jdbcTemplate.query(sql, new Object[]{taskId},
                resultSet -> {
                    return resultSet.getInt("num");
                });

        return num == 1;
    }

    @Override
    public void saveTask(Task task, int userId) {
        String sql = "INSERT INTO tasks (name, description, status, user_id)" +
                "VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, task.getName(), task.getDescription(), task.getStatus(), userId);
    }

    @Override
    public List<Task> getTasks(int userId, int taskStatus) {
        String sql = "SELECT * FROM tasks WHERE user_id = ? and status = ?;";
        return jdbcTemplate.query(sql, new Object[]{userId, taskStatus},
                resultSet -> {
                    List<Task> tasks = new ArrayList<>();
                    while (resultSet.next()) {

                        Task task = new Task();

                        task.setId(resultSet.getInt("id"));
                        task.setName(resultSet.getString("name"));
                        task.setDescription(resultSet.getString("description"));
                        task.setStatus(resultSet.getInt("status"));

                        tasks.add(task);
                    }

                    return tasks;
                });

    }

    @Override
    public void deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?;";
        jdbcTemplate.update(sql, taskId);
    }


}
