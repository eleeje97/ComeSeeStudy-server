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
    private int attr_id;

    @Column
    private String attr_name;

    @Column
    private String attr_main_title;
    
}
