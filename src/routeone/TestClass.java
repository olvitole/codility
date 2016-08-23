package routeone;

import java.io.File;
import java.util.ArrayList;

public class TestClass {

	public static void main(String args[]) {

		StoreRegister sr = new StoreRegister();
		
		File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);

		File inventoryFile = new File("src/com/routeone/interview/sample-inventory.csv");

		sr.loadInventory(inventoryFile);

		// {"PC1033","GenericMotherboard","Mouse","LCD"}

		ArrayList<String> input = new ArrayList<String>();
		input.add("PC1033");
		input.add("GenericMotherboard");
		input.add("Mouse");
		input.add("LCD");

		Receipt rec = sr.checkoutOrder(input);

		System.out.println(rec.getFormattedTotal());
		System.out.println(rec.getOrderedItems());

	}

}
