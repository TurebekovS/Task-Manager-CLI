package factory;

import core.Task;
import state.NewState;

public class NormalTask implements TaskFactory {
    public Task createTask(String name) {
        Task task = new Task(name, "Normal");
        task.setState(new NewState());
        return task;
    }
}
