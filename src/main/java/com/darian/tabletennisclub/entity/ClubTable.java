package com.darian.tabletennisclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ClubTable")
public class ClubTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    public ClubTable() {}

    public Long getId() {
        return id;
    }
    public TableStatus getStatus() {
        return status;
    }
    public void setStatus(TableStatus status) {
        this.status = status;
    }
}
