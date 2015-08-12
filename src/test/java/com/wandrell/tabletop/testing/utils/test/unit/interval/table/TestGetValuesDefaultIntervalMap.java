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

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.table.DefaultIntervalsTable;
import com.wandrell.tabletop.interval.table.IntervalsTable;

/**
 * Unit test for {@link IntervalsTable}, checking that the query methods work
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
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(table.getLowerLimit()), (Integer) 0);
    }

    /**
     * Tests that acquiring the second interval's lower limit works as expected.
     */
    @Test
    public final void testGetValue_LowerLimit_SecondInterval() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(2), (Integer) 2);
    }

    /**
     * Tests that acquiring the value for the second interval works as expected.
     */
    @Test
    public final void testGetValue_SecondInterval() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(3), (Integer) 2);
    }

    /**
     * Tests that acquiring the last interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(table.getUpperLimit()), (Integer) 1);
    }

    /**
     * Tests that acquiring the first interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit_FirstInterval() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(1), (Integer) 0);
    }

    /**
     * Tests that acquiring the second interval's upper limit works as expected.
     */
    @Test
    public final void testGetValue_UpperLimit_SecondInterval() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getValue(5), (Integer) 2);
    }

    /**
     * Test that acquiring the table's lower limit works as expected.
     */
    @Test
    public final void testLowerLimit() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getLowerLimit(), (Integer) 1);
    }

    /**
     * Test that acquiring the table's upper limit works as expected.
     */
    @Test
    public final void testUpperLimit() {
        final IntervalsTable<Integer> table; // Table tested

        table = getTestTable();

        Assert.assertEquals(table.getUpperLimit(), (Integer) 10);
    }

    /**
     * Returns the table to be tested.
     * 
     * @return the table to be tested
     */
    private final DefaultIntervalsTable<Integer> getTestTable() {
        final DefaultIntervalsTable<Integer> table;

        table = new DefaultIntervalsTable<Integer>(new DefaultInterval(1, 1),
                0);
        table.addInterval(new DefaultInterval(2, 5), 2);
        table.addInterval(new DefaultInterval(6, 10), 1);

        return table;
    }

}
