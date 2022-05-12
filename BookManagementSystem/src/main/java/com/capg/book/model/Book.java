package com.capg.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	@Column(name = "AuthID")
	private String AuthID;
	@Column(name = "Genre")
	private String Genre;
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "Birthday")
	private String Birthday;
	@Column(name = "CountryofResidence")
	private String CountryofResidence;
	@Column(name = "CheckoutMonth")
	private String CheckoutMonth;
	@Column(name = "NumberofCheckouts")
	private String NumberofCheckouts;
	@Column(name = "Format")
	private String Format;
	@Column(name = "PubID")
	private String PubID;
	@Column(name = "PublicationDate")
	private String PublicationDate;
	@Column(name = "Pages")
	private String Pages;
	@Column(name = "Rating")
	private String Rating;
	@Column(name = "ReviewerID")
	private String ReviewerID;
	@Column(name = "ReviewID")
	private String ReviewID;
	@Column(name = "PrintRunSize")
	private String PrintRunSize;
	@Column(name = "Price")
	private String Price;
	@Column(name = "ISBN")
	private String ISBN;
	@Column(name = "Discount")
	private String Discount;
	@Column(name = "ItemID")
	private String ItemID;
	@Column(name = "OrderID")
	private String OrderID;
	@Column(name = "SaleDate")
	private String SaleDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthID() {
		return AuthID;
	}
	public void setAuthID(String authID) {
		AuthID = authID;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getCountryofResidence() {
		return CountryofResidence;
	}
	public void setCountryofResidence(String countryofResidence) {
		CountryofResidence = countryofResidence;
	}
	public String getCheckoutMonth() {
		return CheckoutMonth;
	}
	public void setCheckoutMonth(String checkoutMonth) {
		CheckoutMonth = checkoutMonth;
	}
	public String getNumberofCheckouts() {
		return NumberofCheckouts;
	}
	public void setNumberofCheckouts(String numberofCheckouts) {
		NumberofCheckouts = numberofCheckouts;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getPubID() {
		return PubID;
	}
	public void setPubID(String pubID) {
		PubID = pubID;
	}
	public String getPublicationDate() {
		return PublicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		PublicationDate = publicationDate;
	}
	public String getPages() {
		return Pages;
	}
	public void setPages(String pages) {
		Pages = pages;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getReviewerID() {
		return ReviewerID;
	}
	public void setReviewerID(String reviewerID) {
		ReviewerID = reviewerID;
	}
	public String getReviewID() {
		return ReviewID;
	}
	public void setReviewID(String reviewID) {
		ReviewID = reviewID;
	}
	public String getPrintRunSize() {
		return PrintRunSize;
	}
	public void setPrintRunSize(String printRunSize) {
		PrintRunSize = printRunSize;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getDiscount() {
		return Discount;
	}
	public void setDiscount(String discount) {
		Discount = discount;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getSaleDate() {
		return SaleDate;
	}
	public void setSaleDate(String saleDate) {
		SaleDate = saleDate;
	}
	
}
	
	
	