package edu.uprm.ece.icom4035.classes;

public class Gem implements Comparable<Gem>{
	
	private String name;
	private String description;
	private int shine;
	private double price;
	private int rarity;
	private String color;
	private int faces;
	public String[] images1={ "images/gem-02.gif",
		      "images/gem-05.gif",
		      "images/gem-09.gif"};
		public Gem(){};
		public Gem(String name, int shine, double price, int rarity, String color,
			int faces) {
		super();
		this.name = name;
		this.shine = shine;
		this.price = price;
		this.rarity = rarity;
		this.color = color;
		this.faces = faces;
		
	}

	public String getName() {
		return name;
	}
	public String[] getImages() {
		return images1;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getShine() {
		return shine;
	}

	public void setShine(int shine) {
		this.shine = shine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getFaces() {
		return faces;
	}

	public void setFaces(int faces) {
		this.faces = faces;
	}

	@Override
	public int compareTo(Gem o) {
		return this.name.compareTo(o.name);
	}
}
