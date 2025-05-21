package core;

import command.*;
import factory.NormalTask;
import factory.UrgentTask;
import observer.User;
import state.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Task Manager Started!");

        while (running) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 0) continue;

            String cmd = parts[0];

            if (cmd.equals("exit")) {
                running = false;
            } else if (cmd.equals("create")) {
                if (parts.length < 3) {
                    System.out.println("Usage: create [normal|urgent] <taskName>");
                    continue;
                }
                String type = parts[1];
                String name = parts[2];
                Command create = type.equals("normal")
                        ? new CreateTaskCommand(name, new NormalTask())
                        : new CreateTaskCommand(name, new UrgentTask());
                create.execute();

            } else if (cmd.equals("assign")) {
                if (parts.length < 3) {
                    System.out.println("Usage: assign <taskName> <userName>");
                    continue;
                }
                Command assign = new AssignUserCommand(parts[1], new User(parts[2]));
                assign.execute();

            } else if (cmd.equals("update")) {
                if (parts.length < 3) {
                    System.out.println("Usage: update <taskName> <newState>");
                    continue;
                }
                TaskState newState = switch (parts[2].toLowerCase()) {
                    case "new" -> new NewState();
                    case "inprogress" -> new InProgressState();
                    case "completed" -> new CompletedState();
                    default -> null;
                };
                if (newState != null) {
                    Command update = new UpdateStatusCommand(parts[1], newState);
                    update.execute();
                } else {
                    System.out.println("Unknown state.");
                }

            } else if (cmd.equals("list")) {
                for (Task t : TaskManager.getInstance().getAllTasks()) {
                    System.out.println(t.getName() + " [" + t.getPriority() + "] - " +
                            t.getState().getClass().getSimpleName());
                }

            } else {
                System.out.println("Unknown command.");
            }
        }

        System.out.println("Task Manager Closed.");
        scanner.close();
    }
}
