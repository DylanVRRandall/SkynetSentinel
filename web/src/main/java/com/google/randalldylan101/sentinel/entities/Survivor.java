package com.google.randalldylan101.sentinel.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQueries({@NamedQuery(name = "survivorGetByName",query = "select s from Survivor s where s.name = ?1"),
        @NamedQuery(name = "survivorGetInfected",query = "select s from Survivor s where s.infected = ?1"),
        @NamedQuery(name = "survivorGetInfectedCount",query = "select count(s.id) from Survivor s where s.infected = ?1"),
        @NamedQuery(name = "survivorGetAllCount",query = "select count(s.id) from Survivor s")})
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

    @Column
    private boolean infected;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SurvivorResource> survivorResources;
    
}