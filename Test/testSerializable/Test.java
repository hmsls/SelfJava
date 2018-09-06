package testSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		System.out.println("序列化之前：");
		Address address = new Address("中国", "吉林", "长春");
		Employee employee1 = new Employee("张XX", 30, address);
		System.out.println("员工1的信息：");
        System.out.println(employee1);// 输出employee1对象
        System.out.println("序列化之后：");
        
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        Employee employee2 = null;
        try {
			out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
			out.writeObject(employee1);
			in = new ObjectInputStream(new FileInputStream("employee.dat"));
			employee2 = (Employee)in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
        if(employee2 != null){
        	employee2.getAddresss().setState("中国");
        	employee2.getAddresss().setProvince("四川");
        	employee2.getAddresss().setCity("成都");
        	employee2.setName("李XX");
        	employee2.setAge(24);
        	System.out.println("员工1的信息：");
            System.out.println(employee1);// 输出employee1对象
            System.out.println("员工2的信息：");
            System.out.println(employee2);// 输出employee2对象
        }
        
	}
}
