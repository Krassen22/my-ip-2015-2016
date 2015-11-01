package pack001;

import java.util.HashMap;
import java.util.Map;
// import java.util.*; // possible decision

public class Users {
	public Map<String, User> usersInfo = new HashMap<String, User>();
	
	public void takeAllLoggedUsers(){
		System.out.print("ok");
		for (String userName : usersInfo.keySet()){
			User user = usersInfo.get(userName);
			boolean logStatus = user.isLogged();
			if(logStatus == true){
				System.out.print(":" + userName);
			}
		}
		System.out.println();
	}
}
