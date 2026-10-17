package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class TaskManager {
    private final Set<String> COMMANDS = Set.of("1", "2", "3", "4", "0");
    private final TaskHandler handler;
    public final Scanner console;

    public TaskManager(TaskHandler handler) {
        this.handler = handler;
        this.console= new Scanner(System.in);
    }


    public static void handleExit() {
        System.exit(0);
    }

    public void start() {
        while (true) {
            TaskPrinter.printMenu();
            String inputTask = console.nextLine();
            if (COMMANDS.contains(inputTask)) {
                int command = Integer.parseInt(inputTask);
                switch (command){
                    case 0:
                    TaskPrinter.handleExit();
                    handleExit();
                    break;
                    case 1:
                    TaskPrinter.titleOfTask();
                    String title = console.nextLine();
                    TaskPrinter.descriptionOfTask();
                    String description = console.nextLine();
                    while (true) {
                        try {
                            TaskPrinter.deadLine();
                            String day = console.nextLine();
                            int days = Integer.parseInt(day);
                            LocalDateTime deadline = LocalDateTime.now().plusDays(days);
                            TaskPrinter.priority();
                            Priority priority;
                            String set = console.nextLine();
                            int setPriority = Integer.parseInt(set);
                            if (setPriority < 1 || setPriority > 3) {
                                TaskPrinter.correctPoint();
                                continue;
                            }
                            if (setPriority == 1) {
                                priority = Priority.LOW;
                            } else if (setPriority == 2) {
                                priority = Priority.MEDIUM;
                            } else {
                                priority = Priority.HIGH;
                            }
                            TaskStatus status = TaskStatus.PENDING;
                            Task newTask = new Task(title, description, deadline, priority, status);
                            handler.handleNewTask(newTask);
                            TaskPrinter.taskAdded();
                            break;
                        } catch (NumberFormatException e) {
                            TaskPrinter.notText();
                        }
                    }
                    break;
                    case 2:
                    if (handler.isEmpty()) {
                        TaskPrinter.isTaskListEmpty();
                        continue;
                    }
                    TaskPrinter.printTask(handler.getTasks());
                    break;
                    case 3:
                    if (handler.isEmpty()) {
                        TaskPrinter.isTaskListEmpty();
                        continue;
                    }
                    while (true) {
                        TaskPrinter.printTask(handler.getTasks());
                        TaskPrinter.setNum();
                        String in = console.nextLine();
                        try {
                            int taskNumber = Integer.parseInt(in);
                            boolean checkTask = handler.deleteTask(taskNumber);
                            if (checkTask) {
                                TaskPrinter.delTask();
                                break;
                            } else {
                                TaskPrinter.noTask();
                            }
                        } catch (NumberFormatException e) {
                            TaskPrinter.notText();
                        }
                    }
                    break;
                    case 4:
                    if (handler.isEmpty()) {
                        TaskPrinter.isTaskListEmpty();
                        continue;
                    }
                    while (true) {
                        TaskPrinter.printTask(handler.getTasks());
                        TaskPrinter.setNum();
                        String in = console.nextLine();
                        TaskStatus taskStatus;
                        try {
                            int taskNumber = Integer.parseInt(in);
                            Task found = handler.findTaskById(taskNumber);
                            if (found == null) {
                                TaskPrinter.noTask();
                            } else {
                                TaskPrinter.status();
                                String set = console.nextLine();
                                int input = Integer.parseInt(set);
                                if (input < 1 || input > 3) {
                                    TaskPrinter.correctPoint();
                                    continue;
                                }
                                if (input == 1) {
                                    taskStatus = TaskStatus.PENDING;
                                } else if (input == 2) {
                                    taskStatus = TaskStatus.IN_PROGRESS;
                                } else {
                                    taskStatus = TaskStatus.COMPLETED;
                                }
                                boolean ok = handler.changeStatus(taskNumber, taskStatus);
                                if (ok) {
                                    TaskPrinter.status();
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            TaskPrinter.notText();
                        }
                    }
                    default:
                    TaskPrinter.correctPoint();
                }
            }
        }

    }


}
