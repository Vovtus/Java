package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
    private static final String menu = """
                    >>> Меню:
                    1. Добавить задачу
                    2. Показать все задапчи
                    3. Удалить задачу (по номеру)
                    4. Отметить задачу как выполненную
                    0. Выход
            
                    Выберите пункт меню:
            """;


    //public static final String[] task = new String[100];
    //public static final boolean[] taskStatus = new boolean[100];
    public static final Scanner console = new Scanner(System.in);
    public static int taskCount = 0;

    public static boolean isTaskListEmpty() {
        if (taskCount == 0) {
            System.out.println("Список задач пуст");
            return true;
        }
        return false;
    }

    private static final Set<String> COMMANDS = Set.of("1", "2", "3", "4", "0");

    public static void handleExit() {
        System.out.println("Выход");
        System.exit(0);
    }

    public static int command;

    public static void main(String[] args) {
        TaskHandler taskHandler = new TaskHandler();
        Task t1 = new Task(10, "Молоко", "2 литра", null, Priority.MEDIUM, TaskStatus.PENDING);
        Task t2 = new Task(20, "Хлеб", "Ржаной", null, Priority.LOW, TaskStatus.PENDING);

        taskHandler.handleNewTask(t1);
        taskHandler.handleNewTask(t2);

        System.out.println("Размер: " + taskHandler.getTasks().size());


        System.out.println("После атаки: " + taskHandler.getTasks().size());
        System.out.println(taskHandler.findTaskById(2) == null ? "не нашёл" : "нашёл");
        System.out.println(taskHandler.findTaskById(2));
        System.out.println("Найден 20? " + (taskHandler.findTaskById(20) != null));
        System.out.println("Найден 999? " + (taskHandler.findTaskById(999) != null));
        System.out.println("checkTask(20) → "  + taskHandler.checkTask(20));
        System.out.println("checkTask(999) → " + taskHandler.checkTask(999));
        System.out.println("Статус 20: " + taskHandler.findTaskById(20).getTaskStatus());
        System.out.println("deleteTask(10) → " + taskHandler.deleteTask(10));
        System.out.println("Размер: " + taskHandler.getTasks().size());



//        while (true) {
//            System.out.println(menu);
//            String input = console.nextLine();
//
//
//            if (COMMANDS.contains(input)) {
//                int command = Integer.parseInt(input);
//                if (command == 0) {
//                    handleExit();
//
//                } else if (command == 1) {
//                    if (taskCount >= 100) {
//                        System.out.println("Список задач переполнен");
//                        continue;
//                    }
//                    taskHandler.handleNewTask();
//                    System.out.println(taskHandler.getTasks().size());
//                    taskHandler.getTasks().clear();
//                    System.out.println(taskHandler.getTasks().size());
//
//
//                } else if (command == 2) {
//                    if (isTaskListEmpty()) {
//                        continue;
//                    }
//                    System.out.println("Список задач:");
//                    taskHandler.getTasks();
//                    }
//                } else if (command == 3) {
//                    if (isTaskListEmpty()) {
//                        continue;
//                    }
//                    System.out.println("Введите номер задачи для удаления:");
//                    String in = console.nextLine();
//                    try {
//                        int taskNumber = Integer.parseInt(in);
//                        if (taskNumber < 1 || taskNumber > taskCount) {
//                            System.out.println("Введите корректный номер задачи");
//                            continue;
//                        }
//                        int index = taskNumber - 1;
//                        String removedTask = task[index];
//                        for (int i = index; i < taskCount - 1; i++) {
//                            task[i] = task[i + 1];
//                            taskStatus[i] = taskStatus[i + 1];
//
//                        }
//                        taskCount--;
//                        System.out.println("Задача \"" + removedTask + "\" удалена ");
//
//                    } catch (NumberFormatException e) {
//                        System.out.println("Введите число, а не текст");
//                    }
//
//                } else if (command == 4) {
//                    if (isTaskListEmpty()) {
//                        continue;
//                    }
//                    System.out.println("Введите номер задачи для отметки:");
//                    String mark = console.nextLine();
//                    try {
//                        int checkTask = Integer.parseInt(mark);
//                        if (checkTask < 1 || checkTask > taskCount) {
//                            System.out.println("Введите корректный номер задачи");
//                            continue;
//                        }
//                        int index = checkTask - 1;
//                        if (taskStatus[index]) {
//                            System.out.println("Задача уже отмечена как выполненная");
//                            continue;
//
//                        }
//                        taskStatus[index] = true;
//
//                        System.out.println("Задача \"" + task[index] + "\" отмечена как выполненная!");
//
//                    } catch (NumberFormatException e) {
//                        System.out.println("Введите число, а не текст");
//                    }
//
//
//                }
//
//            } else {
//                System.out.println("Введите цифру от 0 до 4");
//
//            }
//        }
    }
}

