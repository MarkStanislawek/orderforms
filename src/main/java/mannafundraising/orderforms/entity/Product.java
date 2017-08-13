package mannafundraising.orderforms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Product {
	private String name;
	private String tuitionCreditPercentage;
	private String faceValue;
	private boolean backorder;

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getTuitionCreditPercentage() {
		return tuitionCreditPercentage;
	}

	public void setTuitionCreditPercentage(String creditPercentage) {
		this.tuitionCreditPercentage = creditPercentage;
	}

	public boolean isBackorder() {
		return backorder;
	}

	public void setBackorder(boolean backorder) {
		this.backorder = backorder;
	}

	@Override
	public String toString() {
		return String.format("Product [name=%s, tuitionCreditPercentage=%s, faceValue=%s, backorder=%b]", name,
				tuitionCreditPercentage, faceValue, backorder);
	}

}
