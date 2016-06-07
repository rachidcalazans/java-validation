package com.github.brunodles.validationbuilder.matcher;

import com.github.brunodles.retrofunctions.IntConsumer;
import com.github.brunodles.validationbuilder.Errors;

import static com.github.brunodles.validationbuilder.matcher.Common._if;

/**
 * Created by bruno on 04/06/16.
 */
public class ObjectMatcherImpl<T> implements ObjectMatcher<T, ObjectMatcherImpl> {

    private T value;
    private IntConsumer adder;

    public ObjectMatcherImpl(T value, IntConsumer adder) {
        this.value = value;
        this.adder = adder;
    }

    @Override
    public ObjectMatcherImpl isNull() {
        _if(() -> value == null, adder, Errors.NULL);
        return this;
    }

    @Override
    public ObjectMatcherImpl isEqualsTo(T expected) {
        _if(() -> value.equals(expected), adder, Errors.EQUAL);
        return this;
    }
}
