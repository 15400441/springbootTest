package com.bean;

public class Author {
	
	private String name;
	private Dynasty dynasty;
	private String desc;
	
	public Author(){};
	
	public Author(String name,Dynasty dynasty,String desc){
		this.name=name;
		this.dynasty=dynasty;
		this.desc=desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dynasty getDynasty() {
		return dynasty;
	}

	public void setDynasty(Dynasty dynasty) {
		this.dynasty = dynasty;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", dynasty=" + dynasty + ", desc=" + desc + "]";
	}
	
	

}
