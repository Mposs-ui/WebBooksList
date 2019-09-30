package root;

import java.util.List;

import controller.ListDetailsHelper;
import controller.UserHelper;
import model.ListDetails;
import model.User;

public class UserTester {

	public static void main(String[] args) {
		
		User arnold = new User("Arnold");
		UserHelper sh = new UserHelper();
		
		sh.insertUser(arnold);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails arnoldList = new ListDetails("Arnold's List", arnold);
		
		ldh.insertNewListDetails(arnoldList);
		
		List<User> allUsers = sh.showAllUsers();
		for(User a: allUsers) {
			System.out.println(a.toString());
		}
	}
}
