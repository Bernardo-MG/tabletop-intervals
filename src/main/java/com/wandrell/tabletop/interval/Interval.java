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
 * continuous, closed and discrete, containing only integers.
 * <p>
 * The only constraint is that the lower limit can't be higher than the upper
 * limit, and viceversa. Also, {@code null} values are expected to be rejected.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface Interval {

    /**
     * Returns interval's upper limit.
     * 
     * @return the upper limit
     */
    public Integer getLowerLimit();

    /**
     * Returns the interval as a string.
     * <p>
     * If the interval has the value 5 as it's lower limit, and the value 7 as
     * it's upper limit, then the string will be "[5,7]".
     * 
     * @return the interval as a string
     */
    public String getStringRepresentation();

    /**
     * Returns the interval's lower limit.
     * 
     * @return the lower limit
     */
    public Integer getUpperLimit();

}
