import java.util.concurrent.ThreadLocalRandom;

public class MakeIntegers {

	public static void main(String[] args) {

		for (int i = 0; i < 500000; i++) {
			int num = ThreadLocalRandom.current().nextInt(1, 1000000 + 1);
			System.out.println(num);
		}
	}

}
