package services;
import exceptions.NotAuthorizedToAddQuestionException;
import exceptions.NotAuthorizedToRemoveQuestionException;
import models.*;
import respositories.OptionsRepository;
import respositories.QuestionsRepository;
import respositories.UserRepository;

import java.util.List;

public class QuestionAddAndRemoveService {
    private QuestionsRepository questionsRepository;
    private OptionsRepository optionsRepository;
    private UserRepository userRepository;

    public QuestionAddAndRemoveService(QuestionsRepository questionsRepository,
                                       OptionsRepository optionsRepository,
                                       UserRepository userRepository) {
        this.questionsRepository = questionsRepository;
        this.optionsRepository = optionsRepository;
        this.userRepository = userRepository;
    }

    public void addQuestionAndOptions(Questions questions, String userName) throws NotAuthorizedToAddQuestionException {
        Users users = userRepository.getUserFromDBUsingUserName(userName);

        boolean canAdd = false;

        for(Roles roles : users.getRoles()) {
            if(roles.getRoleName().equals("ADMIN")) {
                canAdd = true;
            }
        }

        if(!canAdd) {
            //the current user cannot add question
            throw new NotAuthorizedToAddQuestionException(userName+" is not authorized to add question.");
        }
        if(questionsRepository.getQuestionFromDBUsingQuestion(questions.getQuestion()) != null) {
            //Question is already present in DB
        }
        else {
            List<Options> options = questions.getOptions();
            for (Options option : options) {
                if(optionsRepository.getOptionFromDBUsingOption(option.getOption()) != null) {
                    //Option is already present in DB
                }
                else {
                    optionsRepository.saveOptionToDB(option);
                }
            }
            questionsRepository.saveQuestionToDB(questions);
        }
    }

    public void removeQuestion(String question, String userName) throws NotAuthorizedToRemoveQuestionException {
        Users users = userRepository.getUserFromDBUsingUserName(userName);

        boolean canRemove = false;

        for(Roles roles : users.getRoles()) {
            if(roles.getRoleName().equals("ADMIN")) {
                canRemove = true;
            }
        }

        if(!canRemove) {
            //the current user cannot add question
            throw new NotAuthorizedToRemoveQuestionException(userName+" is not authorized to remove question.");
        }

        questionsRepository.removeQuestionFromDB(question);
    }
}
