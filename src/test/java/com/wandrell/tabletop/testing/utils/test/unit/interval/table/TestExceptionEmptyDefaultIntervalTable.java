package com.wandrell.tabletop.testing.utils.test.unit.interval.table;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultIntervalTable;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.IntervalTable;

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
