package com.iaschowrai.spring_batch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id")
    private String organizationId;

    private String name;
    private String website;
    private String country;

    @Column(name = "number_of_employees")
    private String description;


}
