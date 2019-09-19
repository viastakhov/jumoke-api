package jumoke;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;


/**
 * Class <b>Screen</b></br>
 * Class Screen is there, to have a representation for a physical monitor where the capturing process
 * (grabbing a rectangle from a screenshot, to be used for further processing with find operations is
 * implemented. For Multi Monitor Environments it contains features to map to the relevant monitor.
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 2.1
 */
public class Screen implements IRegion {
    private XmlRpcClient agent = null;
    private String sXScreen = null;
    protected int curID = -1;

    Screen(XmlRpcClient agent, int id) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", id = " + id);
        this.agent = agent;
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(id));
        this.curID = id;
        sXScreen = (String) agent.execute("Sikuli.getScreen", params);
        Agent.log.info("<< " + this.toString());
    }


    public BufferedImage capture() throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL());
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);
        String res = (String) agent.execute("Sikuli.capture", params);
        byte[] buf = (byte[]) Marshal.deserialize(res);
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        BufferedImage ret = ImageIO.read(bais);
        Agent.log.info("<< " + ret.toString());
        return ret;
    }


    @Override
    public <PSRML> int click(PSRML target) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString());
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);

        if (target instanceof Pattern) {
            params.addElement(Marshal.serialize(target));
        } else if (target instanceof String) {
            params.addElement(Marshal.serialize((String) target));
        }

        String res = (String) agent.execute("Sikuli.click", params);
        int ret = (int) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    public <PS> boolean exists(PS target, double seconds) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", seconds = " + seconds);
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);

        if (target instanceof Pattern) {
            params.addElement(Marshal.serialize(target));
        } else if (target instanceof String) {
            params.addElement(Marshal.serialize((String) target));
        }

        params.addElement(Marshal.serialize(seconds));
        String res = (String) agent.execute("Sikuli.exists", params);
        boolean ret_ = (boolean) Marshal.deserialize(res);

        Agent.log.info("<< " + ret_);
        return ret_;
    }


    public <PS> boolean wait(PS target, double seconds) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", seconds = " + seconds);
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);

        if (target instanceof Pattern) {
            params.addElement(Marshal.serialize(target));
        } else if (target instanceof String) {
            params.addElement(Marshal.serialize((String) target));
        }

        params.addElement(Marshal.serialize(seconds));
        String res = (String) agent.execute("Sikuli.wait", params);
        boolean ret_ = (boolean) Marshal.deserialize(res);

        Agent.log.info("<< " + ret_);
        return ret_;
    }

    @Override
    public <PSRML> int type(PSRML target, String text) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", text = " + text);
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);

        if (target instanceof Pattern) {
            params.addElement(Marshal.serialize(target));
        } else if (target instanceof String) {
            params.addElement(Marshal.serialize((String) target));
        }

        params.addElement(Marshal.serialize(text));

        String res = (String) agent.execute("Sikuli.type", params);
        int ret = (int) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    @Override
    public <PSRML> int paste(PSRML target, String text) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", text = " + text);
        Vector<Object> params = new Vector<>();
        params.addElement(sXScreen);

        if (target instanceof Pattern) {
            params.addElement(Marshal.serialize(target));
        } else if (target instanceof String) {
            params.addElement(Marshal.serialize((String) target));
        }

        params.addElement(Marshal.serialize(text));

        String res = (String) agent.execute("Sikuli.paste", params);
        int ret = (int) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    @Override
    public String toString() {
        String scrText = curID == -1 ? "Union" : "" + curID;
        return String.format("S(%s)", scrText);
    }
}
