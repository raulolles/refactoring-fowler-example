package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement(Boolean isHtml) {
		String iniH1,finH1, iniH2, finH2, iniP, finP, tab, saltoLin;
		
		if (isHtml) {
			iniH1="<h1>";
			iniH2="<h2>";
			iniP="<p>";
			finH1="</h1>";
			finH2="</h2>";
			finP="</p>";
			tab=" ";
			saltoLin ="";
		} else {
			iniH1 = "";
			finH1 = "";
			iniH2 = "";
			finH2 = "";
			iniP = "";
			finP = "";
			tab = "\t";
			saltoLin = "\n";
		}
		
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = iniH1 + "Rental Record for " + getName() +  finH1 + saltoLin;
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			thisAmount = each._movie.getCharge(each);
			frequentRenterPoints += each._movie.getFrecuentRenterPoints(each);
			
			// show figures for this rental
			result += iniH2 + tab +  each.getMovie().getTitle() + tab
					+ String.valueOf(thisAmount) + finH2 + saltoLin;
			totalAmount += thisAmount;
		}
		// add footer lines
		result += iniP + "Amount owed is " + String.valueOf(totalAmount) + finP + saltoLin;
		result += iniP + "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points" + finP;
		return result;
	}
}
