package ThreadTest;

public class JoinThread {
	public static void main(String[] args) {
		Thread thread = new Thread(new EmergenceThread());
		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		for(int i = 1;i<6;i++){
			try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正常情况：" + i + "号车出发！");
            try {
            	/*带时间的join方法是：允许join的线程执行的时间，如果超过这个时间
             	，则其他线程会接着抢执行权,如join线程需要6秒执行完，但是允许3秒插队，
            	则三秒后其他线程会抢。*/
				thread.join(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
