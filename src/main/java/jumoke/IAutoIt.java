package jumoke;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;

/**
 * Interface <b>IAutoIt</b></br>
 * 
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.1
 */
interface IAutoIt {

	/**
	 * Method <b>autoItSetOption(szOption, nValue)</b> </br>
	 * Changes the operation of various AutoIt functions/parameters.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * AutoIt will halt with an error message if the requested option is unknown.
	 * 
	 * @param option - The option to change. See Remarks.
	 * @param param - The parameter (varies by option). See Remarks.
	 * @return 
	 * Returns the value of the previous setting.</br>
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int autoItSetOption(String szOption, int nValue)throws XmlRpcException, IOException;
	
	/**
	 * Method <b>blockInput(nFlag)</b> </br>
	 * Disable/enable the mouse and keyboard.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * If BlockInput is enabled, the Alt keypress cannot be sent! 
	 * The table below shows how BlockInput behavior depends on Windows' version; however, 
	 * pressing Ctrl+Alt+Del on any platform will re-enable input due to a Windows API feature.
	 * 
	 * @param nFlag - 1 = Disable user input. 0 = Enable user input
	 * @return 
	 * None. </br>
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    void blockInput(long nFlag) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>clipGet(nBufSize)</b> </br>
	 * Retrieves text from the clipboard. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * None.
	 * 
	 * @param nBufSize - size of buffer.
	 * @return 
	 * Success: Returns a string containing the text on the clipboard.</br>
	 * Failure: Sets oAutoIt.error to 1 if clipboard is empty or contains a non-text entry. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	String clipGet(int nBufSize) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlGetHandle(szTitle, szText, szControl)</b> </br>
	 * Retrieves the internal handle of a control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * None.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - The text of the window to read.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns a string containing the control handle value. </br>
	 * Failure: Returns "" (blank string) and sets oAutoIt.error to 1 if no window matches the criteria. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlGetHandle(String szTitle, String szText, String szControl) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlClick(szTitle, szText, szControl [, szButton [, nNumClicks [, nX [, nY ]]]])</b> </br>
	 * Sends a mouse click command to a given control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * Some controls will resist clicking unless they are the active window. 
	 * Use the WinActive() function to force the control's window to the top before using ControlClick().
	 * Using 2 for the number of clicks will send a double-click message to the control - this can 
	 * even be used to launch programs from an explorer control!
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @param szButton - Optional: The button to click, "left", "right" or "middle". Default is the left button.
	 * @param nNumClicks - b>Optional: The number of times to click the mouse. Default is 1. 
	 * @param nX - Optional: The x position to click within the control. Default is center.
	 * @param nY - Optional: The y position to click within the control. Default is center.
	 * @return
	 * Success: Returns 1.  </br>
	 * Failure: Returns 0. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlClick(String szTitle, String szText, String szControl, String szButton, int nNumClicks, int nX, int nY) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlCommand(szTitle, szText, szControl, szCommand, szExtra) </b> </br>
	 * Sends a command to a control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * Certain commands that work on normal Combo and ListBoxes do not work on "ComboLBox" controls. 
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2". Use AU3_Spy.exe to obtain a control's number.
	 * <b>When using text instead of ClassName# in "Control" commands, be sure to use the entire text of the control. Partial text will fail.</b>
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @param szCommand - The command to send to the control.
	 * @param szExtra - Additional parameter required by some commands; use "" if parameter is not required.
	 * @return 
	 * Depends on command (see AutoItX Help). 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	String controlCommand(String szTitle, String szText, String szControl, String szCommand, String szExtra)  throws XmlRpcException, IOException;
	
	
	/**
	 * Method <b>controlGetText(szTitle, szText, szControl) </b> </br>
	 * Retrieves text from a control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns text from a control.</br>
	 * Failure: Returns a blank string of "". 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	String controlGetText(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlFocus(szTitle, szText, szControl)</b> </br>
	 * Sets input focus to a given control on a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns 1.</br>
	 * Failure: Returns 0.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlFocus(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	
	/**
	 * Method <b>controlGetPosX(szTitle, szText, szControl) </b> </br>
	 * Retrieves the position and size of a control relative to it's window. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns the X coordinate of the control.</br>
	 * Failure: Sets oAutoIt.error to 1. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlGetPosX(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlGetPosY(szTitle, szText, szControl) </b> </br>
	 * Retrieves the position and size of a control relative to it's window. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns the Y coordinate of the control.</br>
	 * Failure: Sets oAutoIt.error to 1. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlGetPosY(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlGetPosWidth (szTitle, szText, szControl) </b> </br>
	 * Retrieves the position and size of a control relative to it's window. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns the width of the control.</br>
	 * Failure: Sets oAutoIt.error to 1. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlGetPosWidth(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	/**
	 * Method <b>controlGetPosHeight(szTitle, szText, szControl) </b> </br>
	 * Retrieves the position and size of a control relative to it's window. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @return 
	 * Success: Returns the height of the control.</br>
	 * Failure: Sets oAutoIt.error to 1. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlGetPosHeight(String szTitle, String szText, String szControl)  throws XmlRpcException, IOException;
	
	
	/**
	 * Method <b>controlSend(szTitle, szText, szControl, szSendText, nMode)</b> </br>
	 * Sends a string of characters to a control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * ControlSend can be quite useful to send capital letters without messing up the state of "Shift." 
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * Note, this function cannot send all the characters that the usual Send function can (notably ALT keys) but it can send most of them--even to non-active or hidden windows!
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @param szSendText - String of characters to send to the control.
	 * @param nMode - Optional: Changes how "keys" is processed:  flag = 0 (default), Text contains special characters like + to indicate SHIFT and {LEFT} to indicate left arrow. flag = 1, keys are sent raw.
	 * @return 
	 * Success: Returns 1.</br>
	 * Failure: Returns 0 if window/control is not found.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlSend(String szTitle, String szText, String szControl, String szSendText, long nMode)  throws XmlRpcException, IOException;
		
	/**
	 * Method <b>controlSetText(szTitle, szText, szControl, szControlText)</b> </br>
	 * Sends a string of characters to a control. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * When using a control name in the Control functions, you need to add a number to the end of the name to indicate which control. 
	 * For example, if there two controls listed called "MDIClient", you would refer to these as "MDIClient1" and "MDIClient2".
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @param szControlText - The new text to be set into the control.
	 * @return 
	 * Success: Returns 1.</br>
	 * Failure: Returns 0 if window/control is not found.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int controlSetText(String szTitle, String szText, String szControl, String szControlText)  throws XmlRpcException, IOException;
	
	
	/**
	 * Method <b>controlTreeView(szTitle, szText, szControl, szCommand, szExtra1, szExtra2) </b> </br>
	 * Sends a command to a TreeView32 control.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * As AutoIt is a 32-bit application some commands are not available when referencing a 64-bit application as Explorer 
	 * when running on 64-bit Windows.</b>
	 * 
	 * @param szTitle - The title of the window to access.
	 * @param szText - The text of the window to access.
	 * @param szControl - The control to interact with.
	 * @param szCommand - The command to send to the control.
	 * @param szExtra1 - Additional parameter required by some commands; use "" if parameter is not required.
	 * @param szExtra2 - Additional parameter required by some commands; use "" if parameter is not required.
	 * @return Depends on command (see AutoItX Help). 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	String controlTreeView(String szTitle, String szText, String szControl, String szCommand, String szExtra1, String szExtra2)  throws XmlRpcException, IOException;
	
	/**
	 * Method <b>mouseClick(szButton [, nX, nY [, nClicks [, nSpeed ]]])</b> </br>
	 * Perform a mouse click operation. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * If the button is an empty string, the left button will be clicked. 
	 * If the button is not in the list, then oAutoIt.error will be set to 1. 
	 * If the user has swapped the left and right mouse buttons in the control panel, then the behaviour of the buttons is
	 * different. "Left" and "right" always click those buttons, whether the buttons are swapped or not. The "primary" or 
	 * "main" button will be the main click, whether or not the buttons are swapped. The "secondary" or "menu" buttons will 
	 * usually bring up the context menu, whether the buttons are swapped or not.
	 * 
	 * @param szButton - The button to click: "left", "right", "middle", "main", "menu", "primary", "secondary".
	 * @param nX - Optional: The x coordinates to move the mouse to. If no x coord is given, the current position is used.
	 * @param nY - Optional: The y coordinates to move the mouse to. If no y coord is given, the current position is used.
	 * @param nClicks - Optional: The number of times to click the mouse. Default is 1.
	 * @param nSpeed - Optional: the speed to move the mouse in the range 1 (fastest) to 100 (slowest). A speed of 0 will 
	 * move the mouse instantly. Default speed is 10.
	 * @return None.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int mouseClick(String szButton, int nX, int nY, int nClicks, int nSpeed) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>mouseClickDrag(szButton, nX1, nY1, X2, Y2 [, nSpeed])</b> </br>
	 * Perform a mouse click and drag operation.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * If the button is an empty string, the left button will be clicked.
	 * If the button is not in the list, then oAutoIt.error will be set to 1.
	 * If the user has swapped the left and right mouse buttons in the control panel, then the behaviour of the buttons is different. 
	 * "Left" and "right" always click those buttons, whether the buttons are swapped or not. 
	 * The "primary" or "main" button will be the main click, whether or not the buttons are swapped. 
	 * The "secondary" or "menu" buttons will usually bring up the context menu, whether the buttons are swapped or not. 
	 * See the table in MouseClick for more explaination.
	 * 
	 * @param szButton - The button to click: "left", "right", "middle", "main", "menu", "primary", "secondary".
	 * @param nX1, nY1 - The x/y coords to start the drag operation from.
	 * @param nX2, nY2 - The x/y coords to start the drag operation to.
	 * @param nSpeed - Optional: the speed to move the mouse in the range 1 (fastest) to 100 (slowest). A speed of 0 will 
	 * move the mouse instantly. Default speed is 10.
	 * @return None.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	int mouseClickDrag(String szButton, int nX1, int nY1, int nX2, int nY2, int nSpeed) throws XmlRpcException, IOException;
	
	/**
	 * Method <b>mouseGetPosX()</b> </br>
	 * Retrieves the current X position of the mouse cursor. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * See MouseCoordMode for relative/absolute position settings. If relative positioning, numbers may be negative.
	 * @return Returns the current X position of the mouse cursor.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
	long mouseGetPosX() throws XmlRpcException, IOException;
	
	/**
	 * Method <b>mouseGetPosY()</b> </br>
	 * Retrieves the current Y position of the mouse cursor. </br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * See MouseCoordMode for relative/absolute position settings. If relative positioning, numbers may be negative.
	 * @return Returns the current Y position of the mouse cursor.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    long mouseGetPosY() throws XmlRpcException, IOException;
    
    
    /**
	 * Method <b>run(szRun, szDir, nShowFlag)</b> </br>
	 * Runs an external program.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * After running the requested program the script continues. To pause execution of the script until the spawned program has finished use the RunWait function instead.
	 * The error property is set to 1 as an indication of failure.
	 * 
	 * @param szRun - The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param szDir - Optional: The working directory.
	 * @param nShowFlag - Optional: The "show" flag of the executed program (SW_HIDE = Hidden window, SW_MINIMIZE = Minimized window, SW_MAXIMIZE = Maximized window).
	 * @return 
	 * Success: The PID of the process that was launched.</br>
	 * Failure: Failure: see Remarks.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int run(String szRun, String szDir, long nShowFlag) throws XmlRpcException, IOException; 
    
    
    /**
	 * Method <b>send(szSendText, nMode)</b> </br>
	 * Sends simulated keystrokes to the active window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * The "Send" command syntax is similar to that of ScriptIt and the Visual Basic "SendKeys" command. Characters are sent as written with the exception of the following characters: 
	 * '!' - this tells AutoIt to send an ALT keystroke, therefore Send("This is text!a") would send the keys "This is text" and then press "ALT+a". 
	 * N.B. Some programs are very choosy about capital letters and ALT keys, i.e. "!A" is different to "!a". The first says ALT+SHIFT+A, the second is ALT+a. If in doubt, use lowercase!
	 * '+' - this tells AutoIt to send a SHIFT keystroke, therefore Send("Hell+o") would send the text "HellO". Send("!+a") would send "ALT+SHIFT+a". 
	 * '^' - this tells AutoIt to send a CONTROL keystroke, therefore Send("^!a") would send "CTRL+ALT+a". 
	 * N.B. Some programs are very choosy about capital letters and CTRL keys, i.e. "^A" is different to "^a". The first says CTRL+SHIFT+A, the second is CTRL+a. If in doubt, use lowercase!
	 * '#' - the hash now sends a Windows keystroke; therefore, Send("#r") would send Win+r which launches the Run dialog box. 
	 * You can set SendCapslockMode to make CAPS LOCK disabled at the start of a Send operation and restored upon completion. 
	 * However, if a user is holding down the Shift key when a Send function begins, text may be sent in uppercase. One workaround is to Send("{SHIFTDOWN}{SHIFTUP}") before the other Send operations. <p> 
	 * See AutoItX Help for more information. 
	 * 
	 * @param szSendText - The sequence of keys to send.
	 * @param nMode - Optional: Changes how "keys" is processed: flag = 0 (default), Text contains special characters like + and ! to indicate SHIFT and ALT key presses. flag = 1, keys are sent raw.
	 * @return None.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    void send(String szSendText, long nMode) throws XmlRpcException, IOException;
    
    /**
	 * Method <b>sleep(nMilliseconds)</b> </br>
	 * Pause script execution.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * Maximum sleep time is 2147483647 milliseconds (24 days).
	 * 
	 * @param nMilliseconds - Amount of time to pause (in milliseconds).
	 * @return None.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    void sleep(long nMilliseconds) throws XmlRpcException, IOException;
    
    
	/**
	 * Method <b>winActivate(szTitle, szText)</b> </br>
	 * Activates (gives focus to) a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * You can use the WinActive function to check if WinActivate succeeded. If multiple windows match the criteria, 
	 * the window that was most recently active is the one activated. WinActivate works on minimized windows. 
	 * However, a window that is "Always On Top" could still cover up a window you Activated.
	 * 
	 * @param szTitle - The title of the window to activate.
	 * @param szText - Optional: The text of the window to activate.
	 * @return 
	 * None. </br>
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    void winActivate(String szTitle, String szText) throws XmlRpcException, IOException;
    
    
    /**
	 * Method <b>winClose(szTitle, szText)</b> </br>
	 * Closes a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * This function sends a close message to a window, the result depends on the window (it may ask to save data, etc.). 
	 * To force a window to close, use the WinKill function. If multiple windows match the criteria, the window that was most recently active is closed.
	 * 
	 * @param szTitle - The title of the window to close.
	 * @param szText - Optional: The text of the window to close.
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if window is not found.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winClose(String szTitle, String szText) throws XmlRpcException, IOException;
    
    
	/**
	 * Method <b>winExists(szTitle, szText)</b> </br>
	 * Checks to see if a specified window exists.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * WinExist will return 1 even if a window is hidden.
	 * 
	 * @param szTitle - The title of the window to check.
	 * @param szText - Optional: TThe text of the window to check.
	 * @return 
	 * Returns 1 if the window exists, otherwise returns 0.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winExists(String szTitle, String szText) throws XmlRpcException, IOException;
    
	/**
	 * Method <b>winGetPosX(szTitle, szText)</b> </br>
	 * Retrieves the X-position of a given window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * WinGetPosX returns negative numbers such as -32000 for minimized windows, but works fine with (non-minimized) hidden windows.
	 * If the window title "Program Manager" is used, the function will return the size of the desktop. 
	 * If multiple windows match the criteria, the most recently active window is used.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return 
	 * Success: Returns the X coordinate of the window.</br>
	 * Failure: Returns numeric 1.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winGetPosX(String szTitle, String szText) throws XmlRpcException, IOException;
    
	/**
	 * Method <b>winGetPosY(szTitle, szText)</b> </br>
	 * Retrieves the Y-position of a given window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * winGetPosY returns negative numbers such as -32000 for minimized windows, but works fine with (non-minimized) hidden windows.
	 * If the window title "Program Manager" is used, the function will return the size of the desktop. 
	 * If multiple windows match the criteria, the most recently active window is used.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return 
	 * Success: Returns the Y coordinate of the window.</br>
	 * Failure: Returns numeric 1.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winGetPosY(String szTitle, String szText) throws XmlRpcException, IOException;
    
	/**
	 * Method <b>winGetPosHeight(szTitle, szText)</b> </br>
	 * Retrieves the width of a given window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * winGetPosHeight returns negative numbers such as -32000 for minimized windows, but works fine with (non-minimized) hidden windows.
	 * If the window title "Program Manager" is used, the function will return the size of the desktop. 
	 * If multiple windows match the criteria, the most recently active window is used.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return 
	 * Success: Returns the height of the window.</br>
	 * Failure: Returns numeric 1.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winGetPosHeight(String szTitle, String szText) throws XmlRpcException, IOException;
    
	/**
	 * Method <b>winGetPosWidth(szTitle, szText)</b> </br>
	 * Retrieves the width of a given window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * winGetPosWidth returns negative numbers such as -32000 for minimized windows, but works fine with (non-minimized) hidden windows.
	 * If the window title "Program Manager" is used, the function will return the size of the desktop. 
	 * If multiple windows match the criteria, the most recently active window is used.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return 
	 * Success: Returns the width of the window.</br>
	 * Failure: Returns numeric 1.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winGetPosWidth(String szTitle, String szText) throws XmlRpcException, IOException;
    
	/**
	 * Method <b>winGetText(szTitle, szText)</b> </br>
	 * Retrieves the text from a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * Up to 64KB of window text can be retrieved. WinGetText works on minimized windows, but only works on hidden windows if you've set
	 * AutoItSetOption("WinDetectHiddenText", 1). If multiple windows match the criteria for WinGetText, the information for the most 
	 * recently active match is returned. Use WinGetText("[active]") to get the active window's text.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if timeout occurred.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    String winGetText(String szTitle, String szText) throws XmlRpcException, IOException;
    
        
    /**
	 * Method <b>winSetState(szTitle, szText, nFlags)</b> </br>
	 * Shows, hides, minimizes, maximizes, or restores a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * WinSetState is a replacement for the badly named WinShow function. WinShow is accepted as an alias but this may be withdrawn in the future. 
	 * If multiple windows match the criteria, the most recently active window is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param szTitle - The title of the window to show.
	 * @param szText - The text of the window to show.
	 * @param nFlags - The "show" flag of the executed program: SW_HIDE = Hide window, SW_SHOW = Shows a previously hidden window, SW_MINIMIZE = Minimize window, 
	 * SW_MAXIMIZE = Maximize window, SW_RESTORE = Undoes a window minimization or maximization
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if window is not found. 
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winSetState(String szTitle, String szText, long nFlags) throws XmlRpcException, IOException;
    
    
    /**
	 * Method <b>winGetTitle(szTitle, szText)</b> </br>
	 * Retrieves the full title from a window.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * WinGetTitle("") returns the active window's title. WinGetTitle works on both minimized and hidden windows. 
	 * If multiple windows match the criteria, the most recently active window is used.
	 * 
	 * @param szTitle - The title of the window to read.
	 * @param szText - Optional: The text of the window to read.
	 * @return Returns a string containing the complete window title. Returns numeric 0 if no title match.</br>
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    String winGetTitle(String szTitle, String szText) throws XmlRpcException, IOException;
    
    /**
	 * Method <b>winWait(szTitle, szText, nTimeout)</b> </br>
	 * Pauses execution of the script until the requested window exists.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param szTitle - The title of the window to check.
	 * @param szText - Optional: The text of the window to check.
	 * @param nTimeout - Timeout in seconds
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if timeout occurred.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winWait(String szTitle, String szText, long nTimeout) throws XmlRpcException, IOException; 
    
    
	/**
	 * Method <b>winWaitActive(szTitle, szText, nTimeout)</b> </br>
	 * Pauses execution of the script until the requested window is active.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param szTitle - The title of the window to check.
	 * @param szText - Optional: The text of the window to check.
	 * @param nTimeout - Timeout in seconds
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if timeout occurred.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winWaitActive(String szTitle, String szText, long nTimeout) throws XmlRpcException, IOException; 
    
    /**
	 * Method <b>winWaitClose(szTitle, szText, nTimeout)</b> </br>
	 * Pauses execution of the script until the requested window does not exist.</br><p>
	 * 
	 * <b>Remarks </b> </br>
	 * If the window already doesn't exist when this function is called it will return 1 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param szTitle - The title of the window to check.
	 * @param szText - Optional: The text of the window to check.
	 * @param nTimeout - Timeout in seconds
	 * @return 
	 * Success: Returns 1</br>
	 * Failure: Returns 0 if timeout occurred.
	 * @throws XmlRpcException
	 * @throws IOException
	 */
    int winWaitClose(String szTitle, String szText, long nTimeout) throws XmlRpcException, IOException; 
}
