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
import java.util.Map;

import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.table.DefaultIntervalTable;

public final class TestExceptionGapsDefaultIntervalMap {

    public TestExceptionGapsDefaultIntervalMap() {
        super();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testGaps() {
        new DefaultIntervalTable<Integer>(getIntervalsMap());
    }

    private final Map<Interval, Integer> getIntervalsMap() {
        final Map<Interval, Integer> map;

        map = new LinkedHashMap<Interval, Integer>();
        map.put(new DefaultInterval(1, 1), 0);
        map.put(new DefaultInterval(6, 10), 1);

        return map;
    }

}
