package com.bean;

public class BasicArticle implements Article {

	private Author author;
	private String body="";
	private String title="";
	
	public BasicArticle(){
		this.author=new Author();
	};
	
	public BasicArticle(Author author,String body,String title){
		this.author=author;
		this.body=body;
		this.title=title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public void setBody(String body) {
		this.body = body;
	}
	
	
	public void appendBody(String content){
		this.body=this.body+content;
	}
	

	@Override
	public String toString() {
		return "BasicArticle [author=" + author + ", body=" + body + ", title=" + title + "]";
	}

	@Override
	public String getBody() {
		return body;
	}
	
	
	
	
	

}
