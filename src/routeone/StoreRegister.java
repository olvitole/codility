package routeone;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StoreRegister {

	public HashMap<String, Item> inventory = new HashMap<String, Item>();

	public void loadInventory(File inventoryFile) {

		Scanner scanner;

		try {
			scanner = new Scanner(inventoryFile);

			while (scanner.hasNext()) {

				String line = scanner.nextLine();
				System.out.println(line);
				String[] lineS = line.split(",");
				inventory.put(lineS[0], new Item(lineS[0], new BigDecimal(lineS[1]), lineS[2]));
			}
			System.out.println();
			System.out.println("Loaded " + inventory.size());

			scanner.close();
		} catch (FileNotFoundException e) {

			// check how want this handled for now its fine
			e.printStackTrace();
		}
	}

	public Receipt checkoutOrder(List<String> items) {

		if (items != null && items.size() > 0) {
			List<Item> itemsDtl = new ArrayList<Item>();

			for (String i : items) {
				Item itm = inventory.get(i);
				if (itm != null)
					itemsDtl.add(itm);
			}

			Receipt rcpt = new CoolReceipt(itemsDtl);

			return rcpt;
		}

		return null;
	}
}