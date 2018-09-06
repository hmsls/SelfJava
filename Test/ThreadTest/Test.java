package ThreadTest;

public class Test {
	public static void main(String[] args) {
		ThreadDemo td1 = new ThreadDemo("t1");
		ThreadDemo td2 = new ThreadDemo("t2");
		ThreadDemo td3 = new ThreadDemo("t3");
		
		td1.start();
		td2.start();
		td3.start();
//		td1.stop();
		ThreadList.list();
	}
}
