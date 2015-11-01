package pack001;

public class CommandsHandler {

	final Users allUsers = new Users();
	boolean exitFlag = false;
	
	public void execute(String[] splittedCommand){
		
		if(splittedCommand.length == 2){
			if("login".equals(splittedCommand[1])){
				if(!allUsers.usersInfo.containsKey(splittedCommand[0]))
					allUsers.usersInfo.put(splittedCommand[0], new User());
				allUsers.usersInfo.get(splittedCommand[0]).login();	
				System.out.println("ok");
			}
			else if(!allUsers.usersInfo.containsKey(splittedCommand[0]) || 
					allUsers.usersInfo.get(splittedCommand[0]).isLogged() != true)
				System.out.println("error:notlogged");
			else if("logout".equals(splittedCommand[1])){
					allUsers.usersInfo.get(splittedCommand[0]).logout();
					System.out.println("ok");
			}
			else if("listavailable".equals(splittedCommand[1])){
					allUsers.takeAllLoggedUsers();
			}
			else if("shutdown".equals(splittedCommand[1])){
					exitFlag = true;
					System.out.println("ok");
			}
			else{
				System.out.println("error:unknowncommand");
			}
		}
		else if(splittedCommand.length == 3 && "info".equals(splittedCommand[1])){
			if(!allUsers.usersInfo.containsKey(splittedCommand[0]) ||
					allUsers.usersInfo.get(splittedCommand[0]).isLogged() != true){
				System.out.println("error:notlogged");
				return;
			}
			if(!allUsers.usersInfo.containsKey(splittedCommand[2])){
				System.out.println("ok" + ":" + splittedCommand[2] + ":false:0");
			}
			else{
			System.out.println("ok" + ":" + splittedCommand[2] + 
					":" + allUsers.usersInfo.get(splittedCommand[2]).isLogged() + 
					":" + allUsers.usersInfo.get(splittedCommand[2]).logCount());
			}
		}
		else{
			System.out.println("error:unknowncommand");
		}
	}
	
}