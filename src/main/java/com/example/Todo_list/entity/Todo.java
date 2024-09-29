package com.example.Todo_list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private String task;
    private boolean completed;
    private Date dueDate;

    public Todo() {}

    public Todo(long Id, String task, boolean completed, Date dueDate){
        this.Id=Id;
        this.task=task;
        this.completed=completed;
        this.dueDate=dueDate;

    }
    public long getId(){
        return Id;
    }
    public void setId(long Id){
        this.Id=Id;
    }
    public String getTask(){
        return task;
    }
    public void setTask(String task){
        this.task=task;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;


    }

    public Date getDueDate() {
        return dueDate;
    }


    public void setDueDate(Date dueDate){
       this.dueDate=dueDate;
    }


}
