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
/**
 * Provides an API and default implementations for the intervals tables.
 * <p>
 * An intervals table is basically an interval divided into several smaller
 * intervals, each of them with a value assigned to it.
 * <p>
 * Commonly, all the intervals, are integer intervals and, obviously, they
 * create a bigger interval when joined. Still, it is also possible that the
 * contained intervals would overlap, or leave gaps, but this is not common.
 * <p>
 * It should be noted that these intervals are meant to be used for assigning
 * values to roll results, and this will affect their use and shape.
 * <p>
 * An example of these tables is Bloodbowl's weather table:
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
 * To use this table two dice of six sides are rolled, and the result is
 * compared to the first column. Then the weather event on the second column is
 * applied to the game.
 * <p>
 * This is all represented by the
 * {@link com.wandrell.tabletop.interval.table.IntervalsTable IntervalTable}
 * interface, and it's default implementation
 * {@link com.wandrell.tabletop.interval.table.DefaultIntervalsTable
 * DefaultIntervalTable}.
 */
package com.wandrell.tabletop.interval.table;
