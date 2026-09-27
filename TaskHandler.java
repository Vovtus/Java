package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.*;

class TaskHandler {
    private String task;
    private boolean taskStatus;
    private int taskCount;

    public TaskHandler(String task, boolean taskStatus, int taskCount) {
        this.task = task;
        this.taskStatus = taskStatus;
        this.taskCount = taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public boolean isTaskStatus() {
        return taskStatus;
    }

    public int getTaskCount() {
        return taskCount;
    }

}
public class DataManager(){
    private final List<Task> tasks = new ArrayList<>();
    public DataManager() {
        for (int i = 0; i <100; i++) {
            tasks.add(new Task("Task_" + i, false));
        }
    }
    public void handleExit () {
        System.exit(0);
    }
    public void handleNewTask(String task, boolean taskStatus, int taskCount) {
        tasks.add(new Task(task, taskStatus));
        taskCount++;
        taskStatus[taskCount] = false;
    }
    public void removedTask (int index) {
        tasks.remove(index);
    }
    public void


}

