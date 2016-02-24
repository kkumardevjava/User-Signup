package com.user.signup.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class Util {
	
	public static int getRandomNumber(int size) {
		Random randomGenerator = new Random();  
	      int randomInt = randomGenerator.nextInt(size);
	      System.out.println("randomInt :"+randomInt);
	      if(randomInt== 0){
	    	  randomInt= 2;
	      }
	      System.out.println("randomInt final :"+randomInt);
		return randomInt;
	} 
	
	public static Date convertStringToDate(String dateString)
	{  
	    Date date = null;
	    String formatteddate = null;
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy",new Locale("en_US"));
	    try{
	        date = df.parse(dateString);
	        formatteddate = df.format(date);
	    }
	    catch ( Exception ex ){
	        System.out.println(ex);
	    }
	    return date;
	}
	
	public static boolean validateDate(Date givenDate)
	{  
		boolean valid=true;
		 Calendar calendar = Calendar.getInstance(); 
		 Date today = calendar.getTime();
		 int comparison = givenDate.compareTo(today);
		 System.out.println("comparison :"+comparison);
		 if(comparison ==1){
			 valid=false;
		 }
	    return valid;
	}
	
	public static void clearSession(HttpSession session) {
		session.removeAttribute("userName");
		session.removeAttribute("dob");
		session.removeAttribute("securityQuestion_01");
		session.removeAttribute("securityAnswer_01");
		session.removeAttribute("securityQuestion_02");
		session.removeAttribute("securityAnswer_02");
		session.removeAttribute("securityQuestion_03");
		session.removeAttribute("securityAnswer_03");
		session.removeAttribute("randomQuestion");
		session.removeAttribute("randomAnswer");
		session.removeAttribute("index");
		session.removeAttribute("signUpSuccess");
		
		
	}

}
