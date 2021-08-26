package eci.edu.ieti.dto;

import java.util.Date;
import java.util.UUID;

public class Task {

    private enum StatusType
    {
        TODO, DOING, REVIEW, DONE
    };
    private String id;
    private String name;
    private String description;
    private StatusType status;
    private String assignedTo;
    private Date dueDate;
    private Date created;

    public Task(String name, String description, StatusType status, String assignedTo, Date dueDate, Date created) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.status=status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusType getStatus() {
        return status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
