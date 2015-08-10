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
package com.wandrell.tabletop.testing.utils.framework.conf.factory.parameter;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import com.wandrell.tabletop.testing.utils.framework.conf.factory.raw.IntervalTestRawParametersFactory;

public final class IntervalValuesTestParametersFactory {

    private static final IntervalValuesTestParametersFactory instance = new IntervalValuesTestParametersFactory();

    public static final IntervalValuesTestParametersFactory getInstance() {
        return instance;
    }

    private static final Iterator<Object[]> getIntervalParameters(
            final Collection<Collection<Object>> valuesTable) {
        final Collection<Object[]> result;

        result = new LinkedList<Object[]>();
        for (final Collection<Object> values : valuesTable) {
            result.add(values.toArray());
        }

        return result.iterator();
    }

    private IntervalValuesTestParametersFactory() {
        super();
    }

    public final Iterator<Object[]> getConsecutive() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getConsecutiveValues());
    }

    public final Iterator<Object[]> getContained() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getContainedValues());
    }

    public final Iterator<Object[]> getContaining() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getContainingValues());
    }

    public final Iterator<Object[]> getContainingValue() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getContainingValueValues());
    }

    public final Iterator<Object[]> getDefaultAndInvalid() throws Exception {
        final Collection<Object[]> result;
        Collection<Object> data;

        result = new LinkedList<Object[]>();
        for (final Collection<Object> values : IntervalTestRawParametersFactory
                .getInstance().getInvalidValues()) {
            data = new LinkedList<Object>();

            data.add(Integer.MIN_VALUE);
            data.add(Integer.MAX_VALUE);
            data.addAll(values);

            result.add(data.toArray());
        }

        return result.iterator();
    }

    public final Iterator<Object[]> getInvalid() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getInvalidValues());
    }

    public final Iterator<Object[]> getLowerDifference() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getLowerDifferenceValues());
    }

    public final Iterator<Object[]> getNotConsecutive() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getNotConsecutiveValues());
    }

    public final Iterator<Object[]> getNotContained() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getNotContainedValues());
    }

    public final Iterator<Object[]> getNotContaining() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getNotContainingValues());
    }

    public final Iterator<Object[]> getNotContainingValue() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getNotContainingValueValues());
    }

    public final Iterator<Object[]> getNotPrevious() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getNotPreviousValues());
    }

    public final Iterator<Object[]> getPrevious() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getPreviousValues());
    }

    public final Iterator<Object[]> getUpperDifference() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getUpperDifferenceValues());
    }

    public final Iterator<Object[]> getValid() throws Exception {
        return getIntervalParameters(IntervalTestRawParametersFactory
                .getInstance().getValidValues());
    }

}
