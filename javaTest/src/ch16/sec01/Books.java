package ch16.sec01;

import java.util.Objects;

public class Books {

	private int bookID;
	private String title;
	private String publisher;
	private String year;
	private int price;
	
	public Books(int bookID, String title, String publisher, String year, int price) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
	}

	public int getBookID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookID);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Books)) {
			return false;
		}
		Books books = (Books)obj;
		return this.bookID == books.bookID;	
	}
	
	@Override
	public String toString() {
		return String.format("[Book ID: %-2d] [Title: %-25s] [Publisher: %-14s] [Year: %-4s] [Price: %-3d]%n", 
				bookID, title, publisher, year, price);
	}	
}
