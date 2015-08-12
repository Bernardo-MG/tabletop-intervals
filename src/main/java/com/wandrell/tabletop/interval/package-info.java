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
 * Provides an API and default implementations for the interval structures used
 * on tabletop games.
 * <p>
 * The shape these structures take is always marked by the fact that tabletop
 * games use dice to generate random numbers. And these commonly contain on
 * their facets a continuous interval of integers.
 * <h2>Interval</h2>
 * <p>
 * The basic interval is represented by the interface
 * {@link com.wandrell.tabletop.interval.Interval Interval}, and it's default
 * implementation {@link com.wandrell.tabletop.interval.DefaultInterval
 * DefaultInterval}.
 * <h2>Interval Table</h2>
 * <p>
 * A more complex type of interval is the interval table. This is basically an
 * interval divided into several smaller intervals, each of them with a value
 * assigned to it.
 * <p>
 * This is represented by the
 * {@link com.wandrell.tabletop.interval.table.IntervalsTable IntervalTable}
 * interface, and it's default implementation
 * {@link com.wandrell.tabletop.interval.table.DefaultIntervalsTable
 * DefaultIntervalTable}, which are kept in the
 * {@link com.wandrell.tabletop.interval.table table} package.
 */
package com.wandrell.tabletop.interval;
