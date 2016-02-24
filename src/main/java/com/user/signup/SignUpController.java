package com.user.signup;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.signup.common.Util;
import com.user.signup.model.SecurityQuestions;
import com.user.signup.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		Util.clearSession(session);
		
		return "mainPage";
	} 


	@RequestMapping(value = "/signupPage", method = RequestMethod.GET)
	public String showSignup(Model model,HttpSession session){
		Util.clearSession(session);
		logger.info("inside showSignUp Page");
		model.addAttribute("userForm", new User());
		return "signupPage";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	 public ModelAndView  addUserToSession(@Valid @ModelAttribute("userForm") User user,HttpSession session,BindingResult result, Model model) {
		 ModelAndView modelAndView = new ModelAndView(); 
		String userName = user.getUserName();
		logger.info("userName :"+userName);
		String dob = user.getDob();
		logger.info("dob :"+dob);
		logger.info("result :"+result);
		if(null == userName || userName.isEmpty()){ 
			result.addError(new ObjectError("userName", "UserName is Required"));
		}
		if(null == dob || dob.isEmpty()){ 
			result.addError(new ObjectError("dob", "Date of Birth is Required"));
		}else{
			Date formatedDate = Util.convertStringToDate(dob);
			logger.info("formatedDate 111:"+formatedDate);
			if(null == formatedDate){
				result.addError(new ObjectError("dob", "Date of Birth is not in correct Format"));
			}
			else{
				boolean valid =Util.validateDate(formatedDate);
				if(!valid){
					result.addError(new ObjectError("dob", "Date of Birth is future date"));
				}
			} 
		}
		
		logger.info("result 111:"+result);
		
        if (result.hasErrors()) {
        	  model.addAttribute("userForm", user);
        	  modelAndView.setViewName("signupPage"); 
        	 return  modelAndView  ;
        }
 
		
		session.setAttribute("userName", userName);
		session.setAttribute("dob", dob);
		 
		  modelAndView.addObject("userName", userName);
		  modelAndView.addObject("dob", dob);
		  SecurityQuestions sq = new SecurityQuestions();
		 
			
		 model.addAttribute("securityQuestionsForm", sq);
		 model.addAttribute("securityQuestionsList_01", sq.getSecurityQuestionsList_01());
		 model.addAttribute("securityQuestionsList_02", sq.getSecurityQuestionsList_02());
		 model.addAttribute("securityQuestionsList_03", sq.getSecurityQuestionsList_03());
	     modelAndView.setViewName("showQuestionsPage");
	        return modelAndView;
		  
		 } 
	
	@RequestMapping(value = "/saveSecurityQuestions", method = RequestMethod.POST)
	 public ModelAndView  addUserToSession(@Valid @ModelAttribute("securityQuestionsForm") SecurityQuestions sq,HttpSession session,BindingResult result, Model model) {
		 ModelAndView modelAndView = new ModelAndView(); 
		 
		 result =getBindingresult(sq,result);
		 
		 if(result.hasErrors()){
			 model.addAttribute("securityQuestionsForm", sq);
			 model.addAttribute("securityQuestionsList_01", sq.getSecurityQuestionsList_01());
			 model.addAttribute("securityQuestionsList_02", sq.getSecurityQuestionsList_02());
			 model.addAttribute("securityQuestionsList_03", sq.getSecurityQuestionsList_03());
       	     modelAndView.setViewName("showQuestionsPage"); 
       	     return  modelAndView  ;
		 } 
		 
		 
		 session.setAttribute("securityQuestion_01", sq.getSecurityQuestion_01());
		 session.setAttribute("securityAnswer_01", sq.getSecurityAnswer_01());
		 
		 session.setAttribute("securityQuestion_02", sq.getSecurityQuestion_02());
		 session.setAttribute("securityAnswer_02", sq.getSecurityAnswer_02());
		 
		 session.setAttribute("securityQuestion_03", sq.getSecurityQuestion_03());
		 session.setAttribute("securityAnswer_03", sq.getSecurityAnswer_03());
		 
		 session.setAttribute("signUpSuccess", true);
		 
		 modelAndView.setViewName("mainPage");
	        return modelAndView;
		  
		 }  


	@RequestMapping(value = "/signinPage", method = RequestMethod.GET)
	 public String  reDirectToLoginpage(Model model) { 
		model.addAttribute("userForm", new User()); 
	     return "loginPage";
		  
		 } 
	
	
	@RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
	 public ModelAndView  reDirectToLoginpage( @ModelAttribute("userForm") User user,HttpSession session,BindingResult result,Model model) {
		 ModelAndView modelAndView = new ModelAndView();  
		 
		String userName = user.getUserName();
		logger.info("userName :"+userName);
		if(null == userName || userName.isEmpty()){
			result.addError(new ObjectError("userName", "UserName is required"));
		}else if(!userName.equalsIgnoreCase((String) session.getAttribute("userName"))){
			result.addError(new ObjectError("userName", "UserName Not in the Session , please signUp"));
		}
		  if (result.hasErrors()) {
        	  model.addAttribute("userForm", user);
        	  modelAndView.setViewName("loginPage"); 
        	 return  modelAndView  ;
        } 
		
		 
		 if(userName.equalsIgnoreCase((String) session.getAttribute("userName"))){
			 int index=(Integer) Util.getRandomNumber(3);
			 session.setAttribute("index",index);
			 if(index == 01){
				 session.setAttribute("randomQuestion",session.getAttribute("securityQuestion_01"));
				 session.setAttribute("randomAnswer",session.getAttribute("securityAnswer_01"));
			 }
			 else if(index == 02){
				 session.setAttribute("randomQuestion",session.getAttribute("securityQuestion_02"));
				 session.setAttribute("randomAnswer",session.getAttribute("securityAnswer_02"));
			 }
			 else{
				 session.setAttribute("randomQuestion",session.getAttribute("securityQuestion_03"));
				 session.setAttribute("randomAnswer",session.getAttribute("securityAnswer_03"));
			 }
			 model.addAttribute("securityQuestionsForm", new SecurityQuestions());
			 modelAndView.setViewName("showSecurityQuestion");
		 }
		
	     return modelAndView;
		  
		 }
	
	@RequestMapping(value = "/checkSecurityQuestion", method = RequestMethod.POST)
	 public ModelAndView  reDirectToSuccessPage( @ModelAttribute("securityQuestionsForm") SecurityQuestions sq,HttpSession session,BindingResult result,Model model) {
		
		String randomAnswer = sq.getRandomAnswer();
		logger.info("randomAnswer :"+randomAnswer);
		String sessionRandomAnswer = (String) session.getAttribute("randomAnswer");
		logger.info("sessionRandomAnswer :"+sessionRandomAnswer);
		
		 ModelAndView modelAndView = new ModelAndView();  
		 if(null == randomAnswer || randomAnswer.isEmpty()){
			 result.addError(new ObjectError("randomAnswer", "Answer is required"));
		 }else if(! randomAnswer.equalsIgnoreCase(sessionRandomAnswer)){
			 logger.info("inside IF");
			 result.addError(new ObjectError("randomAnswer", "Answer is not valid")); 
		 }
		 
		 logger.info("result :"+result);
		 if (result.hasErrors()) {
			 model.addAttribute("securityQuestionsForm",sq);
       	     modelAndView.setViewName("showSecurityQuestion"); 
       	 return  modelAndView  ;
       } 
		 
		 
		 if( randomAnswer.equalsIgnoreCase(sessionRandomAnswer)){
			 
			 modelAndView.setViewName("successPage");
		 }
		
	     return modelAndView;
		  
		 }


	
	
	
	
	private BindingResult getBindingresult(SecurityQuestions sq,
			BindingResult result) {
		String secQuestion_01=sq.getSecurityQuestion_01();
		String secQuestion_02=sq.getSecurityQuestion_02();
		String secQuestion_03=sq.getSecurityQuestion_03();
		if(null == secQuestion_01 || secQuestion_01.isEmpty() || secQuestion_01.equalsIgnoreCase("NONE")){
			result.addError(new ObjectError("securityQuestion_01", "Please select Question 01"));
		} else{
			String secAnswer_01=sq.getSecurityAnswer_01();
			if(null == secAnswer_01 || secAnswer_01.isEmpty()){
				result.addError(new ObjectError("securityAnswer_01", "Please Answer Question 01"));
			} 
		}
		
		if(null == secQuestion_02 || secQuestion_02.isEmpty() || secQuestion_02.equalsIgnoreCase("NONE")){
			result.addError(new ObjectError("securityQuestion_02", "Please select Question 02"));
		}else{
			String secAnswer_02=sq.getSecurityAnswer_02();
			if(null == secAnswer_02 || secAnswer_02.isEmpty()){
				result.addError(new ObjectError("securityAnswer_02", "Please Answer Question 02"));
			} 
		}
		
		if(null == secQuestion_03 || secQuestion_03.isEmpty() || secQuestion_03.equalsIgnoreCase("NONE")){
			result.addError(new ObjectError("securityQuestion_03", "Please select Question 03"));
		}else{
			String secAnswer_03=sq.getSecurityAnswer_03();
			if(null == secAnswer_03 || secAnswer_03.isEmpty()){
				result.addError(new ObjectError("securityAnswer_03", "Please Answer Question 03"));
			} 
		} 
		 
		return result;
	}

	
	 
	
	
	
}
