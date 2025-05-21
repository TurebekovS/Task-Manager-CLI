package state;

public class NewState implements TaskState {
    public void handle() {
        System.out.println("Task is NEW.");
    }
}
