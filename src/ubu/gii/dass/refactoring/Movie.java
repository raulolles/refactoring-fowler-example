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
		setPriceCode (priceCode);
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
		switch(arg){
		case MovieType.CHILDRENS:
			_movieType = new Children();
			break;
		case MovieType.NEW_RELEASE:
			_movieType = new NewRelease();
			break;
		case MovieType.REGULAR:
			_movieType = new Regular();
			break;
		}
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(Rental rental) {
		return _movieType.getCharge(rental);
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
