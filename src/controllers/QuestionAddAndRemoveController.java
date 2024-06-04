package controllers;

import dtos.QuestionRequestDTO;
import models.Options;
import models.Questions;
import services.QuestionAddAndRemoveService;

import java.util.ArrayList;
import java.util.List;

public class QuestionAddAndRemoveController {
    private QuestionAddAndRemoveService questionAddAndRemoveService;

    public QuestionAddAndRemoveController(QuestionAddAndRemoveService questionAddAndRemoveService) {
        this.questionAddAndRemoveService = questionAddAndRemoveService;
    }

    public void addQuestionAndOptions(QuestionRequestDTO questionRequestDTO) {
        Questions questions = new Questions();
        questions.setQuestion(questionRequestDTO.getQuestions());

        List<Options> options = new ArrayList<>();
        for(String option : questionRequestDTO.getOptions()) {
            Options options1 = new Options();
            options1.setOption(option);
            options.add(options1);
        }
        questions.setOptions(options);


    }

    public void removeQuestion(QuestionRequestDTO questionRequestDTO) {
        questionAddAndRemoveService.removeQuestion(questionRequestDTO.getQuestions());
    }
}
