package com.qiheng.thread;

public class FetchMoney {
	public static void main(String[] args) {
		Bank bank=new Bank();
		Thread t1=new MoneyThread(bank);
		Thread t2=new MoneyThread(bank);
		t1.start();
		t2.start();
		
		
	}
}
class Bank{
	private int money=1000;
	public synchronized int getMoney(int number){
		if(number<0){
			return -1;
		}
		else if(number>this.money){
			return -2;
		}
		else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money-=number;
			return number;
		}
	}
}

class MoneyThread extends Thread{
	private Bank bank;
	
	
	public MoneyThread(Bank bank) {
		super();
		this.bank = bank;
	}


	@Override
	public void run() {
		int i=this.bank.getMoney(800);
		System.out.println(i);
	}
}