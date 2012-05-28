package com.swzhou.tdd.guess.number;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 12-5-29
 * Time: 上午6:27
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private AnswerGenerator answerGenerator;
    private InputCollector inputCollector;
    private Guesser guesser;
    private OutputPrinter outputPrinter;

    public Game(AnswerGenerator answerGenerator, InputCollector inputCollector, Guesser guesser, OutputPrinter outputPrinter) {

        this.answerGenerator = answerGenerator;
        this.inputCollector = inputCollector;
        this.guesser = guesser;
        this.outputPrinter = outputPrinter;
    }

    public void start() {
        String answer = answerGenerator.generate();
        String guess = inputCollector.guess();
        String result = "";
        do {
           result = guesser.verify(guess, answer);
        } while (result != "4A0B");
        outputPrinter.print("You win");
    }
}
