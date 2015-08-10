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

public final class DiceDocumentParser
        implements Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
            .getLogger(DiceDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public DiceDocumentParser() {
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
        final Collection<Object> data;
        final Integer quantity;
        final Integer sides;
        final Integer modifier;

        data = new LinkedList<Object>();

        quantity = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_QUANTITY).getText());
        sides = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_SIDES).getText());
        modifier = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_MODIFIER).getText());

        data.add(quantity);
        data.add(sides);
        data.add(modifier);

        if (modifier > 0) {
            getLogger().debug(String.format("Read dice %dd%d+%d", quantity,
                    sides, modifier));
        } else {
            getLogger().debug(String.format("Read dice %dd%d-%d", quantity,
                    sides, modifier));
        }

        return data;
    }

}
