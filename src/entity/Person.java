package entity;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    public Person() {
    }


    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }



}
