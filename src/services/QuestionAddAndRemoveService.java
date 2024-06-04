package services;
import models.Options;
import models.Questions;
import respositories.OptionsRepository;
import respositories.QuestionsRepository;

import java.util.List;

public class QuestionAddAndRemoveService {
    private QuestionsRepository questionsRepository;
    private OptionsRepository optionsRepository;

    public QuestionAddAndRemoveService(QuestionsRepository questionsRepository,
                                       OptionsRepository optionsRepository) {
        this.questionsRepository = questionsRepository;
        this.optionsRepository = optionsRepository;
    }

    public void addQuestionAndOptions(Questions questions) {
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

    public void removeQuestion(String question) {
        questionsRepository.removeQuestionFromDB(question);
    }
}
