package com.github.brunodles.javavalidation.matcher;

/**
 * Created by bruno on 03/06/16.
 */
public interface ObjectMatcher<T, SubClass extends EqualsMatcher> extends EqualsMatcher<T, SubClass> {
    SubClass isNull();
}
