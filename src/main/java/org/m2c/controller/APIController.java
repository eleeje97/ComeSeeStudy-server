package org.m2c.controller;

import lombok.RequiredArgsConstructor;
import org.m2c.dto.MainPageResponse;
import org.m2c.entity.*;
import org.m2c.repo.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/css")
public class APIController {
    private final AttributeRepository attributeRepository;
    private final AttrContentRepository attrContentRepository;
    private final QuizRepository quizRepository;

    @GetMapping("/main")
    public MainPageResponse getMainPage(@RequestParam("attr") String attr_name) {
        AttributeEntity attributeEntity = attributeRepository.findByAttrName(attr_name);
        int total = (int) attributeRepository.count();

        int prev = attributeEntity.getAttrId() - 1;
        prev = prev == 0 ? total : prev ;

        int next = (attributeEntity.getAttrId() + 1)%total;
        next = next == 0 ? total : next;

        MainPageResponse response = new MainPageResponse(attributeEntity.getAttrName(),
                attributeEntity.getAttrMainTitle(),
                attributeRepository.findById(prev).get().getAttrName(),
                attributeRepository.findById(next).get().getAttrName());

        System.out.println("Requested URL: /css/main?attr=" + attr_name);

        return response;
    }

}
