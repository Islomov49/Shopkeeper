package com.shoperk.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DEV on 18.07.2016.
 */
@Entity
@Table(name = "shopkeeper")
public class Shopkeeper {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private long id;

    @Column(name = "name_person", nullable = false, length = 300)
    private String Name;

    @Column(name = "create_ID",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_ID;

    public Shopkeeper() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getCreate_ID() {
        return create_ID;
    }

    public void setCreate_ID(Date create_ID) {
        this.create_ID = create_ID;
    }
}
