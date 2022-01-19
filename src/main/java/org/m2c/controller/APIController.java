package org.m2c.controller;

import lombok.RequiredArgsConstructor;
import org.m2c.entity.*;
import org.m2c.repo.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/css")
public class APIController {
    private final AttributeRepository attributeRepository;
    private final AttrContentRepository attrContentRepository;
    private final QuizRepository quizRepository;

    @GetMapping("/test")
    public List<AttributeEntity> findAllAttribute() {
        return attributeRepository.findAll();
    }

}
