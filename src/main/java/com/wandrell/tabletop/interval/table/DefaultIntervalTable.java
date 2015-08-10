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
package com.wandrell.tabletop.interval.table;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalComparator;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

/**
 * Default implementation of {@code IntervalTable}.
 * 
 * @author Bernardo Martínez Garrido
 * @param <V>
 *            the type of the values assigned to the intervals
 */
public final class DefaultIntervalTable<V> implements IntervalTable<V> {

    /**
     * The intervals composing the table and their values.
     */
    private final TreeMap<Interval, V> tableIntervals = new TreeMap<Interval, V>(
            new IntervalComparator());

    /**
     * Copy constructor for {@code DefaultIntervalTable}.
     * 
     * @param table
     *            the table to copy
     */
    public DefaultIntervalTable(final DefaultIntervalTable<V> table) {
        super();

        checkNotNull(table, "Received a null pointer as intervals table");

        for (final Entry<Interval, V> entry : table.tableIntervals.entrySet()) {
            checkNotNull(entry.getKey(), "Received a null pointer as interval");
            checkNotNull(entry.getValue(), "Received a null pointer as value");

            // TODO: Check that the intervals are not overlapping
            getIntervalsModifiable().put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Constructs a {@code DefaultIntervalTable} with the specified parameters.
     * 
     * @param intervals
     *            the intervals and their assigned value
     */
    public DefaultIntervalTable(final Map<Interval, V> intervals) {
        super();

        checkNotNull(intervals, "Received a null pointer as intervals");

        for (final Entry<Interval, V> entry : intervals.entrySet()) {
            checkNotNull(entry.getKey(), "Received a null pointer as interval");
            checkNotNull(entry.getValue(), "Received a null pointer as value");

            // TODO: Check that the intervals are not overlapping
            getIntervalsModifiable().put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final boolean equals(final Object obj) {
        final DefaultIntervalTable<?> other;

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        other = (DefaultIntervalTable<?>) obj;
        return Objects.equals(tableIntervals, other.tableIntervals);
    }

    @Override
    public final Map<Interval, V> getIntervals() {
        return Collections.unmodifiableMap(getIntervalsModifiable());
    }

    @Override
    public final Integer getLowerLimit() {
        return getIntervalsModifiable().firstKey().getLowerLimit();
    }

    @Override
    public final Integer getUpperLimit() {
        return getIntervalsModifiable().lastKey().getUpperLimit();
    }

    @Override
    public final V getValue(final Integer number) {

        if (!isContainedInInterval(number)) {
            if (getIntervalsModifiable().isEmpty()) {
                throw new IndexOutOfBoundsException(String
                        .format("%d is out of the empty interval", number));
            } else {
                throw new IndexOutOfBoundsException(
                        String.format("%d is out of the interval [%d,%d]",
                                number, getLowerLimit(), getUpperLimit()));
            }
        }

        final Iterator<Entry<Interval, V>> itrIntervals;
        V value;
        Entry<Interval, V> entry;

        itrIntervals = getIntervalsModifiable().entrySet().iterator();
        value = null;
        while ((value == null) && (itrIntervals.hasNext())) {
            entry = itrIntervals.next();
            if (IntervalArithmeticsUtils.isContaining(entry.getKey(), number)) {
                value = entry.getValue();
            }
        }

        return value;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(tableIntervals);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("intervals", tableIntervals)
                .toString();
    }

    /**
     * Returns the intervals in a modifiable collection.
     * 
     * @return the intervals in a modifiable collection
     */
    private final TreeMap<Interval, V> getIntervalsModifiable() {
        return tableIntervals;
    }

    /**
     * Checks if a value is contained in the main interval.
     * 
     * @param value
     *            the value to check
     * @return {@code true} if the value is contained, {@code false} otherwise
     */
    private final Boolean isContainedInInterval(final Integer value) {
        final Boolean result;

        if (getIntervalsModifiable().isEmpty()) {
            result = false;
        } else {
            result = ((value >= getLowerLimit()) && (value <= getUpperLimit()));
        }

        return result;
    }

}
