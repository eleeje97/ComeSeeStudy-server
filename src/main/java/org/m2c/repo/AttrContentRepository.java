package org.m2c.repo;

import org.m2c.entity.AttrContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttrContentRepository extends JpaRepository<AttrContentEntity, Integer> {
    int countAllByAttrId(int attrId);
}
