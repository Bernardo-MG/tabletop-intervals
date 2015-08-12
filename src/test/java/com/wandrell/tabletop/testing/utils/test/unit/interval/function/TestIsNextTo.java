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
 * {@code isNextTo} method works as expected.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An interval just before is recognized as being next to.</li>
 * <li>An interval just after is recognized as being next to.</li>
 * <li>An interval not consecutive is recognized as not being next to.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestIsNextTo {

    /**
     * Default constructor.
     */
    public TestIsNextTo() {
        super();
    }

    /**
     * Tests that an interval just after is recognized as being next to.
     */
    @Test
    public final void testIsNextTo_NextTo_After() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isNextTo(intervalA, intervalB));
    }

    /**
     * Tests that an interval just before is recognized as being next to.
     */
    @Test
    public final void testIsNextTo_NextTo_Before() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(15);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(10);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isNextTo(intervalA, intervalB));
    }

    /**
     * Tests that an interval not consecutive is recognized as not being next
     * to.
     */
    @Test
    public final void testIsNextTo_NotNextTo() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(12);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(15);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isNextTo(intervalA, intervalB));
    }

}
