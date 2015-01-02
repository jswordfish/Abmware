package abmware;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.abmware.security.auth.model.UserAuthDetails;
import com.abmware.security.auth.model.UserPolicy;
import com.abmware.security.auth.model.UserPolicyAction;

import junit.framework.TestCase;

public class TestFilter extends TestCase{
	
	@Test
	public void testCreateUserAuthDetails(){
		UserAuthDetails userAuthDetails = new UserAuthDetails();
		userAuthDetails.setAuthenticated(true);
		UserPolicy userPolicy = new UserPolicy();
		userPolicy.setGmId("5");//Extract this from database
		/**
		 * One should extract this from database
		 * This is just an example showing how to populate.
		 */
		List<UserPolicyAction> policyActions = new ArrayList<UserPolicyAction>();
		UserPolicyAction userPolicyAction1 = new UserPolicyAction();
		userPolicyAction1.setSmfId("1912");
		userPolicyAction1.setSmfAction("BirthRegistration.html");
		
		UserPolicyAction userPolicyAction2 = new UserPolicyAction();
		userPolicyAction2.setSmfId("1912");
		userPolicyAction2.setSmfAction("BirthRegistration.html");
		
		UserPolicyAction userPolicyAction3 = new UserPolicyAction();
		userPolicyAction3.setSmfId("1912");
		userPolicyAction3.setSmfAction("BirthRegistration.html");
		
		UserPolicyAction userPolicyAction4 = new UserPolicyAction();
		userPolicyAction4.setSmfId("1912");
		userPolicyAction4.setSmfAction("BirthRegistration.html");
		
		//....and so on
		userPolicy.setPolicyActions(policyActions);
		userAuthDetails.setUserPolicy(userPolicy);
		
	}

}
