
public class ImageDetails {
	private String address;
	private String name;
	private String annotation;

	public ImageDetails() {
	}

	public ImageDetails(String address, String name, String annotation) {
		super();
		this.address = address;
		this.name = name;
		this.annotation = annotation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
