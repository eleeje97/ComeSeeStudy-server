package org.m2c.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ATTR_CONTENT_TB")
public class AttrContentEntity {
    @Id
    private int content_id;

    @JoinColumn
    private int attr_id;

    @Column
    private int page_no;

    @Column
    private String content_title;

    @Column
    private String content_desc;
}
