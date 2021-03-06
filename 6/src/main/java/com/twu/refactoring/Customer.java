package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount = getThisAmountForRegular(thisAmount, each);
				break;
			case Movie.NEW_RELEASE:
				thisAmount = getThisAmountForNewRelease(thisAmount, each);
				break;
			case Movie.CHILDRENS:
				thisAmount = getThisAmountForChildrens(thisAmount, each);
				break;

			}
			frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, each);

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& each.getDaysRented() > 1){
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

	private double getThisAmountForChildrens(double thisAmount, Rental each) {
		thisAmount += 1.5;
		if (each.getDaysRented() > 3)
			thisAmount += (each.getDaysRented() - 3) * 1.5;
		return thisAmount;
	}

	private double getThisAmountForNewRelease(double thisAmount, Rental each) {
		thisAmount += each.getDaysRented() * 3;
		return thisAmount;
	}

	private double getThisAmountForRegular(double thisAmount, Rental each) {
		thisAmount += 2;
		if (each.getDaysRented() > 2)
			thisAmount += (each.getDaysRented() - 2) * 1.5;
		return thisAmount;
	}

}
