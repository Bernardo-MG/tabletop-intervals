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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function.recognition;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

public final class TestContainingValue {

    public TestContainingValue() {
        super();
    }

    @Test
    public final void testIsContaining_Interval_Contained() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(1);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isContaining(intervalA, intervalB));
    }

    @Test
    public final void testIsContaining_Interval_NotContained() {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(11);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(11);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isContaining(intervalA, intervalB));
    }

    @Test
    public final void testIsContaining_Value_Contained() {
        final Interval intervalA;

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Assert.assertTrue(IntervalArithmeticsUtils.isContaining(intervalA, 1));
    }

    @Test
    public final void testIsContaining_Value_NotContained() {
        final Interval intervalA;

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isContaining(intervalA, 11));
    }

}
