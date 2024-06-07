package controllers;

import services.QuizPlayService;

import java.util.concurrent.ExecutionException;

public class QuizPlayController {
    private QuizPlayService quizPlayService;

    public QuizPlayController(QuizPlayService quizPlayService) {
        this.quizPlayService = quizPlayService;
    }

    public void startQuiz() throws InterruptedException, ExecutionException {
        System.out.println("Starting Quiz . . . .");
        quizPlayService.startQuiz();
    }
}
