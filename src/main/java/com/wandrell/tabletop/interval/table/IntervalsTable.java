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
package com.wandrell.tabletop.interval.table;

import java.util.Map;

import com.wandrell.tabletop.interval.Interval;

/**
 * Interface for representing an intervals table. This is a table composed of
 * consecutive intervals, each of them having a value assigned to it. Another
 * way to see it is as an interval divided into several smaller intervals, each
 * with a value assigned to it.
 * <p>
 * Each of the contained intervals is mapped to a value, which can be anything.
 * Some common values are score points or items such as weapons or armor, but
 * may include more abstract concepts like deployment zones or in-game events.
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
 * Here weather events are mapped to the different intervals, some of them being
 * not proper intervals.
 * <p>
 * To use this table two dice of six sides are rolled, and the result is
 * compared to the first column. Then the weather event on the second column is
 * applied to the game.
 * 
 * @author Bernardo Martínez Garrido
 * @param <V>
 *            the type of the values assigned to the intervals
 */
public interface IntervalsTable<V> extends Interval {

    /**
     * Returns all the intervals and their assigned values.
     * 
     * @return all the values and their value
     */
    public Map<Interval, V> getIntervals();

    /**
     * Gets the value assigned to the specified number.
     * <p>
     * This will search for the interval containing the number, and then return
     * the value assigned to it.
     * <p>
     * If the value is not contained on the table, it is expected to indicate
     * this through an {@code IndexOutOfBoundsException} exception.
     * 
     * @param number
     *            the number whose value to find
     * @return the value assigned to the number
     */
    public V getValue(final Integer number);

}
