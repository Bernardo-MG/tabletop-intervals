/**
 * Copyright 2013-2014 the original author or authors
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
 * Represent an integer interval. This means that the interval is continuous,
 * closed and discrete, containing only integers.
 * <p>
 * The only constraint is that the lower limit can't be higher than the upper
 * limit, and viceversa. Also, {@code null} values are expected to be rejected.
 * 
 * @author Bernardo Martínez Garrido
 * @version 0.1.0
 */
public interface Interval {

    /**
     * Returns the interval as a string.
     * 
     * @return the interval as a string
     */
    public String asString();

    /**
     * Returns interval's upper limit.
     * 
     * @return the upper limit
     */
    public Integer getLowerLimit();

    /**
     * Returns the interval's lower limit.
     * 
     * @return the lower limit
     */
    public Integer getUpperLimit();

    /**
     * Sets the interval's lower limit.
     * 
     * @param lowerLimit
     *            the lower limit
     */
    public void setLowerLimit(final Integer lowerLimit);

    /**
     * Sets the interval's upper limit.
     * 
     * @param upperLimit
     *            the upper limit
     */
    public void setUpperLimit(final Integer upperLimit);

}
