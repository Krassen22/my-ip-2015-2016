package pack002.user;

public class User {
	
	private String userName;
	private boolean currentlyLogStatus;
	private int loginCount;
	
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
	
	public void login(){
		if( isCurrentlyLogStatus() != true){
			setCurrentlyLogStatus(true);
			incrementLoginCount();
		}
	}
	public void logout(){
		setCurrentlyLogStatus(false);
	}
}
