package com.google.randalldylan101.sentinel.beans;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
@Getter
@Setter
public class Survivor 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String name,identification;

    @Column
    private int age;

    @Column
    private float lat,lon;
}