package com.example.vo;

public  class Ticket {
	
	
	public User user;
	
	public String from;
	public String to;
	public int price;
	
	public Ticket(User user, String from, String to, int price) {
		
		this.user = user;
		this.from = from;
		this.to = to;
		this.price = price;
	}
	
	public Ticket() {
		
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [user=" + user + ", from=" + from + ", to=" + to + ", price=" + price + "]";
	}
	

	
	
}