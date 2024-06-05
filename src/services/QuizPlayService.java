package services;

import models.Options;
import models.Questions;
import models.Scores;
import respositories.OptionsRepository;
import respositories.QuestionsRepository;

import java.util.List;
import java.util.Scanner;

public class QuizPlayService {
    private QuestionsRepository questionsRepository;
    private OptionsRepository optionsRepository;
    private Scanner scanner;
    private Scores scores;

    public QuizPlayService(QuestionsRepository questionsRepository,
                           OptionsRepository optionsRepository) {
        this.questionsRepository = questionsRepository;
        this.optionsRepository = optionsRepository;
        this.scanner = new Scanner(System.in);
        this.scores = new Scores();
    }

    public void startQuiz() throws InterruptedException {
        int i = 1;
        while(questionsRepository.getQuestion1By1(i) != null) {
            Questions questions = questionsRepository.getQuestion1By1(i);
            scores.increaseTotalScore(2);

            System.out.println(questions.getId()+". "+questions.getQuestion());

            List<Options> options = questions.getOptions();
            for (Options option: options) {
                System.out.println(option.getSequences()+". "+option.getOption());
            }
            //startTimer();

            char userGivenAnswer = scanner.next().charAt(0);
            //user need to give answer
            if(checkIfCorrect(questions, userGivenAnswer)) {
                //increase the score by +2
                scores.increaseScore(2);
                i++;
                System.out.println();
                continue;
            }
            else if(!checkIfCorrect(questions, userGivenAnswer)) {
                System.out.println("Wrong Answer!!");
                i++;
                System.out.println();
                continue;
            }

            System.out.println();
            i++;
        }

        System.out.println("Your Total Score is : "+scores.getScore()+" out of "+scores.getTotalScore()+".");
    }

    public boolean checkIfCorrect(Questions questions, char userGivenAnswer) {

        //need to compare it with the correct option
        char userGivenOption = Character.toLowerCase(userGivenAnswer);
        List<Options> optionsList = questions.getOptions();

        for (Options option : optionsList) {
            String currOption = option.getOptionFromSeq(userGivenOption);
            if (currOption.equals(questions.getCorrectAnswer().getOption())) {
                System.out.println(currOption+" is correct answer!!.");
                return true;
            }
        }
        return false;
    }

    public void startTimer() throws InterruptedException {
        int seconds = 10;  // Set the countdown time in seconds

        for (int i = seconds; i >= 0; i--) {
            System.out.print("\rTime remaining: " + i + " seconds");
            Thread.sleep(1000);  // Sleep for 1 second
        }
    }
}
