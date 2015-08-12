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
 * {@code isOverlapped} method works as expected.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Overlapped interval are recognized as such.</li>
 * <li>Not overlapped interval are recognized as such.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestIsOvelapped {

    /**
     * Default constructor.
     */
    public TestIsOvelapped() {
        super();
    }

    /**
     * Tests that not overlapped interval are recognized as such.
     */
    @Test
    public final void testIsOverlapped_NotOverlapped() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isOverlapped(intervalA, intervalB));
    }

    /**
     * Tests that overlapped interval are recognized as such.
     */
    @Test
    public final void testIsOverlapped_Overlapped() {
        final Interval intervalA; // Interval for testing
        final Interval intervalB; // Interval for testing

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(9);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isOverlapped(intervalA, intervalB));
    }

}
