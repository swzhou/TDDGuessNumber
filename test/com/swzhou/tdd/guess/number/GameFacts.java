package com.swzhou.tdd.guess.number;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: swzhou
 * Date: 12-5-29
 * Time: 上午6:24
 * To change this template use File | Settings | File Templates.
 */
public class GameFacts {
    
    @Test
    public void should_play_game_and_win() {
        Mockery context = new JUnit4Mockery() {
            {
                setImposteriser(ClassImposteriser.INSTANCE);
            }
        };
        final AnswerGenerator answerGenerator = context.mock(AnswerGenerator.class);
        final InputCollector inputCollector = context.mock(InputCollector.class);
        final Guesser guesser = context.mock(Guesser.class);
        final OutputPrinter outputPrinter = context.mock(OutputPrinter.class);

        context.checking(new Expectations() {
            {
                one(answerGenerator).generate();
                will(returnValue("1234"));
            }

            {
                one(inputCollector).guess();
                will(returnValue("1234"));
            }

            {
                oneOf(guesser).verify(with(equal("1234")), with(equal("1234")));
                will(returnValue("4A0B"));
            }

            {
                oneOf(outputPrinter).print(with(equal("You win")));
            }
        });

        Game game = new Game(answerGenerator, inputCollector, guesser, outputPrinter);
        game.start();

        context.assertIsSatisfied();
    }
}
