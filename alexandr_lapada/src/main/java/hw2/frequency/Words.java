package hw2.frequency;

/**
 * Created by sanya on 23.01.2015.
 */
public class Words {
    private String word;
    private Integer frequency;

    public Words(){}

    public Words(String word,Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public void setWord(String word){this.word = word;}

    public void setFrequency(Integer frequency){this.frequency = frequency;}

    public String getWord(){return word;}

    public Integer getFrequency(){return frequency;}
}
