package edu.olivet.se530.model;
/*
 * 
 * 
 */
public class Offer implements Comparable<Offer>{
	
	@Override
	public String toString() {
		return "Offer [seller=" + seller + ", product=" + product + ", price="
				+ price + ", shippingPrice=" + shippingPrice + ", condition="
				+ condition + "]";
	}
	private Seller seller;
	private Product product;
	private float price;
	private float shippingPrice;
	private Condition condition;
	private boolean isPrime;
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public float getFilteredShippingPrice() {
		if(isPrime) return 0;
		return shippingPrice;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public boolean getIsprime() {
		return isPrime;
	}
	public void setIsprime(boolean isPrime) {
		this.isPrime = isPrime;
	}
	//@Override
	public int compareTo(Offer o) {
		int rc = Float.compare(this.price + this.getFilteredShippingPrice(), o.price + o.getFilteredShippingPrice());
		if (rc == 0) {
			rc = -Integer.compare(this.getSeller().getRating(), o.getSeller().getRating());
			if (rc == 0) {
				return -Integer.compare(this.getSeller().getRatingCount(), o.getSeller().getRatingCount());
			}
		}
		return rc;
	}
	
	
}
