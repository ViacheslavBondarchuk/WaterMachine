package com.org.house.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Master {
    @Id
    private long user_id;

    @Column(name = "company_id")
    private long companyId;

    private String firstName;
    private String lastName;
}
