package org.example;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.Scanner;


public class Main {
    public static final Scanner console = new Scanner(System.in);
    public static int id = 1;
    private static final Set<String> COMMANDS = Set.of("1", "2", "3", "4", "0");
    private static final String menu = """
                    ____________________________________
                    >>> Меню:
                    1. Добавить задачу
                    2. Показать все задачи
                    3. Удалить задачу (по номеру)
                    4. Изменить статус задачи
                    0. Выход
            
                    Выберите пункт меню:
                    _____________________________________
            """;
    static TaskHandler taskHandler = new TaskHandler();

    public static boolean isTaskListEmpty() {
        if (taskHandler.isEmpty()) {
            System.out.println("Список задач пуст");
            return true;
        }
        return false;
    }

    public static void handleExit() {
        System.out.println("Выход");
        System.exit(0);
    }

    public static void getTasks() {
        int listSize = taskHandler.getSize();
        for (int i = 0; i < listSize; i++) {
            System.out.println(taskHandler.getTasks().get(i));
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(menu);
            String inputTask = console.nextLine();
            if (COMMANDS.contains(inputTask)) {
                int command = Integer.parseInt(inputTask);
                if (command == 0) {
                    handleExit();
                } else if (command == 1) {
                    System.out.println("Введите название задачи: ");
                    String title = console.nextLine();
                    System.out.println("Введите описание задачи: ");
                    String description = console.nextLine();
                    while (true) {
                        try {
                            System.out.println("Укажите через сколько дней дэдлайн");
                            String day = console.nextLine();
                            int days = Integer.parseInt(day);
                            LocalDateTime deadline = LocalDateTime.now().plusDays(days);
                            System.out.println("""
                                            Укажите приоритет задачи:
                                            1. LOW - низкий
                                            2. MEDIUM - средний
                                            3. HIGH - высокий
                                    """);
                            Priority priority;
                            String set = console.nextLine();
                            int setPriority = Integer.parseInt(set);
                            if (setPriority < 1 || setPriority > 3) {
                                System.out.println("Выберите корректный пункт меню");
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
                            Task newTask = new Task(id, title, description, deadline, priority, status);
                            taskHandler.handleNewTask(newTask);
                            id++;
                            System.out.println("Задача добавлена");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число, а не текст");
                        }
                    }
                } else if (command == 2) {
                    if (isTaskListEmpty()) {
                        continue;
                    }
                    getTasks();
                } else if (command == 3) {
                    if (isTaskListEmpty()) {
                        continue;
                    }
                    while (true) {
                        getTasks();
                        System.out.println("Введите номер задачи для удаления:");
                        String in = console.nextLine();
                        try {
                            int taskNumber = Integer.parseInt(in);
                            boolean checkTask = taskHandler.deleteTask(taskNumber);
                            if (checkTask) {
                                System.out.println("Задача удалена");
                                break;
                            } else {
                                System.out.println("Задача с номером " + taskNumber + " отсутствует");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число, а не текст");
                        }
                    }
                } else if (command == 4) {
                    if (isTaskListEmpty()) {
                        continue;
                    }
                    while (true) {
                        getTasks();
                        System.out.println("Введите номер задачи для изменения статуса: ");
                        String in = console.nextLine();
                        TaskStatus taskStatus;
                        try {
                            int taskNumber = Integer.parseInt(in);
                            Task found = taskHandler.findTaskById(taskNumber);
                            if (found == null) {
                                System.out.println("Задача с номером " + taskNumber + " отсутствует");
                            } else {

                                System.out.println("""
                                        Выберите статус:
                                        1. PENDING - Задача не начата
                                        2. IN_PROGRESS - Задача в процессе
                                        3. COMPLETED - Задача выполнена
                                        """);
                                String set = console.nextLine();
                                int input = Integer.parseInt(set);
                                if (input < 1 || input > 3) {
                                    System.out.println("Выберите корректный пункт меню");
                                    continue;
                                }
                                if (input == 1) {
                                    taskStatus = TaskStatus.PENDING;
                                } else if (input == 2) {
                                    taskStatus = TaskStatus.IN_PROGRESS;
                                } else {
                                    taskStatus = TaskStatus.COMPLETED;
                                }
                                boolean ok = taskHandler.changeStatus(input, taskStatus);
                                if (ok) {
                                    System.out.println("Статус задачи изменён");
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число, а не текст");
                        }
                    }
                } else {
                    System.out.println("Введите цифру от 0 до 4");
                }
            }
        }
    }
}



