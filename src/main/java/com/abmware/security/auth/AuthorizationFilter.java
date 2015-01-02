package com.abmware.security.auth;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abmware.security.auth.model.UserAuthDetails;
import com.abmware.security.auth.model.UserPolicy;
import com.abmware.security.auth.model.UserPolicyAction;
public class AuthorizationFilter implements Filter{
	//Change it accordingly
	private static final String LOGIN_PAGE = "login.jsp";
	
	
		public void  init(FilterConfig config) 
            throws ServletException{
		//Right now do nothing
		}
		
		
		public void  doFilter(ServletRequest request, 
		    ServletResponse response,
		    FilterChain chain) 
		    throws java.io.IOException, ServletException {
		
		// step 1 Verify if the User is authenticated, If yes proceed to step 2
			 HttpServletRequest req = (HttpServletRequest) request;
			 HttpServletResponse res = (HttpServletResponse) response;
			 UserAuthDetails userAuthDetails = null;
			 UserPolicy userPolicy = null;
			 if(req.getSession().getAttribute("userAuthDetails") == null){
				 //Redirect to log in page
				 res.sendRedirect(LOGIN_PAGE); //redirect for authentication
			 }
			 else{
				 userAuthDetails = (UserAuthDetails)req.getSession().getAttribute("userAuthDetails");
				 if(!userAuthDetails.isAuthenticated()){
					//Redirect to log in page
					 res.sendRedirect(LOGIN_PAGE);//redirect for authentication
				 }
			 }
			 
			 
			
		//step 2 Extract the policy actions (smf actions) for the user policy , if available for the logged in user 
			 userPolicy =  userAuthDetails.getUserPolicy();
			
		//step 3 Extract the page name of the url intended to be visited by the user for this request
			String pageToVisit =  req.getRequestURI().replace(req.getContextPath(), "");
		//step 4 Verify if the user has access to the page he intends to visit by comparing it to the list of policy actions retrieved in step 2.
			Iterator<UserPolicyAction> itr = userPolicy.getPolicyActions().iterator();
			boolean isAuthorized = false;
				while(itr.hasNext()){
					UserPolicyAction policyAction = itr.next();
					if(pageToVisit.contains(policyAction.getSmfAction())){
						isAuthorized  = true;
						break;
					}
					
				}
				
		// step 5 Pass request back down the filter chain
			if(isAuthorized){
				chain.doFilter(request,response);
			}
			else{
				res.sendRedirect(LOGIN_PAGE);
			}
		
		}
		
		
		public void destroy( ){
		/* Called before the Filter instance is removed 
		from service by the web container*/
			//Right now do  nothing.
		}
}