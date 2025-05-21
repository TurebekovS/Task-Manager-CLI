package core;

import observer.User;
import state.TaskState;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String priority;
    private TaskState state;
    private List<User> observers;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        observers = new ArrayList<>();
    }

    public void setState(TaskState state) {
        this.state = state;
        notifyUsers();
    }

    public void attachObserver(User user) {
        observers.add(user);
    }

    private void notifyUsers() {
        for (User user : observers) {
            user.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public TaskState getState() {
        return state;
    }

    public String getPriority() {
        return priority;
    }
}
