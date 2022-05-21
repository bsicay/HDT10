import java.util.Scanner;

public class HDT10 {
    public static void main(String[] args){
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        int[][] matrix = read.getMatrix();
        AllPairShortestPath floyd = new AllPairShortestPath();
        int option = 0;
        String menu= "Seleccione la opcion que desea realizar:\n\n"
        		+ "1. Nueva ruta entre dos ciudades"
        		+ "\n2. Interrupción de tráfico entre dos ciudades"
        		+ "\n3. Calcular la ruta mas corta entre dos ciudades"
        		+ "\n4. Mostrar el centro del grafo"
        		+ "\n5. Salir";

        do {
        	try {
        		System.out.println("\n______________________-----------------------------------______________________");
                System.out.println("______________________--------- EFICIENCIA DE RUTAS ---------______________________");
                System.out.println("______________________-----------------------------------______________________\n");
                System.out.println(menu);
                option= Integer.parseInt(in.nextLine());
                switch(option) {
	                case 1: {
		        		
		        	}break;
	                case 2: {
	                	
	                	
	                	
		        	}break;
	                case 3: {
	                	System.out.println("\nMatriz de adyacencia representante: \n");
	                	floyd.floydWarshall(matrix);
		        	}break;
	                case 4: {
		        		
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
