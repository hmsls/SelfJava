package ThreadTest;

public class ThreadDemo extends Thread {
	private volatile int account = 100;// 将域变量用volatile修饰
	private String name;
	public ThreadDemo(String name){
		this.name = name;
	}
	public void run(){
		Thread.currentThread().setName(name);
		String name1 = Thread.currentThread().getName();
//		int i = 0;
		while(true){
			System.out.println(name1+"---"+(account++));
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
