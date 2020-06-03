
package com.khoubyari.example.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "city")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @Id
    @GeneratedValue()
    private long id;

    //findCityByName
    @Column(nullable = false)
    private String name;

    //findyCityByDescription
    @Column
    private String description;

    //findyCityByLength
    @Column
    private Long length;


    public City() {
    }

    public  City(String name, String description, Long length){

        this.name = name;
        this.description = description;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", length=" + length +
                '}';
    }

}
