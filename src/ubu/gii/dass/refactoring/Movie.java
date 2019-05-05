package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	private String _title;
	private int _priceCode;
	private MovieType _movieType;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(Rental rental) {
		double result = 0;
		// determine amounts for each line
		switch (rental.getMovie().getPriceCode()) {
		case MovieType.REGULAR:
			result += 2;
			if (rental.getDaysRented() > 2)
				result += (rental.getDaysRented() - 2) * 1.5;
			break;
		case MovieType.NEW_RELEASE:
			result += rental.getDaysRented() * 3;
			break;
		case MovieType.CHILDRENS:
			result += 1.5;
			if (rental.getDaysRented() > 3)
				result += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}

	public int getFrecuentRenterPoints(Rental rental) {
		// add frequent renter points
		int frequentRenterPoints = 1;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
