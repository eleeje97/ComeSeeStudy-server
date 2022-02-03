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
        HashMap<String, String> answerCodes = getAnswerCodes(quizEntity, requiredElements);

        LearningPageResponse response = new LearningPageResponse(attr_name,
                attrContentEntity.getPageNo(),
                attrContentRepository.countAllByAttrId(attrId),
                attrContentEntity.getContentTitle(),
                attrContentEntity.getContentDesc(),
                quizEntity.getQuizValue(),
                requiredElements,
                quizEntity.getQuizNum(),
                settingCodes,
                answerCodes);

        System.out.println("Requested URL: /css/learning?attr=" + attr_name + "&pageNo=" + pageNo + " contentId: " + contentId);

        return response;
    }


    @PostMapping("/check")
    public AnswerCheckResponse checkAnswers(@RequestBody AnswerCheckRequest request) {
        int attrId = attributeRepository.findByAttrName(request.getAttrName()).getAttrId();
        int contentId = (attrId * 100) + request.getPageNo();
        AttrContentEntity attrContentEntity = attrContentRepository.findById(contentId).get();
        QuizEntity quizEntity = quizRepository.findById(contentId).get();
        HashMap<String, String> requiredElements = getRequiredElements(attrContentEntity);
        HashMap<String, String> answerCodes = getAnswerCodes(quizEntity, requiredElements);
        HashMap<String, String> userAnswers = request.getAnswers();
        HashMap<String, Boolean> answerCheck = new HashMap<>();

        for (String key : answerCodes.keySet()) {
            if (userAnswers.get(key).replaceAll("\\s", "").equals(answerCodes.get(key).replaceAll("\\s", ""))) {
                answerCheck.put(key, true);
            } else {
                answerCheck.put(key, false);
            }
        }


        AnswerCheckResponse response = new AnswerCheckResponse(request.getAttrName(),
                attrContentEntity.getPageNo(),
                quizEntity.getQuizNum(),
                userAnswers,
                answerCodes,
                answerCheck);

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
        String[] quizSettingArray;
        String str = "";

        while (quizSettingStrData.contains("%ETC%")) {
            String temp = quizSettingStrData.substring(0, quizSettingStrData.indexOf("%ETC%"));
            str += temp + "\n";
            quizSettingStrData = quizSettingStrData.substring(temp.length() + 5);
        }

        if (quizSettingStrData.length() > 0) {
            quizSettingArray = quizSettingStrData.split("&&&");
        } else {
            quizSettingArray = new String[0];
        }


        for (int i = 0; i < quizNum; i++) {
            if (i != 0) {
                str = "}\n";
            }
            str += "#" + quizElementNamesArray[i] + " {";
            if (quizSettingArray.length > i) {
                String[] codeArray = quizSettingArray[i].split("\n");
                for (String s: codeArray) {
                    str += "\n\t" + s;
                }
            }
            settingCodes.add(str);
        }
        settingCodes.add("}");

//        for (String cmd:settingCodes) {
//            System.out.println(cmd);
//        }

        return settingCodes;
    }


    public HashMap<String, String> getAnswerCodes(QuizEntity quizEntity, HashMap<String, String> requiredElements) {
        HashMap<String, String> answerCodes = new HashMap<>();
        String quizAnswerCodesStrData = quizEntity.getQuizAnswerCode();
        String[] quizAnswerCodesArray = quizAnswerCodesStrData.split("&&&");

        for (String key : requiredElements.keySet()) {
            if (!key.equals("bg")) {
                answerCodes.put(key,quizAnswerCodesArray[answerCodes.size()]);
            }
        }

        return answerCodes;
    }

}
