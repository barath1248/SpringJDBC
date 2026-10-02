package com.practiceday2;

public class ProductBO {
	private int product_no;
	private String product_name;
	private String about;
	private double price;

	public ProductBO() {
		super();
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductBO [product_no=" + product_no + ", product_name=" + product_name + ", about=" + about
				+ ", price=" + price + "]";
	}

}
