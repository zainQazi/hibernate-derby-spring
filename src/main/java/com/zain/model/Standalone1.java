package com.zain.model;


/**
 * Created by qhasan on 5/20/2017.
 */

import javax.persistence.*;

@Table(name = "STANDALONE1")
@Entity
public class Standalone1 {


    private long id;
    private String name;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
