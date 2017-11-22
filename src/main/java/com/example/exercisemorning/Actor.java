package com.example.exercisemorning;
import javax.annotation.Generated;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlID;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Actor {
    @XmlID
    @GeneratedValue(strategy=GeneratedType.AUTO)
    private long id;
    private String name;
    private String realname;
    private String headshot;

     @ManyToMany(mappedBy="cash")
    private Set<Movie> movies;
     public Actor()
     {
         //instansate the class
         movies=new HashSet<Movies>();
     }
     public void addMovie(Movie m)
     {
         //method to add one movie to set of movies
       movies.add(m);
     }
}
