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

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;
import com.wandrell.tabletop.interval.table.IntervalTable;

public final class TestExceptionEmptyDefaultIntervalTable {

    public TestExceptionEmptyDefaultIntervalTable() {
        super();
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Max_NotFound_Exception() {
        final IntervalTable<Integer> table;

        table = new DefaultIntervalTable<Integer>(
                new LinkedHashMap<Interval, Integer>());

        table.getValue(Integer.MAX_VALUE);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Min_NotFound_Exception() {
        final IntervalTable<Integer> table;

        table = new DefaultIntervalTable<Integer>(
                new LinkedHashMap<Interval, Integer>());

        table.getValue(Integer.MIN_VALUE);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Zero_NotFound_Exception() {
        final IntervalTable<Integer> table;

        table = new DefaultIntervalTable<Integer>(
                new LinkedHashMap<Interval, Integer>());

        table.getValue(0);
    }

}
