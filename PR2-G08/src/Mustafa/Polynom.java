package Mustafa;

public class Polynom {

	public static void main(String[] args) {

		Polynom polynom1 = new Polynom(1, 2, 5);
		// System.out.println(polynom1.berechne(1)); //Funktioniert

		// System.out.println(polynom1.berechne(2,2)); //Funktioniert
		// System.out.println(polynom1.getGrad()); //Funktioniert
		System.out.println(polynom1.integriere());

	}

	private final double[] koeffizient;
	static final double GRENZWERT = 0.0001;

	// Konstruktor
	public Polynom(double... koeffizienten) {
		this.koeffizient = koeffizienten;
	}

	// Konstruktor fuer Nullpolynom
	public Polynom() {
		this.koeffizient = new double[] { 0 };
	}

	/* ******** Methoden ******** */
	
	public double[] addiere(Polynom other) {

		if (this.getGrad() > other.getGrad())
			return add(this.koeffizient, other.koeffizient);
		else
			return add(other.koeffizient, this.koeffizient);
	}

	private double[] add(double[] groeßererKoeff, double[] kleinererKoeff) {
		double[] newKoeff = new double[groeßererKoeff.length];

		int i = 0;
		for (; i < kleinererKoeff.length; i++)
			newKoeff[i] = groeßererKoeff[i] + kleinererKoeff[i];

		for (; i < groeßererKoeff.length; i++)
			newKoeff[i] = groeßererKoeff[i];

		return newKoeff;
	}

	public double[] subtrahiere(Polynom other) {

		if (this.getGrad() > other.getGrad()) {
			return sub(this.koeffizient, other.koeffizient, new double[this.koeffizient.length]);
		} else {
			return sub(this.koeffizient, other.koeffizient, new double[other.koeffizient.length]);
		}
	}

	private double[] sub(double[] ersterKoeff, double[] zweiterKoeff, double[] newKoeff) {

		int i = 0;
		for (; i < ersterKoeff.length && i < zweiterKoeff.length; i++)
			newKoeff[i] = ersterKoeff[i] - zweiterKoeff[i];

		if (ersterKoeff.length > zweiterKoeff.length)
			for (; i < ersterKoeff.length; i++)
				newKoeff[i] = ersterKoeff[i];
		else
			for (; i < zweiterKoeff.length; i++)
				newKoeff[i] = 0 - zweiterKoeff[i];

		return newKoeff;
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	// Berechnen des Wertes des Polynoms fur ein beliebiges x
	public double berechne(double x) {
		// Initialisierung vom Funktionswert
		double funktionswert = 0;

		for (int i = getGrad(); i >= 0; i--) {
			// Funktionswert = Koeffizient * x^Grad
			funktionswert = funktionswert + (Math.pow(x, i) * koeffizient[i]);

		}
		return funktionswert;
	}

	// Berechnen des Wertes des Polynoms fuer mehrere x
	public double[] berechne(double... x) {
		// Da wir mehrere Ergebnisse haben, erstellen wir für die
		// Funktionswerte von x ein Array.
		double funktionswert[] = new double[x.length];

		for (int j = 0; j < x.length; j++) {
			funktionswert[j] = funktionswert[j] + berechne(x[j]);
			System.out.println(funktionswert[j]);
		}
		return funktionswert;
	}

	// Berechnen des Integrals des Polynoms
	public double[] integriere() {
		// Für das Integral muss man das Polynom aufleiten um eine Stammfunktion
		// zu bilden.
		// Beim aufleiten eines Polynoms bekommt man am Ende eine Variable die
		// unendlich viele Zahlen
		// haben kann, daher muss das Array um eins vergrößert werden.
		double[] stammfunktion = new double[this.koeffizient.length + 1];
		stammfunktion[0] = 0;

		for (int i = 0; i < koeffizient.length; i++) {
			// Aufleiten von x^2 VIELLEICHT AUCH koeffizient[i] x^2 -> (x^3)/3
			stammfunktion[i + 1] = koeffizient[i] / (i + 1);
		}
		return stammfunktion;
	}

	public double[] differenziere() {
		if (this.getGrad() == 0)
			return (new Polynom()).koeffizient;

		double[] newKoeff = new double[this.getGrad()];
		for (int i = 0; i < newKoeff.length; i++)
			newKoeff[i] = this.koeffizient[i + 1] * (i + 1);

		return newKoeff;
	}

	public boolean equals(Polynom other) {
		if (this.getGrad() != other.getGrad())
			return false;

		for (int i = 0; i < this.koeffizient.length; i++)
			if (Math.abs(this.koeffizient[i] - other.koeffizient[i]) > GRENZWERT)
				return false;

		return true;
	}

	@Override
	public String toString() {
		if (this.getGrad() == 0 && Math.abs(this.koeffizient[0]) < GRENZWERT)
			return "Grad 0: 0";

		String ausgabe = "Grad " + this.getGrad() + ":";

		boolean ersterEintrag = true;
		int i = this.koeffizient.length - 1;
		for (; ersterEintrag && i > 1; i--)
			if (Math.abs(this.koeffizient[i]) > GRENZWERT && this.koeffizient[i] > 0) {
				ausgabe = ausgabe + " " + this.koeffizient[i] + "x^" + i;
				ersterEintrag = false;
			}

		for (; i > 1; i--)
			if (Math.abs(this.koeffizient[i]) > GRENZWERT && this.koeffizient[i] > 0)
				ausgabe = ausgabe + " +" + this.koeffizient[i] + "x^" + i;
			else if (Math.abs(this.koeffizient[i]) > GRENZWERT && this.koeffizient[i] < 0)
				ausgabe = ausgabe + " " + this.koeffizient[i] + "x^" + i;

		if (i == 1 && ersterEintrag && Math.abs(this.koeffizient[i]) > GRENZWERT) {
			ausgabe = ausgabe + " " + this.koeffizient[i] + "x";

			if (Math.abs(this.koeffizient[0]) > GRENZWERT)
				if (this.koeffizient[0] > 0)
					ausgabe = ausgabe + " +" + this.koeffizient[0];
				else
					ausgabe = ausgabe + " " + this.koeffizient[0];
		} else if (i == 1 && !ersterEintrag && Math.abs(this.koeffizient[i]) > GRENZWERT) {
			if (this.koeffizient[i] > 0)
				ausgabe = ausgabe + " +" + this.koeffizient[i] + "x";
			else
				ausgabe = ausgabe + " " + this.koeffizient[i] + "x";

			if (Math.abs(this.koeffizient[0]) > GRENZWERT)
				if (this.koeffizient[0] > 0)
					ausgabe = ausgabe + " +" + this.koeffizient[0];
				else
					ausgabe = ausgabe + " " + this.koeffizient[0];
		}
		if (ersterEintrag)
			ausgabe = ausgabe + " " + this.koeffizient[0];
		else if (!ersterEintrag) {
			if (this.koeffizient[0] > 0)
				ausgabe = ausgabe + " +" + this.koeffizient[0];
			else
				ausgabe = ausgabe + " " + this.koeffizient[0];
		}
		return ausgabe;
	}

	/* ******** Getter - Methoden ******** */

	// Auslesen aller Koeffizienten in einem Schritt
	public void getKoeffizienten() {
		for (int i = 0; i < this.koeffizient.length; i++)
			System.out.print(this.koeffizient[i] + " ");
		System.out.println("");
	}

	// Auslesen einzelner Koeffizienten
	public void getKoeffizient(int i) {
		if (i >= 0 && i < this.koeffizient.length)
			System.out.println(this.koeffizient[i]);
	}

	// Auslesen des Grades des Polynoms
	public int getGrad() {
		return koeffizient.length - 1;
	}
}
