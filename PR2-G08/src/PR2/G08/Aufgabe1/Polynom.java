package PR2.G08.Aufgabe1;

public class Polynom {

    public static void main(String[] args) { 
    	
    	Polynom polynom1 = new Polynom(1,2);
    	//System.out.println(polynom1.berechne(1));	//Funktioniert
    	
    	//System.out.println(polynom1.berechne(2,2)); //Funktioniert	
    }    

    double[] koeffizient;
    // Konstruktor
    Polynom(double... koeffizienten) {
        this.koeffizient = koeffizienten;
     
    }
    
    //Konstruktor für Nullpolynom
    public Polynom() {
    	koeffizient = null;
    	String fehlermeldung = "Keine Werte an das Polynom übergeben!";
    	System.out.print(fehlermeldung);
	}
    
 
    
    /* ******** Methoden ******** */
    
  //Berechnen des Wertes des Polynoms fur ein beliebiges x
    public double berechne(double x) {
    	//Initialisierung vom Funktionswert
    	double funktionswert = 0;
    	
    	for(int i=getGrad(); i>=0; i--){
    		//Funktionswert = Koeffizient * x^Grad
    		funktionswert = funktionswert + (Math.pow(x,i)*koeffizient[i]);
    	
    	}
    	return funktionswert;
    }
    
    
    //Berechnen des Wertes des Polynoms f¨ur mehrere x
    public double[] berechne(double... x) {
    	//Da wir mehrere Ergebnisse haben, erstellen wir für die
    	//Funktionswerte von x ein Array.
    	double funktionswert[] = new double[x.length];
    
    	for(int j=0;j<x.length;j++){
    		funktionswert[j] = funktionswert[j] + berechne(x[j]);
    		System.out.println(funktionswert[j]);
    	}	
    	return funktionswert;
    }
    
    
    
    //Berechnen des Integrals des Polynoms
    public double[] integriere (){
    	//Für das Integral muss man das Polynom aufleiten um eine Stammfunktion zu bilden.
    	//Beim aufleiten eines Polynoms bekommt man am Ende eine Variable die unendlich viele Zahlen
    	//haben kann, daher muss das Array um eins vergrößert werden.
    	double[] stammfunktion = new double[koeffizient.length + 1];
    	
    	for(int i=0;i<=koeffizient.length;i++){
    		stammfunktion[i+1] = koeffizient[i+1]/ (i+1); 	//Aufleiten von x^2 VIELLEICHT AUCH koeffizient[i]
    														//x^2 -> (x^3)/3
    	}
    	return stammfunktion;
    }
    
    

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
		return koeffizient.length-1;
	}
	
}
