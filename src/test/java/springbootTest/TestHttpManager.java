package springbootTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import httpinternal.HttpManager;

public class TestHttpManager {
	
	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newFixedThreadPool(100);
		
		HttpManager.get("http://www.gangpiaoquan.com/");
		
		/*
		for(int i=0;i<=99;i++){
			executor.execute(()->{
				
				while(true){
					try{
						HttpManager.get("http://www.gangpiaoquan.com/");
					}catch(Exception e){
						
					}
					
				}
				
			});
		}
		*/
		
		
	}

}
