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
package com.wandrell.tabletop.testing.utils.test.unit.interval.exception;

import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;

public final class TestExceptionsSetIntervalDefaultInterval {

    public TestExceptionsSetIntervalDefaultInterval() {
        super();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetLimits_Lower() {
        final Interval interval;

        interval = new DefaultInterval();

        interval.setUpperLimit(1);
        interval.setLowerLimit(10);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetLimits_Upper() {
        final Interval interval;

        interval = new DefaultInterval();

        interval.setLowerLimit(10);
        interval.setUpperLimit(1);
    }

}
