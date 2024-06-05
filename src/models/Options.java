package models;

public class Options {
    private long id;
    private char sequences;
    private String option;
    private long questionID;

    public String getOptionFromSeq(char seq) {
        if(seq == this.sequences) {
            return this.option;
        }
        return "";
    }

    public char getSequences() {
        return sequences;
    }

    public void setSequences(char sequences) {
        this.sequences = sequences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }
}
