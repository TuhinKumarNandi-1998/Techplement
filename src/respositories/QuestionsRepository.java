package respositories;

import models.Options;
import models.Questions;
import models.Roles;
import models.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsRepository {
    Map<Integer, Questions> questionDB = new HashMap<>();

    //saving Question to DB
    int i=1;
    public void saveQuestionToDB(Questions questions) {
        questions.setId(i*1L);
        List<Options> options = new ArrayList<>();
        int j=0;
        for (Options option : questions.getOptions()) {
            option.setSequences((char) (97+j));
            options.add(option);
            j++;
        }
        questions.setOptions(options);
        questionDB.put(i, questions);
        i++;
    }

    //getting question 1 by 1
    public Questions getQuestion1By1(int question_no) {
        return questionDB.get(question_no);
    }

    //getting Question from DB
    public Questions getQuestionFromDBUsingQuestion(String question) {
        for (Map.Entry<Integer, Questions> entry : questionDB.entrySet()) {
            int key = entry.getKey();
            Questions questions = entry.getValue();

            if(questions.getQuestion().equals(question)) {
                return questions;
            }
        }
        return null;
    }

    //Removing Question from DB
    public void removeQuestionFromDB(String question) {
        for (Map.Entry<Integer, Questions> entry : questionDB.entrySet()) {
            int key = entry.getKey();
            Questions questions = entry.getValue();

            if(questions.getQuestion().equals(question)) {
                //I have to remove it
                questionDB.remove(key);
            }
        }
    }
}
