package com.wandrell.tabletop.testing.utils.test.unit.interval.function.creation;

import java.util.Iterator;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestUpperDifferenceCreation {

    private static final String DATA = "data";

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance()
                .getUpperDifference();
    }

    public TestUpperDifferenceCreation() {
        super();
    }

    @Test(dataProvider = DATA)
    public final void testUpperDifference(final Integer lowerA,
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

        intervalResult = IntervalArithmeticsUtils.getUpperDifference(intervalA,
                intervalB);

        if (lowerE != null) {
            Assert.assertEquals(intervalResult.getLowerLimit(), lowerE);
            Assert.assertEquals(intervalResult.getUpperLimit(), upperE);
        } else {
            Assert.assertNull(intervalResult);
        }
    }

    @Test(dataProvider = DATA)
    public final void testUpperDifference_Symmetric(final Integer lowerA,
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

        intervalResult = IntervalArithmeticsUtils.getUpperDifference(intervalB,
                intervalA);

        if (lowerE != null) {
            Assert.assertEquals(intervalResult.getLowerLimit(), lowerE);
            Assert.assertEquals(intervalResult.getUpperLimit(), upperE);
        } else {
            Assert.assertNull(intervalResult);
        }
    }

}
