package eci.edu.ieti.data;

import java.util.Date;

public class TaskDto {
    private enum StatusType
    {
        TODO, DOING, REVIEW, DONE
    };
    private String name;
    private String description;
    private StatusType status;
    private String assignedTo;
    private Date dueDate;
    private Date created;

    public TaskDto(String name, String description,StatusType status, String assignedTo, Date dueDate, Date created) {
        this.name = name;
        this.description = description;
        this.status=status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
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
