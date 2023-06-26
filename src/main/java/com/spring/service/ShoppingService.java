package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.bo.ShoppingBO;
import com.spring.exception.UnavailableCategoryException;
import com.spring.model.Shopping;

//use appropriate annotation to make this class as component class
@Component
public class ShoppingService {

	private ShoppingBO shoppingBO;

	// use appropriate annotation
	@Autowired
	public ShoppingService(ShoppingBO shoppingBO) {
		super();
		this.shoppingBO = shoppingBO;
	}

	public ShoppingBO getShoppingBO() {
		return shoppingBO;
	}

	public void setShoppingBO(ShoppingBO shoppingBO) {
		this.shoppingBO = shoppingBO;
	}

	public void calculateTotalBill(Shopping shoppingObj) throws UnavailableCategoryException {
		// Fill the code
		String category = shoppingObj.getCategory();
		
		if(shoppingObj.getCategoryDetails().containsKey(category)) {
			double totalBillAmount = shoppingBO.calculateTotalBill(shoppingObj);
			shoppingObj.calculateBonusPoints(totalBillAmount);
		}
		else {
			throw new UnavailableCategoryException("This category is not available");
		}
	}
}