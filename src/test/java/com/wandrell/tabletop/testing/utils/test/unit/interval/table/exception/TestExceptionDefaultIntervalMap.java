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
package com.wandrell.tabletop.testing.utils.test.unit.interval.table.exception;

import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;
import com.wandrell.tabletop.interval.table.IntervalTable;

/**
 * Unit test for {@link IntervalTable}, checking that exceptions are thrown for
 * invalid values.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IndexOutOfBoundsException} is thrown when acquiring a the value
 * for a number out of the interval.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionDefaultIntervalMap {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultIntervalMap() {
        super();
    }

    /**
     * Tests that an {@code IndexOutOfBoundsException} is thrown when acquiring
     * a the value for a number out of the interval.
     */
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_NotFound() {
        final IntervalTable<Integer> table; // Table tested

        table = getTestTable();

        table.getValue(Integer.MAX_VALUE);
    }

    /**
     * Returns the table to be tested.
     * 
     * @return the table to be tested
     */
    private final DefaultIntervalTable<Integer> getTestTable() {
        final DefaultIntervalTable<Integer> table;

        table = new DefaultIntervalTable<Integer>(new DefaultInterval(1, 1), 0);
        table.addInterval(new DefaultInterval(2, 5), 2);
        table.addInterval(new DefaultInterval(6, 10), 1);

        return table;
    }

}
