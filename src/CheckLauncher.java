

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckLauncher {

	public static void main(final String[] args) {

		final List<String> unpaidList = new ArrayList<String>(Arrays.asList("1", "2", "22", "3", "4"));
		final List<String> paidList = new ArrayList<String>(Arrays.asList("1", "8", "3", "4", "5", "6", "22"));

		unpaidList.retainAll(paidList);

		System.out.println(unpaidList);

	}
}
