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
package com.wandrell.tabletop.testing.utils.test.unit.interval.function.exception;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.util.IntervalArithmeticsUtils;

/**
 * Unit test for {@link IntervalArithmeticsUtils}, checking that exceptions are
 * thrown by the {@code isContaining} when the arguments are invalid.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown when the interval is
 * invalid.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionsContainingValue {

    /**
     * Default constructor.
     */
    public TestExceptionsContainingValue() {
        super();
    }

    /**
     * Tests that an {@code IllegalArgumentException} is thrown when the
     * interval is invalid.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testIsContaining_Value() {
        final Interval interval; // Interval for testing

        interval = Mockito.mock(Interval.class);

        Mockito.when(interval.getLowerLimit()).thenReturn(10);
        Mockito.when(interval.getUpperLimit()).thenReturn(1);

        IntervalArithmeticsUtils.isContaining(interval, 0);
    }

}
