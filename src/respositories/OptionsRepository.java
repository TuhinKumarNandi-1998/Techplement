package respositories;

import models.Options;
import models.Questions;
import models.Roles;

import java.util.HashMap;
import java.util.Map;

public class OptionsRepository {
    Map<Integer, Options> optionDB = new HashMap<>();

    //saving Option to DB
    int j=1;
    public void saveOptionToDB(Options options) {
        options.setId(j*1L);
        options.setQuestionID(j*1L);
        optionDB.put(j, options);
        j++;
    }

    //getting Option from DB
    public Options getOptionFromDBUsingOption(String option) {
        for (Map.Entry<Integer, Options> entry : optionDB.entrySet()) {
            int key = entry.getKey();
            Options options = entry.getValue();

            if(options.getOption().equals(option)) {
                return options;
            }
        }
        return null;
    }
}
