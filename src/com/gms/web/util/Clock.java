package com.gms.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	public String getNow(){
				

		return new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ a hh:mm:ss").format(new Date());	
	}

}
