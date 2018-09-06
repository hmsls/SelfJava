package ReflectTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewClassTest {
	public static void main(String[] args) {
		try {//获得File类的Constructor对象
			Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
			System.out.println("使用反射创建File对象");
			try {
				File file = constructor.newInstance("a.txt");
				System.out.println("使用File对象创建文件：a.txt");
				try {
					file.createNewFile();
					System.out.println("文件是否创建成功：" + file.exists());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
