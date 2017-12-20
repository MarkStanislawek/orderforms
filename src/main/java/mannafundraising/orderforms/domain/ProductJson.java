package mannafundraising.orderforms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProductJson {
	private String name;
	private String tuitionCreditPercentage;
	private String faceValue;
	private boolean backorder;

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
}
