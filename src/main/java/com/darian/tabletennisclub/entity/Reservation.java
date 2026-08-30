package com.darian.tabletennisclub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private ClubTable table;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime dateCreated;

    public Reservation() {}

    public Long getId() {
        return id;
    }
    public ClubTable getTable() {
        return table;
    }
    public void setTable(ClubTable table) {
        this.table = table;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
