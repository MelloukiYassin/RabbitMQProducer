package org.rabbitmq.training1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SCHOLAR" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scholar implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idScholar;

    private String name;

    private String firstname;

    private int age;


}
