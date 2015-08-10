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
package com.wandrell.tabletop.testing.utils.framework.conf.factory.raw;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.pattern.parser.xml.FilteredEntriesXMLFileParser;
import com.wandrell.pattern.parser.xml.XMLFileParser;
import com.wandrell.tabletop.testing.utils.framework.conf.IntervalParametersConf;
import com.wandrell.tabletop.testing.utils.framework.conf.TestXMLConf;
import com.wandrell.tabletop.testing.utils.framework.util.parser.IntervalContainingValueDocumentParser;
import com.wandrell.tabletop.testing.utils.framework.util.parser.IntervalDifferenceDocumentParser;
import com.wandrell.tabletop.testing.utils.framework.util.parser.IntervalPairDocumentParser;

public final class IntervalTestRawParametersFactory {

    private static IntervalTestRawParametersFactory instance;
    private static Object                           lockConsecutive        = new Object();
    private static Object                           lockContained          = new Object();
    private static Object                           lockContaining         = new Object();
    private static Object                           lockContainingValue    = new Object();
    /**
     * Lock for synchronizing the instance creation.
     */
    private static Object                           lockInstance           = new Object();
    private static Object                           lockInvalid            = new Object();
    private static Object                           lockLowerDiff          = new Object();
    private static Object                           lockNotConsecutive     = new Object();
    private static Object                           lockNotContained       = new Object();
    private static Object                           lockNotContaining      = new Object();
    private static Object                           lockNotContainingValue = new Object();
    private static Object                           lockNotPrevious        = new Object();
    private static Object                           lockPrevious           = new Object();
    private static Object                           lockUpperDiff          = new Object();
    private static Object                           lockValid              = new Object();
    private static Collection<Collection<Object>>   valuesConsecutive;
    private static Collection<Collection<Object>>   valuesContained;
    private static Collection<Collection<Object>>   valuesContaining;
    private static Collection<Collection<Object>>   valuesContainingValueContained;
    private static Collection<Collection<Object>>   valuesContainingValueNotContained;
    private static Collection<Collection<Object>>   valuesInvalid;
    private static Collection<Collection<Object>>   valuesLowerDifference;
    private static Collection<Collection<Object>>   valuesNotConsecutive;
    private static Collection<Collection<Object>>   valuesNotContained;
    private static Collection<Collection<Object>>   valuesNotContaining;
    private static Collection<Collection<Object>>   valuesNotPrevious;
    private static Collection<Collection<Object>>   valuesPrevious;
    private static Collection<Collection<Object>>   valuesUpperDifference;
    private static Collection<Collection<Object>>   valuesValid;

    public static final IntervalTestRawParametersFactory getInstance() {
        if (instance == null) {
            synchronized (lockInstance) {
                if (instance == null) {
                    instance = new IntervalTestRawParametersFactory();
                }
            }
        }

        return instance;
    }

    private IntervalTestRawParametersFactory() {
        super();
    }

    public final Collection<Collection<Object>> getConsecutiveValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesConsecutive == null) {
            synchronized (lockConsecutive) {
                if (valuesConsecutive == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_CONSECUTIVE);

                    valuesConsecutive = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesConsecutive);
    }

    public final Collection<Collection<Object>> getContainedValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesContained == null) {
            synchronized (lockContained) {
                if (valuesContained == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINED);

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesContained = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesContained);
    }

    public final Collection<Collection<Object>> getContainingValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesContaining == null) {
            synchronized (lockContaining) {
                if (valuesContaining == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINING);

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesContaining = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesContaining);
    }

    public final Collection<Collection<Object>> getContainingValueValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesContainingValueContained == null) {
            synchronized (lockContainingValue) {
                if (valuesContainingValueContained == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalContainingValueDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINED);

                    valuesContainingValueContained = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTAINING_VALUE)));
                }
            }
        }

        return Collections
                .unmodifiableCollection(valuesContainingValueContained);
    }

    public final Collection<Collection<Object>> getInvalidValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesInvalid == null) {
            synchronized (lockInvalid) {
                if (valuesInvalid == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID);

                    valuesInvalid = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesInvalid);
    }

    public final Collection<Collection<Object>> getLowerDifferenceValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesLowerDifference == null) {
            synchronized (lockLowerDiff) {
                if (valuesLowerDifference == null) {
                    parserFile = new XMLFileParser();
                    parserParams = new IntervalDifferenceDocumentParser();

                    valuesLowerDifference = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.LOWER_DIFFERENCE)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesLowerDifference);
    }

    public final Collection<Collection<Object>> getNotConsecutiveValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesNotConsecutive == null) {
            synchronized (lockNotConsecutive) {
                if (valuesNotConsecutive == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_CONSECUTIVE);
                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesNotConsecutive = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesNotConsecutive);
    }

    public final Collection<Collection<Object>> getNotContainedValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesNotContained == null) {
            synchronized (lockNotContained) {
                if (valuesNotContained == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINED);
                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesNotContained = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesNotContained);
    }

    public final Collection<Collection<Object>> getNotContainingValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesNotContaining == null) {
            synchronized (lockNotContaining) {
                if (valuesNotContaining == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINING);
                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesNotContaining = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesNotContaining);
    }

    public final Collection<Collection<Object>> getNotContainingValueValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesContainingValueNotContained == null) {
            synchronized (lockNotContainingValue) {
                if (valuesContainingValueNotContained == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalContainingValueDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_CONTAINED);

                    valuesContainingValueNotContained = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTAINING_VALUE)));
                }
            }
        }

        return Collections
                .unmodifiableCollection(valuesContainingValueNotContained);
    }

    public final Collection<Collection<Object>> getNotPreviousValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesNotPrevious == null) {
            synchronized (lockNotPrevious) {
                if (valuesNotPrevious == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_PREVIOUS);
                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID_B);

                    valuesNotPrevious = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesNotPrevious);
    }

    public final Collection<Collection<Object>> getPreviousValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesPrevious == null) {
            synchronized (lockPrevious) {
                if (valuesPrevious == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRequiredAttribute(
                            TestXMLConf.ATTRIBUTE_PREVIOUS);

                    valuesPrevious = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesPrevious);
    }

    public final Collection<Collection<Object>> getUpperDifferenceValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesUpperDifference == null) {
            synchronized (lockUpperDiff) {
                if (valuesUpperDifference == null) {
                    parserFile = new XMLFileParser();
                    parserParams = new IntervalDifferenceDocumentParser();

                    valuesUpperDifference = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.UPPER_DIFFERENCE)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesUpperDifference);
    }

    public final Collection<Collection<Object>> getValidValues()
            throws Exception {
        final FilteredEntriesXMLFileParser parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        if (valuesValid == null) {
            synchronized (lockValid) {
                if (valuesValid == null) {
                    parserFile = new FilteredEntriesXMLFileParser("data");
                    parserParams = new IntervalPairDocumentParser();

                    parserFile.addRejectedAttribute(
                            TestXMLConf.ATTRIBUTE_INVALID);

                    valuesValid = parserParams
                            .parse(parserFile.parse(getClassPathReader(
                                    IntervalParametersConf.CONTRAST_INTERVAL)));
                }
            }
        }

        return Collections.unmodifiableCollection(valuesValid);
    }

    /**
     * Creates an {@code InputStream} pointing to the file specified by the
     * path, if it exists.
     * <p>
     * If any problem occurs during this process a {@code RuntimeException} is
     * thrown, or an {@code IllegalArgumentException} if the file is not found.
     * 
     * @param path
     *            the path to transform
     * @return an {@code InputStream} pointing to the path
     */
    private final InputStream getClassPathInputStream(final String path) {
        final URL url;                  // URL parsed from the path
        final InputStream stream;       // Stream for the file

        url = getClassPathURL(path);

        checkArgument(url != null,
                String.format("The path %s is invalid", path));

        try {
            stream = new BufferedInputStream(url.openStream());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return stream;
    }

    /**
     * Creates a {@code Reader} pointing to the file specified by the path, if
     * it exists.
     * <p>
     * If any problem occurs during this process a {@code RuntimeException} is
     * thrown, or an {@code IllegalArgumentException} if the file is not found.
     * 
     * @param path
     *            the path to transform
     * @return an {@code InputStream} pointing to the path
     */
    private final Reader getClassPathReader(final String path) {
        return new BufferedReader(
                new InputStreamReader(getClassPathInputStream(path)));
    }

    /**
     * Creates an {@code URL} pointing to the file specified by the path, if it
     * exists.
     * 
     * @param path
     *            the path to transform
     * @return an URL pointing inside the class path
     */
    private final URL getClassPathURL(final String path) {
        checkNotNull(path, "Received a null pointer as path");

        return this.getClass().getClassLoader().getResource(path);
    }

}
