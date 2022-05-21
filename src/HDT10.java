import java.io.IOException;
import java.util.Scanner;

public class HDT10 {
	
    public static void main(String[] args){
    	
    	//Declaracion de variables
        Reader read = new Reader();
        Scanner in = new Scanner(System.in);
        
        AllPairShortestPath floyd = new AllPairShortestPath();
        
        boolean found = false;
        
        int[][] matrix = read.getMatrix();
        int option = 0;
        int peso = 0;
        
        String menu= "Seleccione la opcion que desea realizar:\n\n"
        		+ "1. Nueva ruta entre dos ciudades"
        		+ "\n2. Interrupción de tráfico entre dos ciudades"
        		+ "\n3. Calcular la ruta mas corta entre dos ciudades"
        		+ "\n4. Mostrar el centro del grafo"
        		+ "\n5. Salir";
        String origen = "";
		String destino = "";
		
        while(!found) //Mientras la variable sea "False"
        {
			String[] fileContent = null;
			
			try //Se encuentra el archivo
			{ 
				fileContent = read.readFile();
				floyd.fileToGraph(fileContent);
				found = true; //Si se encuentra el archivo la variable se cambia a "True" y se rompe el ciclo
			} 
			
			catch (IOException e) //Si no se encuentra el archivo
			{ 
				System.out.println("\nArchivo no encontrado.\nPor favor, asegurese de que el archivo guategrafo.txt sea valido y se encuentre en la carpeta donde se ubica el programa.");
				System.out.println("Presione enter para volver a buscar el archivo.");
				in.nextLine();
			}	
        }
        
        System.out.println("\nArchivo encontrado.");

        do 
        {
        	
        	try 
        	{
        		//imprime el menu
        		System.out.println("\n______________________-------------------------------------______________________");
                System.out.println("______________________--------- EFICIENCIA DE RUTAS -------______________________");
                System.out.println("______________________-------------------------------------______________________\n");
                
                System.out.println(menu);
                option= Integer.parseInt(in.nextLine()); //lee opcion
               
		        switch(option) {
		        
	                case 1: {
	                	System.out.println("\n\nIndique la ciudad de origen:");
						origen = in.nextLine();
						
						System.out.println("\nIndique la ciudad destino:");
						destino = in.nextLine();
						
						try 
						{
							System.out.println("Indique la cantidad de kilometros entre ambas ciudades:");
							peso = Integer.parseInt(in.nextLine());
						}
						
						catch(Exception e) 
						{
							System.out.println("Ingrese un numero entero");
						}
						
						try 
						{
							System.out.println("\n");
							System.out.println(floyd.newRoute(origen,destino,peso));
						}
						
						catch (Exception e) 
						{
							System.out.println("\nHa ocurrido un error al manipular el grafo");
						}
						
		        	}
	                break;
	                
	                case 2: {
	                	System.out.println("\n\nIndique la ciudad de origen:");
						origen = in.nextLine();
						
						System.out.println("\nIndique la ciudad destino:");
						destino = in.nextLine();
						
						System.out.println("\n");
						System.out.println(floyd.breakRoute(origen,destino));
		        	}
	                break;
		        	
	                case 3: {
	                	System.out.println("\n\nIngrese la ciudad de origen:");
						origen = in.nextLine();
						
						System.out.println("\nIngrese la ciudad destino:");
						destino = in.nextLine();
						
						System.out.println("\n");
						System.out.println(floyd.shorterRoute(origen,destino));
		        	}
	                break;
		        	
	                case 4: {
	                	System.out.println("\n\nLa ciudad al centro del grafo es: "+ floyd.getGraphCenter());
		        	}
	                break;
		        	
	                default: {
		        		
		        	}
	                break;
                }
	        	
        	}
        	
        	catch(Exception e)
        	{
                System.out.println("Por favor, ingrese un formato valido");
            }
            
        }while (option != 5);
        Reader.deleteFile();
		try {
			floyd.rewriteFile();
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error a reescribir el archivo.");
		}
    }
}
