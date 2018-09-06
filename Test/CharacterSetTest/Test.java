package CharacterSetTest;

public class Test {
	public static void main(String[] args) {
		ChangeCharacterSetUtil au = new ChangeCharacterSetUtil();
		String res = au.ascii2Utf(au.getStrFromFile());
		System.out.println(res);
		
		String res1 = au.utf2Asscii(au.getStrFromFile());
		System.out.println(res1);
	}
}
