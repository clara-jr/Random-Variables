package es.upm.salt;

public class Taxi2noequiprobable {

	private int[][] ciudad;
	private int coordenadax;
	private int coordenaday;
	private double distancia2;
	private int numUsuarios2;
	private double recaudacion2;

	public Taxi2noequiprobable () {
		ciudad = new int[101][101];
		coordenadax=50;
		coordenaday=50;
		distancia2 = 0;
		numUsuarios2 = 0;
		recaudacion2=0;
	}
	
	public double getDistanciaRecorrida2 () {
		return distancia2;
	}
	
	public int getNumUsuarios2() {
		return numUsuarios2;
	}
	
	public double getRecaudacion2() {
		return recaudacion2;
	}
	
	public boolean dentro(int x, int y) {
		boolean dentro = false;
		if (x<ciudad.length && y<ciudad[0].length && x>=0 && y>=0)
			dentro = true;
		return dentro;
	}
	
	public int taxiX () {
		return coordenadax;
	}
	
	public int taxiY () {
		return coordenaday;
	}
	
	public void localizacionTaxi(){
		System.out.println ("Coordenada x = " + taxiX() + " Coordenada y = " + taxiY());
	}
	
	public void llamar2(int x, int y, int x2, int y2) {
		if (dentro(x,y)) {
			distancia2 += Math.sqrt(Math.pow(taxiX()-x,2)+Math.pow(taxiY()-y,2));
			coordenadax=x;
			coordenaday=y;
			llevar2(x2,y2);
		}
	}
	
	public void llevar2(int x2, int y2) { // El usuario que le llamó, le pide que le lleve a un lugar determinado (x2,y2) y el taxi va allí. Después va al centro de la ciudad a esperar a una siguiente llamada. El número de usuarios se incrementa en uno.
		if (dentro(x2,y2)) {
			distancia2 += Math.sqrt(Math.pow(taxiX()-x2,2)+Math.pow(taxiY()-y2,2));
			recaudacion2 += Math.sqrt(Math.pow(taxiX()-x2,2)+Math.pow(taxiY()-y2,2))*0.5;
			coordenadax=x2;
			coordenaday=y2;
			distancia2 += Math.sqrt(Math.pow(taxiX()-50,2)+Math.pow(taxiY()-50,2));
			coordenadax=50;
			coordenaday=50;
			numUsuarios2++;
		}
	}
	
	public double distanciaT2() { 
		recaudacion2=0;
		distancia2=0;
		numUsuarios2=0;
		double n = Math.random();
		while (numUsuarios2<200) {
			int x = (int) Math.floor(Math.random()*100); 
			int y = (int) Math.floor(Math.random()*100); 
			if(n<=0.5) { //centro
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*(65-35+1)+35);
				llamar2(x,y,x2,y2);
			}
			//Ahora hay que repartir 0,5 entre 9240 elementos que ocupan distintos intervalos en el plano, y por tanto hay que analizarlos por separado pero aportando a cada punto la misma probabilidad
			if(0.5<n && n<=0.691287878) { // lado izquierdo (3535 elementos)
				int x2 = (int) Math.floor(Math.random()*34); 
				int y2 = (int) Math.floor(Math.random()*100);
				llamar2(x,y,x2,y2);
			}
			if(0.691287878<n && n<=0.882575756) { // lado derecho (3535 elementos)
				int x2 = (int) Math.floor(Math.random()*(100-66+1)+66); 
				int y2 = (int) Math.floor(Math.random()*100);
				llamar2(x,y,x2,y2);
			}
			if(0.882575756<n && n<=0.941287877) { // cuadrado de arriba (1085 elementos)
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*(100-66+1)+66);
				llamar2(x,y,x2,y2);
			}
			if(n>0.941287877) { // cuadrado de abajo (1085 elementos)
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*34);
				llamar2(x,y,x2,y2);
			}
		}
		return getDistanciaRecorrida2();
	}
	
	public int numUsuarios2() { 
		recaudacion2=0;
		distancia2=0;
		numUsuarios2=0;
		while (distancia2<14000) {
			double n = Math.random();
			int x = (int) Math.floor(Math.random()*100); 
			int y = (int) Math.floor(Math.random()*100); 
			if(n<=0.5) { //centro
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*(65-35+1)+35);
				llamar2(x,y,x2,y2);
			}
			//Ahora hay que repartir 0,5 entre 9240 elementos que ocupan distintos intervalos en el plano, y por tanto hay que analizarlos por separado pero aportando a cada punto la misma probabilidad
			if(0.5<n && n<=0.691287878) { // lado izquierdo (3535 elementos)
				int x2 = (int) Math.floor(Math.random()*34); 
				int y2 = (int) Math.floor(Math.random()*100);
				llamar2(x,y,x2,y2);
			}
			if(0.691287878<n && n<=0.882575756) { // lado derecho (3535 elementos)
				int x2 = (int) Math.floor(Math.random()*(100-66+1)+66); 
				int y2 = (int) Math.floor(Math.random()*100);
				llamar2(x,y,x2,y2);
			}
			if(0.882575756<n && n<=0.941287877) { // cuadrado de arriba (1085 elementos)
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*(100-66+1)+66);
				llamar2(x,y,x2,y2);
			}
			if(n>0.941287877) { // cuadrado de abajo (1085 elementos)
				int x2 = (int) Math.floor(Math.random()*(65-35+1)+35); 
				int y2 = (int) Math.floor(Math.random()*34);
				llamar2(x,y,x2,y2);
			}
		}
		return getNumUsuarios2();
	}
	
	public static void main(String[] args) {
		Taxi2noequiprobable prueba2 = new Taxi2noequiprobable();
		System.out.println("       TAXI2 no equiprobable----SITUACION 1\r");
		System.out.println("Dado un límite de 200 usuarios, para atenderlos a todos, el taxi2 ha tenido que recorrer una distancia determinada. Es la siguiente:");
		System.out.println("El taxi2 ha recorrido " + prueba2.distanciaT2() + "u");
		System.out.println("En estas condiciones, el taxi2 ha recaudado " + prueba2.getRecaudacion2() + "€\r");
		System.out.println("       TAXI2 no equiprobable----SITUACION 2\r");
		System.out.println("Dado un límite de distancias recorridas de 14000u, el taxi2 ha podido atender a un determinado número de usuarios. Es el siguiente:");
		System.out.println("El taxi2 ha atendido a " + prueba2.numUsuarios2() + " usuarios");
		System.out.println("En estas condiciones, el taxi2 ha recaudado " + prueba2.getRecaudacion2() + "€");
	}
	
}