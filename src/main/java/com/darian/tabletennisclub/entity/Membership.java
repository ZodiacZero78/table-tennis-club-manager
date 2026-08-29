package com.darian.tabletennisclub.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Membership")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private MembershipStatus status;

    private LocalDateTime dateJoined;
    private LocalDateTime dateEnded;

    public Membership() {}

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public MembershipStatus getStatus() {
        return status;
    }
    public void setStatus(MembershipStatus status) {
        this.status = status;
    }
    public LocalDateTime getDateJoined() {
        return dateJoined;
    }
    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }
    public LocalDateTime getDateEnded() {
        return dateEnded;
    }
    public void setDateEnded(LocalDateTime dateEnded) {
        this.dateEnded = dateEnded;
    }
}
