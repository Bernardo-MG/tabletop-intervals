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

public final class TestIntervalCopy {

    private static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getPairInterval() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance().getValid();
    }

    public TestIntervalCopy() {
        super();
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsConsecutiveTo_NotConsecutiveTo(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isRightAfter(intervalA, intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void
            testIsConsecutiveTo_NotConsecutiveTo_Symmetric(final Integer lowerA,
                    final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isRightAfter(intervalB, intervalA));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsContaining(final Integer lowerA,
            final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isContaining(intervalA, intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsContaining_Symmetric(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isContaining(intervalB, intervalA));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void
            testIsNextTo_NotNextTo(final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isNextTo(intervalA, intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsNextTo_NotNextTo_Symmetric(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isNextTo(intervalB, intervalA));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsOverlapped(final Integer lowerA,
            final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isOverlapped(intervalA, intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsOverlapped_Symmetric(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                IntervalArithmeticsUtils.isOverlapped(intervalB, intervalA));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsPreviousTo_NotPreviousTo(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isRightBefore(intervalA, intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void
            testIsPreviousTo_NotPreviousTo_Symmetric(final Integer lowerA,
                    final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isRightBefore(intervalB, intervalA));
    }

}
