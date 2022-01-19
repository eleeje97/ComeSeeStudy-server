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
    @Column(name = "content_id")
    private int contentId;

    @JoinColumn(name = "attr_id")
    private int attrId;

    @Column(name = "page_no")
    private int pageNo;

    @Column(name = "content_title")
    private String contentTitle;

    @Column(name = "content_desc")
    private String contentDesc;
}
