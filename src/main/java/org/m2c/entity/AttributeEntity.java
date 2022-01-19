package org.m2c.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ATTRIBUTE_TB")
public class AttributeEntity {
    @Id
    @Column(name = "attr_id")
    private int attrId;

    @Column(name = "attr_name")
    private String attrName;

    @Column(name = "attr_main_title")
    private String attrMainTitle;
    
}
