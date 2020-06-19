package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Score {

    Color color;

    Integer score;

    public Score(Color color) {
        this.color = color;
        this.score = 0;
    }

    public Color getColor() {
        return color;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
