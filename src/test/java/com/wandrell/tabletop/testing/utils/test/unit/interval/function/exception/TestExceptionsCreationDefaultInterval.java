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

public final class TestExceptionsCreationDefaultInterval {

    public TestExceptionsCreationDefaultInterval() {
        super();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsContaining_Value() {
        final Interval interval;

        interval = Mockito.mock(Interval.class);

        Mockito.when(interval.getLowerLimit()).thenReturn(10);
        Mockito.when(interval.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isContaining(interval, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsContainingInterval_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isContaining(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsContainingInterval_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isContaining(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsNextTo_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isNextTo(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsNextTo_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isNextTo(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsOverlapped_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isOverlapped(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsOverlapped_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isOverlapped(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightAfter_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isRightAfter(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightAfter_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isRightAfter(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightBefore_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsRightBefore_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testLowerDifference_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.getLowerDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testLowerDifference_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.getLowerDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testUpperDifference_First() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(1);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalArithmeticsUtils.getUpperDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testUpperDifference_Second() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(10);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.getUpperDifference(intervalA, intervalB);
    }

}
