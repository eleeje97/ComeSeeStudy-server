package org.m2c.repo;

import org.m2c.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {
    AttributeEntity findByAttrName(String attr_name);
}
