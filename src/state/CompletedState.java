package state;

public class CompletedState implements TaskState {
    public void handle() {
        System.out.println("Task is COMPLETED.");
    }
}
