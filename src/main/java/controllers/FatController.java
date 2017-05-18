package controllers;

import dao.FatDao;
import models.Task;
import models.TaskUser;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    A fat controller that provides all possible functionality
    TODO: transform this class into three classes
 */
@Controller
public class FatController {
    private static final FatDao dao = FatDao.getInstance();

    /*
        Show tasks functionality
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String showTasksListGET(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "../WEB-INF/jsp/tasks.jsp";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public String showTasksListPOST(User user, Model model) {
        String msg;
        int taskStatus = user.getId();

        if(!dao.validUser(user)) {
            msg = "uname or pass is invalid";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/tasks.jsp";
        }

        if(taskStatus != 0 && taskStatus != 1 && taskStatus != 2) {
            msg = "invalid task status";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/tasks.jsp";
        }

        List<Task> tasks =  dao.getTasks(user.getId(), taskStatus);
        model.addAttribute("tasks", tasks);

        return "../WEB-INF/jsp/tasklist.jsp";
    }

    /*
        Create a task functionality
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTaskGET(Model model) {
        TaskUser taskUser = new TaskUser();
        model.addAttribute("taskUser", taskUser);
        return "../WEB-INF/jsp/create.jsp";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTaskPOST(TaskUser taskUser, Model model) {
        User user = taskUser.getUser();
        Task task = taskUser.getTask();
        String msg;

        if(!dao.validUser(user)) {
            msg = "uname or pass is invalid";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/create.jsp";
        }

        if(task.getName().length() < 3) {
            msg = "too short task name";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/create.jsp";
        }

        if(task.getDescription().length() < 5) {
            msg = "too short task description";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/create.jsp";
        }

        if(task.getStatus() != 0 && task.getStatus() != 1 && task.getStatus() != 2) {
            msg = "invalid task status";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/create.jsp";
        }

        dao.saveTask(task, user.getId());

        return "../WEB-INF/jsp/success.jsp";
    }

    /*
        Delete a task functionality
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteTaskGET(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "../WEB-INF/jsp/delete.jsp";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteTaskPOST(User user, Model model) {
        String msg;
        int taskId = user.getId();

        if(!dao.validUser(user)) {
            msg = "uname or pass is invalid";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/delete.jsp";
        }

        if(!dao.validTask(taskId)) {
            msg = "invalid task id";
            model.addAttribute("msg", msg);
            return "../WEB-INF/jsp/delete.jsp";
        }

        dao.deleteTask(taskId);

        return "../WEB-INF/jsp/success.jsp";
    }

}

