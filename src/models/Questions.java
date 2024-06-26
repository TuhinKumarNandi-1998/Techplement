package models;

import java.util.List;

public class Questions {
    private long id;
    private String question;
    private List<Options> options;
    private Options correctAnswer;

    public Options getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(Options correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }
}
