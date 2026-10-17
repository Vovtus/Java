package org.example;

import java.util.List;

public final class TaskPrinter {
    private TaskPrinter() {
        throw new UnsupportedOperationException();

    }

    public static void printMenu() {
        System.out.println("""
                        ____________________________________
                        >>> Меню:
                        1. Добавить задачу
                        2. Показать все задачи
                        3. Удалить задачу (по номеру)
                        4. Изменить статус задачи
                        0. Выход
                
                        Выберите пункт меню:
                        _____________________________________
                """);
    }

    public static void isTaskListEmpty() {
        System.out.println("Список задач пуст");
    }

    public static void printTask(List<Task> tasks) {
        int index = 1;
        for (Task task : tasks) {
            String status = task.getTaskStatus() == TaskStatus.COMPLETED ? "[X]" : "[ ]";
            System.out.printf("%d. %s | ID: %s | Задача: %s |Описание задачи: %s |Дэдлайн: %s | Приоритеть: %s | Статус: %s%n",
                    index++,
                    status,
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getDeadline(),
                    task.getPriority(),
                    task.getTaskStatus());
        }
    }

    public static void handleExit() {
        System.out.println("Выход");
    }
    public static void titleOfTask(){
        System.out.println("Введите название задачи: ");
    }
    public static void descriptionOfTask () {
        System.out.println("Введите описание задачи: ");
    }
    public static void deadLine () {
        System.out.println("Укажите через сколько дней дэдлайн");
    }
    public static void priority () {
        System.out.println("""
                                            Укажите приоритет задачи:
                                            1. LOW - низкий
                                            2. MEDIUM - средний
                                            3. HIGH - высокий
                                    """);
    }
    public static void correctPoint (){
        System.out.println("Выберите корректный пункт меню");
    }
    public  static void taskAdded () {
        System.out.println("Задача добавлена");
    }
    public static void notText() {
        System.out.println("Введите число, а не текст");
    }
    public static void setNum () {
        System.out.println("Введите номер задачи: ");
    }
    public static void  delTask (){
        System.out.println("Задача удалена");
    }
    public static void noTask () {
        System.out.println("Задача с таким номером отсутствует");
    }
    public static void status () {
        System.out.println("""
                                        Выберите статус:
                                        1. PENDING - Задача не начата
                                        2. IN_PROGRESS - Задача в процессе
                                        3. COMPLETED - Задача выполнена
                                        """);
    }
    public static void setStatus (){
        System.out.println("Статус задачи изменён");
    }


}
