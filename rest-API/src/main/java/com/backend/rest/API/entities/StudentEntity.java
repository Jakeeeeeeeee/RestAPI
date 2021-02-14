package com.backend.rest.API.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue
    @GenericGenerator(name =  "uuid2", strategy = "uuid2")
    @Type(type="uuid-binary")
    private UUID id;

    @Column(name ="first_name", unique = false, nullable = false)
    private String firstName;

    @Column(name = "password", unique = false, nullable = false)
    private  String password;
}
