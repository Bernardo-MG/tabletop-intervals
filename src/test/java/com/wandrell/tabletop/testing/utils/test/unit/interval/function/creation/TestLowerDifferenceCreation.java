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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function.creation;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

public final class TestLowerDifferenceCreation {

    public TestLowerDifferenceCreation() {
        super();
    }

    @Test
    public final void testLowerDifference() {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(3);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(5);

        intervalResult = IntervalArithmeticsUtils.getLowerDifference(intervalA,
                intervalB);

        Assert.assertEquals(intervalResult.getLowerLimit(), (Integer) 1);
        Assert.assertEquals(intervalResult.getUpperLimit(), (Integer) 2);
    }

    @Test
    public final void testLowerDifference_NotProper() {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(2);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(5);

        intervalResult = IntervalArithmeticsUtils.getLowerDifference(intervalA,
                intervalB);

        Assert.assertEquals(intervalResult.getLowerLimit(), (Integer) 1);
        Assert.assertEquals(intervalResult.getUpperLimit(), (Integer) 1);
    }

}
