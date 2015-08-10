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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;
import com.wandrell.tabletop.interval.table.IntervalTable;

public final class TestGapsDefaultIntervalMap {

    private IntervalTable<Integer> table;

    public TestGapsDefaultIntervalMap() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        table = new DefaultIntervalTable<Integer>(getIntervalsMap());
    }

    @Test
    public final void testGetValue_Gap() {
        Assert.assertEquals(table.getValue(2), null);
    }

    @Test
    public final void testGetValue_LowerLimit() {
        Assert.assertEquals(table.getValue(table.getLowerLimit()), (Integer) 0);
    }

    @Test
    public final void testGetValue_LowerLimit_LastInterval() {
        Assert.assertEquals(table.getValue(6), (Integer) 1);
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
        map.put(new DefaultInterval(1, 1), 0);
        map.put(new DefaultInterval(6, 10), 1);

        return map;
    }

}
