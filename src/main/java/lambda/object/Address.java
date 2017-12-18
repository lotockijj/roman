package lambda.object;

public class Address {
	private String street;
	private String city;
	private String district;
	private String region;

	public Address(String street, String city, String district, String region) {
		this.street = street;
		this.city = city;
		this.district = district;
		this.region = region;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Address: " + street + ", " + city + ", " + district + ", " + region;
	}
	
	
}
