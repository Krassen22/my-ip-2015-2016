package pack001;

public class User {
	
	private boolean logStatus;
	private int logCount;
	
	
	public User(){
		logStatus = false;
		logCount = 0;
	}
	
	public User(boolean status){
		logStatus = status;
	}
	
	public boolean isLogged(){
		return logStatus;
	}
	
	public int logCount(){
		return logCount;
	}
	
	public void login(){
		if(logStatus != true){
			logStatus = true;
			logCount += 1;
		}
	}
	
	public void logout(){
		logStatus = false;
	}
	
}
