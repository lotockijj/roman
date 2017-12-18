package lambda.object;

import java.util.Random;

public class AddressGen {
	Random r = new Random(47);

	public Address getAddress() {
		String[] cityName = {"1", "2", "3", "4"};
		String[] district = {"11", "22", "33", "44"};
		String[] region = {"111", "222", "333", "444"};
		String[] street = {"1111", "2222", "3333", "4444"};
		String name = cityName[r.nextInt(cityName.length)];
		String dist = district[r.nextInt(district.length)];
		String reg = region[r.nextInt(region.length)];
		String str = street[r.nextInt(street.length)];
		return new Address(str, name, dist, reg);
	}
}
