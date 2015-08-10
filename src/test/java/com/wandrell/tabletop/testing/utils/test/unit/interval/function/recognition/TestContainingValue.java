package com.wandrell.tabletop.testing.utils.test.unit.interval.function.recognition;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalOperationUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestContainingValue {

    private static final String INTERVAL_CONTAINED     = "interval_contained";
    private static final String INTERVAL_NOT_CONTAINED = "interval_not_contained";
    private static final String VALUE_CONTAINED        = "value_contained";
    private static final String VALUE_NOT_CONTAINED    = "value_not_contained";

    @DataProvider(name = INTERVAL_CONTAINED)
    public final static Iterator<Object[]> getIntervalsContained()
            throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getContainingValue();
    }

    @DataProvider(name = INTERVAL_NOT_CONTAINED)
    public final static Iterator<Object[]> getIntervalsNotContained()
            throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getNotContainingValue();
    }

    @DataProvider(name = VALUE_CONTAINED)
    public final static Iterator<Object[]> getValuesContained()
            throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getContainingValue();
    }

    @DataProvider(name = VALUE_NOT_CONTAINED)
    public final static Iterator<Object[]> getValuesNotContained()
            throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getNotContainingValue();
    }

    public TestContainingValue() {
        super();
    }

    @Test(dataProvider = INTERVAL_CONTAINED)
    public final void testIsContaining_Interval_Contained(final Integer lowerA,
            final Integer upperA, final Integer value) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(value);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(value);

        Assert.assertTrue(IntervalOperationUtils.isContaining(intervalA,
                intervalB));
    }

    @Test(dataProvider = INTERVAL_NOT_CONTAINED)
    public final void testIsContaining_Interval_NotContained(
            final Integer lowerA, final Integer upperA, final Integer value) {
        final Interval intervalA;
        final Interval intervalB;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(value);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(value);

        Assert.assertTrue(!IntervalOperationUtils.isContaining(intervalA,
                intervalB));
    }

    @Test(dataProvider = VALUE_CONTAINED)
    public final void testIsContaining_Value_Contained(final Integer lowerA,
            final Integer upperA, final Integer value) {
        final Interval intervalA;

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(IntervalOperationUtils.isContaining(intervalA, value));
    }

    @Test(dataProvider = VALUE_NOT_CONTAINED)
    public final void testIsContaining_Value_NotContained(final Integer lowerA,
            final Integer upperA, final Integer value) {
        final Interval intervalA;

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Assert.assertTrue(!IntervalOperationUtils
                .isContaining(intervalA, value));
    }

}
