package PR2.G08.Aufgabe1;

public class Polynom {

    public static void main(String[] args) {   }    

    double[] koeffizient;

    // Konstruktor
    Polynom(double... koeffizienten) {
        this.koeffizient = koeffizienten;
     
    }
    
    //Konstruktor für Nullpolynom
    public Polynom() {
    	koeffizient = null;
	}
    
 
    
    /* ******** Methoden ******** */
    
    
    
    
    
    

    
    
    /* ******** Getter - Methoden ******** */
    
    //Auslesen aller Koeffizienten in einem Schritt
    public double[] getKoeffizienten(){
    	return this.koeffizient;	
    }

	//Auslesen einzelner Koeffizienten
	public double getKoeffizient(int i) {
		return koeffizient[i];
	}
   
	//Auslesen des Grades des Polynoms
	public int getGrad() {
		return koeffizient.length;
	}
	
}
