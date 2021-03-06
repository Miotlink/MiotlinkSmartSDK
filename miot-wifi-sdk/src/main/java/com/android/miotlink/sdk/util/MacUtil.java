package com.android.miotlink.sdk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacUtil {

	
	public static boolean isMacAddress(String macAddress) {
		String reg = "^([0-9a-fA-F]){2}([:][0-9a-fA-F]{2}){5}";
		if (macAddress.equals("00.00.00.00.00")) {
			return false;
		}
		return Pattern.compile(reg).matcher(macAddress).find();
	}
	
	public static boolean isMobileNO(String mobiles){ 
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,0-9])|(14[0,7])|(17[0,0-9]))\\d{8}$"); 
		Matcher m = p.matcher(mobiles); 
		return m.matches(); 
		} 
	
	public static String MakeMac(String string){
		String s=string;
		 s=insertString1(":", string, 2);
		 s=insertString1(":", s, 5);
		 s=insertString1(":", s, 8);
		 s=insertString1(":", s, 11);
		 s=insertString1(":", s, 14);
		return s;
		
	}
	
	 public static String insertString1(String srcStr, String descStr, int off)
	    {
	        if(off > descStr.length())
	        {
	            return "";
	        }
	        
	        char[] src = srcStr.toCharArray();
	        char[] desc = descStr.toCharArray();
	        StringBuilder ret = new StringBuilder();
	        
	        for(int i = 0;i <= desc.length;i++)
	        {
	            if(i == off)
	            {
	                for(int j = 0;j < src.length;j++)
	                {
	                    ret.append(src[j]);
	                }
	                
	            }
	            
	            if(i < desc.length)
	            {
	                ret.append(desc[i]);
	            }
	        }
	        
	        return ret.toString();
	    }
}
