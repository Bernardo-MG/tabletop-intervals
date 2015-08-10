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

import java.util.Map;

/**
 * Represents a table where sections of an interval are mapped to different
 * values. Meaning that the main interval is divided into a series of smaller
 * ones, each of them having some sort of value assigned.
 * <p>
 * Commonly, all the intervals, both the main and the contained ones, are
 * integer intervals and, obviously, the contained intervals are contained in
 * the main one, are consecutive one to another and create the main one when
 * joined. Still, it is also possible that the contained intervals would
 * overlap, or leave gaps, but this is not common.
 * <p>
 * Apart from this there are no other constraints, allowing negative values or
 * not proper intervals to be used.
 * <p>
 * Each of the contained intervals is mapped to a value whose type can not be
 * predicted, it can range items of any kind such as weapons or armor, to more
 * abstract concepts like deployment zones or in-game events.
 * <p>
 * For example, this is Bloodbowl's weather table:
 * <table summary="Interval table example">
 * <tr>
 * <th>Interval</th>
 * <th>Result</th>
 * </tr>
 * <tr>
 * <td>2</td>
 * <td>Sweltering Heat</td>
 * </tr>
 * <tr>
 * <td>3</td>
 * <td>Very Sunny</td>
 * </tr>
 * <tr>
 * <td>4-10</td>
 * <td>Nice</td>
 * </tr>
 * <tr>
 * <td>11</td>
 * <td>Pouring Rain</td>
 * </tr>
 * <tr>
 * <td>12</td>
 * <td>Blizzard</td>
 * </tr>
 * </table>
 * <p>
 * In this case, two dice of six sides are rolled, and the result is compared to
 * the first column. Then the event on the second column is applied to the game.
 * <p>
 * This represents a common use, as interval tables are commonly used to
 * generate non-numeric random values with the use or dice.
 * </p>
 * 
 * @author Bernardo Martínez Garrido
 * @version 0.1.0
 * @param <V>
 *            the type of the assigned values
 */
public interface IntervalTable<V> {

    /**
     * Returns all the intervals and their assigned values.
     * 
     * @return all the values and their range
     */
    public Map<Interval, V> getIntervals();

    /**
     * Returns the lower limit of the table.
     * 
     * @return the lower limit
     */
    public Integer getLowerLimit();

    /**
     * Returns the upper limit of the table.
     * 
     * @return the upper limit
     */
    public Integer getUpperLimit();

    /**
     * Gets the value assigned to the specified number.
     * <p>
     * Searches for the interval containing the number, and then returns the
     * value assigned to it.
     * <p>
     * If the value is not contained on the table, it is expected to indicate it
     * through an {@code IndexOutOfBoundsException} exception.
     * 
     * @param number
     *            the number whose value to find
     * @return the value assigned to the number
     */
    public V getValue(final Integer number);

}
