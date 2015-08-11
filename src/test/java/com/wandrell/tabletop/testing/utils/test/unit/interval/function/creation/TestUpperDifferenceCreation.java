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

public final class TestUpperDifferenceCreation {

    public TestUpperDifferenceCreation() {
        super();
    }

    @Test
    public final void testUpperDifference() {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(2);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(7);

        intervalResult = IntervalArithmeticsUtils.getUpperDifference(intervalA,
                intervalB);

        Assert.assertEquals(intervalResult.getLowerLimit(), (Integer) 8);
        Assert.assertEquals(intervalResult.getUpperLimit(), (Integer) 10);
    }

    @Test
    public final void testUpperDifference_NotProper() {
        final Interval intervalA;
        final Interval intervalB;
        final Interval intervalResult;

        intervalA = Mockito.mock(Interval.class);
        intervalB = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Mockito.when(intervalB.getLowerLimit()).thenReturn(2);
        Mockito.when(intervalB.getUpperLimit()).thenReturn(9);

        intervalResult = IntervalArithmeticsUtils.getUpperDifference(intervalA,
                intervalB);

        Assert.assertEquals(intervalResult.getLowerLimit(), (Integer) 10);
        Assert.assertEquals(intervalResult.getUpperLimit(), (Integer) 10);
    }

}
