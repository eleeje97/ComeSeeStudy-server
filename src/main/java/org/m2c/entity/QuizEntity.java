package org.m2c.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "QUIZ_TB")
public class QuizEntity {
    @Id
    @JoinColumn
    private int content_id;

    @Column
    private String quiz_question;

    @Column
    private String quiz_answer_code;

    @Column
    private String quiz_setting;

    @Column
    private int quiz_num;
}
