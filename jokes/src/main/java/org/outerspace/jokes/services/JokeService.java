package org.outerspace.jokes.services;

import org.springframework.stereotype.Service;

@Service
public class JokeService {
    private final JokeQuotes jokeQuotes;

    public JokeService() {
        this.jokeQuotes = new JokeQuotes();
    }

    public String getJoke() {
        return this.jokeQuotes.getQuote();
    }
}
