package com.sda.studysystem.models;

import com.sda.studysystem.utils.constraints.ValidSchool;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * School model
 *
 * @author Ott Pikk
 */
@Entity
@ValidSchool
@Data
@EqualsAndHashCode(callSuper = true)
public class School extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank(message = "{messages.constraints.blank-school-name}")
    private String name;

    private String city;
    private String phone;
    private boolean isActive;

}
