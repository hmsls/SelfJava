import com.ctrip.hotel.pmml.ModelCalcConsole;

public class TestReadSAS {
	public static void main(String[] args) {
//		ModelCalcConsole mcc = new ModelCalcConsole();
		String[] paths = {"F:\\读SAS\\BsbModel\\iris_rf.pmml","F:\\读SAS\\BsbModel\\irisv2.csv","F:\\读SAS\\BsbModel\\result1.txt"};
		System.out.println(paths[0]);
		System.out.println(paths[1]);
		System.out.println(paths[2]);
		ModelCalcConsole.readSASData(paths);
	}
}
