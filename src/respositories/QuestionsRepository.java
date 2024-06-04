package respositories;

import models.Options;
import models.Questions;
import models.Roles;
import models.Users;

import java.util.HashMap;
import java.util.Map;

public class QuestionsRepository {
    Map<Integer, Questions> questionDB = new HashMap<>();

    //saving Question to DB
    int i=1;
    public void saveQuestionToDB(Questions questions) {
        questionDB.put(i, questions);
        i++;
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
