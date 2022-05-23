package com.antsiferov.webplayerqueue.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "queue_table")
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User customer;

    @Column
    private String url;

    @Column
    private String description;

    public Queue(User customer, String url, String description) {
        this.description = description;
        this.customer = customer;
        this.url = url;
    }

    public Queue() {

    }
}
