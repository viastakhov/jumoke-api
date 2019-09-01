package jumoke;

import java.io.IOException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.LogManager;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

/**
 * Class <b>Agent</b></br>
 * 
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.1
 */
public class Agent {

	private XmlRpcClient agent;
	public static java.util.logging.Logger log;
	
	/**
	 * Constructor <b>Agent(String url, int port)</b> </br>
	 * @param url - URL of remote agent
	 * @param port - port of remote agent
	 * @throws Exception 
	 */
	public Agent(String url, int port) throws Exception{
		log = java.util.logging.Logger.getLogger(Agent.class.getName());
		log.info(">> " + "url = " + url + ", " + "port = " + port);
		
		try {
            LogManager.getLogManager().readConfiguration(Agent.class.getResourceAsStream("/jumoke.logging.properties"));
        } catch (Exception e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
            e.printStackTrace();
        }
		
		agent = new XmlRpcClient("http://" + url + ":" + port);
		log.info("<< " + agent.toString());
		handshake();	
	}
	
	/**
	 * Constructor <b>Agent(int port)</b> </br>
	 * URL = "localhost"
	 * @param port - port of remote agent
	 * @throws Exception 
	 */
	public Agent(int port) throws Exception{
		this("localhost", port);
	}
	
	/**
	 * Constructor <b>Agent()</b> </br>
	 * URL = "localhost" </br>
	 * port = 80
	 * @throws Exception 
	 */
	public Agent() throws Exception{
		this("localhost", 80);
	}
	
	/**
	 * Method <b>getURL()</b> </br>
	 * @return URL of remote agent
	 */
	public URL getURL() {
		log.info(">>");
		URL ret = agent.getURL();
		log.info("<< " + ret);
		return ret;
	}
	
	/**
	 * Method <b>getAutoIt()</b> </br>
	 * @return AutoIT instance
	 */
	public AutoIt getAutoIt() {
		return new AutoIt(agent);
	}
	
	/**
	 * Method <b>getJdbc(String connectionString)</b> </br>
	 * @param connectionString - connection string
	 * @return JDBC instance
	 */
	public Jdbc getJdbc(String connectionString) {
		return new Jdbc(agent, connectionString);
	}
	
	/**
	 * Method <b>getSikuli()</b> </br>
	 * @return Sikuli instance
	 */
	public Sikuli getSikuli() {
		return new Sikuli(agent);
	}

	/**
	 * Method <b>getWinApi()</b> </br>
	 * @return WinApi instance
	 */
	public WinApi getWinApi() {
		return new WinApi(agent);
	}
	
	private int handshake() throws Exception  {
		log.info(">> " + "agent = " + agent.getURL());
		
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(agent.getURL().toString())); 
		int ret = 0;
		try {
			ret = (int) agent.execute("Agent.handshake", params);
		} catch (XmlRpcException | IOException e) {
			log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		log.info("<< " + ret);
		return ret;
	}
	
	/**
	 * Get current online status of remote agent.
	 * @return true is online, false is offline
	 */
	public boolean isOnline() {
		log.info(">> "  + "agent = " + agent.getURL());
		try {
			Vector<Object> params = new Vector<>();
			params.addElement(Marshal.serialize(agent.getURL().toString())); 
			@SuppressWarnings("unused")
			int ret = (int) agent.execute("Agent.handshake", params);
		} catch (Exception ex) {
			log.info("<< " + false);
			return false;
		}
		log.info("<< " + true);
		return true;
	}
	
	/**
	 * Get highlight delay (msec.) on remote agent
	 * @return miliseconds
	 * @throws Exception
	 */
	public int getHighlightDelay() throws Exception  {
		log.info(">> " + "agent = " + agent.getURL());
		
		Vector<Object> params = new Vector<>(); 
		int ret = 0;
		try {
			ret = (int) agent.execute("Agent.getHighlightDelay", params);
		} catch (XmlRpcException | IOException e) {
			log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		log.info("<< " + ret + " msec.");
		return ret;
	}
	
	/**
	 * Set highlight delay (msec.) on remote agent
	 * @param highlightDelay is integer value, specifies dalay (msec.)
	 * @return applied miliseconds
	 * @throws Exception
	 */
	public int setHighlightDelay(int highlightDelay) throws Exception  {
		log.info(">> " + "agent = " + agent.getURL() + ", " + "highlightDelay = " + highlightDelay);
		
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(highlightDelay)); 
		int ret = -1;
		try {
			ret = (int) agent.execute("Agent.setHighlightDelay", params);
		} catch (XmlRpcException | IOException e) {
			log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		log.info("<< " + ret + " msec.");
		return ret;
	}
	
	/**
	 * Get highlight mode on remote agent
	 * @return true - ON, false - OFF
	 * @throws Exception
	 */
	public boolean getHighlightMode() throws Exception  {
		log.info(">> " + "agent = " + agent.getURL());
		
		Vector<Object> params = new Vector<>(); 
		boolean ret = false;
		try {
			ret = (boolean) agent.execute("Agent.getHighlightMode", params);
		} catch (XmlRpcException | IOException e) {
			log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		log.info("<< " + (ret ? "ON" : "OFF"));
		return ret;
	}
	
	/**
	 * Set highlight mode on remote agent
	 * @param highlightMode is boolean value (true - ON, false - OFF)
	 * @return true - ON, false - OFF
	 * @throws Exception
	 */
	public boolean setHighlightMode(boolean highlightMode) throws Exception  {
		log.info(">> " + "agent = " + agent.getURL() + ", " + "highlightMode = " + highlightMode);
		
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(highlightMode)); 
		boolean ret = false;
		try {
			ret = (boolean) agent.execute("Agent.setHighlightMode", params);
		} catch (XmlRpcException | IOException e) {
			log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		log.info("<< " + (ret ? "ON" : "OFF"));
		return ret;
	}
	
}
