package com.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import com.bean.Article;
import com.bean.Author;
import com.bean.BasicArticle;

public class BasicExtractor implements Extractor{
	
	private List<Article> list=new LinkedList<>();
	
	private static String nextArticleRegex="^[0-9].*"; 
	private static String titleRegex="^[0-9].*\\：.*";
	private static String authorRegex="^[0-9].*\\：.*";
	private static String bodyRegex="[^0-9].*";

	public static void main(String[] args) {
		
		BasicExtractor extractor=new BasicExtractor();
		
		List<Article> ls=extractor.genArticles();
		
		System.out.println("---------------------------");
		System.out.println(ls);
		
		
		//extractor.basicMatch("001张九龄：感遇四首之一", nextArticleRegex);
		
		

				
	}
	
	
	public Article addContent(BasicArticle article,String content){
		content=content.trim();
		
		if(matchBody(content)){
			article.appendBody(content);
		}else{
			article.getAuthor().setName(extractAuthor(content));
			article.setTitle(extractTitle(content));
		}
		
		return article;
	}
	
	
	
	
	
	@Override
	public List<Article> genArticles() {
		
		BasicArticle article=new BasicArticle();
		Path p=Paths.get("files/tangshi.txt");
		try {
			List<String> cs=Files.readAllLines(p, StandardCharsets.UTF_8);
			
			
			for(String content:cs){
				content=content.trim();
				
				if(matchNextArticle(content)){
					list.add(article);
					/*
					if(list.size()>3){
						list.remove(0);
						return list;
					}
					
					*/
					
					article=new BasicArticle();
				}
					
				addContent(article,content);
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		list.remove(0);
		return list;
	}
	
	
	public static String extractTitle(String content){
		if(!matchTitle(content)){
			return "";
		}
		if(content==null)
			return "";
		return content.substring(content.indexOf("：")+1);
	}
	
	
	public static String extractAuthor(String content){
		if(!matchAuthor(content))
			return "";
		if(content==null)
			return "";
		content=content.replaceAll("[0-9]", "");
		return content.substring(0, content.indexOf("："));
	}
	
	
	
	public static boolean matchNextArticle(String content){
		AppLogger.info("match next article=>content:"+content);
		return basicMatch(content,nextArticleRegex);
	}
	
	
	public static boolean matchBody(String content){
		content=content.trim();
		AppLogger.info("match body");
		return basicMatch(content,bodyRegex);
	}
	
	
	public static boolean matchTitle(String content){
		AppLogger.info("match title=>content:"+content);
		return basicMatch(content,titleRegex);
	}
	
	
	public static boolean matchAuthor(String author){
		AppLogger.info("match author=>   content=>"+author);
		return basicMatch(author,authorRegex);
	}
	
	
	
	
	public static boolean basicMatch(String content,String regex){
		boolean result=false;
		if(content!=null && regex!=null){
			result=content.matches(regex);
		}
		
		AppLogger.info("matched:"+result);
		return result;
		
	}

}
