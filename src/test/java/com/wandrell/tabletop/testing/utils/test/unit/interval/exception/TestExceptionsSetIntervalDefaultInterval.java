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

/**
 * Unit test for {@link DefaultInterval}, checking that exceptions are thrown
 * for invalid intervals.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown when the constructor
 * receives and invalid interval.</li>
 * <li>An {@code IllegalArgumentException} is thrown when the lower limit is set
 * as higher than the upper limit.</li>
 * <li>An {@code IllegalArgumentException} is thrown when the upper limit is set
 * as lower than the lower limit.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionsSetIntervalDefaultInterval {

    /**
     * Default constructor.
     */
    public TestExceptionsSetIntervalDefaultInterval() {
        super();
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the
     * constructor receives and invalid interval.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testConstructor() {
        new DefaultInterval(10, 1);
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the lower
     * limit is set as higher than the upper limit.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetLimits_Lower() {
        final DefaultInterval interval; // Interval being tested

        interval = new DefaultInterval();

        interval.setUpperLimit(1);
        interval.setLowerLimit(10);
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the upper
     * limit is set as lower than the lower limit.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetLimits_Upper() {
        final DefaultInterval interval; // Interval being tested

        interval = new DefaultInterval();

        interval.setLowerLimit(10);
        interval.setUpperLimit(1);
    }

}
