package org.outerspace.jokes.services;

import java.util.List;
import java.util.Random;

public class JokeQuotes {

    List<String> quotes;

    public JokeQuotes() {
        this.quotes = List.of(
        "Chuck Norris doesn't read books. He stares them down until he gets the information he wants",
        "Time waits for no man. Unless that man is Chuck Norris.",
        "If you spell Chuck Norris in Scrabble, you win. Forever.",
        "Chuck Norris breathes air ... five times a day.",
        "In the Beginning there was nothing ... then Chuck Norris roundhouse kicked nothing and told it to get a job.",
        "When God said, “Let there be light!” Chuck Norris said, “Say Please.”",
        "If Chuck Norris were to travel to an alternate dimension in which there was another Chuck Norris and they both fought, they would both win.",
        "The dinosaurs looked at Chuck Norris the wrong way once. You know what happened to them.",
        "Chuck Norris' tears cure cancer. Too bad he has never cried."
        );
    }

    public String getQuote() {
        Random random = new Random();
        return quotes.get(random.ints(0,8).findFirst().getAsInt());
    }
}
