package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.exit;


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
    private static final String [] task = new String[100];
    private static final boolean [] taskStatus = new boolean[100];
    private static final Scanner console = new Scanner(System.in);
    private static final Set<String> COMMANDS = Set.of("1", "2", "3", "4", "0");
    private static int taskCount;
    public static void handleExit() {
        System.out.println("Выход");
        System.exit(0);
    }
    public static void handleNewTask(){
        System.out.println("Введите описание задачи:");
        task[taskCount] = console.nextLine();
        taskCount++;
        taskStatus[taskCount] = false;
        System.out.println("Задача добавлена!");
    }
    public static boolean isTaskListEmpty(){
        if (taskCount == 0){
            System.out.println("Список задач пуст");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println(menu);
            String input = console.nextLine();
            int command = Integer.parseInt(input);
            if (COMMANDS.contains(input)) {
                if (command == 0) {
                    handleExit();
                }
                else if (command == 1) {
                    if (taskCount >= 100) {
                        System.out.println("Список задач переполнен");
                        continue;
                    }
                    handleNewTask();
                }
                else if (command == 2) {
                    if (isTaskListEmpty())
                    {
                        continue;
                    }
                    System.out.println("Список задач:");
                    for (int i = 0; i < taskCount; i++) {
                        String status = taskStatus[i] ? "[X]" : "[ ]";
                        System.out.println(i + 1 + ". " + status + " " + task[i]);
                    }
                }
                else if (command == 3) {
                    if (isTaskListEmpty())
                    {
                        continue;
                    }
                    System.out.println("Введите номер задачи для удаления:");
                    String in = console.nextLine();
                    try {
                        int taskNumber = Integer.parseInt(in);
                        if (taskNumber < 1 || taskNumber > taskCount) {
                            System.out.println("Введите корректный номер задачи");
                            continue;
                        }
                        int index = taskNumber - 1;
                        String removedTask = task[index];
                        for (int i = index; i < taskCount - 1; i++) {
                            task[i] = task[i + 1];
                            taskStatus[i] = taskStatus[i + 1];

                        }
                        taskCount--;
                        System.out.println("Задача \"" + removedTask + "\" удалена ");

                    } catch (NumberFormatException e) {
                        System.out.println("Введите число, а не текст");
                    }
                }
                else if (command == 4) {
                    if (isTaskListEmpty())
                    {
                        continue;
                    }
                    System.out.println("Введите номер задачи для отметки:");
                    String mark = console.nextLine();
                    try {
                        int checkTask = Integer.parseInt(mark);
                        if (checkTask < 1 || checkTask > taskCount) {
                            System.out.println("Введите корректный номер задачи");
                            continue;
                        }
                        int index = checkTask - 1;
                        if (taskStatus[index]) {
                            System.out.println("Задача уже отмечена как выполненная");
                            continue;

                        }
                        taskStatus[index] = true;

                        System.out.println("Задача \"" + task[index] + "\" отмечена как выполненная!");

                    } catch (NumberFormatException e) {
                        System.out.println("Введите число, а не текст");
                    }


                } else {
                    System.out.println("Введите цифру от 0 до 4");

                }
            }

        }}}


