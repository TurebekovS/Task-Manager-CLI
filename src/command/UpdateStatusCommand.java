package command;

import core.Task;
import core.TaskManager;
import state.TaskState;

public class UpdateStatusCommand implements Command {
    private String taskName;
    private TaskState newState;

    public UpdateStatusCommand(String taskName, TaskState newState) {
        this.taskName = taskName;
        this.newState = newState;
    }

    @Override
    public void execute() {
        Task task = TaskManager.getInstance().findTaskByName(taskName);
        if (task != null) {
            task.setState(newState);
            System.out.println("Task '" + taskName + "' updated to " + newState.getClass().getSimpleName());
        } else {
            System.out.println("Task not found.");
        }
    }
}
