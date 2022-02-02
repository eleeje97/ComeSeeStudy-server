package org.m2c.controller;

import lombok.RequiredArgsConstructor;
import org.m2c.dto.*;
import org.m2c.entity.*;
import org.m2c.repo.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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

        int next = attributeEntity.getAttrId() + 1;
        next = next > total ? 1 : next;

        MainPageResponse response = new MainPageResponse(attributeEntity.getAttrName(),
                attributeEntity.getAttrMainTitle(),
                attributeRepository.findById(prev).get().getAttrName(),
                attributeRepository.findById(next).get().getAttrName());

        System.out.println("Requested URL: /css/main?attr=" + attr_name);

        return response;
    }

    @GetMapping("/learning")
    public LearningPageResponse getLearningPage(@RequestParam("attr") String attr_name, @RequestParam("pageNo") int pageNo) {
        int attrId = attributeRepository.findByAttrName(attr_name).getAttrId();
        int contentId = (attrId * 100) + pageNo;
        AttrContentEntity attrContentEntity = attrContentRepository.findById(contentId).get();
        QuizEntity quizEntity = quizRepository.findById(contentId).get();


        HashMap<String, String> requiredElements = getRequiredElements(attrContentEntity);
        List<String> settingCodes = getSettingCodes(quizEntity);

        LearningPageResponse response = new LearningPageResponse(attr_name,
                attrContentEntity.getPageNo(),
                attrContentRepository.countAllByAttrId(attrId),
                attrContentEntity.getContentTitle(),
                attrContentEntity.getContentDesc(),
                quizEntity.getQuizValue(),
                requiredElements,
                quizEntity.getQuizNum(),
                settingCodes);

        System.out.println("Requested URL: /css/learning?attr=" + attr_name + "&pageNo=" + pageNo + " contentId: " + contentId);

        return response;
    }


    public HashMap<String, String> getRequiredElements(AttrContentEntity attrContentEntity) {
        HashMap<String, String> requiredElements = new HashMap<>();
        String requiredElementsStrData = attrContentEntity.getRequiredElements();
        String[] requiredElementsArray = requiredElementsStrData.split(",");

        for (String str:requiredElementsArray) {
            requiredElements.put(str.substring(str.length()-2), str);
        }

        return requiredElements;
    }


    public List<String> getSettingCodes(QuizEntity quizEntity) {
        List<String> settingCodes = new ArrayList<>();
        int quizNum = quizEntity.getQuizNum();
        String quizElementNamesStrData = quizEntity.getQuizElementNames();
        String[] quizElementNamesArray = quizElementNamesStrData.split(",");
        String quizSettingStrData = quizEntity.getQuizSetting();
        String[] quizSettingArray = quizSettingStrData.split("&&&");

        for (int i = 0; i < quizNum; i++) {
            String str;
            if (i != 0) {
                str = "}\n";
            } else {
                str = "";
            }
            str += "#" + quizElementNamesArray[i] + " {\n\t" + quizSettingArray[i];
            System.out.println(str);
            System.out.println("########### input창 ##########");
            settingCodes.add(str);
        }
        System.out.println("}");
        settingCodes.add("}");
        
        
        return settingCodes;
    }

}
