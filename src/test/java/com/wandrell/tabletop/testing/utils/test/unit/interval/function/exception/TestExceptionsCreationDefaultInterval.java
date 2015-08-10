package com.wandrell.tabletop.testing.utils.test.unit.interval.function.exception;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalOperationUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestExceptionsCreationDefaultInterval {

    private static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance().getInvalid();
    }

    public TestExceptionsCreationDefaultInterval() {
        super();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsContaining_Value(final Integer lower,
            final Integer upper) {
        final Interval interval;

        interval = Mockito.mock(Interval.class);

        Mockito.when(interval.getLowerLimit()).thenReturn(lower);
        Mockito.when(interval.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isContaining(interval, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsContainingInterval_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.isContaining(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsContainingInterval_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isContaining(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsNextTo_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.isNextTo(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsNextTo_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isNextTo(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsOverlapped_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.isOverlapped(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsOverlapped_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isOverlapped(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsRightAfter_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.isRightAfter(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsRightAfter_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isRightAfter(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsRightBefore_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.isRightBefore(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testIsRightBefore_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.isRightBefore(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testLowerDifference_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.getLowerDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testLowerDifference_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.getLowerDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testUpperDifference_First(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upper);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        IntervalOperationUtils.getUpperDifference(intervalA, intervalB);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testUpperDifference_Second(final Integer lower,
            final Integer upper) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(Integer.MIN_VALUE);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(Integer.MAX_VALUE);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lower);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upper);

        IntervalOperationUtils.getUpperDifference(intervalA, intervalB);
    }

}
