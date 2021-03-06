/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * Defines the Java API for XML Processing (JAXP), the Streaming API for XML (StAX),
 * the Simple API for XML (SAX), and the W3C Document Object Model (DOM) API.
 *
 * <h2 id="LookupMechanism">JAXP Lookup Mechanism</h2>
 * JAXP defines an ordered lookup procedure to determine the implementation class
 * to load for the JAXP factories. Factories that support the mechanism are listed
 * in the table below along with the method, System Property name, Configuration
 * File, and System Default method to be used in the procedure.
 *
 * <table class="plain" id="Factories">
 * <caption>JAXP Factories</caption>
 * <thead>
 * <tr>
 * <th scope="col">Factory</th>
 * <th scope="col">Method</th>
 * <th scope="col">System Property Name</th>
 * <th scope="col">Configuration File</th>
 * <th scope="col">System Default</th>
 * </tr>
 * </thead>
 *
 * <tbody>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="DOM">
 *     {@link javax.xml.parsers.DocumentBuilderFactory DocumentBuilderFactory}
 * </th>
 * <td>{@link javax.xml.parsers.DocumentBuilderFactory#newInstance() newInstance()}</td>
 * <td>{@code javax.xml.parsers.DocumentBuilderFactory}</td>
 * <td><a href="#JaxpProperties">jaxp.properties</a></td>
 * <td>{@link javax.xml.parsers.DocumentBuilderFactory#newDefaultInstance() newDefaultInstance()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="SAX">
 *     {@link javax.xml.parsers.SAXParserFactory SAXParserFactory}
 * </th>
 * <td>{@link javax.xml.parsers.SAXParserFactory#newInstance() newInstance()}</td>
 * <td>{@code javax.xml.parsers.SAXParserFactory}</td>
 * <td><a href="#JaxpProperties">jaxp.properties</a></td>
 * <td>{@link javax.xml.parsers.SAXParserFactory#newDefaultInstance() newDefaultInstance()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="StAXEvent">
 *     {@link javax.xml.stream.XMLEventFactory XMLEventFactory}
 * </th>
 * <td>{@link javax.xml.stream.XMLEventFactory#newFactory() newFactory()}</td>
 * <td>{@code javax.xml.stream.XMLEventFactory}</td>
 * <td>
 *     <a href="#StAXProperties">stax.properties</a> and then
 *     <a href="#JaxpProperties">jaxp.properties</a>
 * </td>
 * <td>{@link javax.xml.stream.XMLEventFactory#newDefaultFactory() newDefaultFactory()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="StAXInput">
 *     {@link javax.xml.stream.XMLInputFactory XMLInputFactory}
 * </th>
 * <td>{@link javax.xml.stream.XMLInputFactory#newFactory() newFactory()}</td>
 * <td>{@code javax.xml.stream.XMLInputFactory}</td>
 * <td>
 *     <a href="#StAXProperties">stax.properties</a> and then
 *     <a href="#JaxpProperties">jaxp.properties</a>
 * </td>
 * <td>{@link javax.xml.stream.XMLInputFactory#newDefaultFactory() newDefaultFactory()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="StAXOutput">
 *     {@link javax.xml.stream.XMLOutputFactory XMLOutputFactory}
 * </th>
 * <td>{@link javax.xml.stream.XMLOutputFactory#newFactory() newFactory()}</td>
 * <td>{@code javax.xml.stream.XMLOutputFactory}</td>
 * <td>
 *     <a href="#StAXProperties">stax.properties</a> and then
 *     <a href="#JaxpProperties">jaxp.properties</a>
 * </td>
 * <td>{@link javax.xml.stream.XMLOutputFactory#newDefaultFactory() newDefaultFactory()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="XSLT">
 *     {@link javax.xml.transform.TransformerFactory TransformerFactory}
 * </th>
 * <td>{@link javax.xml.transform.TransformerFactory#newInstance() newInstance()}</td>
 * <td>{@code javax.xml.transform.TransformerFactory}</td>
 * <td><a href="#JaxpProperties">jaxp.properties</a></td>
 * <td>{@link javax.xml.transform.TransformerFactory#newDefaultInstance() newDefaultInstance()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="Validation">
 *     {@link javax.xml.validation.SchemaFactory SchemaFactory}
 * </th>
 * <td>{@link javax.xml.validation.SchemaFactory#newInstance(java.lang.String) newInstance(schemaLanguage)}</td>
 * <td>{@code javax.xml.validation.SchemaFactory:}<i>schemaLanguage</i>[1]</td>
 * <td><a href="#JaxpProperties">jaxp.properties</a></td>
 * <td>{@link javax.xml.validation.SchemaFactory#newDefaultInstance() newDefaultInstance()}</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="XPath">
 *     {@link javax.xml.xpath.XPathFactory XPathFactory}
 * </th>
 * <td>{@link javax.xml.xpath.XPathFactory#newInstance(java.lang.String) newInstance(uri)}</td>
 * <td>{@link javax.xml.xpath.XPathFactory#DEFAULT_PROPERTY_NAME DEFAULT_PROPERTY_NAME} + ":uri"[2]</td>
 * <td><a href="#JaxpProperties">jaxp.properties</a></td>
 * <td>{@link javax.xml.xpath.XPathFactory#newDefaultInstance() newDefaultInstance()}</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * <b>[1]</b> where <i>schemaLanguage</i> is the parameter to the
 * {@link javax.xml.validation.SchemaFactory#newInstance(java.lang.String) newInstance(schemaLanguage)}
 * method.
 * <p>
 * <b>[2]</b> where <i>uri</i> is the parameter to the
 * {@link javax.xml.xpath.XPathFactory#newInstance(java.lang.String) newInstance(uri)}
 * method.
 *
 * <h3 id="JaxpProperties">jaxp.properties</h3>
 * {@code jaxp.properties} is a configuration file in standard
 * {@link java.util.Properties} format and typically located in the {@code conf}
 * directory of the Java installation. It contains the fully qualified
 * name of the implementation class with the key being the system property name
 * defined in <a href="#Factories">the table</a> above.
 * <p>
 * The {@code jaxp.properties} file is read only once by the implementation and
 * the values are then cached for future use.  If the file does not exist when
 * the first attempt is made to read from it, no further attempts
 * are made to check for its existence. It is not possible to change the value
 * of any property after it has been read for the first time.
 *
 * <h3 id="StAXProperties">stax.properties</h3>
 * {@code stax.properties} is a configuration file that functions the same as
 * {@code jaxp.properties} except that it is only used by StAX factory lookup.
 *
 * <h3 id="LookupProcedure">Lookup Procedure</h3>
 * The <a href="#Factories">JAXP Factories</a> follow the procedure described
 * below in order to locate and load the implementation class:
 *
 * <ul>
 * <li>
 * Use the system property as described in column System Property of the table
 * <a href="#Factories">JAXP Factories</a> above.
 * </li>
 * <li>
 * <p>
 * Use the configuration file <a href="#JaxpProperties">jaxp.properties</a> as
 * indicated in the table <a href="#Factories">JAXP Factories</a>. For StAX,
 * if <a href="#StAXProperties">stax.properties</a> exists, the factories will
 * first attempt to read from it instead of <a href="#JaxpProperties">jaxp.properties</a>.
 * </li>
 * <li>
 * <p>
 * Use the service-provider loading facility, defined by the
 * {@link java.util.ServiceLoader} class, to attempt to locate and load an
 * implementation of the service using the {@linkplain
 * java.util.ServiceLoader#load(java.lang.Class) default loading mechanism}:
 * the service-provider loading facility will use the {@linkplain
 * java.lang.Thread#getContextClassLoader() current thread's context class loader}
 * to attempt to load the service. If the context class
 * loader is null, the {@linkplain
 * ClassLoader#getSystemClassLoader() system class loader} will be used.
 *
 * <h3>{@link javax.xml.validation.SchemaFactory SchemaFactory}</h3>
 * In case of the {@link javax.xml.validation.SchemaFactory SchemaFactory},
 * each potential service provider is required to implement the method
 * {@link javax.xml.validation.SchemaFactory#isSchemaLanguageSupported(java.lang.String)
 * isSchemaLanguageSupported(String schemaLanguage)}.
 * The first service provider found that supports the specified schema language
 * is returned.
 *
 * <h3>{@link javax.xml.xpath.XPathFactory XPathFactory}</h3>
 * In case of the {@link javax.xml.xpath.XPathFactory XPathFactory},
 * each potential service provider is required to implement the method
 * {@link javax.xml.xpath.XPathFactory#isObjectModelSupported(String objectModel)
 * isObjectModelSupported(String objectModel)}.
 * The first service provider found that supports the specified object model is
 * returned.
 * </li>
 * <li>
 * <p>
 * Otherwise, the {@code system-default} implementation is returned, which is
 * equivalent to calling the {@code newDefaultInstance() or newDefaultFactory()}
 * method as shown in column System Default of the table
 * <a href="#Factories">JAXP Factories</a> above.
 *
 * <h3>{@link javax.xml.validation.SchemaFactory SchemaFactory}</h3>
 * In case of the {@link javax.xml.validation.SchemaFactory SchemaFactory},
 * there must be a {@linkplain javax.xml.validation.SchemaFactory#newDefaultInstance()
 * platform default} {@code SchemaFactory} for W3C XML Schema.
 *
 * <h3>{@link javax.xml.xpath.XPathFactory XPathFactory}</h3>
 * In case of the {@link javax.xml.xpath.XPathFactory XPathFactory},
 * there must be a
 * {@linkplain javax.xml.xpath.XPathFactory#newDefaultInstance() platform default}
 * {@code XPathFactory} for the W3C DOM, i.e.
 * {@link javax.xml.xpath.XPathFactory#DEFAULT_OBJECT_MODEL_URI DEFAULT_OBJECT_MODEL_URI}.
 * </li>
 * </ul>
 *
 * @implNote
 * <h2>Implementation Specific Features and Properties</h2>
 *
 * In addition to the standard features and properties described within the public
 * APIs of this module, the JDK implementation supports a further number of
 * implementation specific features and properties. This section describes the
 * naming convention, System Properties, jaxp.properties, scope and order,
 * and processors to which a property applies. A table listing the implementation
 * specific features and properties which the implementation currently supports
 * can be found at the end of this note.
 *
 * <h3>Naming Convention</h3>
 * The names of the features and properties are fully qualified, composed of a
 * prefix and name.
 *
 * <h4>Prefix</h4>
 * The prefix for JDK properties is defined as:
 * <pre>
 *     {@code http://www.oracle.com/xml/jaxp/properties/}
 * </pre>
 *
 * The prefix for features:
 * <pre>
 *     {@code http://www.oracle.com/xml/jaxp/features/}
 * </pre>
 *
 * The prefix for System Properties:
 * <pre>
 *     {@code jdk.xml.}
 * </pre>
 *
 * <h4>Name</h4>
 * A name may consist of one or multiple words that are case-sensitive.
 * All letters of the first word are in lowercase, while the first letter of
 * each subsequent word is capitalized.
 * <p>
 * An example of a property that indicates whether an XML document is standalone
 * would thus have a format:
 * <pre>
 *     {@code http://www.oracle.com/xml/jaxp/properties/isStandalone}
 * </pre>
 * and a corresponding System Property:
 * <pre>
 *     {@systemProperty jdk.xml.isStandalone}
 * </pre>
 *
 * <h3>System Properties</h3>
 * A property may have a corresponding System Property that has the same name
 * except for the prefix as shown above. A System Property should be set prior
 * to the creation of a processor and may be cleared afterwards.
 *
 * <h3>jaxp.properties</h3>
 * A system property can be specified in the <a href="#JaxpProperties">jaxp.properties</a>
 * file to set the behavior for all invocations of the JDK. The format is
 * {@code system-property-name=value}. For example:
 * <pre>
 *     {@code jdk.xml.isStandalone=true}
 * </pre>
 *
 * <h3 id="ScopeAndOrder">Scope and Order</h3>
 * The {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature
 * (hereafter referred to as secure processing) is required for XML processors
 * including DOM, SAX, Schema Validation, XSLT, and XPath. Any properties flagged
 * as {@code "security: yes"} (hereafter referred to as security properties) in
 * table <a href="#Properties">Implementation Specific Properties</a>
 * are enforced when secure processing is set to true. Such enforcement includes
 * setting security features to true and limits to the defined values shown in
 * the table. The property values will not be affected, however, when setting
 * secure processing to false.
 * <p>
 * When the Java Security Manager is present, secure processing is set to true
 * and can not be turned off. The security properties are therefore enforced.
 * <p>
 * Properties specified in the jaxp.properties file affect all invocations of
 * the JDK, and will override their default values, or those that may have been
 * set by secure processing.
 * <p>
 * System properties, when set, affect the invocation of the JDK and override
 * the default settings or those that may have been set in jaxp.properties or
 * by secure processing.
 * <p>
 * JAXP properties specified through JAXP factories or processors (e.g. SAXParser)
 * take preference over system properties, the jaxp.properties file, as well as
 * secure processing.
 *
 * <h3 id="Processor">Processor Support</h3>
 * Features and properties may be supported by one or more processors. The
 * following table lists the processors by IDs that can be used for reference.
 *
 * <table class="plain" id="Processors">
 * <caption>Processors</caption>
 * <thead>
 * <tr>
 * <th scope="col">ID</th>
 * <th scope="col">Name</th>
 * <th scope="col">How to set the property</th>
 * </tr>
 * </thead>
 *
 * <tbody>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="DOM">DOM</th>
 * <td>DOM Parser</td>
 * <td>
 * {@code DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();}<br>
 * {@code dbf.setAttribute(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="SAX">SAX</th>
 * <td>SAX Parser</td>
 * <td>
 * {@code SAXParserFactory spf = SAXParserFactory.newInstance();}<br>
 * {@code SAXParser parser = spf.newSAXParser();}<br>
 * {@code parser.setProperty(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="StAX">StAX</th>
 * <td>StAX Parser</td>
 * <td>
 * {@code XMLInputFactory xif = XMLInputFactory.newInstance();}<br>
 * {@code xif.setProperty(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="Validation">Validation</th>
 * <td>XML Validation API</td>
 * <td>
 * {@code SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaLanguage);}<br>
 * {@code schemaFactory.setProperty(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="Transform">Transform</th>
 * <td>XML Transform API</td>
 * <td>
 * {@code TransformerFactory factory = TransformerFactory.newInstance();}<br>
 * {@code factory.setAttribute(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="XSLTCSerializer">XSLTC Serializer</th>
 * <td>XSLTC Serializer</td>
 * <td>
 * {@code Transformer transformer = TransformerFactory.newInstance().newTransformer();}<br>
 * {@code transformer.setOutputProperty(name, value);}
 * </td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="DOMLS">DOMLS</th>
 * <td>DOM Load and Save</td>
 * <td>
 * {@code LSSerializer serializer = domImplementation.createLSSerializer();} <br>
 * {@code serializer.getDomConfig().setParameter(name, value);}
 * </td>
 * </tr>
 * </tbody>
 * </table>
 *
 * <h3>Implementation Specific Features and Properties</h3>
 * The Implementation Specific Features and Properties reflect JDK's choice to
 * manage the limitations on resources while complying with the API specification,
 * or allow applications to alter behaviors beyond those required by the standards.
 * <p>
 * The table below lists the Implementation Specific Properties currently supported
 * by the JDK. More properties may be added in the future if necessary.
 *
 * <table class="striped" id="Properties">
 * <caption>Implementation Specific Properties</caption>
 * <thead>
 * <tr>
 * <th scope="col" rowspan="2">Name [1]</th>
 * <th scope="col" rowspan="2">Description</th>
 * <th scope="col" rowspan="2">System Property [2]</th>
 * <th scope="col" rowspan="2">jaxp.properties [2]</th>
 * <th scope="col" colspan="3" style="text-align:center">Value [3]</th>
 * <th scope="col" rowspan="2">Security [4]</th>
 * <th scope="col" rowspan="2">Supported Processor [5]</th>
 * <th scope="col" rowspan="2">Since [6]</th>
 * </tr>
 * <tr>
 * <th scope="col">Type</th>
 * <th scope="col">Value</th>
 * <th scope="col">Default</th>
 * </tr>
 * </thead>
 *
 * <tbody>
 *
 * <tr>
 * <th scope="row" style="font-weight:normal" id="EELimit">entityExpansionLimit</th>
 * <td>Limits the number of entity expansions.
 * </td>
 * <td rowspan="9">yes</td>
 * <td rowspan="9">yes</td>
 * <td rowspan="9">Integer</td>
 * <th scope="row" style="font-weight:normal" rowspan="9">
 * A positive integer. A value less than or equal to 0 indicates no limit.
 * If the value is not an integer, a NumberFormatException is thrown.
 * </th>
 * <th scope="row" style="font-weight:normal">64000</th>
 * <td rowspan="9">Yes</td>
 * <td rowspan="9">
 *     <a href="#DOM">DOM</a><br>
 *     <a href="#SAX">SAX</a><br>
 *     <a href="#StAX">StAX</a><br>
 *     <a href="#Validation">Validation</a><br>
 *     <a href="#Transform">Transform</a>
 * </td>
 * <td rowspan="9">8</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="EALimit">elementAttributeLimit</th>
 * <td>Limits the number of attributes an element can have.
 * </td>
 * <th scope="row" style="font-weight:normal">10000</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="OccurLimit">maxOccurLimit</th>
 * <td>Limits the number of content model nodes that may be created when building
 * a grammar for a W3C XML Schema that contains maxOccurs attributes with values
 * other than "unbounded".
 * </td>
 * <th scope="row" style="font-weight:normal">5000</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="SizeLimit">totalEntitySizeLimit</th>
 * <td>Limits the total size of all entities that include general and parameter
 * entities. The size is calculated as an aggregation of all entities.
 * </td>
 * <th scope="row" style="font-weight:normal">5x10^7</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="GELimit">maxGeneralEntitySizeLimit</th>
 * <td>Limits the maximum size of any general entities.
 * </td>
 * <th scope="row" style="font-weight:normal">0</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="PELimit">maxParameterEntitySizeLimit</th>
 * <td>Limits the maximum size of any parameter entities, including the result
 * of nesting multiple parameter entities.
 * </td>
 * <th scope="row" style="font-weight:normal">10^6</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="ERLimit">entityReplacementLimit</th>
 * <td>Limits the total number of nodes in all entity references.
 * </td>
 * <th scope="row" style="font-weight:normal">3x10^6</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="ElementDepth">maxElementDepth</th>
 * <td>Limits the maximum element depth.
 * </td>
 * <th scope="row" style="font-weight:normal">0</th>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="NameLimit">maxXMLNameLimit</th>
 * <td>Limits the maximum size of XML names, including element name, attribute
 * name and namespace prefix and URI.
 * </td>
 * <th scope="row" style="font-weight:normal">1000</th>
 * </tr>
 *
 * <tr>
 * <th scope="row" style="font-weight:normal" id="ISSTANDALONE">isStandalone</th>
 * <td>indicates that the serializer should treat the output as a
 * standalone document. The property can be used to ensure a newline is written
 * after the XML declaration. Unlike the property
 * {@link org.w3c.dom.ls.LSSerializer#getDomConfig() xml-declaration}, this property
 * does not have an effect on whether an XML declaration should be written out.
 * </td>
 * <td>yes</td>
 * <td>yes</td>
 * <td>boolean</td>
 * <th scope="row" style="font-weight:normal">true/false</th>
 * <th scope="row" style="font-weight:normal">false</th>
 * <td>No</td>
 * <td><a href="#DOMLS">DOMLS</a></td>
 * <td>17</td>
 * </tr>
 * <tr>
 * <th scope="row" style="font-weight:normal" id="XSLTCISSTANDALONE">xsltcIsStandalone</th>
 * <td>indicates that the <a href="#XSLTCSerializer">XSLTC serializer</a> should
 * treat the output as a standalone document. The property can be used to ensure
 * a newline is written after the XML declaration. Unlike the property
 * {@link javax.xml.transform.OutputKeys#OMIT_XML_DECLARATION OMIT_XML_DECLARATION},
 * this property does not have an effect on whether an XML declaration should be
 * written out.
 * <p>
 * This property behaves similar to that for <a href="#DOMLS">DOMLS</a> above,
 * except that it is for the <a href="#XSLTCSerializer">XSLTC Serializer</a>
 * and its value is a String.
 * </td>
 * <td>yes</td>
 * <td>yes</td>
 * <td>String</td>
 * <th scope="row" style="font-weight:normal">yes/no</th>
 * <th scope="row" style="font-weight:normal">no</th>
 * <td>No</td>
 * <td><a href="#XSLTCSerializer">XSLTC Serializer</a></td>
 * <td>17</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>
 * <b>[1]</b> The name of a property. The fully-qualified name, prefix + name,
 * should be used when setting the property.
 * <p>
 * <b>[2]</b> A value "yes" indicates there is a corresponding System Property
 * for the property, "no" otherwise.
 *
 * <p>
 * <b>[3]</b> The value must be exactly as listed in this table, case-sensitive.
 * The value of the corresponding System Property is the String representation of
 * the property value. If the type is boolean, the system property is true only
 * if it is "true"; If the type is String, the system property is true only if
 * it is exactly the same string representing the positive value (e.g. "yes" for
 * {@code xsltcIsStandalone}); The system property is false otherwise. If the type
 * is Integer, the value of the System Property is the String representation of
 * the value (e.g. "64000" for {@code entityExpansionLimit}).
 *
 * <p>
 * <b>[4]</b> A value "yes" indicates the property is a Security Property. Refer
 * to the <a href="#ScopeAndOrder">Scope and Order</a> on how secure processing
 * may affect the value of a Security Property.
 * <p>
 * <b>[5]</b> One or more processors that support the property. The values of the
 * field are IDs described in table <a href="#Processor">Processors</a>.
 * <p>
 * <b>[6]</b> Indicates the initial release the property is introduced.
 *
 *
 *
 * @uses javax.xml.datatype.DatatypeFactory
 * @uses javax.xml.parsers.DocumentBuilderFactory
 * @uses javax.xml.parsers.SAXParserFactory
 * @uses javax.xml.stream.XMLEventFactory
 * @uses javax.xml.stream.XMLInputFactory
 * @uses javax.xml.stream.XMLOutputFactory
 * @uses javax.xml.transform.TransformerFactory
 * @uses javax.xml.validation.SchemaFactory
 * @uses javax.xml.xpath.XPathFactory
 * @uses org.xml.sax.XMLReader
 *
 * @moduleGraph
 * @since 9
 */
module java.xml {
    exports javax.xml;
    exports javax.xml.catalog;
    exports javax.xml.datatype;
    exports javax.xml.namespace;
    exports javax.xml.parsers;
    exports javax.xml.stream;
    exports javax.xml.stream.events;
    exports javax.xml.stream.util;
    exports javax.xml.transform;
    exports javax.xml.transform.dom;
    exports javax.xml.transform.sax;
    exports javax.xml.transform.stax;
    exports javax.xml.transform.stream;
    exports javax.xml.validation;
    exports javax.xml.xpath;
    exports org.w3c.dom;
    exports org.w3c.dom.bootstrap;
    exports org.w3c.dom.events;
    exports org.w3c.dom.ls;
    exports org.w3c.dom.ranges;
    exports org.w3c.dom.traversal;
    exports org.w3c.dom.views;
    exports org.xml.sax;
    exports org.xml.sax.ext;
    exports org.xml.sax.helpers;

    exports com.sun.org.apache.xml.internal.dtm to
        java.xml.crypto;
    exports com.sun.org.apache.xml.internal.utils to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.compiler to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.functions to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.objects to
        java.xml.crypto;
    exports com.sun.org.apache.xpath.internal.res to
        java.xml.crypto;

    uses javax.xml.datatype.DatatypeFactory;
    uses javax.xml.parsers.DocumentBuilderFactory;
    uses javax.xml.parsers.SAXParserFactory;
    uses javax.xml.stream.XMLEventFactory;
    uses javax.xml.stream.XMLInputFactory;
    uses javax.xml.stream.XMLOutputFactory;
    uses javax.xml.transform.TransformerFactory;
    uses javax.xml.validation.SchemaFactory;
    uses javax.xml.xpath.XPathFactory;
    uses org.xml.sax.XMLReader;
}
