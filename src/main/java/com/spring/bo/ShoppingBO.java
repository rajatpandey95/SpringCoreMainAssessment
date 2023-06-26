package com.spring.bo;

import org.springframework.stereotype.Component;

import com.spring.model.Shopping;

//use appropriate annotation to make this class as component class
@Component
public class ShoppingBO {

	public double calculateTotalBill(Shopping shoppingObj) {
		double totalBill = 0;
		// Fill the code
		String category = shoppingObj.getCategory();
		double billAmount = shoppingObj.getBillAmount();
		
		int discountPercentage = shoppingObj.getCategoryDetails().get(category);
		
		totalBill = billAmount - (billAmount * discountPercentage)/100;
		
		return totalBill;
	}
}
