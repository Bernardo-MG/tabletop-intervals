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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

/**
 * Unit test for {@link IntervalArithmeticsUtils}, checking that the
 * {@code isRightBefore} method works as expected.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An interval right before is recognized as such.</li>
 * <li>An interval not right before is recognized as such.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestIsRightBefore {

    /**
     * Default constructor.
     */
    public TestIsRightBefore() {
        super();
    }

    /**
     * Tests that an interval not right before is recognized as such.
     */
    @Test
    public final void testIsRightBefore_NotRightBefore() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(12);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB));
    }

    /**
     * Tests that an interval right before is recognized as such.
     */
    @Test
    public final void testIsRightBefore_RightBefore() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB));
    }

}
