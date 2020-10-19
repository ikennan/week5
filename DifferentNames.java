import acm.program.*;
import java.util.*;

public class DifferentNames extends ConsoleProgram {
	public void run() {
		ArrayList<String> namelist = new ArrayList<String>();
		while (true) {
			String differentname = readLine("Enter name: ");
			if (differentname.equals(""))
				break;
			if (!namelist.contains(differentname)) {
				namelist.add(differentname);
			}
		}

		println("DifferentNames list contains:");
		printList(namelist);
	}

	/* Prints out the names inside the ArrayList, one name per line */
	private void printList(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			println(list.get(i));
		}
	}

}