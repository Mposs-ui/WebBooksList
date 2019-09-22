package root;
import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addABook() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Title: ");
			String title = in.nextLine();
			System.out.print("Enter an Author: ");
			String author = in.nextLine();
			ListItem toAdd = new ListItem(title, author);
			lih.insertItem(toAdd);
		}

		private static void deleteABook() {
			// TODO Auto-generated method stub
			System.out.print("Enter the Title to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the Author to delete: ");
			String author = in.nextLine();
			ListItem toDelete = new ListItem(title, author);
			lih.deleteItem(toDelete);
		}

		private static void editAnAuthor() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Author");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems = null;
			
			if (searchBy == 1) {
				System.out.print("Enter the Title: ");
				String titleName = in.nextLine();
				foundItems = lih.searchForItemByTitle(titleName);
			} else {
				System.out.print("Enter the Author: ");
				String authorName = in.nextLine();
				foundItems = lih.searchForItemByAuthor(authorName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getAuthor());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Author");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the book list! ---");
			while (goAgain) {
				System.out.println("*  Select an Item:");
				System.out.println("*  1 -- Add a Book");
				System.out.println("*  2 -- Edit a Book");
				System.out.println("*  3 -- Delete a Book");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addABook();
				} else if (selection == 2) {
					editAnAuthor();
				} else if (selection == 3) {
					deleteABook();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem>allItems = lih.showAllItems();
			for(ListItem singleItem : allItems){
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}