package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListItem;
import model.User;

/**
 * Servlet implementation class editExistinglistServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExistingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// import all helpers
		ListDetailsHelper slh = new ListDetailsHelper();
		ListItemHelper lih = new ListItemHelper();
		UserHelper sh = new UserHelper();

		// search for object to make changes to
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails toEdit = slh.searchForListById(idToEdit);

		// update the listName first
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		toEdit.setListName(listName);

		// update the User
		String userName = request.getParameter("userName");
		User user;
		try {
			user = sh.searchForUserByName(userName);
		} catch (NoResultException ex) {
			user = new User(userName);
		} catch (Exception ex) {
			user = new User(userName);
		}

		toEdit.setUser(user);

		// update the list of items
		List<ListItem> previousListOfItems = toEdit.getListOfItems();

		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<ListItem> selectedItemsInList = new ArrayList<ListItem>();

		if (selectedItems != null && selectedItems.length > 0 ) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);

			}

			previousListOfItems.addAll(selectedItemsInList);
		}

		toEdit.setListOfItems(previousListOfItems);

		slh.updateList(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
