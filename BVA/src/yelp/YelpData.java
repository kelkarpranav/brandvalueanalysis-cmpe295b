package yelp;

public class YelpData {
	
	private String total;
	private YelpBusinesss[] businesses;
	
	public YelpBusinesss[] getBusiness() {
		return businesses;
	}
	public void setBusiness(YelpBusinesss[] business) {
		this.businesses = business;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
	

}
