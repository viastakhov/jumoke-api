package jumoke;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

/**
 * Class <b>AutoIT</b></br>
 * 
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.0
 */
public class AutoIt implements IAutoIt {
	private XmlRpcClient agent;
	
	AutoIt(XmlRpcClient agent) {
		Agent.log.info(">> " + "agent = " + agent.toString());
		this.agent = agent;
		Agent.log.info("<< " + this.toString());
	}

	@Override
	public int autoItSetOption(String szOption, int nValue) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szOption = " + szOption + ", " + "nValue = " + nValue);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szOption)); 
		params.addElement(Marshal.serialize(nValue)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.autoItSetOption", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public String clipGet(int nBufSize) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "nBufSize = " + nBufSize);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(nBufSize)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.clipGet", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = new String((byte[]) Marshal.deserialize(res));
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int controlGetHandle(String szTitle, String szText, String szControl) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetHandle", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlClick(String szTitle, String szText, String szControl, String szButton, int nNumClicks, int nX, int nY) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl + ", " + "szButton = " + szButton + ", " +
				"nNumClicks = " + nNumClicks + ", " + "nX = " + nX  + ", " + "nY = " + nY);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		params.addElement(Marshal.serialize(szButton));
		params.addElement(Marshal.serialize(nNumClicks));
		params.addElement(Marshal.serialize(nX));
		params.addElement(Marshal.serialize(nY));
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlClick", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
 
	@Override
	public int mouseClick(String szButton, int nX, int nY, int nClicks, int nSpeed) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szButton = " + szButton + ", " + "nX = " + nX + ", " + "nY = " + nY + ", " + "nClicks = " + nClicks + ", " + "nSpeed = " + nSpeed);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szButton)); 
		params.addElement(Marshal.serialize(nX)); 
		params.addElement(Marshal.serialize(nY)); 
		params.addElement(Marshal.serialize(nClicks));
		params.addElement(Marshal.serialize(nSpeed));
		String res;
		try {
			res = (String) agent.execute("AutoIT.mouseClick", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int mouseClickDrag(String szButton, int nX1, int nY1, int nX2, int nY2, int nSpeed) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szButton = " + szButton + ", " + "nX1 = " + nX1 + ", " + "nY1 = " + nY1 + ", " + "nX2 = " + nX2 + ", " + "nY2 = " + nY2 + ", " + "nSpeed = " + nSpeed);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szButton)); 
		params.addElement(Marshal.serialize(nX1)); 
		params.addElement(Marshal.serialize(nY1)); 
		params.addElement(Marshal.serialize(nX2)); 
		params.addElement(Marshal.serialize(nY2));
		params.addElement(Marshal.serialize(nSpeed));
		String res;
		try {
			res = (String) agent.execute("AutoIT.mouseClickDrag", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public long mouseGetPosX() throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL());
		Vector<Object> params = new Vector<>();
		String res;
		try {
			res = (String) agent.execute("AutoIT.mouseGetPosX", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		long ret = (long) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public long mouseGetPosY() throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL());
		Vector<Object> params = new Vector<>();
		String res;
		try {
			res = (String) agent.execute("AutoIT.mouseGetPosY", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		long ret =  (long) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public void winActivate(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winActivate", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		@SuppressWarnings("unused")
		long ret = (long) Marshal.deserialize(res);
		Agent.log.info("<<");
	}

	@Override
	public int winWaitActive(String szTitle, String szText, long nTimeout)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "nTimeout = " + nTimeout);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(nTimeout)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winWaitActive", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int winWaitClose(String szTitle, String szText, long nTimeout)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "nTimeout = " + nTimeout);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(nTimeout)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winWaitClose", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public String winGetText(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetText", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = (String) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public String winGetTitle(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetTitle", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = (String) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public void blockInput(long nFlag) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "nFlag = " + nFlag);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(nFlag)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.blockInput", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		@SuppressWarnings("unused")
		long ret = (long) Marshal.deserialize(res);
		Agent.log.info("<<");
		
	}

	@Override
	public int run(String szRun, String szDir, long nShowFlag)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szRun = " + szRun + ", " + "szDir = " + szDir + ", " + "nShowFlag = " + nShowFlag);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szRun)); 
		params.addElement(Marshal.serialize(szDir)); 
		params.addElement(Marshal.serialize(nShowFlag)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.run", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int winClose(String szTitle, String szText) throws XmlRpcException,
			IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winClose", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public String controlCommand(String szTitle, String szText,  String szControl, String szCommand, String szExtra)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl + ", " + "szCommand = " + szCommand + ", " + "szExtra = " + szExtra);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		params.addElement(Marshal.serialize(szCommand)); 
		params.addElement(Marshal.serialize(szExtra)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlCommand", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = (String) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public String controlGetText(String szTitle, String szText, String szControl)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetText", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = (String) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlSend(String szTitle, String szText, String szControl, String szSendText, long nMode) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl + ", " + "szSendText = " + szSendText + ", " + "nMode = " + nMode);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		params.addElement(Marshal.serialize(szSendText));
		params.addElement(Marshal.serialize(nMode));
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlSend", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public void send(String szSendText, long nMode) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szSendText = " + szSendText + ", " + "nMode = " + nMode);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szSendText)); 
		params.addElement(Marshal.serialize(nMode)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.send", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		long ret = (long) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
	}

	@Override
	public void sleep(long nMilliseconds) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "nMilliseconds = " + nMilliseconds);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(nMilliseconds)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.sleep", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		long ret = (long) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
	}

	@Override
	public int controlSetText(String szTitle, String szText, String szControl, String szControlText) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl + ", " + "szControlText = " + szControlText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		params.addElement(Marshal.serialize(szControlText));
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlSetText", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlFocus(String szTitle, String szText, String szControl)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlFocus", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int winSetState(String szTitle, String szText, long nFlags)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "nFlags = " + nFlags);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(nFlags)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winSetState", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int winExists(String szTitle, String szText) throws XmlRpcException,
			IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winExists", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlGetPosX(String szTitle, String szText, String szControl)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetPosX", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlGetPosY(String szTitle, String szText, String szControl) 
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetPosY", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlGetPosWidth(String szTitle, String szText, String szControl) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetPosWidth", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public int controlGetPosHeight(String szTitle, String szText, String szControl) throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "szControl = " + szControl);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlGetPosHeight", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}

	@Override
	public String controlTreeView(String szTitle, String szText,
			String szControl, String szCommand, String szExtra1, String szExtra2) throws XmlRpcException, IOException {

		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " +
		"szText = " + szText + ", " + "szControl = " + szControl + ", " + "szCommand = " + 
				szCommand + ", " + "szExtra1 = " + szExtra1 + ", " + "szExtra2 = " + szExtra2);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(szControl)); 
		params.addElement(Marshal.serialize(szCommand)); 
		params.addElement(Marshal.serialize(szExtra1)); 
		params.addElement(Marshal.serialize(szExtra2)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.controlTreeView", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		String ret = (String) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;

	}

	@Override
	public int winWait(String szTitle, String szText, long nTimeout)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText + ", " + "nTimeout = " + nTimeout);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		params.addElement(Marshal.serialize(nTimeout)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winWait", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int winGetPosX(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetPosX", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int winGetPosY(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetPosY", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int winGetPosHeight(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetPosHeight", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
	
	@Override
	public int winGetPosWidth(String szTitle, String szText)
			throws XmlRpcException, IOException {
		Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "szTitle = " + szTitle + ", " + "szText = " + szText);
		Vector<Object> params = new Vector<>();
		params.addElement(Marshal.serialize(szTitle)); 
		params.addElement(Marshal.serialize(szText)); 
		String res;
		try {
			res = (String) agent.execute("AutoIT.winGetPosWidth", params);
		} catch (XmlRpcException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		} catch (IOException e) {
			Agent.log.log(Level.SEVERE, e.toString(), e);
			throw e;
		}
		int ret = (int) Marshal.deserialize(res);
		Agent.log.info("<< " + ret);
		return ret;
	}
		
}
