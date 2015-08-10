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
package com.wandrell.tabletop.testing.utils.framework.util.parser;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.testing.utils.framework.conf.TestXMLConf;

public final class IntervalContainingValueDocumentParser implements
        Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
                                               .getLogger(IntervalContainingValueDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public IntervalContainingValueDocumentParser() {
        super();
    }

    @Override
    public final Collection<Collection<Object>> parse(final Document doc) {
        final Collection<Collection<Object>> colData;

        colData = new LinkedHashSet<Collection<Object>>();
        for (final Element node : doc.getRootElement().getChildren()) {
            colData.add(readNode(node));
        }

        return colData;
    }

    private final Collection<Object> readNode(final Element node) {
        final Integer value;
        final Collection<Object> data;
        final Element interval;
        final Integer limitLower;
        final Integer limitUpper;

        interval = node.getChild(TestXMLConf.NODE_INTERVAL);

        limitLower = Integer.parseInt(interval.getChild(
                TestXMLConf.NODE_LOWER_LIMIT).getValue());
        limitUpper = Integer.parseInt(interval.getChild(
                TestXMLConf.NODE_UPPER_LIMIT).getValue());

        value = Integer.parseInt(node.getChild(TestXMLConf.NODE_VALUE)
                .getText());

        data = new LinkedList<Object>();
        data.add(limitLower);
        data.add(limitUpper);
        data.add(value);

        getLogger().debug(
                String.format("Read value %d in interval [%d,%d]", value,
                        limitLower, limitUpper));

        return data;
    }

}
