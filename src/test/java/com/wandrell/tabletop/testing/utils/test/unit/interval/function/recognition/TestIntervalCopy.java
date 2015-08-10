package com.wandrell.tabletop.testing.utils.test.unit.interval.function.recognition;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalOperationUtils;
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

        Assert.assertTrue(!IntervalOperationUtils.isRightAfter(intervalA,
                intervalB));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void
            testIsConsecutiveTo_NotConsecutiveTo_Symmetric(
                    final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(!IntervalOperationUtils.isRightAfter(intervalB,
                intervalA));
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

        Assert.assertTrue(IntervalOperationUtils.isContaining(intervalA,
                intervalB));
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

        Assert.assertTrue(IntervalOperationUtils.isContaining(intervalB,
                intervalA));
    }

    @Test(dataProvider = DATA)
    public final <V extends Number> void testIsNextTo_NotNextTo(
            final Integer lowerA, final Integer upperA) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(!IntervalOperationUtils
                .isNextTo(intervalA, intervalB));
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

        Assert.assertTrue(!IntervalOperationUtils
                .isNextTo(intervalB, intervalA));
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

        Assert.assertTrue(IntervalOperationUtils.isOverlapped(intervalA,
                intervalB));
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

        Assert.assertTrue(IntervalOperationUtils.isOverlapped(intervalB,
                intervalA));
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

        Assert.assertTrue(!IntervalOperationUtils.isRightBefore(intervalA,
                intervalB));
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

        Assert.assertTrue(!IntervalOperationUtils.isRightBefore(intervalB,
                intervalA));
    }

}
