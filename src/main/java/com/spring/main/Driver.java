package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.ApplicationConfig;
import com.spring.exception.UnavailableCategoryException;
import com.spring.model.Shopping;
import com.spring.service.ShoppingService;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// Fill the code
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the category");
		String category1 = sc.nextLine();
		System.out.println("Enter the bill amount");
		double billAmount1 = sc.nextDouble();
		
		Shopping shoppingObj1 = context.getBean(Shopping.class);
		shoppingObj1.setCategory(category1);
		shoppingObj1.setBillAmount(billAmount1);
		
		sc.nextLine();  // as we cannot take string input after sc.nextDouble();
		
		System.out.println("Enter the category");
		String category2 = sc.nextLine();
		
		System.out.println("Enter the bill amount");
		double billAmount2 = sc.nextDouble();
		
		Shopping shoppingObj2 = context.getBean(Shopping.class);
		shoppingObj2.setCategory(category2);
		shoppingObj2.setBillAmount(billAmount2);
		
		
		ShoppingService shoppingService = context.getBean(ShoppingService.class);
		
		try {
			shoppingService.calculateTotalBill(shoppingObj1);
			System.out.println("The bonus points gained from the first purchase is " + shoppingObj1.getBonusPoints());			
		} catch (UnavailableCategoryException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			shoppingService.calculateTotalBill(shoppingObj2);
			System.out.println("The bonus points gained from the second purchase is " + shoppingObj2.getBonusPoints());
		} catch (UnavailableCategoryException e) {
			System.out.println(e.getMessage());
		}
	}
}
