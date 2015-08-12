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
 * thrown by the {@code isContaining} when the arguments are invalid.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown when the first interval is
 * invalid.</li>
 * <li>An {@code IllegalArgumentException} is thrown when the second interval is
 * invalid.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionsRightBefore {

    /**
     * Default constructor.
     */
    public TestExceptionsRightBefore() {
        super();
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the first
     * interval is invalid.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightBefore_First() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB);
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the second
     * interval is invalid.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightBefore_Second() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB);
    }

}
