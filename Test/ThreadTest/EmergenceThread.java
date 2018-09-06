package ThreadTest;

public class EmergenceThread implements Runnable{
	public void run(){
		for(int i = 0;i<6;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("紧急情况：" + i + "号车出发！");
		}
	}
}
