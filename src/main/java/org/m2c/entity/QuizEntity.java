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
    @JoinColumn(name = "content_id")
    private int contentId;

    @Column(name = "quiz_value")
    private String quizValue;

    @Column(name = "quiz_answer_code")
    private String quizAnswerCode;

    @Column(name = "quiz_setting")
    private String quizSetting;

    @Column(name = "quiz_num")
    private int quizNum;

    @Column(name = "quiz_element_names")
    private String quizElementNames;
}
