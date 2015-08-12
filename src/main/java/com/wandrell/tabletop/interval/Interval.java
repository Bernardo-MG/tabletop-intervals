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
package com.wandrell.tabletop.interval;

/**
 * Interface for representing integer intervals. This interval will be
 * continuous, closed and discrete, containing only integers. Not proper
 * intervals, those where both extremes are equal, are considered valid.
 * <p>
 * The only constraint is that the lower limit can't be higher than the upper
 * limit, and viceversa. Also, {@code null} values are expected to be rejected.
 * <p>
 * Tabletop games commonly work with integer intervals because they use dice to
 * generate random values.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface Interval {

    /**
     * Returns interval's upper limit.
     * <p>
     * This is the right handed value on it's representation, and should be
     * higher or equal to the lower limit.
     * 
     * @return the upper limit
     */
    public Integer getLowerLimit();

    /**
     * Returns the interval's lower limit.
     * <p>
     * This is the left handed value on it's representation, and should be lower
     * or equal to the upper limit.
     * 
     * @return the lower limit
     */
    public Integer getUpperLimit();

}
