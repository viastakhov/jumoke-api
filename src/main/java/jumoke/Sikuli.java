package jumoke;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;


/**
 * Class <b>Sikuli</b></br>
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.0
 */
public class Sikuli {
    private XmlRpcClient agent;

    Sikuli(XmlRpcClient agent) {
        Agent.log.info(">> " + "agent = " + agent.getURL());
        this.agent = agent;
        Agent.log.info("<< " + this.toString());
    }

    /**
     * Method <b>getScreen(int i) </b> </br>
     *
     * @param i - number of Screen
     * @return Sikuli Screen object
     * @throws XmlRpcException
     * @throws IOException
     */
    public Screen getScreen(int i) throws XmlRpcException, IOException {
        return new Screen(agent, i);
    }

    /**
     * Method <b>getRegion(int x, int y, int w, int h)  </b> </br>
     *
     * @param x - left
     * @param y - top
     * @param w - width
     * @param h - high
     * @return Sikuli Region object
     * @throws XmlRpcException
     * @throws IOException
     */
    public Region getRegion(int x, int y, int w, int h) throws XmlRpcException, IOException {
        return new Region(agent, x, y, w, h);
    }
}
