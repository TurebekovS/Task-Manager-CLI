package command;

import core.TaskManager;
import factory.TaskFactory;
import core.Task;

public class CreateTaskCommand implements Command {
    private String name;
    private TaskFactory factory;

    public CreateTaskCommand(String name, TaskFactory factory) {
        this.name = name;
        this.factory = factory;
    }

    @Override
    public void execute() {
        Task task = factory.createTask(name);
        TaskManager.getInstance().addTask(task);
        System.out.println("Task created: " + name);
    }
}
