package com.github.brunodles.validationbuilder.matcher;

import com.github.brunodles.oleaster_suite_runner.OleasterSuiteRunner;
import com.github.brunodles.validationbuilder.Errors;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import java.util.function.IntConsumer;

import static com.mscharhag.oleaster.runner.StaticRunnerSupport.before;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static org.mockito.Mockito.mock;

/**
 * Created by bruno on 04/06/16.
 */
@RunWith(OleasterRunner.class)
public class DoubleMatcherTest extends NumberMatcherTestBase<Double, DoubleMatcher> {

    {
        describe("Given a IntegerMatcher for 7", () -> {
            before(() -> {
                adder = mock(IntConsumer.class);
                matcher = new DoubleMatcher(7D, adder);
            });
            describe("when call isBetween", () -> {
                when_isBetween(1D, 7D, this::itShouldNotCallAdder);
                when_isBetween(7D, 10D, this::itShouldNotCallAdder);
                when_isBetween(5D, 9D, () -> itShouldCallAdderWith("BETWEEN", Errors.BETWEEN));
            });
            describe("when call isLower", () -> {
                when_isLower(7D, this::itShouldNotCallAdder);
                when_isLower(8D, () -> itShouldCallAdderWith("LOWER", Errors.LOWER));
            });
            describe("when call isGreater", () -> {
                when_isGreater(7D, this::itShouldNotCallAdder);
                when_isGreater(6D, () -> itShouldCallAdderWith("GREATER", Errors.GREATER));
            });
            describe("when call isEqual", () -> {
                when_isEqualTo(6D, this::itShouldNotCallAdder);
                when_isEqualTo(8D, this::itShouldNotCallAdder);
                when_isEqualTo(7D, () -> itShouldCallAdderWith("EQUAL", Errors.EQUAL));
            });
        });
    }
}