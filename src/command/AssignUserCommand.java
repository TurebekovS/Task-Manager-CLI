package command;

import core.Task;
import core.TaskManager;
import observer.User;

public class AssignUserCommand implements Command {
    private String taskName;
    private User user;

    public AssignUserCommand(String taskName, User user) {
        this.taskName = taskName;
        this.user = user;
    }

    @Override
    public void execute() {
        Task task = TaskManager.getInstance().findTaskByName(taskName);
        if (task != null) {
            task.attachObserver(user);
            System.out.println("User " + user.getName() + " assigned to task '" + taskName + "'");
        } else {
            System.out.println("Task not found.");
        }
    }
}
