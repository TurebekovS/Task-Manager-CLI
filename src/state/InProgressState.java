package state;

public class InProgressState implements TaskState {
    public void handle() {
        System.out.println("Task is IN PROGRESS.");
    }
}
