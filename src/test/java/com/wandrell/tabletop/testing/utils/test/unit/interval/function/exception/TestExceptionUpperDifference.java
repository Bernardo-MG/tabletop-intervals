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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function.exception;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

/**
 * Unit test for {@link IntervalArithmeticsUtils}, checking that exceptions are
 * thrown by the {@code getUpperDifference} when the arguments are invalid.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown when an interval is
 * invalid.</li>
 * <li>An {@code IllegalArgumentException} is thrown when both intervals have
 * the same upper limit.</li>
 * <li>An {@code IllegalArgumentException} is thrown when the intervals are not
 * overlapped.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionUpperDifference {

    /**
     * Default constructor.
     */
    public TestExceptionUpperDifference() {
        super();
    }

    /**
     * Tests than an {@code IllegalArgumentException} is thrown when an interval
     * is invalid.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testUpperDifference_InvalidInterval() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(5);

        IntervalArithmeticsUtils.getUpperDifference(intervalA, intervalB);
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the
     * intervals are not overlapped.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testUpperDifference_NotOverlapped() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        IntervalArithmeticsUtils.getUpperDifference(intervalA, intervalB);
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when both
     * intervals have the same upper limit.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testUpperDifference_SameUpperLimit() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(5);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(10);

        IntervalArithmeticsUtils.getUpperDifference(intervalA, intervalB);
    }

}
