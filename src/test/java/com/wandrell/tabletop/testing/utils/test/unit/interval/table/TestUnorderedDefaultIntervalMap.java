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

public final class TestUnorderedDefaultIntervalMap {

    private IntervalTable<Integer> table;

    public TestUnorderedDefaultIntervalMap() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        table = new DefaultIntervalTable<Integer>(getIntervalsMap());
    }

    @Test
    public final void testGetValue_LowerLimit() {
        Assert.assertEquals(table.getValue(table.getLowerLimit()), (Integer) 0);
    }

    @Test
    public final void testGetValue_LowerLimit_SecondInterval() {
        Assert.assertEquals(table.getValue(2), (Integer) 2);
    }

    @Test
    public final void testGetValue_SecondInterval() {
        Assert.assertEquals(table.getValue(3), (Integer) 2);
    }

    @Test
    public final void testGetValue_UpperLimit() {
        Assert.assertEquals(table.getValue(table.getUpperLimit()), (Integer) 1);
    }

    @Test
    public final void testGetValue_UpperLimit_FirstInterval() {
        Assert.assertEquals(table.getValue(1), (Integer) 0);
    }

    @Test
    public final void testGetValue_UpperLimit_SecondInterval() {
        Assert.assertEquals(table.getValue(5), (Integer) 2);
    }

    @Test
    public final void testLowerLimit() {
        Assert.assertEquals(table.getLowerLimit(), (Integer) 1);
    }

    @Test
    public final void testUpperLimit() {
        Assert.assertEquals(table.getUpperLimit(), (Integer) 10);
    }

    private final Map<Interval, Integer> getIntervalsMap() {
        final Map<Interval, Integer> map;

        map = new LinkedHashMap<Interval, Integer>();
        map.put(new DefaultInterval(2, 5), 2);
        map.put(new DefaultInterval(1, 1), 0);
        map.put(new DefaultInterval(6, 10), 1);

        return map;
    }

}
