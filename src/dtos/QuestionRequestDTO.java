package dtos;

import java.util.List;

public class QuestionRequestDTO {
    private String questions;
    private List<String> options;

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
