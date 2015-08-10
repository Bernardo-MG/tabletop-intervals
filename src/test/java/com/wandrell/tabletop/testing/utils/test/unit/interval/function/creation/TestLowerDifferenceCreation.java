package com.wandrell.tabletop.testing.utils.test.unit.interval.function.creation;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalOperationUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestLowerDifferenceCreation {

    private static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getLowerDifference();
    }

    public TestLowerDifferenceCreation() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testLowerDifference(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB,
            final Integer lowerE, final Integer upperE) {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        intervalResult = IntervalOperationUtils.getLowerDifference(intervalA,
                intervalB);

        if (lowerE != null) {
            Assert.assertEquals(intervalResult.getLowerLimit(), lowerE);
            Assert.assertEquals(intervalResult.getUpperLimit(), upperE);
        } else {
            Assert.assertNull(intervalResult);
        }
    }

    @Test(dataProvider = DATA)
    public final void testLowerDifference_Symmetric(final Integer lowerA,
            final Integer upperA, final Integer lowerB, final Integer upperB,
            final Integer lowerE, final Integer upperE) {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(lowerA);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(upperA);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(lowerB);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(upperB);

        intervalResult = IntervalOperationUtils.getLowerDifference(intervalB,
                intervalA);

        if (lowerE != null) {
            Assert.assertEquals(intervalResult.getLowerLimit(), lowerE);
            Assert.assertEquals(intervalResult.getUpperLimit(), upperE);
        } else {
            Assert.assertNull(intervalResult);
        }
    }

}
