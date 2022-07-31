package com.sda.studysystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

/**
 * School model
 *
 * @author Ott Pikk
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class School extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String city;
    private String phone;
    private boolean isActive;

}
