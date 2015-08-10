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

public final class IntervalDifferenceDocumentParser implements
        Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
                                               .getLogger(IntervalDifferenceDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public IntervalDifferenceDocumentParser() {
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
        final Element intervalA;
        final Element intervalB;
        final Element intersection;
        final Integer limitLowerA;
        final Integer limitUpperA;
        final Integer limitLowerB;
        final Integer limitUpperB;
        final Integer limitLowerC;
        final Integer limitUpperC;

        intervalA = node.getChild(TestXMLConf.NODE_INTERVAL_A);
        intervalB = node.getChild(TestXMLConf.NODE_INTERVAL_B);
        intersection = node.getChild(TestXMLConf.NODE_DIFFERENCE);

        limitLowerA = Integer.parseInt(intervalA.getChild(
                TestXMLConf.NODE_LOWER_LIMIT).getValue());
        limitUpperA = Integer.parseInt(intervalA.getChild(
                TestXMLConf.NODE_UPPER_LIMIT).getValue());

        limitLowerB = Integer.parseInt(intervalB.getChild(
                TestXMLConf.NODE_LOWER_LIMIT).getValue());
        limitUpperB = Integer.parseInt(intervalB.getChild(
                TestXMLConf.NODE_UPPER_LIMIT).getValue());

        if (intersection.getChildren().size() > 0) {
            limitLowerC = Integer.parseInt(intersection.getChild(
                    TestXMLConf.NODE_LOWER_LIMIT).getValue());
            limitUpperC = Integer.parseInt(intersection.getChild(
                    TestXMLConf.NODE_UPPER_LIMIT).getValue());
        } else {
            limitLowerC = null;
            limitUpperC = null;
        }

        data = new LinkedList<Object>();
        data.add(limitLowerA);
        data.add(limitUpperA);

        data.add(limitLowerB);
        data.add(limitUpperB);

        data.add(limitLowerC);
        data.add(limitUpperC);

        getLogger()
                .debug(String
                        .format("Read intervals [%d,%d] and [%d,%d] with result [%d,%d]",
                                limitLowerA, limitUpperA, limitLowerB,
                                limitUpperB, limitLowerC, limitUpperC));

        return data;
    }

}
