package com.example.exercisemorning;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlID;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GeneratedType.AUTO)
    private long id;
    private String title;
    private long year;
    private String description;
    public Movie(){
        this.cast=new HashSet<Actor>();
    }
    @ManyToMany()
    private Set<Actor> cast;

    public void addActor(Actor a)
    {
        this.cast.add(a);
    }

}
