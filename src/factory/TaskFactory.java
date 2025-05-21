package factory;

import core.Task;

public interface TaskFactory {
    Task createTask(String name);
}
