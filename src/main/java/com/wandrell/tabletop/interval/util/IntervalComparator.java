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
package com.wandrell.tabletop.interval.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Comparator;

import com.wandrell.tabletop.interval.Interval;

/**
 * Comparator for sorting {@link Interval} instances.
 * <p>
 * They will be compared based on the lower limit.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class IntervalComparator
        implements Comparator<Interval>, Serializable {

    /**
     * Serialization value.
     */
    private static final long serialVersionUID = 2242823598874420432L;

    /**
     * Constructs the {@code IntervalComparator}.
     */
    public IntervalComparator() {
        super();
    }

    @Override
    public int compare(final Interval intervalA, final Interval intervalB) {
        checkNotNull(intervalA,
                "Received a null pointer as the first interval");
        checkNotNull(intervalB,
                "Received a null pointer as the second interval");

        return Integer.compare(intervalA.getLowerLimit(),
                intervalB.getLowerLimit());
    }

}
