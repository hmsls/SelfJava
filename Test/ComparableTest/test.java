package ComparableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<Employee> es = new ArrayList<Employee>();
		es.add(new Employee("tom1",12,5));
		es.add(new Employee("tom2",11,9));
		es.add(new Employee("tom3",19,2));
		
		System.out.println("排序前：");
		for(Employee e:es){
			System.out.println(e);
		}
		System.out.println("排序后：");
		//执行自动排序
		Collections.sort(es);
		for(Employee e:es){
			System.out.println(e);
		}
	}
}
