package jumoke;

import java.io.IOException;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;


/**
 * Class <b>Region</b></br>
 * The Region is besides Images/Patterns (called Visuals) and Matches (where a Visual was found and how)
 * the basic element in the SikuliX concept. So be sure, you have understood all aspects of a Region.
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 2.0
 */
public class Region implements IRegion {
    private XmlRpcClient agent = null;
    private String sXRegion = null;
    /**
     * X-coordinate of the Region
     */
    public int x;
    /**
     * Y-coordinate of the Region
     */
    public int y;
    /**
     * Width of the Region
     */
    public int w;
    /**
     * Height of the Region
     */
    public int h;


    Region(XmlRpcClient agent, int x, int y, int w, int h) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", x = " + x + ", y = " + y + ", w = " + w + ", h = " + h);
        this.agent = agent;
        Vector<Object> params = new Vector<>();
        {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
        params.addElement(Marshal.serialize(x));
        params.addElement(Marshal.serialize(y));
        params.addElement(Marshal.serialize(w));
        params.addElement(Marshal.serialize(h));
        sXRegion = (String) agent.execute("Sikuli.getRegion", params);
        Agent.log.info("<< " + this.toString());
    }

    public Region(Region r) {
        agent = r.agent;
        sXRegion = r.sXRegion;
    }

    public void copy(Region r) {
        agent = r.agent;
        sXRegion = r.sXRegion;
    }

    @Override
    public <PSRML> int click(PSRML target) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString());
        Vector<Object> params = new Vector<>();
        params.addElement(sXRegion);

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
        params.addElement(sXRegion);

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

    @Override
    public <PS> boolean wait(PS target, double seconds) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", seconds = " + seconds);
        Vector<Object> params = new Vector<>();
        params.addElement(sXRegion);

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

    @Override
    public <PSRML> int type(PSRML target, String text) throws Exception {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", target = " + target.toString() + ", text = " + text);
        Vector<Object> params = new Vector<>();
        params.addElement(sXRegion);

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
        params.addElement(sXRegion);

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
        return String.format("R[%d,%d %dx%d]", x, y, w, h);
    }
}
