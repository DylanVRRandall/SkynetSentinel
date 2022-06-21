package com.google.randalldylan101.sentinel.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Survivor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name,identification;

    @Column
    private int age;

    @Column
    private float lat,lon;

    @OneToMany
    private List<SurvivorResource> survivorResources;
    
}