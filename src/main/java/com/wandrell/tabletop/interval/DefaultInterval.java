/**
 * Copyright 2013-2014 the original author or authors
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
package com.wandrell.tabletop.interval;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Range;

/**
 * Default implementation of {@code Interval}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultInterval implements Interval {

    /**
     * Range representing the interval.
     */
    private Range<Integer> range;

    /**
     * Constructs a {@code DefaultInterval}.
     * <p>
     * Creates an interval where the lower limit is the minimum allowed integer,
     * and the upper is the maximum allowed integer.
     */
    public DefaultInterval() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Copy constructor for {@code DefaultInterval} .
     * 
     * @param interval
     *            the interval to copy
     */
    public DefaultInterval(final DefaultInterval interval) {
        super();

        checkNotNull(interval, "Received a null pointer as interval");

        range = Range.closed(interval.range.lowerEndpoint(),
                interval.range.upperEndpoint());
    }

    /**
     * Constructs a {@code DefaultInterval} with the specified limits.
     * <p>
     * The lower limit should be lower or equal to the upper, otherwise an
     * {@code IllegalIntervalLimitException} is thrown.
     * 
     * @param lowerLimit
     *            the lower limit
     * @param upperLimit
     *            the upper limit
     */
    public DefaultInterval(final Integer lowerLimit, final Integer upperLimit) {
        super();

        checkNotNull(lowerLimit, "Received a null pointer as lower limit");
        checkNotNull(upperLimit, "Received a null pointer as upper limit");

        range = Range.closed(lowerLimit, upperLimit);
    }

    /**
     * Constructs a {@code DefaultInterval} from the specified interval.
     * 
     * @param interval
     *            the interval from which to get the limits
     */
    public DefaultInterval(final Interval interval) {
        this(interval.getLowerLimit(), interval.getUpperLimit());
    }

    @Override
    public final String getStringRepresentation() {
        return String.format("[%d,%d]", getLowerLimit(), getUpperLimit());
    }

    @Override
    public final boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DefaultInterval other;

        other = (DefaultInterval) obj;

        return Objects.equals(range, other.range);
    }

    @Override
    public final Integer getLowerLimit() {
        return getRange().lowerEndpoint();
    }

    @Override
    public final Integer getUpperLimit() {
        return getRange().upperEndpoint();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(range);
    }

    @Override
    public final void setLowerLimit(final Integer lowerLimit) {
        checkNotNull(lowerLimit, "Received a null pointer as lower limit");

        range = Range.closed(lowerLimit, range.upperEndpoint());
    }

    @Override
    public final void setUpperLimit(final Integer upperLimit) {
        checkNotNull(upperLimit, "Received a null pointer as upper limit");

        range = Range.closed(range.lowerEndpoint(), upperLimit);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("range", range).toString();
    }

    /**
     * The range holding the interval's data.
     * 
     * @return the interval's range
     */
    private final Range<Integer> getRange() {
        return range;
    }

}
