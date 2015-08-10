/**
 * Copyright 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.wandrell.tabletop.interval.util;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;

/**
 * Utilities class for interval arithmetics.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class IntervalArithmeticsUtils {

    /**
     * Returns the lower difference of two intervals.
     * <p>
     * This will be a new interval having the lowest lower limit as it's lower
     * limit, and the highest lower limit as it's upper limit.
     * 
     * @param intervalA
     *            first interval for the operation
     * @param intervalB
     *            second interval for the operation
     * @return the lower difference interval
     */
    public static final Interval getLowerDifference(final Interval intervalA,
            final Interval intervalB) {
        final Interval lowerDifference;
        Integer upper, lower;

        checkNotNull(intervalA,
                "Received a null pointer as the first interval");
        checkNotNull(intervalB,
                "Received a null pointer as the second interval");

        checkArgument(isValid(intervalA),
                "Received an invalid interval as the first argument");
        checkArgument(isValid(intervalB),
                "Received an invalid interval as the second argument");

        if ((isOverlapped(intervalA, intervalB)) && (!intervalA.getLowerLimit()
                .equals(intervalB.getLowerLimit()))) {
            upper = (Math.max(intervalA.getLowerLimit(),
                    intervalB.getLowerLimit()) - 1);
            lower = (Math.min(intervalA.getLowerLimit(),
                    intervalB.getLowerLimit()));

            lowerDifference = new DefaultInterval(lower, upper);
        } else {
            throw new IllegalArgumentException(
                    "The intervals are the same or don't overlap");
        }

        return lowerDifference;
    }

    /**
     * Returns the upper difference of two intervals.
     * <p>
     * This will be a new interval having the lowest upper limit as it's lower
     * limit, and the highest upper limit as it's upper limit.
     * 
     * @param intervalA
     *            first interval for the operation
     * @param intervalB
     *            second interval for the operation
     * @return the upper difference interval
     */
    public static final Interval getUpperDifference(final Interval intervalA,
            final Interval intervalB) {
        final Interval upperDifference;
        final Integer upper, lower;

        checkNotNull(intervalA,
                "Received a null pointer as the first interval");
        checkNotNull(intervalB,
                "Received a null pointer as the second interval");

        checkArgument(isValid(intervalA),
                "Received an invalid interval as the first argument");
        checkArgument(isValid(intervalB),
                "Received an invalid interval as the second argument");

        // *-----* = this interval
        // O-----O = received interval
        if ((isOverlapped(intervalA, intervalB)) && (!intervalA.getUpperLimit()
                .equals(intervalB.getUpperLimit()))) {
            upper = Math.max(intervalA.getUpperLimit(),
                    intervalB.getUpperLimit());
            lower = (Math.min(intervalA.getUpperLimit(),
                    intervalB.getUpperLimit()) + 1);

            upperDifference = new DefaultInterval(lower, upper);
        } else {
            throw new IllegalArgumentException(
                    "The intervals upper limits are the same or the intervals don't overlap");
        }

        return upperDifference;
    }

    /**
     * Indicates if an interval contains a value.
     * 
     * @param interval
     *            the interval for the check
     * @param value
     *            the value to check
     * @return {@code true} if the value is contained, {@code false} otherwise
     */
    public static final Boolean isContaining(final Interval interval,
            final Integer value) {
        final Range<Integer> rangeA;
        final Range<Integer> rangeB;

        checkNotNull(interval, "Received a null pointer as interval");
        checkNotNull(value, "Received a null pointer as value");

        checkArgument(isValid(interval), "Received an invalid interval");

        rangeA = Range.closed(interval.getLowerLimit(),
                interval.getUpperLimit());
        rangeB = Range.singleton(value);

        return rangeA.encloses(rangeB);
    }

    /**
     * Indicates if an interval contains another.
     * 
     * @param containing
     *            the interval which may be containing the other
     * @param contained
     *            the interval which may be contained
     * @return {@code true} if the interval is contained, {@code false}
     *         otherwise
     */
    public static final Boolean isContaining(final Interval containing,
            final Interval contained) {
        final Range<Integer> rangeContaining;
        final Range<Integer> rangeContained;

        checkNotNull(containing,
                "Received a null pointer as the first interval");
        checkNotNull(contained,
                "Received a null pointer as the second interval");

        checkArgument(isValid(containing),
                "Received an invalid interval as the first argument");
        checkArgument(isValid(contained),
                "Received an invalid interval as the second argument");

        rangeContaining = Range.closed(containing.getLowerLimit(),
                containing.getUpperLimit());
        rangeContained = Range.closed(contained.getLowerLimit(),
                contained.getUpperLimit());

        return rangeContaining.encloses(rangeContained);
    }

    /**
     * Indicates if two intervals are consecutive one to another. It does not
     * indicate any order.
     * <p>
     * They are consecutive if adding 1 to one interval's upper limit gives the
     * other interval's lower limit.
     * 
     * @param intervalA
     *            first interval for the check
     * @param intervalB
     *            second interval for the check
     * @return {@code true} if they are one next to the other, {@code false}
     *         otherwise
     */
    public static final Boolean isNextTo(final Interval intervalA,
            final Interval intervalB) {
        return isRightBefore(intervalA, intervalB)
                || isRightAfter(intervalA, intervalB);
    }

    /**
     * Indicates if two intervals overlap.
     * 
     * @param intervalA
     *            first interval for the check
     * @param intervalB
     *            second interval for the check
     * @return {@code true} if they overlap, {@code false} otherwise
     */
    public static final Boolean isOverlapped(final Interval intervalA,
            final Interval intervalB) {
        final Range<Integer> rangeA;
        final Range<Integer> rangeB;

        checkNotNull(intervalA,
                "Received a null pointer as the first interval");
        checkNotNull(intervalB,
                "Received a null pointer as the second interval");

        checkArgument(isValid(intervalA),
                "Received an invalid interval as the first argument");
        checkArgument(isValid(intervalB),
                "Received an invalid interval as the second argument");

        rangeA = Range.closed(intervalA.getLowerLimit(),
                intervalA.getUpperLimit());
        rangeB = Range.closed(intervalB.getLowerLimit(),
                intervalB.getUpperLimit());

        return rangeA.isConnected(rangeB);
    }

    /**
     * Indicates if one interval is after another.
     * 
     * @param second
     *            the interval to check if it is after the first
     * @param first
     *            the interval to check if it is the before the second
     * @return {@code true} if the first interval if before the second,
     *         {@code false} otherwise
     */
    public static final Boolean isRightAfter(final Interval second,
            final Interval first) {
        final Boolean after;

        checkNotNull(second, "Received a null pointer as the first interval");
        checkNotNull(first, "Received a null pointer as the second interval");

        checkArgument(isValid(second),
                "Received an invalid interval as the first argument");
        checkArgument(isValid(first),
                "Received an invalid interval as the second argument");

        after = (first.getUpperLimit() < Integer.MAX_VALUE)
                && (second.getLowerLimit().equals(first.getUpperLimit() + 1));

        return after;
    }

    /**
     * Indicates if one interval is before another.
     * 
     * @param first
     *            the interval to check if it is the before the second
     * @param second
     *            the interval to check if it is after the first
     * @return {@code true} if the second interval if after the first,
     *         {@code false} otherwise
     */
    public static final Boolean isRightBefore(final Interval first,
            final Interval second) {
        return isRightAfter(second, first);
    }

    /**
     * Indicates if the interval is valid.
     * 
     * @param interval
     *            the interval to check
     * @return {@code true} if it is valid, {@code false} otherwise
     */
    private static final Boolean isValid(final Interval interval) {
        return interval.getUpperLimit() >= interval.getLowerLimit();
    }

    /**
     * Constructs an {@code IntervalArithmeticsUtils}.
     * <p>
     * As this is a utilities class the constructor is private.
     */
    private IntervalArithmeticsUtils() {
        super();
    }

}
