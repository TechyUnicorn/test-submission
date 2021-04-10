package org.codejudge.sb.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "QuizQuestions")
@Data
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Integer id;

    @Column
    String name;

    @Column
    String options;

    @Column
    String correct_option;

    @Column
    String quiz;

    @Column
    String points;
}

