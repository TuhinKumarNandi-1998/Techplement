package controllers;

import services.QuizPlayService;

public class QuizPlayController {
    private QuizPlayService quizPlayService;

    public QuizPlayController(QuizPlayService quizPlayService) {
        this.quizPlayService = quizPlayService;
    }

    public void startQuiz() throws InterruptedException {
        System.out.println("Starting Quiz . . . .");
        quizPlayService.startQuiz();
    }
}
