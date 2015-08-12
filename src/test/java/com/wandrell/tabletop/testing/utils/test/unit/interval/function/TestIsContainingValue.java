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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

/**
 * Unit test for {@link IntervalArithmeticsUtils}, checking that the
 * {@code isContaining} method works as expected.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>A contained value is recognized as such.</li>
 * <li>A not contained value is recognized as such.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestIsContainingValue {

    /**
     * Default constructor.
     */
    public TestIsContainingValue() {
        super();
    }

    /**
     * Tests that a contained value is recognized as such.
     */
    @Test
    public final void testIsContaining_Contained() {
        final Interval intervalA; // Interval for testing

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Assert.assertTrue(IntervalArithmeticsUtils.isContaining(intervalA, 1));
    }

    /**
     * Tests that a not contained value is recognized as such.
     */
    @Test
    public final void testIsContaining_NotContained() {
        final Interval intervalA; // Interval for testing

        intervalA = Mockito.mock(Interval.class);

        Mockito.when(intervalA.getLowerLimit()).thenReturn(1);
        Mockito.when(intervalA.getUpperLimit()).thenReturn(10);

        Assert.assertTrue(
                !IntervalArithmeticsUtils.isContaining(intervalA, 11));
    }

}
