package es.upm.salt;

public class Taxi1 {
	
	
	private int[][] ciudad; // plano de la ciudad
	private int coordenadax; // posición del taxi en el eje x
	private int coordenaday; // posición del taxi en el eje y
	private double distancia; // distancia que ha recorrido el TAXI1
	private int numUsuarios; // nº de usuarios atendidos por el TAXI1
	private double recaudacion; // dinero recaudado

	public Taxi1 () { // INICIALIZAMOS VARIABLES
		ciudad = new int[101][101];
		coordenadax = 50;
		coordenaday = 50;
		distancia = 0;
		numUsuarios = 0;
		recaudacion=0;
	}
	
	public double getDistanciaRecorrida () {
		return distancia;
	}
	
	public int getNumUsuarios() {
		return numUsuarios;
	}
	
	public double getRecaudacion() {
		return recaudacion;
	}
	
	public boolean dentro(int x, int y) { // Comprueba que las coordenadas están dentro de la ciudad
		boolean dentro = false;
		if (x<ciudad.length && y<ciudad[0].length && x>=0 && y>=0)
			dentro = true;
		return dentro;
	}
	
	public int taxiX () { // Obtener la coordenada X de la posición del taxi
		return coordenadax;
	}
	
	public int taxiY () { // Obtener la coordenada Y de la posición del taxi
		return coordenaday;
	}
	
	public void localizacionTaxi(){
		System.out.println ("Coordenada x = " + taxiX() + " Coordenada y = " + taxiY());
	}

	public void llamar(int x, int y, int x2, int y2) { // Un usuario llama al taxi y este se dirige al lugar de donde proviene la llamada
		if (dentro(x,y)) {
			distancia += Math.sqrt(Math.pow(taxiX()-x,2)+Math.pow(taxiY()-y,2));
			coordenadax=x;
			coordenaday=y;
			llevar(x2,y2);
		}
	}
	
	public void llevar(int x2, int y2) { // El usuario que le llamó, le pide que le lleve a un lugar determinado (x2,y2) y el taxi va allí. El número de usuarios se incrementa en uno.
		if (dentro(x2,y2)) {
			distancia += Math.sqrt(Math.pow(taxiX()-x2,2)+Math.pow(taxiY()-y2,2));
			recaudacion += Math.sqrt(Math.pow(taxiX()-x2,2)+Math.pow(taxiY()-y2,2))*0.5;
			coordenadax=x2;
			coordenaday=y2;
			numUsuarios++;
		}
	}
	
	public double distanciaT1() { // Dadas unas coordenadas aleatorias, realizamos un bucle para demandar el trabajo del taxi repetidamente hasta obtener una distancia recorrida total
		recaudacion=0;
		distancia=0;
		numUsuarios=0;
		while (numUsuarios<200) {
			int x = (int) Math.floor(Math.random()*100); 
			int y = (int) Math.floor(Math.random()*100); 
			int x2 = (int) Math.floor(Math.random()*100); 
			int y2 = (int) Math.floor(Math.random()*100);
			llamar(x,y,x2,y2);
		}
		return getDistanciaRecorrida();
	}
	
	public int numUsuarios() { // Dadas unas coordenadas aleatorias, realizamos un bucle para demandar el trabajo del taxi repetidamente hasta obtener un numero de usuarios atendidos
		recaudacion=0;
		distancia=0;
		numUsuarios=0;
		while (distancia<14000) {
			int x = (int) Math.floor(Math.random()*100); 
			int y = (int) Math.floor(Math.random()*100); 
			int x2 = (int) Math.floor(Math.random()*100); 
			int y2 = (int) Math.floor(Math.random()*100);
			llamar(x,y,x2,y2);
		}
		return getNumUsuarios();
	}
	
	public static void main(String[] args) {
		Taxi1 prueba = new Taxi1();
		System.out.println("       TAXI1----SITUACION 1\r");
		System.out.println("Dado un límite de 200 usuarios, para atenderlos a todos, el taxi1 ha tenido que recorrer una distancia determinada. Es la siguiente:");
		System.out.println("El taxi1 ha recorrido " + prueba.distanciaT1() + "u");
		System.out.println("En estas condiciones, el taxi1 ha recaudado " + prueba.getRecaudacion() + "€\r");
		System.out.println("       TAXI1----SITUACION 2\r");
		System.out.println("Dado un límite de distancias recorridas de 14000u, el taxi1 ha podido atender a un determinado número de usuarios. Es el siguiente:");
		System.out.println("El taxi1 ha atendido a " + prueba.numUsuarios() + " usuarios");
		System.out.println("En estas condiciones, el taxi1 ha recaudado " + prueba.getRecaudacion() + "€");
	}

}
