package jumoke;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinBase.OVERLAPPED;
import com.sun.jna.platform.win32.WinBase.SECURITY_ATTRIBUTES;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;


/**
 * Class <b>WinApi</b><br>
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.5
 */
public class WinApi {
    private XmlRpcClient agent = null;

    public final static int CDS_NONE = 0;
    public final static int CDS_UPDATEREGISTRY = 0x00000001;
    public final static int CDS_TEST = 0x00000002;
    public final static int CDS_FULLSCREEN = 0x00000004;
    public final static int CDS_GLOBAL = 0x00000008;
    public final static int CDS_SET_PRIMARY = 0x00000010;
    public final static int CDS_VIDEOPARAMETERS = 0x00000020;
    public final static int CDS_ENABLE_UNSAFE_MODES = 0x00000100;
    public final static int CDS_DISABLE_UNSAFE_MODES = 0x00000200;
    public final static int CDS_RESET = 0x40000000;
    public final static int CDS_RESET_EX = 0x20000000;
    public final static int CDS_NORESET = 0x10000000;

    public final static int ENUM_CURRENT_SETTINGS = -1;
    public final static int ENUM_REGISTRY_SETTINGS = -2;

    public final static int PAGE_READWRITE = 0x04;

    public final static int PROCESS_VM_READ = 0x0010;
    public final static int PROCESS_VM_WRITE = 0x0020;
    public final static int PROCESS_VM_OPERATION = 0x0008;

    public final static int MEM_COMMIT = 0x00001000;
    public final static int MEM_RELEASE = 0x8000;
    public final static int MEM_RESERVE = 0x00002000;
    public final static int MEM_RESET = 0x00080000;

    public final static int DISP_CHANGE_SUCCESSFUL = 0;
    public final static int DISP_CHANGE_RESTART = 1;
    public final static int DISP_CHANGE_BADFLAGS = -4;
    public final static int DISP_CHANGE_BADPARAM = -5;
    public final static int DISP_CHANGE_FAILED = -1;
    public final static int DISP_CHANGE_BADMODE = -2;
    public final static int DISP_CHANGE_NOTUPDATED = -3;

    //Indicates file copy and install options
    public final static int FC_NOOVERWRITE = 0; //Do not overwrite existing files (default)
    public final static int FC_OVERWRITE = 1; //Overwrite existing files
    public final static int FC_CREATEPATH = 8; //Create destination directory structure if it doesn't exist

    //Indicates file date and time options
    public final static int FT_MODIFIED = 0; //Date and time file was last modified (default)
    public final static int FT_CREATED = 1; //Date and time file was created
    public final static int FT_ACCESSED = 2; //Date and time file was last accessed

    //FileGetTime Constants
    public final static int FT_ARRAY = 0;
    public final static int FT_STRING = 1;

    //FileSelectFolder Constants
    public final static int FSF_CREATEBUTTON = 1;
    public final static int FSF_NEWDIALOG = 2;
    public final static int FSF_EDITCONTROL = 4;

    //FileSetTime, FileSetAttrib
    public final static int FT_NONRECURSIVE = 0;
    public final static int FT_RECURSIVE = 1;

    //Indicates the mode to open a file
    public final static int FO_READ = 0; //Read mode
    public final static int FO_APPEND = 1; //Write mode (append)
    public final static int FO_OVERWRITE = 2; //Write mode (erase previous contents)
    public final static int FO_CREATEPATH = 8; //Create directory structure if it doesn't exist
    public final static int FO_BINARY = 16; //Read/Write mode binary
    public final static int FO_UNICODE = 32; //Write mode Unicode UTF16-LE
    public final static int FO_UTF16_LE = 32; //Write mode Unicode UTF16-LE
    public final static int FO_UTF16_BE = 64; //Write mode Unicode UTF16-BE
    public final static int FO_UTF8 = 128; //Read/Write mode UTF8 with BOM
    public final static int FO_UTF8_NOBOM = 256; //Read/Write mode UTF8 with no BOM
    public final static int FO_ANSI = 512; //Read/Write mode ANSI
    public final static int FO_UTF16_LE_NOBOM = 1024; //Write mode Unicode UTF16-LE with no BOM
    public final static int FO_UTF16_BE_NOBOM = 2048; //Write mode Unicode UTF16-BE with no BOM
    public final static int FO_UTF8_FULL = 16384; //Use full file UTF8 detection if no BOM present
    public final static int FO_FULLFILE_DETECT = 16384; //Use full file UTF8 detection if no BOM present

    //Indicates file read options
    public final static int EOF = -1; //End-of-file reached

    //Indicates file open and save dialog options
    public final static int FD_FILEMUSTEXIST = 1; //File must exist
    public final static int FD_PATHMUSTEXIST = 2; //Path must exist
    public final static int FD_MULTISELECT = 4; //Allow multi-select
    public final static int FD_PROMPTCREATENEW = 8; //Prompt to create new file
    public final static int FD_PROMPTOVERWRITE = 16; //Prompt to overWrite file

    public final static int CREATE_NEW = 1;
    public final static int CREATE_ALWAYS = 2;
    public final static int OPEN_EXISTING = 3;
    public final static int OPEN_ALWAYS = 4;
    public final static int TRUNCATE_EXISTING = 5;

    public final static int INVALID_SET_FILE_POINTER = -1;

    //Indicates starting point for the file pointer move operations
    public final static int FILE_BEGIN = 0;
    public final static int FILE_CURRENT = 1;
    public final static int FILE_END = 2;

    public final static int FILE_ATTRIBUTE_READONLY = 0x00000001;
    public final static int FILE_ATTRIBUTE_HIDDEN = 0x00000002;
    public final static int FILE_ATTRIBUTE_SYSTEM = 0x00000004;
    public final static int FILE_ATTRIBUTE_DIRECTORY = 0x00000010;
    public final static int FILE_ATTRIBUTE_ARCHIVE = 0x00000020;
    public final static int FILE_ATTRIBUTE_DEVICE = 0x00000040;
    public final static int FILE_ATTRIBUTE_NORMAL = 0x00000080;
    public final static int FILE_ATTRIBUTE_TEMPORARY = 0x00000100;
    public final static int FILE_ATTRIBUTE_SPARSE_FILE = 0x00000200;
    public final static int FILE_ATTRIBUTE_REPARSE_POINT = 0x00000400;
    public final static int FILE_ATTRIBUTE_COMPRESSED = 0x00000800;
    public final static int FILE_ATTRIBUTE_OFFLINE = 0x00001000;
    public final static int FILE_ATTRIBUTE_NOT_CONTENT_INDEXED = 0x00002000;
    public final static int FILE_ATTRIBUTE_ENCRYPTED = 0x00004000;

    public final static int FILE_SHARE_READ = 0x00000001;
    public final static int FILE_SHARE_WRITE = 0x00000002;
    public final static int FILE_SHARE_DELETE = 0x00000004;
    public final static int FILE_SHARE_READWRITE = FILE_SHARE_READ | FILE_SHARE_WRITE;
    public final static int FILE_SHARE_ANY = FILE_SHARE_READ | FILE_SHARE_WRITE | FILE_SHARE_DELETE;

    public final static int GENERIC_ALL = 0x10000000;
    public final static int GENERIC_EXECUTE = 0x20000000;
    public final static int GENERIC_WRITE = 0x40000000;
    public final static int GENERIC_READ = 0x80000000;
    public final static int GENERIC_READWRITE = GENERIC_READ | GENERIC_WRITE;

    //FileGetEncoding Constants
    public final static int FILE_ENCODING_UTF16LE = 32;

    public final static int FE_ENTIRE_UTF8 = 1;
    public final static int FE_PARTIALFIRST_UTF8 = 2;

    //FileGetLongName and FileGetShortName
    public final static int FN_FULLPATH = 0;
    public final static int FN_RELATIVEPATH = 1;

    //FileGetVersion Constants _WinAPI_VerQueryValue, _WinAPI_VerQueryValueEx
    public final static String FV_COMMENTS = "Comments";
    public final static String FV_COMPANYNAME = "CompanyName";
    public final static String FV_FILEDESCRIPTION = "FileDescription";
    public final static String FV_FILEVERSION = "FileVersion";
    public final static String FV_INTERNALNAME = "InternalName";
    public final static String FV_LEGALCOPYRIGHT = "LegalCopyright";
    public final static String FV_LEGALTRADEMARKS = "LegalTrademarks";
    public final static String FV_ORIGINALFILENAME = "OriginalFilename";
    public final static String FV_PRODUCTNAME = "ProductName";
    public final static String FV_PRODUCTVERSION = "ProductVersion";
    public final static String FV_PRIVATEBUILD = "PrivateBuild";
    public final static String FV_SPECIALBUILD = "SpecialBuild";

    //Indicates _FileReadToArray modes
    public final static int FRTA_NOCOUNT = 0;
    public final static int FRTA_COUNT = 1;
    public final static int FRTA_INTARRAYS = 2;
    public final static int FRTA_ENTIRESPLIT = 4;

    //Indicates _FileListToArray modes
    public final static int FLTA_FILESFOLDERS = 0;
    public final static int FLTA_FILES = 1;
    public final static int FLTA_FOLDERS = 2;

    //Indicates _FileListToArrayRec modes
    public final static int FLTAR_FILESFOLDERS = 0;
    public final static int FLTAR_FILES = 1;
    public final static int FLTAR_FOLDERS = 2;
    public final static int FLTAR_NOHIDDEN = 4;
    public final static int FLTAR_NOSYSTEM = 8;
    public final static int FLTAR_NOLINK = 16;
    public final static int FLTAR_NORECUR = 0;
    public final static int FLTAR_RECUR = 1;
    public final static int FLTAR_NOSORT = 0;
    public final static int FLTAR_SORT = 1;
    public final static int FLTAR_FASTSORT = 2;
    public final static int FLTAR_NOPATH = 0;
    public final static int FLTAR_RELPATH = 1;
    public final static int FLTAR_FULLPATH = 2;

    //Styles
    final static int TVS_HASBUTTONS = 0x00000001; //Displays plus (+) and minus (-) buttons next to parent items
    final static int TVS_HASLINES = 0x00000002; //Uses lines to show the hierarchy of items
    final static int TVS_LINESATROOT = 0x00000004; //Uses lines to link items at the root of the control
    final static int TVS_EDITLABELS = 0x00000008; //Allows the user to edit item labels
    final static int TVS_DISABLEDRAGDROP = 0x00000010; //Prevents the from sending $TVN_BEGINDRAG notification messages
    final static int TVS_SHOWSELALWAYS = 0x00000020; //Causes a selected item to remain selected when the control loses focus
    final static int TVS_RTLREADING = 0x00000040; //Causes text to be displayed from right-to-left
    final static int TVS_NOTOOLTIPS = 0x00000080; //Disables ToolTips
    final static int TVS_CHECKBOXES = 0x00000100; //Enables check boxes for items
    final static int TVS_TRACKSELECT = 0x00000200; //Enables hot tracking
    final static int TVS_SINGLEEXPAND = 0x00000400; //Causes items to automatically expand and collapse upon selection
    final static int TVS_INFOTIP = 0x00000800; //Obtains ToolTip information by sending the $TVN_GETINFOTIP notification
    final static int TVS_FULLROWSELECT = 0x00001000; //Enables full row selection
    final static int TVS_NOSCROLL = 0x00002000; //Disables both horizontal and vertical scrolling in the control
    final static int TVS_NONEVENHEIGHT = 0x00004000; //Sets item height with the $TVM_SETITEMHEIGHT message
    final static int TVS_NOHSCROLL = 0x00008000; //Disables horizontal scrolling in the control
    final static int TVS_DEFAULT = 0x00000037; //Default control style

    //Control default styles
    final static int GUI_SS_DEFAULT_TREEVIEW = TVS_HASBUTTONS | TVS_HASLINES | TVS_LINESATROOT | TVS_DISABLEDRAGDROP | TVS_SHOWSELALWAYS;

    //Expand flags
    final static int TVE_COLLAPSE = 0x0001;
    final static int TVE_EXPAND = 0x0002;
    final static int TVE_TOGGLE = 0x0003;
    final static int TVE_EXPANDPARTIAL = 0x4000;
    final static int TVE_COLLAPSERESET = 0x8000;

    //GetNext flags
    final static int TVGN_ROOT = 0x00000000;
    final static int TVGN_NEXT = 0x00000001;
    final static int TVGN_PREVIOUS = 0x00000002;
    final static int TVGN_PARENT = 0x00000003;
    final static int TVGN_CHILD = 0x00000004;
    final static int TVGN_FIRSTVISIBLE = 0x00000005;
    final static int TVGN_NEXTVISIBLE = 0x00000006;
    final static int TVGN_PREVIOUSVISIBLE = 0x00000007;
    final static int TVGN_DROPHILITE = 0x00000008;
    final static int TVGN_CARET = 0x00000009;
    final static int TVGN_LASTVISIBLE = 0x0000000A;

    //HitTest flags
    final static int TVHT_NOWHERE = 0x00000001;
    final static int TVHT_ONITEMICON = 0x00000002;
    final static int TVHT_ONITEMLABEL = 0x00000004;
    final static int TVHT_ONITEMINDENT = 0x00000008;
    final static int TVHT_ONITEMBUTTON = 0x00000010;
    final static int TVHT_ONITEMRIGHT = 0x00000020;
    final static int TVHT_ONITEMSTATEICON = 0x00000040;
    final static int TVHT_ONITEM = 0x00000046;
    final static int TVHT_ABOVE = 0x00000100;
    final static int TVHT_BELOW = 0x00000200;
    final static int TVHT_TORIGHT = 0x00000400;
    final static int TVHT_TOLEFT = 0x00000800;

    //Insert flags
    final static int TVI_ROOT = 0xFFFF0000;
    final static int TVI_FIRST = 0xFFFF0001;
    final static int TVI_LAST = 0xFFFF0002;
    final static int TVI_SORT = 0xFFFF0003;

    //item/itemex mask flags
    final static int TVIF_TEXT = 0x00000001;
    final static int TVIF_IMAGE = 0x00000002;
    final static int TVIF_PARAM = 0x00000004;
    final static int TVIF_STATE = 0x00000008;
    final static int TVIF_HANDLE = 0x00000010;
    final static int TVIF_SELECTEDIMAGE = 0x00000020;
    final static int TVIF_CHILDREN = 0x00000040;
    final static int TVIF_INTEGRAL = 0x00000080;
    final static int TVIF_EXPANDEDIMAGE = 0x00000100;
    final static int TVIF_STATEEX = 0x00000200;
    final static int TVIF_DI_SETITEM = 0x00001000;

    //image list params
    final static int TVSIL_NORMAL = 0;
    final static int TVSIL_STATE = 2;

    //type of action
    final static int TVC_BYKEYBOARD = 0x2;
    final static int TVC_BYMOUSE = 0x1;
    final static int TVC_UNKNOWN = 0x0;

    //item states
    final static int TVIS_FOCUSED = 0x00000001;
    final static int TVIS_SELECTED = 0x00000002;
    final static int TVIS_CUT = 0x00000004;
    final static int TVIS_DROPHILITED = 0x00000008;
    final static int TVIS_BOLD = 0x00000010;
    final static int TVIS_EXPANDED = 0x00000020;
    final static int TVIS_EXPANDEDONCE = 0x00000040;
    final static int TVIS_EXPANDPARTIAL = 0x00000080;
    final static int TVIS_OVERLAYMASK = 0x00000F00;
    final static int TVIS_STATEIMAGEMASK = 0x0000F000;
    final static int TVIS_USERMASK = 0x0000F000;
    final static int TVIS_UNCHECKED = 4096;
    final static int TVIS_CHECKED = 8192;

    final static int TVNA_ADD = 1;
    final static int TVNA_ADDFIRST = 2;
    final static int TVNA_ADDCHILD = 3;
    final static int TVNA_ADDCHILDFIRST = 4;
    final static int TVNA_INSERT = 5;

    final static int TVTA_ADDFIRST = 1;
    final static int TVTA_ADD = 2;
    final static int TVTA_INSERT = 3;

    //Messages to send to TreeView
    final static int TV_FIRST = 0x1100;
    final static int TVM_INSERTITEMA = TV_FIRST + 0;
    final static int TVM_DELETEITEM = TV_FIRST + 1;
    final static int TVM_EXPAND = TV_FIRST + 2;
    public final static int TVM_GETITEMRECT = TV_FIRST + 4;
    final static int TVM_GETCOUNT = TV_FIRST + 5;
    final static int TVM_GETINDENT = TV_FIRST + 6;
    final static int TVM_SETINDENT = TV_FIRST + 7;
    final static int TVM_GETIMAGELIST = TV_FIRST + 8;
    final static int TVM_SETIMAGELIST = TV_FIRST + 9;
    final static int TVM_GETNEXTITEM = TV_FIRST + 10;
    final static int TVM_SELECTITEM = TV_FIRST + 11;
    final static int TVM_GETITEMA = TV_FIRST + 12;
    final static int TVM_SETITEMA = TV_FIRST + 13;
    final static int TVM_EDITLABELA = TV_FIRST + 14;
    final static int TVM_GETEDITCONTROL = TV_FIRST + 15;
    final static int TVM_GETVISIBLECOUNT = TV_FIRST + 16;
    final static int TVM_HITTEST = TV_FIRST + 17;
    final static int TVM_CREATEDRAGIMAGE = TV_FIRST + 18;
    final static int TVM_SORTCHILDREN = TV_FIRST + 19;
    final static int TVM_ENSUREVISIBLE = TV_FIRST + 20;
    final static int TVM_SORTCHILDRENCB = TV_FIRST + 21;
    final static int TVM_ENDEDITLABELNOW = TV_FIRST + 22;
    final static int TVM_GETISEARCHSTRINGA = TV_FIRST + 23;
    final static int TVM_SETTOOLTIPS = TV_FIRST + 24;
    final static int TVM_GETTOOLTIPS = TV_FIRST + 25;
    final static int TVM_SETINSERTMARK = TV_FIRST + 26;
    final static int TVM_SETITEMHEIGHT = TV_FIRST + 27;
    final static int TVM_GETITEMHEIGHT = TV_FIRST + 28;
    final static int TVM_SETBKCOLOR = TV_FIRST + 29;
    final static int TVM_SETTEXTCOLOR = TV_FIRST + 30;
    final static int TVM_GETBKCOLOR = TV_FIRST + 31;
    final static int TVM_GETTEXTCOLOR = TV_FIRST + 32;
    final static int TVM_SETSCROLLTIME = TV_FIRST + 33;
    final static int TVM_GETSCROLLTIME = TV_FIRST + 34;
    final static int TVM_SETINSERTMARKCOLOR = TV_FIRST + 37;
    final static int TVM_GETINSERTMARKCOLOR = TV_FIRST + 38;
    final static int TVM_GETITEMSTATE = TV_FIRST + 39;
    final static int TVM_SETLINECOLOR = TV_FIRST + 40;
    final static int TVM_GETLINECOLOR = TV_FIRST + 41;
    final static int TVM_MAPACCIDTOHTREEITEM = TV_FIRST + 42;
    final static int TVM_MAPHTREEITEMTOACCID = TV_FIRST + 43;
    final static int TVM_INSERTITEMW = TV_FIRST + 50;
    final static int TVM_GETITEMW = TV_FIRST + 62;
    final static int TVM_SETITEMW = TV_FIRST + 63;
    final static int TVM_GETISEARCHSTRINGW = TV_FIRST + 64;
    final static int TVM_EDITLABELW = TV_FIRST + 65;
    final static int TVM_GETUNICODEFORMAT = 0x2000 + 6;
    final static int TVM_SETUNICODEFORMAT = 0x2000 + 5;

    //Notifications
    final static int TVN_FIRST = -400;
    final static int TVN_SELCHANGINGA = TVN_FIRST - 1;
    final static int TVN_SELCHANGEDA = TVN_FIRST - 2;
    final static int TVN_GETDISPINFOA = TVN_FIRST - 3;
    final static int TVN_SETDISPINFOA = TVN_FIRST - 4;
    final static int TVN_ITEMEXPANDINGA = TVN_FIRST - 5;
    final static int TVN_ITEMEXPANDEDA = TVN_FIRST - 6;
    final static int TVN_BEGINDRAGA = TVN_FIRST - 7;
    final static int TVN_BEGINRDRAGA = TVN_FIRST - 8;
    final static int TVN_DELETEITEMA = TVN_FIRST - 9;
    final static int TVN_BEGINLABELEDITA = TVN_FIRST - 10;
    final static int TVN_ENDLABELEDITA = TVN_FIRST - 11;
    final static int TVN_KEYDOWN = TVN_FIRST - 12;
    final static int TVN_GETINFOTIPA = TVN_FIRST - 13;
    final static int TVN_GETINFOTIPW = TVN_FIRST - 14;
    final static int TVN_SINGLEEXPAND = TVN_FIRST - 15;
    final static int TVN_ITEMCHANGINGA = TVN_FIRST - 16;
    final static int TVN_ITEMCHANGINGW = TVN_FIRST - 17;
    final static int TVN_ITEMCHANGEDA = TVN_FIRST - 18;
    final static int TVN_ITEMCHANGEDW = TVN_FIRST - 19;
    final static int TVN_SELCHANGINGW = TVN_FIRST - 50;
    final static int TVN_SELCHANGEDW = TVN_FIRST - 51;
    final static int TVN_GETDISPINFOW = TVN_FIRST - 52;
    final static int TVN_SETDISPINFOW = TVN_FIRST - 53;
    final static int TVN_ITEMEXPANDINGW = TVN_FIRST - 54;
    final static int TVN_ITEMEXPANDEDW = TVN_FIRST - 55;
    final static int TVN_BEGINDRAGW = TVN_FIRST - 56;
    final static int TVN_BEGINRDRAGW = TVN_FIRST - 57;
    final static int TVN_DELETEITEMW = TVN_FIRST - 58;
    final static int TVN_BEGINLABELEDITW = TVN_FIRST - 59;
    final static int TVN_ENDLABELEDITW = TVN_FIRST - 60;

    WinApi(XmlRpcClient agent) {
        Agent.log.info(">> " + "agent = " + agent.getURL());
        this.agent = agent;
        Agent.log.info("<< " + this.toString());
    }

    /**
     * Method <b>changeDisplaySettings(lpDevMode, dwflags)</b><br>
     * The ChangeDisplaySettings function changes the display settings to the specified graphics mode.
     *
     * <b>Remarks </b><br>
     * Using the DEVMODE returned by the EnumDisplaySettings function ensures that the DEVMODE passed to ChangeDisplaySettings
     * is valid and contains only values supported by the display driver.<br>
     * See http://winapi.freetechsecrets.com/win32/WIN32ChangeDisplaySettings.htm
     *
     * @param lpDevMode - pointer to a DEVMODE structure that describes the graphics mode to switch to.
     *                  The dmSize member must be initialized to the size, in bytes, of the DEVMODE structure.
     * @param dwflags   - indicates how the graphics mode should be changed. .
     * @return If the function succeeds, the return value is zero. If the function fails, the return value is nonzero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public int changeDisplaySettings(Structure lpDevMode, int dwflags) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpDevMode = " + lpDevMode + ", " + "dwflags = " + dwflags);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpDevMode));
        params.addElement(Marshal.serialize(dwflags));

        String res;
        try {
            res = (String) agent.execute("WinApi.changeDisplaySettings", params);
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

    /**
     * Method <b>closeHandle(hObject) </b><br>
     * The CloseHandle function closes an open object handle.
     *
     * <b>Remarks </b><br>
     * The CloseHandle function closes handles to the following objects: Console input or output, ,Event file, ,File mapping, , Mutex,
     * Named pipe, Process, Semaphore, Thread, Token (Windows NT only).<br>
     * CloseHandle invalidates the specified object handle, decrements the object's handle count, and performs object retention checks.
     * Once the last handle to an object is closed, the object is removed from the operating system. This function does not close module objects.
     * Use CloseHandle to close handles returned by calls to the CreateFile function. Use FindClose to close handles returned by calls to the FindFirstFile function.
     * Closing an invalid handle raises an exception. This includes closing a handle twice, not checking the return value and closing an invalid handle, and
     * using CloseHandle on a handle returned by FindFirstFile.
     *
     * @param hObject - Identifies an open object handle.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean closeHandle(HANDLE hObject) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hObject = " + hObject);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hObject));
        String res;
        try {
            res = (String) agent.execute("WinApi.closeHandle", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>closeClipboard() </b><br>
     * Closes the clipboard.
     *
     * <b>Remarks </b><br>
     * When the window has finished examining or changing the clipboard, close the clipboard by calling CloseClipboard. This enables other windows to access the clipboard.
     * Do not place an object on the clipboard after calling CloseClipboard.
     *
     * @return When the window has finished examining or changing the clipboard, close the clipboard by calling CloseClipboard. This enables other windows to access the clipboard.
     * Do not place an object on the clipboard after calling CloseClipboard.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean closeClipboard() throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL());
        Vector<Object> params = new Vector<>();
        String res;
        try {
            res = (String) agent.execute("WinApi.closeClipboard", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>emptyClipboard() </b><br>
     * Empties the clipboard and frees handles to data in the clipboard. The function then assigns ownership of the clipboard to the window that currently has the clipboard open.
     *
     * <b>Remarks </b><br>
     * Before calling EmptyClipboard, an application must open the clipboard by using the OpenClipboard function. If the application specifies a NULL window handle when opening the clipboard,
     * EmptyClipboard succeeds but sets the clipboard owner to NULL. Note that this causes SetClipboardData to fail.
     *
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean emptyClipboard() throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL());
        Vector<Object> params = new Vector<>();
        String res;
        try {
            res = (String) agent.execute("WinApi.emptyClipboard", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>enumDisplaySettings(lpszDeviceName, iModeNum, lpDevMode)</b><br>
     * The EnumDisplaySettings function obtains information about one of a display device's graphics modes. You can obtain information
     * for all of a display device's graphics modes by making a series of calls to this function.
     *
     * <b>Remarks </b><br>
     * See http://winapi.freetechsecrets.com/win32/WIN32EnumDisplaySettings.htm
     *
     * @param lpszDeviceName - pointer to a null-terminated string that specifies the display device whose graphics mode the function will
     *                       obtain information about. This parameter can be NULL. A NULL value specifies the current display device on the computer that
     *                       the calling thread is running on. If lpszDeviceName is not NULL, the string must be of the form \\.\DisplayX, where X can have the values 1, 2, or 3.
     * @param iModeNum       - index value that specifies the graphics mode for which information is to be obtained.
     *                       Graphics mode indexes start at zero. To obtain information for all of a display device's graphics modes, make a series of calls to EnumDisplaySettings,
     *                       as follows: Set iModeNum to zero for the first call, and increment iModeNum by one for each subsequent call.
     *                       Continue calling the function until the return value is FALSE.
     *                       When you call EnumDisplaySettings with iModeNum set to zero, the operating system initializes and caches information about the display device.
     *                       When you call EnumDisplaySettings with iModeNum set to a non-zero value, the function returns the information that was cached the last time the function was called with iModeNum set to zero.
     * @param lpDevMode      - pointer to a DEVMODE structure into which the function stores information about the specified graphics mode.
     * @return If the function succeeds, the return value is true.
     * If the function fails, the return value is false.
     * The function fails if iModeNum is greater than the index of the display device's last graphics mode. As noted in the description
     * of the iModeNum parameter, you can use this behavior to enumerate all of a display device's graphics modes.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean enumDisplaySettings(String lpszDeviceName, int iModeNum, Structure lpDevMode) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpszDeviceName = " + lpszDeviceName + ", " + "iModeNum = " + iModeNum + ", " + "lpDevMode = " + lpDevMode);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpszDeviceName));
        params.addElement(Marshal.serialize(iModeNum));
        params.addElement(Marshal.serialize(lpDevMode));

        String res;
        try {
            res = (String) agent.execute("WinApi.enumDisplaySettings", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class EnumDisplaySettings {
            boolean res;
            Structure lpDevMode;
        }

        EnumDisplaySettings eds = (EnumDisplaySettings) Marshal.deserialize(res);

        boolean ret = eds.res;

        if (eds.lpDevMode instanceof DEVMODE) {
            ((DEVMODE) lpDevMode).dmDeviceName = ((DEVMODE) eds.lpDevMode).dmDeviceName;
            ((DEVMODE) lpDevMode).dmSpecVersion = ((DEVMODE) eds.lpDevMode).dmSpecVersion;
            ((DEVMODE) lpDevMode).dmDriverVersion = ((DEVMODE) eds.lpDevMode).dmDriverVersion;
            ((DEVMODE) lpDevMode).dmSize = ((DEVMODE) eds.lpDevMode).dmSize;
            ((DEVMODE) lpDevMode).dmDriverExtra = ((DEVMODE) eds.lpDevMode).dmDriverExtra;
            ((DEVMODE) lpDevMode).dmFields = ((DEVMODE) eds.lpDevMode).dmFields;
            ((DEVMODE) lpDevMode).dmOrientation = ((DEVMODE) eds.lpDevMode).dmOrientation;
            ((DEVMODE) lpDevMode).dmPaperSize = ((DEVMODE) eds.lpDevMode).dmPaperSize;
            ((DEVMODE) lpDevMode).dmPaperLength = ((DEVMODE) eds.lpDevMode).dmPaperLength;
            ((DEVMODE) lpDevMode).dmPaperWidth = ((DEVMODE) eds.lpDevMode).dmPaperWidth;
            ((DEVMODE) lpDevMode).dmScale = ((DEVMODE) eds.lpDevMode).dmScale;
            ((DEVMODE) lpDevMode).dmCopies = ((DEVMODE) eds.lpDevMode).dmCopies;
            ((DEVMODE) lpDevMode).dmDefaultScore = ((DEVMODE) eds.lpDevMode).dmDefaultScore;
            ((DEVMODE) lpDevMode).dmPrintQuality = ((DEVMODE) eds.lpDevMode).dmPrintQuality;
            ((DEVMODE) lpDevMode).dmColor = ((DEVMODE) eds.lpDevMode).dmColor;
            ((DEVMODE) lpDevMode).dmDuplex = ((DEVMODE) eds.lpDevMode).dmDuplex;
            ((DEVMODE) lpDevMode).dmYResolution = ((DEVMODE) eds.lpDevMode).dmYResolution;
            ((DEVMODE) lpDevMode).dmTTOption = ((DEVMODE) eds.lpDevMode).dmTTOption;
            ((DEVMODE) lpDevMode).dmCollate = ((DEVMODE) eds.lpDevMode).dmCollate;
            ((DEVMODE) lpDevMode).dmFormName = ((DEVMODE) eds.lpDevMode).dmFormName;
            ((DEVMODE) lpDevMode).dmLogPixels = ((DEVMODE) eds.lpDevMode).dmLogPixels;
            ((DEVMODE) lpDevMode).dmBitsPerPel = ((DEVMODE) eds.lpDevMode).dmBitsPerPel;
            ((DEVMODE) lpDevMode).dmPelsWidth = ((DEVMODE) eds.lpDevMode).dmPelsWidth;
            ((DEVMODE) lpDevMode).dmPelsHeight = ((DEVMODE) eds.lpDevMode).dmPelsHeight;
            ((DEVMODE) lpDevMode).dmNup = ((DEVMODE) eds.lpDevMode).dmNup;
            ((DEVMODE) lpDevMode).dmDisplayFrequency = ((DEVMODE) eds.lpDevMode).dmDisplayFrequency;
            ((DEVMODE) lpDevMode).dmICMMethod = ((DEVMODE) eds.lpDevMode).dmICMMethod;
            ((DEVMODE) lpDevMode).dmICMIntent = ((DEVMODE) eds.lpDevMode).dmICMIntent;
            ((DEVMODE) lpDevMode).dmMediaType = ((DEVMODE) eds.lpDevMode).dmMediaType;
            ((DEVMODE) lpDevMode).dmDitherType = ((DEVMODE) eds.lpDevMode).dmDitherType;
            ((DEVMODE) lpDevMode).dmReserved1 = ((DEVMODE) eds.lpDevMode).dmReserved1;
            ((DEVMODE) lpDevMode).dmReserved2 = ((DEVMODE) eds.lpDevMode).dmReserved2;
            ((DEVMODE) lpDevMode).dmPanningWidth = ((DEVMODE) eds.lpDevMode).dmPanningWidth;
            ((DEVMODE) lpDevMode).dmPanningHeight = ((DEVMODE) eds.lpDevMode).dmPanningHeight;
        } else {
            lpDevMode = eds.lpDevMode;
        }

        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>openClipboard(hWndNewOwner) </b><br>
     * Opens the clipboard for examination and prevents other applications from modifying the clipboard content.
     *
     * <b>Remarks </b><br>
     * The CloseHandle function closes handles to the following objects: Console input or output, ,Event file, ,File mapping, , Mutex,
     * Named pipe, Process, Semaphore, Thread, Token (Windows NT only).<br>
     * CloseHandle invalidates the specified object handle, decrements the object's handle count, and performs object retention checks.
     * Once the last handle to an object is closed, the object is removed from the operating system. This function does not close module objects.
     * Use CloseHandle to close handles returned by calls to the CreateFile function. Use FindClose to close handles returned by calls to the FindFirstFile function.
     * Closing an invalid handle raises an exception. This includes closing a handle twice, not checking the return value and closing an invalid handle, and
     * using CloseHandle on a handle returned by FindFirstFile.
     *
     * @param hWndNewOwner - A handle to the window to be associated with the open clipboard. If this parameter is NULL, the open clipboard is associated with the current task.
     * @return OpenClipboard fails if another window has the clipboard open. An application should call the CloseClipboard function after every successful call to OpenClipboard.
     * The window identified by the hWndNewOwner parameter does not become the clipboard owner unless the EmptyClipboard function is called. If an application calls OpenClipboard
     * with hwnd set to NULL, EmptyClipboard sets the clipboard owner to NULL; this causes SetClipboardData to fail.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean openClipboard(HWND hWndNewOwner) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hWndNewOwner = " + hWndNewOwner);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hWndNewOwner));
        String res;
        try {
            res = (String) agent.execute("WinApi.openClipboard", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>openProcess(dwDesiredAccess, bInheritHandle, dwProcessId)</b><br>
     * The OpenProcess function returns a handle of an existing process object.
     *
     * <b>Remarks </b><br>
     * The handle returned by the OpenProcess function can be used in any function that requires a handle to a process, such as the wait functions,
     * provided the appropriate access rights were requested. When you are finished with the handle, be sure to close it using the CloseHandle function.
     *
     * @param dwDesiredAccess - Specifies the access to the process object. For operating systems that support security checking, this access is checked
     *                        against any security descriptor for the target process. Any combination of the following access flags can be specified in addition to the STANDARD_RIGHTS_REQUIRED access flags.
     * @param bInheritHandle  - Specifies whether the returned handle can be inherited by a new process created by the current process. If TRUE, the handle is inheritable.
     * @param dwProcessId     - Specifies the process identifier of the process to open.
     * @return If the function succeeds, the return value is an open handle of the specified process. If the function fails, the return value is NULL.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public HANDLE openProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "dwDesiredAccess = " + dwDesiredAccess + ", " + "bInheritHandle = " + bInheritHandle + ", " + "dwProcessId = " + dwProcessId);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(dwDesiredAccess));
        params.addElement(Marshal.serialize(bInheritHandle));
        params.addElement(Marshal.serialize(dwProcessId));
        String res;
        try {
            res = (String) agent.execute("WinApi.openProcess", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        HANDLE ret = (HANDLE) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>readProcessMemory(hProcess, lpBaseAddress, lpBuffer, nSize, lpNumberOfBytesRead)</b><br>
     * The ReadProcessMemory function reads memory in a specified process. The entire area to be read must be accessible, or the operation fails.
     *
     * <b>Remarks </b><br>
     * ReadProcessMemory copies the data in the specified address range from the address space of the specified process into the specified buffer of the current process.
     * Any process that has a handle with PROCESS_VM_READ access can call the function. The process whose address space is read is typically, but not necessarily, being debugged.
     * The entire area to be read must be accessible. If it is not, the function fails as noted previously.
     *
     * @param hProcess            - Identifies an open handle of a process whose memory is read. The handle must have PROCESS_VM_READ access to the process.
     * @param lpBaseAddress       - Points to the base address in the specified process to be read. Before any data transfer occurs, the system verifies that all data in the base address
     *                            and memory of the specified size is accessible for read access. If this is the case, the function proceeds; otherwise, the function fails.
     * @param lpBuffer            - Points to a buffer that receives the contents from the address space of the specified process.
     * @param nSize               - Specifies the requested number of bytes to read from the specified process.
     * @param lpNumberOfBytesRead - Points to the actual number of bytes transferred into the specified buffer. If lpNumberOfBytesRead is NULL, the parameter is ignored.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.
     * The function fails if the requested read operation crosses into an area of the process that is inaccessible.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean readProcessMemory(HANDLE hProcess, Pointer lpBaseAddress, Structure lpBuffer, int nSize, Pointer lpNumberOfBytesRead) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hProcess = " + hProcess + ", " + "lpBaseAddress = " + lpBaseAddress + ", " + "lpBuffer = " + lpBuffer + ", " + "nSize = " + nSize + ", " + "lpNumberOfBytesRead = " + lpNumberOfBytesRead);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hProcess));
        params.addElement(Marshal.serialize(lpBaseAddress));
        params.addElement(Marshal.serialize(lpBuffer));  //check this one!
        params.addElement(Marshal.serialize(nSize));
        params.addElement(Marshal.serialize(lpNumberOfBytesRead));
        String res;
        try {
            res = (String) agent.execute("WinApi.readProcessMemory", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class ReadProcessMemory {
            boolean res;
            Structure lpBuffer;
        }

        ReadProcessMemory rv = (ReadProcessMemory) Marshal.deserialize(res);
        boolean ret = rv.res;

        if (rv.lpBuffer instanceof RECT) {
            ((RECT) lpBuffer).left = ((RECT) rv.lpBuffer).left;
            ((RECT) lpBuffer).right = ((RECT) rv.lpBuffer).right;
            ((RECT) lpBuffer).bottom = ((RECT) rv.lpBuffer).bottom;
            ((RECT) lpBuffer).top = ((RECT) rv.lpBuffer).top;
        } else if (rv.lpBuffer instanceof POINT) {
            ((POINT) lpBuffer).x = ((POINT) rv.lpBuffer).x;
            ((POINT) lpBuffer).y = ((POINT) rv.lpBuffer).y;
        } else {
            lpBuffer = rv.lpBuffer;
        }

        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>virtualAllocEx(hProcess, lpAddress, dwSize, flAllocationType, flProtect)</b><br>
     * The VirtualAllocEx function reserves, commits, or both, a region of memory within the virtual address space of a specified process.
     * The function initializes the memory it allocates to zero. The difference between the VirtualAllocEx function and the VirtualAlloc function is that VirtualAlloc
     * allocates memory within the address space of the calling process, while VirtualAllocEx lets you specify a process.
     *
     * <b>Remarks </b><br>
     * The VirtualAllocEx function can perform the following operations:<br>
     * - Commit a region of pages reserved by a previous call to the VirtualAllocEx function.<br>
     * - Reserve a region of free pages.<br>
     * - Reserve and commit a region of free pages.<br>
     * You can use VirtualAllocEx to reserve a block of pages and then make additional calls to VirtualAllocEx to commit individual pages from the reserved block.
     * This lets you reserve a range of a process's virtual address space without consuming physical storage until it is needed.<br>
     * If the lpAddress parameter is not NULL, the function uses the lpAddress and dwSize parameters to compute the region of pages to be allocated.
     * The current state of the entire range of pages must be compatible with the type of allocation specified by the flAllocationType parameter.
     * Otherwise, the function fails and none of the pages is allocated. This compatibility requirement does not preclude committing an already committed page; see the preceding list.
     * The PAGE_GUARD protection modifier flag establishes guard pages. Guard pages act as one-shot access alarms.<br>
     * See http://winapi.freetechsecrets.com/win32/WIN32VirtualAllocEx_New__Windows_NT.htm
     *
     * @param hProcess         - Handle to a process. The function allocates memory within the virtual address space of this process. You must have PROCESS_VM_OPERATION access to the process.
     *                         If you do not, the function fails.
     * @param lpAddress        - Pointer that specifies a desired starting address for the region of pages that you want to allocate. If you are reserving memory, the function rounds this
     *                         address down to the nearest 64-kilobyte boundary. If you are committing memory that is already reserved, the function rounds this address down to the nearest page boundary.
     *                         To determine the size of a page on the host computer, use the GetSystemInfo function. If lpAddress is NULL, the function determines where to allocate the region.
     * @param dwSize           - Specifies the size, in bytes, of the region of memory to allocate. If lpAddress is NULL, the function rounds dwSize up to the next page boundary.
     *                         If lpAddress is not NULL, the function allocates all pages that contain one or more bytes in the range from lpAddress to (lpAddress+dwSize).
     *                         This means, for example, that a 2-byte range that straddles a page boundary causes the function to allocate both pages.
     * @param flAllocationType - A set of bit flags that specifies the type of memory allocation.
     * @param flProtect        - A set of bit flags that specifies access protection for the region of pages you are allocating. You can specify one of the following flags,
     *                         along with the PAGE_GUARD and PAGE_NOCACHE protection modifier flags
     * @return If the function succeeds, the return value is the base address of the allocated region of pages. If the function fails, the return value is NULL.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public Pointer virtualAllocEx(HANDLE hProcess, Pointer lpAddress, int dwSize, int flAllocationType, int flProtect) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hProcess = " + hProcess + ", " + "lpAddress = " + lpAddress + ", " + "dwSize = " + dwSize + ", " + "flAllocationType = " + flAllocationType + ", " + "flProtect = " + flProtect);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hProcess));
        params.addElement(Marshal.serialize(Pointer.nativeValue(lpAddress)));
        params.addElement(Marshal.serialize(dwSize));
        params.addElement(Marshal.serialize(flAllocationType));
        params.addElement(Marshal.serialize(flProtect));
        String res;
        try {
            res = (String) agent.execute("WinApi.virtualAllocEx", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        Pointer ret = (Pointer) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>virtualFreeEx(hProcess, lpAddress, dwSize, dwFreeType)</b><br>
     * The VirtualFreeEx function releases, decommits, or both, a region of memory within the virtual address space of a specified process.
     * The difference between the VirtualFreeEx function and the VirtualFree function is that VirtualFree frees memory within the address space of the calling process,
     * while VirtualFreeEx lets you specify a process.
     *
     * <b>Remarks </b><br>
     * See: http://winapi.freetechsecrets.com/win32/WIN32VirtualFreeEx_New__Windows_NT.htm
     *
     * @param hProcess   - Handle to a process. The function frees memory within the virtual address space of this process. You must have PROCESS_VM_OPERATION access to this process.
     *                   If you do not, the function fails.
     * @param lpAddress  - Pointer to the starting address of the region of memory to free. If the MEM_RELEASE flag is set in the dwFreeType parameter,
     *                   lpAddress must be the base address returned by the VirtualAllocEx function when the region was reserved.
     * @param dwSize     - Specifies the size, in bytes, of the region of memory to free.  If the MEM_RELEASE flag is set in the dwFreeType parameter, dwSize must be zero.
     *                   The function frees the entire region that was reserved in the initial allocation call to VirtualAllocEx. If the MEM_DECOMMIT flag is set, the function decommits all memory pages
     *                   that contain one or more bytes in the range from the lpAddress parameter to (lpAddress+dwSize). This means, for example, that a 2-byte region of memory that straddles a page boundary
     *                   causes both pages to be decommitted.
     * @param dwFreeType - Set of bit flags that specifies the type of free operation.
     * @return If the function succeeds, the return value is a nonzero value. If the function fails, the return value is zero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean virtualFreeEx(HANDLE hProcess, Pointer lpAddress, int dwSize, int dwFreeType) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hProcess = " + hProcess + ", " + "lpAddress = " + lpAddress + ", " + "dwFreeType = " + dwFreeType);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hProcess));
        params.addElement(Marshal.serialize(lpAddress));
        params.addElement(Marshal.serialize(dwSize));
        params.addElement(Marshal.serialize(dwFreeType));
        String res;
        try {
            res = (String) agent.execute("WinApi.virtualFreeEx", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>writeProcessMemory(hProcess, lpBaseAddress, lpBuffer, nSize, lpNumberOfBytesWritten)</b><br>
     * The WriteProcessMemory function writes memory in a specified process. The entire area to be written to must be accessible, or the operation fails.
     *
     * <b>Remarks </b><br>
     * WriteProcessMemory copies the data from the specified buffer in the current process to the address range of the specified process. Any process that has a handle
     * with PROCESS_VM_WRITE and PROCESS_VM_OPERATION access to the process to be written to can call the function. The process whose address space is being written to
     * is typically, but not necessarily, being debugged. The entire area to be written to must be accessible. If it is not, the function fails as noted previously.
     *
     * @param hProcess               - Identifies an open handle to a process whose memory is to be written to. The handle must have PROCESS_VM_WRITE and PROCESS_VM_OPERATION access to the process.
     * @param lpBaseAddress          - Points to the base address in the specified process to be written to. Before any data transfer occurs, the system verifies that all data in the base address
     *                               and memory of the specified size is accessible for write access. If this is the case, the function proceeds; otherwise, the function fails.
     * @param lpBuffer               - Points to the buffer that supplies data to be written into the address space of the specified process.
     * @param nSize                  - Specifies the requested number of bytes to write into the specified process.
     * @param lpNumberOfBytesWritten - Points to the actual number of bytes transferred into the specified process. This parameter is optional.
     *                               If lpNumberOfBytesWritten is NULL, the parameter is ignored.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero. To get extended error information, call GetLastError.
     * The function will fail if the requested write operation crosses into an area of the process that is inaccessible.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean writeProcessMemory(HANDLE hProcess, Pointer lpBaseAddress, Structure lpBuffer, int nSize, Pointer lpNumberOfBytesWritten) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hProcess = " + hProcess + ", " + "lpBaseAddress = " + lpBaseAddress + ", " + "lpBuffer = " + lpBuffer + ", " + "nSize = " + nSize + ", " + "lpNumberOfBytesWritten = " + lpNumberOfBytesWritten);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hProcess));   //probably need send int
        params.addElement(Marshal.serialize(lpBaseAddress));  //probably need send native long
        params.addElement(Marshal.serialize(lpBuffer));
        params.addElement(Marshal.serialize(nSize));
        params.addElement(Marshal.serialize(Pointer.nativeValue(lpNumberOfBytesWritten)));
        String res;
        try {
            res = (String) agent.execute("WinApi.writeProcessMemory", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }


        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>clientToScreen(HWND hWnd, Structure lpPoint)</b><br>
     * The ClientToScreen function converts the client coordinates of a specified point to screen coordinates
     *
     * <b>Remarks </b><br>
     * The ClientToScreen function replaces the client coordinates in the POINT structure with the screen coordinates.
     * The screen coordinates are relative to the upper-left corner of the screen.
     *
     * @param hWnd    - Identifies the window whose client area is used for the conversion.
     * @param lpPoint - Points to a POINT structure that contains the client coordinates to be converted. The new screen coordinates are copied into this structure if the function succeeds.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean clientToScreen(HWND hWnd, POINT lpPoint) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hWnd = " + hWnd + ", " + "lpPoint = " + lpPoint);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hWnd));
        params.addElement(Marshal.serialize(lpPoint));
        String res;
        try {
            res = (String) agent.execute("WinApi.clientToScreen", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class ClientToScreen {
            boolean res;
            POINT lpPoint;
        }

        ClientToScreen rv = (ClientToScreen) Marshal.deserialize(res);
        boolean ret = rv.res;
        lpPoint.x = rv.lpPoint.x;
        lpPoint.y = rv.lpPoint.y;

        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Method <b>findWindow(lpClassName, lpWindowName) </b><br>
     * The FindWindow function retrieves the handle to the top-level window whose class name and window name match the specified strings. This function does not search child windows.
     *
     * @param lpClassName  - Points to a null-terminated string that specifies the class name or is an atom that identifies the class-name string. If this parameter is an atom, it must be
     *                     a global atom created by a previous call to the GlobalAddAtom function. The atom, a 16-bit value, must be placed in the low-order word of lpClassName; the high-order word must be zero.
     * @param lpWindowName - Points to a null-terminated string that specifies the window name (the window's title). If this parameter is NULL, all window names match.
     * @return If the function succeeds, the return value is the handle to the window that has the specified class name and window name.If the function fails, the return value is NULL.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public HWND findWindow(String lpClassName, String lpWindowName) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpClassName = " + lpClassName + ", " + "lpWindowName = " + lpWindowName);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpClassName));
        params.addElement(Marshal.serialize(lpWindowName));
        String res;
        try {
            res = (String) agent.execute("WinApi.findWindow", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        HWND ret = (HWND) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Method <b>getWindowThreadProcessId(hWnd, lpdwProcessId)</b><br>
     * The GetWindowThreadProcessId function retrieves the identifier of the thread that created the specified window and, optionally, the identifier of the process that created the window. T
     * his function supersedes the GetWindowTask function.
     *
     * <b>Remarks </b><br>
     * This function replaces the GetWindowTask function of Windows version 3.x.
     *
     * @param hWnd          - Identifies the window.
     * @param lpdwProcessId - Points to a 32-bit value that receives the process identifier. If this parameter is not NULL, GetWindowThreadProcessId copies the identifier of the process to the
     *                      32-bit value; otherwise, it does not.
     * @return the value is the identifier of the thread that created the window.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public int getWindowThreadProcessId(HWND hWnd, IntByReference lpdwProcessId) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hWnd = " + hWnd + ", " + "lpdwProcessId = " + lpdwProcessId.getValue());
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hWnd));
        params.addElement(Marshal.serialize(lpdwProcessId.getValue()));
        String res;
        try {
            res = (String) agent.execute("WinApi.getWindowThreadProcessId", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }


        class WindowThreadProcessId {
            int res;
            int ldwProcessId;
        }

        WindowThreadProcessId rv = (WindowThreadProcessId) Marshal.deserialize(res);

        lpdwProcessId.setValue(rv.ldwProcessId);

        int ret = rv.res;
        Agent.log.info("<< " + ret + ", " + lpdwProcessId.getValue());
        return ret;
    }


    /**
     * Method <b>setCursorPos(X, Y)</b><br>
     * Retrieves the position of the mouse cursor, in screen coordinates.
     *
     * @param lpPoint - A pointer to a POINT structure that receives the screen coordinates of the cursor.
     * @return nonzero if successful or zero otherwise.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean getCursorPos(POINT lpPoint) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpPoint = " + lpPoint);
        Vector<Object> params = new Vector<>();
        String res;
        try {
            res = (String) agent.execute("WinApi.getCursorPos", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class CursorPos {
            boolean res;
            POINT lpPoint;
            long lPoint;
        }

        CursorPos rv = (CursorPos) Marshal.deserialize(res);
        Pointer p = lpPoint.getPointer();
        p.setLong(0, rv.lPoint);

        boolean ret = rv.res;
        lpPoint.x = rv.lpPoint.x;
        lpPoint.y = rv.lpPoint.y;

        Agent.log.info("<< " + ret + ", " + lpPoint);
        return ret;
    }


    /**
     * Method <b>sendMessageW(HWND hWnd, UINT Msg, WPARAM wParam, LPARAM lParam)</b><br>
     * Sends the specified message to a window or windows. The SendMessage function calls the window procedure for the specified
     * window and does not return until the window procedure has processed the message.
     *
     * <b>Remarks </b><br>
     * Applications that need to communicate using HWND_BROADCAST should use the RegisterWindowMessage function to obtain a unique message for inter-application communication.
     * If the specified window was created by the calling thread, the window procedure is called immediately as a subroutine. If the specified window was created by a different thread,
     * Windows switches to that thread and calls the appropriate window procedure. Messages sent between threads are processed only when the receiving thread executes message retrieval code.
     * The sending thread is blocked until the receiving thread processes the message.
     *
     * @param hWnd   - A handle to the window whose window procedure will receive the message. If this parameter is HWND_BROADCAST ((HWND)0xffff),
     *               the message is sent to all top-level windows in the system, including disabled or invisible unowned windows, overlapped windows,
     *               and pop-up windows; but the message is not sent to child windows. Message sending is subject to UIPI. The thread of a process can send
     *               messages only to message queues of threads in processes of lesser or equal integrity level.
     * @param Msg    - The message to be sent.
     * @param wParam - Additional message-specific information.
     * @param lParam - Additional message-specific information.
     * @return a value specifies the result of the message processing; it depends on the message sent.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public LRESULT sendMessage(HWND hWnd, UINT Msg, WPARAM wParam, LPARAM lParam) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hWnd = " + hWnd + ", Msg = " + Msg + ", wParam = " + wParam + ", lParam = " + lParam);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hWnd));
        params.addElement(Marshal.serialize(Msg));
        params.addElement(Marshal.serialize(wParam.longValue())); //fix issue in Agent
        params.addElement(Marshal.serialize(lParam.longValue())); //fix issue in Agent
        String res;
        try {
            res = (String) agent.execute("WinApi.sendMessage", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        LRESULT ret = (LRESULT) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }


    /**
     * Method <b>setCursorPos(X, Y)</b><br>
     * Moves the cursor to the specified screen coordinates. If the new coordinates are not within the screen rectangle set by the most recent ClipCursor function call, the system
     * automatically adjusts the coordinates so that the cursor stays within the rectangle.
     *
     * @param X - the new x-coordinate of the cursor, in screen coordinates.
     * @param Y - the new y-coordinate of the cursor, in screen coordinates.
     * @return nonzero if successful or zero otherwise.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean setCursorPos(int X, int Y) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "X = " + X + ", " + "Y = " + Y);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(X));
        params.addElement(Marshal.serialize(Y));
        String res;
        try {
            res = (String) agent.execute("WinApi.setCursorPos", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Method <b>windowFromPoint(lPoint)</b><br>
     * Retrieves a handle to the window that contains the specified point.
     *
     * @param lPoint - the point to be checked.
     * @return the value is a handle to the window that contains the point. If no window exists at the given point, the return value is NULL. If the point is over a static text control,
     * the return value is a handle to the window under the static text control.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public HWND windowFromPoint(long lPoint) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lPoint = " + lPoint);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lPoint));
        String res;
        try {
            res = (String) agent.execute("WinApi.windowFromPoint", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        HWND ret = (HWND) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Method <b>deleteFileA(lpFileName) </b><br>
     * The DeleteFileA function deletes an existing file.
     *
     * @param lpFileName - Points to a null-terminated string that specifies the file to be deleted.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.<br>
     * @throws XmlRpcException exception
     * @throws IOException     exception
     */
    public boolean deleteFileA(String lpFileName) throws XmlRpcException, IOException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpFileName = " + lpFileName);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpFileName));
        String res;
        try {
            res = (String) agent.execute("WinApi.deleteFileA", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Searches a directory for a file or subdirectory with a name that matches a specific name (or partial name if wildcards are used).
     * To specify additional attributes to use in a search, use the FindFirstFileEx function.
     * To perform this operation as a transacted operation, use the FindFirstFileTransacted function.
     *
     * @param lpFileName     - The directory or path, and the file name, which can include wildcard characters, for example, an asterisk (*) or a question mark (?).
     *                       This parameter should not be NULL, an invalid string (for example, an empty string or a string that is missing the terminating null character), or end in a trailing backslash (\).
     *                       If the string ends with a wildcard, period (.), or directory name, the user must have access permissions to the root and all subdirectories on the path.
     *                       In the ANSI version of this function, the name is limited to MAX_PATH characters. To extend this limit to 32,767 wide characters, call the Unicode version of the function and prepend "\\?\" to the path. For more information, see Naming a File.
     *                       Starting in Windows 10, version 1607, for the unicode version of this function (FindFirstFileW), you can opt-in to remove the MAX_PATH character limitation without prepending "\\?\". See the "Maximum Path Limitation" section of Naming Files, Paths, and Namespaces for details.
     * @param lpFindFileData structure
     * @return a handle
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public HANDLE findFirstFileA(String lpFileName, Structure lpFindFileData) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpFileName = " + lpFileName + ", " + "lpFindFileData = " + lpFindFileData);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpFileName));
        params.addElement(Marshal.serialize(lpFindFileData));

        String res;
        try {
            res = (String) agent.execute("WinApi.findFirstFileA", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class FindFirstFileA {
            HANDLE res;
            Structure lpFindFileData;
        }

        FindFirstFileA fffa = (FindFirstFileA) Marshal.deserialize(res);

        HANDLE ret = fffa.res;

        if (fffa.lpFindFileData instanceof WIN32_FIND_DATA) {
            ((WIN32_FIND_DATA) lpFindFileData).dwFileAttributes = ((WIN32_FIND_DATA) fffa.lpFindFileData).dwFileAttributes;
            ((WIN32_FIND_DATA) lpFindFileData).ftCreationTime = ((WIN32_FIND_DATA) fffa.lpFindFileData).ftCreationTime;
            ((WIN32_FIND_DATA) lpFindFileData).ftLastAccessTime = ((WIN32_FIND_DATA) fffa.lpFindFileData).ftLastAccessTime;
            ((WIN32_FIND_DATA) lpFindFileData).ftLastWriteTime = ((WIN32_FIND_DATA) fffa.lpFindFileData).ftLastWriteTime;
            ((WIN32_FIND_DATA) lpFindFileData).nFileSizeHigh = ((WIN32_FIND_DATA) fffa.lpFindFileData).nFileSizeHigh;
            ((WIN32_FIND_DATA) lpFindFileData).nFileSizeLow = ((WIN32_FIND_DATA) fffa.lpFindFileData).nFileSizeLow;
            ((WIN32_FIND_DATA) lpFindFileData).dwReserved0 = ((WIN32_FIND_DATA) fffa.lpFindFileData).dwReserved0;
            ((WIN32_FIND_DATA) lpFindFileData).dwReserved1 = ((WIN32_FIND_DATA) fffa.lpFindFileData).dwReserved1;
            ((WIN32_FIND_DATA) lpFindFileData).cFileName = ((WIN32_FIND_DATA) fffa.lpFindFileData).cFileName;
            ((WIN32_FIND_DATA) lpFindFileData).cAlternateFileName = ((WIN32_FIND_DATA) fffa.lpFindFileData).cAlternateFileName;
        } else {
            lpFindFileData = fffa.lpFindFileData;
        }

        Agent.log.info("<< " + ret + ", " + lpFindFileData);
        return ret;
    }

    /**
     * Continues a file search from a previous call to the FindFirstFile, FindFirstFileEx, or FindFirstFileTransacted functions.
     *
     * @param hFindFile      - The search handle returned by a previous call to the FindFirstFile or FindFirstFileEx function.
     * @param lpFindFileData - A pointer to the WIN32_FIND_DATA structure that receives information about the found file or subdirectory.
     * @return If the function succeeds, the return value is nonzero and the lpFindFileData parameter contains information about the next file or directory found.
     * If the function fails, the return value is zero and the contents of lpFindFileData are indeterminate
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public boolean findNextFileA(HANDLE hFindFile, Structure lpFindFileData) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hFindFile = " + hFindFile + ", " + "lpFindFileData = " + lpFindFileData);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hFindFile));
        params.addElement(Marshal.serialize(lpFindFileData));

        String res;
        try {
            res = (String) agent.execute("WinApi.findNextFileA", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class FindNextFileA {
            boolean res;
            Structure lpFindFileData;
        }

        FindNextFileA fnfa = (FindNextFileA) Marshal.deserialize(res);

        boolean ret = fnfa.res;

        if (fnfa.lpFindFileData instanceof WIN32_FIND_DATA) {
            ((WIN32_FIND_DATA) lpFindFileData).dwFileAttributes = ((WIN32_FIND_DATA) fnfa.lpFindFileData).dwFileAttributes;
            ((WIN32_FIND_DATA) lpFindFileData).ftCreationTime = ((WIN32_FIND_DATA) fnfa.lpFindFileData).ftCreationTime;
            ((WIN32_FIND_DATA) lpFindFileData).ftLastAccessTime = ((WIN32_FIND_DATA) fnfa.lpFindFileData).ftLastAccessTime;
            ((WIN32_FIND_DATA) lpFindFileData).ftLastWriteTime = ((WIN32_FIND_DATA) fnfa.lpFindFileData).ftLastWriteTime;
            ((WIN32_FIND_DATA) lpFindFileData).nFileSizeHigh = ((WIN32_FIND_DATA) fnfa.lpFindFileData).nFileSizeHigh;
            ((WIN32_FIND_DATA) lpFindFileData).nFileSizeLow = ((WIN32_FIND_DATA) fnfa.lpFindFileData).nFileSizeLow;
            ((WIN32_FIND_DATA) lpFindFileData).dwReserved0 = ((WIN32_FIND_DATA) fnfa.lpFindFileData).dwReserved0;
            ((WIN32_FIND_DATA) lpFindFileData).dwReserved1 = ((WIN32_FIND_DATA) fnfa.lpFindFileData).dwReserved1;
            ((WIN32_FIND_DATA) lpFindFileData).cFileName = ((WIN32_FIND_DATA) fnfa.lpFindFileData).cFileName;
            ((WIN32_FIND_DATA) lpFindFileData).cAlternateFileName = ((WIN32_FIND_DATA) fnfa.lpFindFileData).cAlternateFileName;
        } else {
            lpFindFileData = fnfa.lpFindFileData;
        }

        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * Closes a file search handle opened by the FindFirstFile, FindFirstFileEx, FindFirstFileNameW, FindFirstFileNameTransactedW, FindFirstFileTransacted,
     * FindFirstStreamTransactedW, or FindFirstStreamW functions.
     *
     * @param hFindFile - The file search handle.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public boolean findClose(HANDLE hFindFile) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hFindFile = " + hFindFile);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hFindFile));

        String res;
        try {
            res = (String) agent.execute("WinApi.findClose", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        boolean ret = (boolean) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * The CreateFile function creates or opens the following objects and returns a handle that can be used to access the object:
     * - files
     * - pipes
     * - mailslots
     * - communications resources
     * - disk devices (Windows NT only)
     * - consoles
     * - directories (open only)
     *
     * <b>Remarks </b><br>
     * See: http://winapi.freetechsecrets.com/win32/WIN32CreateFile.htm
     *
     * @param lpFileName             - Points to a null-terminated string that specifies the name of the object (file, pipe, mailslot, communications resource, disk device, console, or directory) to create or open.
     *                               If *lpFileName is a path, there is a default string size limit of MAX_PATH characters. This limit is related to how the CreateFile function parses paths.
     * @param dwDesiredAccess        - Specifies the type of access to the object. An application can obtain read access, write access, read-write access, or device query access. This parameter can be any combination of the following values.
     * @param dwShareMode            - Set of bit flags that specifies how the object can be shared. If dwShareMode is 0, the object cannot be shared. Subsequent open operations on the object will fail, until the handle is closed.
     * @param lpSecurityAttributes   - Pointer to a SECURITY_ATTRIBUTES structure that determines whether the returned handle can be inherited by child processes. If lpSecurityAttributes is NULL, the handle cannot be inherited.
     * @param dwCreationDistribution - Specifies which action to take on files that exist, and which action to take when files do not exist. For more information about this parameter, see the Remarks section.
     * @param dwFlagsAndAttributes   - Specifies the file attributes and flags for the file. Any combination of the following attributes is acceptable, except all other file attributes override FILE_ATTRIBUTE_NORMAL.
     * @param hTemplateFile          - Specifies a handle with GENERIC_READ access to a template file. The template file supplies file attributes and extended attributes for the file being created.
     * @return If the function succeeds, the return value is an open handle to the specified file. If the specified file exists before the function call and dwCreationDistribution is CREATE_ALWAYS or OPEN_ALWAYS, a call to GetLastError returns ERROR_ALREADY_EXISTS (even though the function has succeeded). If the file does not exist before the call, GetLastError returns zero.
     * If the function fails, the return value is INVALID_HANDLE_VALUE.
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public HANDLE createFileA(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDistribution, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "lpFileName = " + lpFileName + ", " + "dwDesiredAccess = " + dwDesiredAccess + ", " + "dwShareMode = " + dwShareMode + ", " + "lpSecurityAttributes = " + lpSecurityAttributes + ", " + "dwCreationDistribution = " + dwCreationDistribution + ", " + "dwFlagsAndAttributes = " + dwFlagsAndAttributes + ", " + "hTemplateFile = " + hTemplateFile);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(lpFileName));
        params.addElement(Marshal.serialize(dwDesiredAccess));
        params.addElement(Marshal.serialize(dwShareMode));
        params.addElement(Marshal.serialize(lpSecurityAttributes));
        params.addElement(Marshal.serialize(dwCreationDistribution));
        params.addElement(Marshal.serialize(dwFlagsAndAttributes));
        params.addElement(Marshal.serialize(hTemplateFile));
        String res;
        try {
            res = (String) agent.execute("WinApi.createFileA", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        HANDLE ret = (HANDLE) Marshal.deserialize(res);
        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * The WriteFile function writes data to a file and is designed for both synchronous and asynchronous operation.
     * The function starts writing data to the file at the position indicated by the file pointer.
     * After the write operation has been completed, the file pointer is adjusted by the number of bytes actually written, except when the file is opened with FILE_FLAG_OVERLAPPED.
     * If the file handle was created for overlapped input and output (I/O), the application must adjust the position of the file pointer after the write operation is finished.
     *
     * <b>Remarks </b><br>
     * See: http://winapi.freetechsecrets.com/win32/WIN32WriteFile.htm
     *
     * @param hFile                  - Identifies the file to be written to. The file handle must have been created with GENERIC_WRITE access to the file
     * @param lpBuffer               - Points to the buffer containing the data to be written to the file.
     * @param nNumberOfBytesToWrite  - Specifies the number of bytes to write to the file. Unlike the MS-DOS operating system, Windows NT interprets a value of zero as specifying a null write operation.
     *                               A null write operation does not write any bytes but does cause the time stamp to change. Named pipe write operations across a network are limited to 65535 bytes.
     * @param lpNumberOfBytesWritten - Points to the number of bytes written by this function call. WriteFile sets this value to zero before doing any work or error checking.
     * @param lpOverlapped           - Points to an OVERLAPPED structure. This structure is required if hFile was opened with FILE_FLAG_OVERLAPPED.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public boolean writeFile(HANDLE hFile, byte[] lpBuffer, int nNumberOfBytesToWrite, IntByReference lpNumberOfBytesWritten, OVERLAPPED lpOverlapped) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hFile = " + hFile + ", " + "lpBuffer = " + lpBuffer + ", " + "nNumberOfBytesToWrite = " + nNumberOfBytesToWrite + ", " + "lpNumberOfBytesWritten = " + lpNumberOfBytesWritten.getValue() + ", " + "lpOverlapped = " + lpOverlapped);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hFile));
        params.addElement(Marshal.serialize(lpBuffer));
        params.addElement(Marshal.serialize(nNumberOfBytesToWrite));
        params.addElement(Marshal.serialize(lpNumberOfBytesWritten.getValue()));
        params.addElement(Marshal.serialize(lpOverlapped));

        String res;
        try {
            res = (String) agent.execute("WinApi.writeFile", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class WriteFile {
            boolean res;
            int lpNumberOfBytesWritten;
            OVERLAPPED lpOverlapped;
        }

        WriteFile wf = (WriteFile) Marshal.deserialize(res);

        boolean ret = wf.res;

        lpNumberOfBytesWritten.setValue(wf.lpNumberOfBytesWritten);

        if (wf.lpOverlapped instanceof OVERLAPPED) {
            lpOverlapped.Internal = wf.lpOverlapped.Internal;
            lpOverlapped.InternalHigh = wf.lpOverlapped.InternalHigh;
            lpOverlapped.Offset = wf.lpOverlapped.Offset;
            lpOverlapped.OffsetHigh = wf.lpOverlapped.OffsetHigh;
            lpOverlapped.hEvent = wf.lpOverlapped.hEvent;
        } else {
            lpOverlapped = wf.lpOverlapped;
        }

        Agent.log.info("<< " + ret);
        return ret;
    }

    /**
     * The ReadFile function reads data from a file, starting at the position indicated by the file pointer.
     * After the read operation has been completed, the file pointer is adjusted by the number of bytes actually read, unless the file handle is created with the overlapped attribute.
     * If the file handle is created for overlapped input and output (I/O), the application must adjust the position of the file pointer after the read operation.
     *
     * <b>Remarks </b><br>
     * See: http://winapi.freetechsecrets.com/win32/WIN32ReadFile.htm
     *
     * @param hFile                - Identifies the file to be read. The file handle must have been created with GENERIC_READ access to the file.
     * @param lpBuffer             - Points to the buffer that receives the data read from the file.
     * @param nNumberOfBytesToRead - Specifies the number of bytes to be read from the file.
     * @param lpNumberOfBytesRead  - Points to the number of bytes read. ReadFile sets this value to zero before doing any work or error checking.
     *                             If this parameter is zero when ReadFile returns TRUE on a named pipe, the other end of the message-mode pipe called the WriteFile function with nNumberOfBytesToWrite set to zero.
     * @param lpOverlapped         - Points to an OVERLAPPED structure. This structure is required if hFile was created with FILE_FLAG_OVERLAPPED.
     * @return If the function succeeds, the return value is nonzero. If the function fails, the return value is zero.
     * @throws IOException     exception
     * @throws XmlRpcException exception
     */
    public boolean readFile(HANDLE hFile, Memory lpBuffer, int nNumberOfBytesToRead, IntByReference lpNumberOfBytesRead, OVERLAPPED lpOverlapped) throws IOException, XmlRpcException {
        Agent.log.info(">> " + "agent = " + agent.getURL() + ", " + "hFile = " + hFile + ", " + "lpBuffer = " + lpBuffer + ", " + "nNumberOfBytesToRead = " + nNumberOfBytesToRead + ", " + "lpNumberOfBytesRead = " + lpNumberOfBytesRead.getValue() + ", " + "lpOverlapped = " + lpOverlapped);
        Vector<Object> params = new Vector<>();
        params.addElement(Marshal.serialize(hFile));
        params.addElement(Marshal.serialize(lpBuffer.getByteArray(0, (int) lpBuffer.size())));
        params.addElement(Marshal.serialize(nNumberOfBytesToRead));
        params.addElement(Marshal.serialize(lpNumberOfBytesRead.getValue()));
        params.addElement(Marshal.serialize(lpOverlapped));

        String res;
        try {
            res = (String) agent.execute("WinApi.readFile", params);
        } catch (XmlRpcException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        } catch (IOException e) {
            Agent.log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }

        class ReadFile {
            boolean res;
            byte[] lpBuffer;
            int lpNumberOfBytesRead;
            OVERLAPPED lpOverlapped;
        }

        ReadFile rf = (ReadFile) Marshal.deserialize(res);
        boolean ret = rf.res;
        lpBuffer.write(0, rf.lpBuffer, 0, rf.lpBuffer.length);
        lpNumberOfBytesRead.setValue(rf.lpNumberOfBytesRead);

        if (rf.lpOverlapped instanceof OVERLAPPED) {
            lpOverlapped.Internal = rf.lpOverlapped.Internal;
            lpOverlapped.InternalHigh = rf.lpOverlapped.InternalHigh;
            lpOverlapped.Offset = rf.lpOverlapped.Offset;
            lpOverlapped.OffsetHigh = rf.lpOverlapped.OffsetHigh;
            lpOverlapped.hEvent = rf.lpOverlapped.hEvent;
        } else {
            lpOverlapped = rf.lpOverlapped;
        }

        Agent.log.info("<< " + ret);
        return ret;
    }
}
