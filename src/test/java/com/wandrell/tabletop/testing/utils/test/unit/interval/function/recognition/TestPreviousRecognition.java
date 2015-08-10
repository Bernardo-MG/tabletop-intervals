package com.wandrell.tabletop.testing.utils.test.unit.interval.function.recognition;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestPreviousRecognition {

    private static final String NOT_PREVIOUS = "not_previous";
    private static final String PREVIOUS     = "previous";

    @DataProvider(name = NOT_PREVIOUS)
    public final static Iterator<Object[]> getNotPrevious() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getNotPrevious();
    }

    @DataProvider(name = PREVIOUS)
    public final static Iterator<Object[]> getPrevious() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance().getPrevious();
    }

    public TestPreviousRecognition() {
        super();
    }

    @Test(dataProvider = NOT_PREVIOUS)
    public final void testIsConsecutiveTo_NotPrevious(final Integer lowerA,
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

    @Test(dataProvider = PREVIOUS)
    public final void testIsConsecutiveTo_Previous(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(IntervalArithmeticsUtils.isRightAfter(intervalA,
                intervalB));
    }

    @Test(dataProvider = PREVIOUS)
    public final void testIsConsecutiveTo_Previous_Asymmetric(
            final Integer lowerA, final Integer upperA, final Integer lowerB,
            final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(IntervalArithmeticsUtils.isRightBefore(intervalB,
                intervalA));
    }

    @Test(dataProvider = PREVIOUS)
    public final void testIsContaining(final Integer lowerA,
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

    @Test(dataProvider = PREVIOUS)
    public final void testIsContaining_Symmetric(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        Assert.assertTrue(!IntervalArithmeticsUtils.isContaining(intervalB,
                intervalA));
    }

    @Test(dataProvider = PREVIOUS)
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

        Assert.assertTrue(IntervalArithmeticsUtils.isNextTo(intervalA, intervalB));
    }

    @Test(dataProvider = PREVIOUS)
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

        Assert.assertTrue(!IntervalArithmeticsUtils.isOverlapped(intervalA,
                intervalB));
    }

    @Test(dataProvider = PREVIOUS)
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

        Assert.assertTrue(!IntervalArithmeticsUtils.isOverlapped(intervalB,
                intervalA));
    }
}
