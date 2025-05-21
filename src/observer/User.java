package observer;

import core.Task;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(Task task) {
        System.out.println("Notification for " + name + ": Task '" + task.getName() +
                "' changed state to " + task.getState().getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }
}
