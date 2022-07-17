package com.sda.studysystem.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Course model
 *
 * @author Ott Pikk
 */
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double durationHours;

}
