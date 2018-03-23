package com.example.pmill.project4part2;

/**
 * Created by pmill on 3/23/2018.
 */

public class WordPair {

    String word, antonym;

    public WordPair(String word, String antonym)
    {
        this.word = word;
        this.antonym = antonym;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public String getWord()
    {
        return this.word;
    }

    public void setAntonym(String antonym)
    {
        this.antonym = antonym;
    }

    public String getAntonym()
    {
        return this.antonym;
    }
}
