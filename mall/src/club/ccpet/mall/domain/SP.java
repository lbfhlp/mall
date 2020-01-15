package club.ccpet.mall.domain;

public class SP {
	 private int id;
	 private int sex;
	 private String name;
	 private int sort_parent_id;
	 private int sort_sub_id;
	 private double salePrice;
	 private double cost;
	 private int stock;
	 private int salesVolume;
	private String img_name;
	 private String img_path;
	 private String color;
	 private String size;
	 private String disc;
	 
	public SP() {
		super();
	}


	public SP(int id, int sex,String name, int sort_parent_id, int sort_sub_id, double salePrice, double cost, int stock,int salesVolume,
			String img_name, String img_path, String color, String size, String disc) {
		super();
		this.sex = sex;
		this.id = id;
		this.name = name;
		this.sort_parent_id = sort_parent_id;
		this.sort_sub_id = sort_sub_id;
		this.salePrice = salePrice;
		this.cost = cost;
		this.stock = stock;
		this.salesVolume = salesVolume;
		this.img_name = img_name;
		this.img_path = img_path;
		this.color = color;
		this.size = size;
		this.disc = disc;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	 public int getSex() {
			return sex;
	}

	public void setSex(int sex) {
			this.sex = sex;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSort_parent_id() {
		return sort_parent_id;
	}


	public void setSort_parent_id(int sort_parent_id) {
		this.sort_parent_id = sort_parent_id;
	}


	public int getSort_sub_id() {
		return sort_sub_id;
	}


	public void setSort_sub_id(int sort_sub_id) {
		this.sort_sub_id = sort_sub_id;
	}


	public double getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getSalesVolume() {
		return salesVolume;
	}


	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getImg_name() {
		return img_name;
	}


	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}


	public String getImg_path() {
		return img_path;
	}


	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getDisc() {
		return disc;
	}


	public void setDisc(String disc) {
		this.disc = disc;
	}
	 
	 
	 

}
