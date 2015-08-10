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

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestContainingRecognition {

    private static final String CONTAINING     = "containing";
    private static final String NOT_CONTAINING = "not_containing";

    @DataProvider(name = CONTAINING)
    public final static Iterator<Object[]> getContaining() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getContaining();
    }

    @DataProvider(name = NOT_CONTAINING)
    public final static Iterator<Object[]> getNotContaining() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getNotContaining();
    }

    public TestContainingRecognition() {
        super();
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsConsecutiveTo(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(!IntervalArithmeticsUtils.isRightAfter(intervalA,
                intervalB));
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsContaining_Containing(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(IntervalArithmeticsUtils.isContaining(intervalA,
                intervalB));
    }

    @Test(dataProvider = NOT_CONTAINING)
    public final void testIsContaining_NotContaining(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(!IntervalArithmeticsUtils.isContaining(intervalA,
                intervalB));
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsNextTo(final Integer lowerA, final Integer upperA,
            final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(!IntervalArithmeticsUtils
                .isNextTo(intervalA, intervalB));
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsOverlapped(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(IntervalArithmeticsUtils.isOverlapped(intervalA,
                intervalB));
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsOverlapped_Symmetric(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(IntervalArithmeticsUtils.isOverlapped(intervalB,
                intervalA));
    }

    @Test(dataProvider = CONTAINING)
    public final void testIsPreviousTo(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(!IntervalArithmeticsUtils.isRightBefore(intervalA,
                intervalB));
    }

}
