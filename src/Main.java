import controllers.QuestionAddAndRemoveController;
import controllers.QuizPlayController;
import controllers.UserController;
import dtos.QuestionRequestDTO;
import dtos.UserRequestDTO;
import exceptions.NotAuthorizedToAddQuestionException;
import respositories.OptionsRepository;
import respositories.QuestionsRepository;
import respositories.RolesRepository;
import respositories.UserRepository;
import services.QuestionAddAndRemoveService;
import services.QuizPlayService;
import services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NotAuthorizedToAddQuestionException, InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);

        //Instantiating The classes related to UserService
        UserRepository userRepository = new UserRepository();
        RolesRepository rolesRepository = new RolesRepository();

        UserService userService = new UserService(userRepository, rolesRepository);
        UserController userController = new UserController(userService);


        //Signing up users
        //user 1 ->
        UserRequestDTO userRequestDTO1 = new UserRequestDTO();
        userRequestDTO1.setName("Tuhin");
        String role1 = "ADMIN";
        String role2 = "NORMAL_USER";
        List<String> rolesList = new ArrayList<>();
        rolesList.add(role1);
        rolesList.add(role2);
        userRequestDTO1.setRoles(rolesList);
        userController.signUp(userRequestDTO1);


        //user 2 ->
        UserRequestDTO userRequestDTO2 = new UserRequestDTO();
        userRequestDTO2.setName("Mriganka");
//        String role11 = "ADMIN";
        String role22 = "NORMAL_USER";
        List<String> rolesList1 = new ArrayList<>();
//        rolesList1.add(role11);
        rolesList1.add(role22);
        userRequestDTO2.setRoles(rolesList1);
        userController.signUp(userRequestDTO2);



        //Instantiating The classes related to QuestionService
        QuestionsRepository questionsRepository = new QuestionsRepository();
        OptionsRepository optionsRepository = new OptionsRepository();

        QuestionAddAndRemoveService questionAddAndRemoveService = new QuestionAddAndRemoveService(questionsRepository, optionsRepository, userRepository);
        QuestionAddAndRemoveController questionAddAndRemoveController = new QuestionAddAndRemoveController(questionAddAndRemoveService);

        //adding system default Questions and options to each questions

        //Question - 1:
        QuestionRequestDTO questionRequestDTO1 = new QuestionRequestDTO();
        questionRequestDTO1.setUser("Tuhin");
        questionRequestDTO1.setQuestions("What is the capital of France?");
        List<String> optionsList1 = new ArrayList<>();
        optionsList1.add("Berlin");
        optionsList1.add("Madrid");
        optionsList1.add("Paris");
        optionsList1.add("Rome");
        questionRequestDTO1.setOptions(optionsList1);
        questionRequestDTO1.setCorrectAnswer("Paris");
        questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO1);

        //Question - 2:
        QuestionRequestDTO questionRequestDTO2 = new QuestionRequestDTO();
        questionRequestDTO2.setUser("Tuhin");
        questionRequestDTO2.setQuestions("Which element has the chemical symbol 'O'?");
        List<String> optionsList2 = new ArrayList<>();
        optionsList2.add("Gold");
        optionsList2.add("Oxygen");
        optionsList2.add("Osmium");
        optionsList2.add("Oganesson");
        questionRequestDTO2.setOptions(optionsList2);
        questionRequestDTO2.setCorrectAnswer("Oxygen");
        questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO2);

        //Question - 3:
        QuestionRequestDTO questionRequestDTO3 = new QuestionRequestDTO();
        questionRequestDTO3.setUser("Tuhin");
        questionRequestDTO3.setQuestions("What is the largest planet in our Solar System?");
        List<String> optionsList3 = new ArrayList<>();
        optionsList3.add("Earth");
        optionsList3.add("Mars");
        optionsList3.add("Jupiter");
        optionsList3.add("Saturn");
        questionRequestDTO3.setOptions(optionsList3);
        questionRequestDTO3.setCorrectAnswer("Jupiter");
        questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO3);

        //Question - 4:
        QuestionRequestDTO questionRequestDTO4 = new QuestionRequestDTO();
        questionRequestDTO4.setUser("Tuhin");
        questionRequestDTO4.setQuestions("In what year did the Titanic sink?");
        List<String> optionsList4 = new ArrayList<>();
        optionsList4.add("1905");
        optionsList4.add("1912");
        optionsList4.add("1918");
        optionsList4.add("1923");
        questionRequestDTO4.setOptions(optionsList4);
        questionRequestDTO4.setCorrectAnswer("1912");
        questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO4);

        //Question - 5:
        QuestionRequestDTO questionRequestDTO5 = new QuestionRequestDTO();
        questionRequestDTO5.setUser("Tuhin");
        questionRequestDTO5.setQuestions("What is the powerhouse of the cell?");
        List<String> optionsList5 = new ArrayList<>();
        optionsList5.add("Nucleus");
        optionsList5.add("Ribosome");
        optionsList5.add("Mitochondrion");
        optionsList5.add("Chloroplast");
        questionRequestDTO5.setOptions(optionsList5);
        questionRequestDTO5.setCorrectAnswer("Mitochondrion");
        questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO5);

        QuizPlayService quizPlayService = new QuizPlayService(questionsRepository, optionsRepository);
        QuizPlayController quizPlayController = new QuizPlayController(quizPlayService);

        System.out.println("*READ THE INSTRUCTIONS CAREFULLY*");
        System.out.println("*ONLY ADMIN USERS CAN ADD QUESTIONS*");
        System.out.println("Do you want to (add question / play quiz) ?");
        String usersChoice = sc.nextLine();
        String playQuiz = "NO";

        //allowing user to add question
        while (!usersChoice.equalsIgnoreCase("play quiz")) {
            System.out.println("Enter your user : ");
            String userName = sc.next();
            sc.nextLine(); //consuming the newLine

            System.out.println("Enter the Question : ");
            String question = sc.nextLine();

            System.out.println("Enter options (single comma separated) : ");
            String userEnteredOptions = sc.nextLine();
            List<String> optionsList = Arrays.stream(userEnteredOptions.split(","))
                    .toList();

            System.out.println("Enter the correct option : ");
            String correctOption = sc.nextLine();

            QuestionRequestDTO questionRequestDTO = new QuestionRequestDTO();
            questionRequestDTO.setUser(userName);
            questionRequestDTO.setQuestions(question);
            questionRequestDTO.setOptions(optionsList);
            questionRequestDTO.setCorrectAnswer(correctOption);
            questionAddAndRemoveController.addQuestionAndOptions(questionRequestDTO);

//            sc.nextLine();

            System.out.println("Do you want to enter more question? (YES/NO)");
            String addingQuestion = sc.next();

            if (addingQuestion.equalsIgnoreCase("NO")) {
                System.out.println("Do you want to play quiz now? (YES/NO)");
                playQuiz = sc.next();
                break;
            }
        }

        if(usersChoice.equalsIgnoreCase("play quiz") || playQuiz.equalsIgnoreCase("YES")) {
            quizPlayController.startQuiz();
        }
    }
}