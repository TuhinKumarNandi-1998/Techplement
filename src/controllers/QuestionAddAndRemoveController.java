package controllers;

import dtos.QuestionRequestDTO;
import exceptions.NotAuthorizedToAddQuestionException;
import exceptions.NotAuthorizedToRemoveQuestionException;
import exceptions.UserNotExistInDBException;
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
        String userName = questionRequestDTO.getUser();

        Questions questions = new Questions();
        questions.setQuestion(questionRequestDTO.getQuestions());

        List<Options> options = new ArrayList<>();
        for(String option : questionRequestDTO.getOptions()) {
            Options options1 = new Options();
            options1.setOption(option);
            options.add(options1);
        }
        questions.setOptions(options);

        Options correctOption = new Options();
        correctOption.setOption(questionRequestDTO.getCorrectAnswer());
        questions.setCorrectAnswer(correctOption);

        try {
            questionAddAndRemoveService.addQuestionAndOptions(questions, userName);
        }
        catch (UserNotExistInDBException exception1) {
            System.out.println("*** User with name "+userName+" not present in DB. Question cannot be added. ***");
        }
        catch (NotAuthorizedToAddQuestionException exception2) {
            System.out.println("*** User with name "+userName+" does not have necessary authorization to add question. Question cannot be added. ***");
        }
    }

    public void removeQuestion(QuestionRequestDTO questionRequestDTO) throws NotAuthorizedToRemoveQuestionException {
        questionAddAndRemoveService.removeQuestion(questionRequestDTO.getQuestions(), questionRequestDTO.getUser());
    }
}
