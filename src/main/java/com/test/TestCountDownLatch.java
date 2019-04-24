package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestCountDownLatch {

  private static AtomicReference<CountDownLatch> countDownLatchAtomic = new AtomicReference<>();
  private ScheduledFuture task1Future;
  private Future task2Future;
  private AtomicInteger counter = new AtomicInteger(0);
  private BlockingQueue<Order> ordersQueue = new LinkedBlockingQueue();

  public static void main(String[] args) {
     TestCountDownLatch testCountDownLatch = new TestCountDownLatch();
     testCountDownLatch.runTask1();
     testCountDownLatch.runTask2();
  }


  public void runTask1(){
    task1Future = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{

      countDownLatchAtomic.get().countDown();
      Order order = new Order("order",counter.getAndAdd(1));
      ordersQueue.add(order);
      System.out.println("run task1--------"+order);


    },100,100,TimeUnit.MILLISECONDS);
  }

  public void runTask2(){
    countDownLatchAtomic.set(new CountDownLatch(5));
    task2Future = Executors.newFixedThreadPool(1).submit(() -> {
      while(true){
        countDownLatchAtomic.get().await();

        List<Order> orders = new ArrayList<>();
        ordersQueue.drainTo(orders);
        if(!orders.isEmpty()){
          orders.forEach(order -> {
            System.out.println("task2:"+order);
          });
        }
        countDownLatchAtomic.getAndSet(new CountDownLatch(5));
      }
    });
  }

  public void stopTask1(){
    if(task1Future !=null && !task1Future.isCancelled()){
      task1Future.cancel(true);
    }
  }

  public void stopTask2(){
    if(task2Future !=null && !task2Future.isCancelled()){
      task2Future.cancel(true);
    }
  }
}


class Order {
  String name;
  Integer id;
  public Order(String name, Integer id){
    this.name = name;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Order{" +
        "name='" + name + '\'' +
        ", id=" + id +
        '}';
  }
}
