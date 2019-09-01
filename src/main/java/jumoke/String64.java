package jumoke;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Class <b>String64</b></br>
 * 
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 1.0
 */
public class String64 {
	
	public static String decode(String sText64) throws UnsupportedEncodingException{
		byte[] bRes = sText64.getBytes();
		//String sRes = new String(Base64.getDecoder().decode(bRes), "UTF-16");
		//String sRes2 = new String(Base64.getDecoder().decode(bRes), "UTF-8");
		String sRes = new String(Base64.getDecoder().decode(bRes), "Cp1251");
		//String sRes4 = new String(Base64.getDecoder().decode(bRes), "Windows-1251"); //aka Cp1251
		//String sRes5 = new String(Base64.getDecoder().decode(bRes));
		return sRes;
	}
	
	public static String encode(String sText){
		byte[] bRes = sText.getBytes();
		String sRes64 = Base64.getEncoder().encodeToString(bRes);
		return sRes64;
	}
	
}
