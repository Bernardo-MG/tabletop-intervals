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

import java.util.Iterator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestExceptionsSetIntervalDefaultInterval {

    private static final String DATA = "data";
    private Interval            interval;

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance().getInvalid();
    }

    public TestExceptionsSetIntervalDefaultInterval() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        interval = new DefaultInterval();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testSetLimits_Lower(final Integer lowerLimit,
            final Integer upperLimit) {
        interval.setUpperLimit(upperLimit);

        interval.setLowerLimit(lowerLimit);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testSetLimits_Upper(final Integer lowerLimit,
            final Integer upperLimit) {
        interval.setLowerLimit(lowerLimit);

        interval.setUpperLimit(upperLimit);
    }

}
