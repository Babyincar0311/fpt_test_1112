package org.t2404e.test1112.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees") // Tên bảng trong DB
@Data // Lombok: Tự sinh getter, setter, toString...
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự tăng ID
    private Long id;

    private String name;
    private Double salary;
}