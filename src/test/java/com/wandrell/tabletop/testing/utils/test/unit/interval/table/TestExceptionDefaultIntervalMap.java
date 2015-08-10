package com.wandrell.tabletop.testing.utils.test.unit.interval.table;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;
import com.wandrell.tabletop.interval.table.IntervalTable;

public final class TestExceptionDefaultIntervalMap {

    private IntervalTable<Integer> table;

    public TestExceptionDefaultIntervalMap() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        table = new DefaultIntervalTable<Integer>(getIntervalsMap());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Max_NotFound_Exception() {
        table.getValue(Integer.MAX_VALUE);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Min_NotFound_Exception() {
        table.getValue(Integer.MIN_VALUE);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public final void testGetValue_Zero_NotFound_Exception() {
        table.getValue(0);
    }

    @Test
    public final void testUpperLimit() {
        Assert.assertEquals(table.getUpperLimit(), (Integer) 10);
    }

    private final Map<Interval, Integer> getIntervalsMap() {
        final Map<Interval, Integer> map;

        map = new LinkedHashMap<Interval, Integer>();
        map.put(new DefaultInterval(1, 1), 0);
        map.put(new DefaultInterval(2, 5), 2);
        map.put(new DefaultInterval(6, 10), 1);

        return map;
    }

}
