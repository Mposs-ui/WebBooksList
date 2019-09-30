package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_book_list")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="books_on_list",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="ID", referencedColumnName="ID", unique=true) }
	  )
	private List<ListItem> listOfItems;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(String listName, User user) {
		super();
		this.listName = listName;
		this.user = user;
	}

	public ListDetails(String listName, User user, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.user = user;
		this.listOfItems = listOfItems;
	}

	public ListDetails(int id, String listName, User user, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.user = user;
		this.listOfItems = listOfItems;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	
	
}
