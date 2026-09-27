package org.example;

import java.time.LocalDateTime;

public class Task {
    private final int id;                        // id задачи
    private final String title;                 // Название задачи
    private String description;                // Описание задачи
    private final LocalDateTime deadline;     // Дедлайн задачи
    private Priority priority;               // Приоритет
    private TaskStatus taskStatus;          // Статус
public Task( int id, String title, String description, LocalDateTime deadline, Priority priority, TaskStatus taskStatus){
    this.id=id;
    this.title=title;
    this.deadline=deadline;
    this.description=description;
    this.priority=priority;
    this.taskStatus=taskStatus;
}
    public int getId() {return id;}

    public String getTitle() {
        return  title;
    }

    public String getDescription() {
        return  description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Priority getPriority(){
    return priority;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
    public TaskStatus getTaskStatus(){
    return taskStatus;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }
}




