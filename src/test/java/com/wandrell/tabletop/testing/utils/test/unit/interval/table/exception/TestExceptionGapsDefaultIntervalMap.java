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
 * Unit test for {@link IntervalTable}, checking that exceptions are thrown when
 * adding a non continuous interval.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown adding a interval which is
 * not consecutive to the upper limit.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionGapsDefaultIntervalMap {

    /**
     * Default constructor.
     */
    public TestExceptionGapsDefaultIntervalMap() {
        super();
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown adding a
     * interval which is not consecutive to the upper limit.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testGaps() {
        final DefaultIntervalTable<Integer> table;

        table = new DefaultIntervalTable<Integer>(new DefaultInterval(1, 1), 0);
        table.addInterval(new DefaultInterval(6, 10), 1);
    }

}
