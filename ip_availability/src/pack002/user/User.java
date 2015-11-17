package pack002.user;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String userName;
	private boolean currentlyLogStatus;
	private int loginCount;
	private List<Interval> activityDates = new ArrayList<Interval>();
	
	public User(String userName){
		setUserName(userName);
		setCurrentlyLogStatus(true);
		setLoginCount(1);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isCurrentlyLogStatus() {
		return currentlyLogStatus;
	}
	public void setCurrentlyLogStatus(boolean currentlyLogStatus) {
		this.currentlyLogStatus = currentlyLogStatus;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public void incrementLoginCount(){
		loginCount++;
	}

	public String exportWholeActivity (){
		String wholeActivity = "";
		for(Interval activity : activityDates){
			wholeActivity += activity.storeActivityInString();
		}
		return wholeActivity;
	}
	
	public void login(){
		if(!isCurrentlyLogStatus()){
			setCurrentlyLogStatus(true);
			incrementLoginCount();
		}
		activityDates.add(new Interval(new Date()));
	}
	public void logout(){
		setCurrentlyLogStatus(false);
		activityDates.get(activityDates.size()-1).setTo(new Date());
	}	
}
