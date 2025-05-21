package factory;

import core.Task;
import state.NewState;

public class UrgentTask implements TaskFactory {
    public Task createTask(String name) {
        Task task = new Task(name, "Urgent");
        task.setState(new NewState());
        return task;
    }
}
