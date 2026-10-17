package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class TaskHandler {
    private int nextId = 1;


    private List<Task> tasks;

    public TaskHandler() {
        this.tasks = new ArrayList<>();
    }


    public void handleNewTask(Task task) {// Добавляем задачу если 1
        task.setId(nextId);
        nextId++;
        tasks.add(task);
    }

    public List<Task> getTasks() {// возвращаем список задач, если 2
        return List.copyOf(tasks);

    }

    public int getSize() {         // получаем колличество задач в списке.
        int listSize = tasks.size();
        return listSize;
    }

    public Task findTaskById(int id) {// Ищем нужную задачу по id
        int listSize = tasks.size();
        for (int i = 0; i < listSize; i++) {
            Task t = tasks.get(i);
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public boolean deleteTask(int id) {// Удаляем задачу по id если 3
        return tasks.removeIf(task -> task.getId() == id);
    }

    boolean changeStatus(int id, TaskStatus newStatus) { // Помечаем задачу как выполненную если 4
        Task found = findTaskById(id);
        if (found == null) {
            return false;
        }
        found.setTaskStatus(newStatus);
        return true;

    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}



