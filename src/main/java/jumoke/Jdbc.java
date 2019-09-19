package jumoke;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Vector;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.w3c.dom.Document;


/**
 * Class <b>Jdbc</b></br>
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.0
 */
public class Jdbc {
    private XmlRpcClient agent = null;
    private String connectionString;

    Jdbc(XmlRpcClient agent, String connectionString) {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "connectionString = " + connectionString);
        this.agent = agent;
        this.connectionString = connectionString;
        Agent.log.info("<< " + this.toString());
    }

    /**
     * Method <b>executeQuery(String sqlStatement)</b> </br>
     * Executes the given SQL statement.
     *
     * @param sqlStatement - an SQL statement to be sent to the database, typically a static SQL SELECT statement
     * @return a XML document object that contains the data produced by the given query. </br>
     * For example: </br> <pre>
     * {@code
     * <Result>
     * 	<Row>
     * 		<posno>1</posno>
     * 		<shiftno>99</shiftno>
     * 		<ticketno>959</ticketno>
     * 	</Row>
     * </Result>
     * }
     * @throws XmlRpcException
     * @throws IOException
     * @throws TransformerException
     */
    public Document executeQuery(String sqlStatement) throws XmlRpcException, IOException, TransformerException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "sqlStatement = " + sqlStatement);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(this.connectionString));
        params.addElement(Marshal.serialize(sqlStatement));
        String res = (String) agent.execute("Jdbc.executeQuery", params);
        Document ret = (Document) Marshal.deserialize(res);
        Agent.log.info("<< " + convertoDocumentToString(ret));
        return ret;
    }

    private String convertoDocumentToString(Document xmldoc) throws TransformerException {
        DOMSource domSource = new DOMSource(xmldoc);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);
        return sw.toString();
    }
}
