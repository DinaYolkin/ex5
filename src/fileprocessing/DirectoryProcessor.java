package fileprocessing;

public class DirectoryProcessor {


	public static void main(String[] args) {

		String name = "dina.txt";
		String[] split = name.split("\\.");
		System.out.println(split.length);
		System.out.println(split);
		for (String aSplit : split) {
			System.out.println(aSplit);
		}

	}

}