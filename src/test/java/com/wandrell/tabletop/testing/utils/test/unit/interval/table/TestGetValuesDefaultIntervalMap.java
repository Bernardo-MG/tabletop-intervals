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
package com.wandrell.tabletop.testing.utils.test.unit.interval.table;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;
import com.wandrell.tabletop.interval.table.IntervalTable;

/**
 * Unit test for {@link IntervalTable}, checking that the query methods work
 * correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Acquiring the table's lower limit works as expected.</li>
 * <li>Acquiring the table's upper limit works as expected.</li>
 * <li>Acquiring the first interval's upper limit works as expected.</li>
 * <li>Acquiring the second interval's lower limit works as expected.</li>
 * <li>Acquiring the second interval's upper limit works as expected.</li>
 * <li>Acquiring the last interval's upper limit works as expected.</li>
 * <li>Acquiring the value for the first interval works as expected.</li>
 * <li>Acquiring the value for the second interval works as expected.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestGetValuesDefaultIntervalMap {

    /**
     * Default constructor.
     */
    public TestGetValuesDefaultIntervalMap() {
        super();
    }

    /**
     * Tests that acquiring the value for the first interval works as expected.
     */
    @Test
    public final void testGetValue_FirstInterval() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(table.getLowerLimit()), (Integer) 0);
    }

    /**
     * Tests that acquiring the second interval's lower limit works as expected.
     */
    @Test
    public final void testGetValue_LowerLimit_SecondInterval() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(2), (Integer) 2);
    }

    /**
     * Tests that acquiring the value for the second interval works as expected.
     */
    @Test
    public final void testGetValue_SecondInterval() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(3), (Integer) 2);
    }

    /**
     * Tests that acquiring the last interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(table.getUpperLimit()), (Integer) 1);
    }

    /**
     * Tests that acquiring the first interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit_FirstInterval() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(1), (Integer) 0);
    }

    /**
     * Tests that acquiring the second interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit_SecondInterval() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getValue(5), (Integer) 2);
    }

    /**
     * Test that acquiring the table's lower limit works as expected.
     */
    @Test
    public final void testLowerLimit() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getLowerLimit(), (Integer) 1);
    }

    /**
     * Test that acquiring the table's upper limit works as expected.
     */
    @Test
    public final void testUpperLimit() {
        final IntervalTable<Integer> table; // Table tested

        table = new DefaultIntervalTable<Integer>(getIntervalsMap());

        Assert.assertEquals(table.getUpperLimit(), (Integer) 10);
    }

    /**
     * Returns the values used to initialize the table.
     * 
     * @return the values used to initialize the table.
     */
    private final Map<Interval, Integer> getIntervalsMap() {
        final Map<Interval, Integer> map;

        map = new LinkedHashMap<Interval, Integer>();
        map.put(new DefaultInterval(1, 1), 0);
        map.put(new DefaultInterval(6, 10), 1);
        map.put(new DefaultInterval(2, 5), 2);

        return map;
    }

}
