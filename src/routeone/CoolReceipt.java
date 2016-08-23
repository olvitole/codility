package routeone;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoolReceipt implements Receipt {

	private List<Item> items;

	public CoolReceipt(List<Item> items) {
		this.items = items;
	}

	@Override
	public String getFormattedTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (Item i : items) {
			total = total.add(i.getPrice());
		}

		return currencyFormat(total);
	}

	public class MyCom implements Comparator<Item> {

		@Override
		public int compare(Item it1, Item it2) {

			if (it1.getPrice().compareTo(it2.getPrice()) < 0) {
				return 1;
			} else if (it1.getPrice().compareTo(it2.getPrice()) > 0) {
				return -1;
			} else {
				if (it1.getName().compareTo(it2.getName()) < 0) {
					return -1;
				} else
					return 1;
			}
		}
	}

	private static String currencyFormat(BigDecimal n) {
		return NumberFormat.getCurrencyInstance().format(n);
	}

	@Override
	public List<String> getOrderedItems() {

		// note sorting each time we print receipt may get inefficient
		// might think an alternative of keeping the list sorted
		// but since duplicates are allowed cannot really use TreeSet.
		Collections.sort(items, new MyCom());

		List<String> out = new ArrayList<String>();
		for (Item i : items) {
			out.add(i.getName());
		}

		return out;
	}

}
