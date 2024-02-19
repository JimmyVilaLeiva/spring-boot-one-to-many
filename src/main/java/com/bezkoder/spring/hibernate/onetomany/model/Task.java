package com.bezkoder.spring.hibernate.onetomany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="task_id")
    private long taskId;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="task_name", nullable=false, length=50)
    private String taskName;

    @Column(name="task_content", nullable=false)
    private String taskContent;

    @Column(name="priority", nullable=false)
    private Integer priority;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @JsonIgnore // Prevent JSON infinite recursion
    public User getUser() {
        return user;
    }

    // The default constructor only exists for the sake of JPA.
    // You won’t use it directly, so it is designated as protected.
    protected Task() {}

}
