import java.io.IOException;
import java.util.Scanner;

public class HDT10 {
    public static void main(String[] args){
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        int[][] matrix = read.getMatrix();
        boolean found = false;
        AllPairShortestPath floyd = new AllPairShortestPath();
        int option = 0;
        String menu= "Seleccione la opcion que desea realizar:\n\n"
        		+ "1. Nueva ruta entre dos ciudades"
        		+ "\n2. Interrupción de tráfico entre dos ciudades"
        		+ "\n3. Calcular la ruta mas corta entre dos ciudades"
        		+ "\n4. Mostrar el centro del grafo"
        		+ "\n5. Salir";
        
        while(!found) {
			String[] fileContent = null;
			try { //Se encuentra el archivo
				fileContent = read.readFile();
				floyd.fileToGraph(fileContent);
				found = true;
			} catch (IOException e) { //Si no se encuentra el archivo
				System.out.println("\nArchivo no encontrado.\nPor favor, asegurese de que el archivo guategrafo.txt sea valido y se encuentre en la carpeta donde se ubica el programa.");
				System.out.println("Presione enter para volver a buscar el archivo.");
				in.nextLine();
			}	
        }System.out.println("\nArchivo encontrado.");

        do {
        	try {
        		System.out.println("\n______________________-----------------------------------______________________");
                System.out.println("______________________--------- EFICIENCIA DE RUTAS -------______________________");
                System.out.println("______________________-----------------------------------______________________\n");
                System.out.println(menu);
                option= Integer.parseInt(in.nextLine());
                String origen = "";
				String destino = "";
                switch(option) {
	                case 1: {
	                	
		        	}break;
	                case 2: {
	                	
		        	}break;
	                case 3: {
	                	System.out.println("Ingrese la ciudad de origen:");
						origen = in.nextLine();
						System.out.println("Ingrese la ciudad destino:");
						destino = in.nextLine();
						System.out.println(floyd.shorterRoute(origen,destino));
		        	}break;
	                case 4: {
	                	System.out.println("La ciudad al centro del grafo es: "+ floyd.getGraphCenter());
		        	}break;
	                default: {
		        		
		        	}break;
                }
	        	
        	}catch(Exception e){
                System.out.println("Por favor, ingrese un formato valido");
            }
            
        }while (option != 5);
        // Print the solution
    }
}
