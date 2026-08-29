package com.darian.tabletennisclub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MembershipApplication")
public class MembershipApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private String reason;
    private LocalDateTime dateCreated;
    private LocalDateTime dateReviewed;

    public MembershipApplication() {}

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    public LocalDateTime getDateReviewed() {
        return dateReviewed;
    }
    public void setDateReviewed(LocalDateTime dateReviewed) {
        this.dateReviewed = dateReviewed;
    }
}
