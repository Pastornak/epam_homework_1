package lab_6;

public class Main {

	public static void main(final String[] args) {
		try {
			System.out.println(IJones.getInstance().ijones("src/lab_6/test1"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}