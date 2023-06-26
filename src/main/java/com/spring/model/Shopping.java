package com.spring.model;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//pojo class with required attributes,getters and setters 
//use appropriate annotation to make this class as component class and use appropriate annotation for scope
@Component
@Scope("prototype")
public class Shopping implements SmartCard {

	private String category;
	private double billAmount;
	private double bonusPoints;

	// use appropriate annotation
	@Value("#{${categoryDetails.map}}")
	private Map<String, Integer> categoryDetails;

	// use appropriate annotation
	@Value("${percentage}")
	private double percentage;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(double bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public Map<String, Integer> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(Map<String, Integer> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public void calculateBonusPoints(double billAmount) {
		//Fill the code
		double bonus = (billAmount * percentage) / 100;
		this.setBonusPoints(bonus);
	}
}
