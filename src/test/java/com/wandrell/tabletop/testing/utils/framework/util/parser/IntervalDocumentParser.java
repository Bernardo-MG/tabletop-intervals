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

public final class IntervalDocumentParser implements
        Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
                                               .getLogger(IntervalDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public IntervalDocumentParser() {
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
        final Element interval;
        final Integer limitLower;
        final Integer limitUpper;

        interval = node.getChild(TestXMLConf.NODE_INTERVAL);

        limitLower = Integer.parseInt(interval.getChild(
                TestXMLConf.NODE_LOWER_LIMIT).getValue());
        limitUpper = Integer.parseInt(interval.getChild(
                TestXMLConf.NODE_UPPER_LIMIT).getValue());

        data = new LinkedList<Object>();
        data.add(limitLower);
        data.add(limitUpper);

        getLogger().debug(
                String.format("Read interval [%d,%d]", limitLower, limitUpper));

        return data;
    }

}
