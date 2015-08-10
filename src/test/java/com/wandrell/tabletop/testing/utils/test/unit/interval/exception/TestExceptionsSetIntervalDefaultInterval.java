package com.wandrell.tabletop.testing.utils.test.unit.interval.exception;

import java.util.Iterator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.DefaultInterval;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter.IntervalValuesTestParametersFactory;

public final class TestExceptionsSetIntervalDefaultInterval {

    private static final String DATA = "data";
    private Interval            interval;

    @DataProvider(name = DATA)
    public final static Iterator<Object[]> getData() throws Exception {
        return IntervalValuesTestParametersFactory.getInstance().getInvalid();
    }

    public TestExceptionsSetIntervalDefaultInterval() {
        super();
    }

    @BeforeClass
    public final void initialize() {
        interval = new DefaultInterval();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testSetLimits_Lower(final Integer lowerLimit,
            final Integer upperLimit) {
        interval.setUpperLimit(upperLimit);

        interval.setLowerLimit(lowerLimit);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            dataProvider = DATA)
    public final void testSetLimits_Upper(final Integer lowerLimit,
            final Integer upperLimit) {
        interval.setLowerLimit(lowerLimit);

        interval.setUpperLimit(upperLimit);
    }

}
