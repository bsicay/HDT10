import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    File file;
    Scanner scan;
    ArrayList<String> nodeArray = new ArrayList<String>();      //Contiene el nombre de los lugares
    Integer[][] matrix;
    public static final String PATH = System.getProperty("user.dir") + "\\guategrafo.txt";

    public Reader(){
        findFile();
        getNodes();
        int n = nodeArray.size();
        matrix = new Integer[n][n];

        doMatrix();
    }

    public int[][] getMatrix(){
        return toPrimitive();
    }

    private void findFile(){
        try {
            file = new File("src/guategrafo.txt");
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println("No se encontro el archivo");
            System.exit(0);
        }
    }
    
    /**
	 * Metodo que se encarga de obtener todas las filas del archivo datos.txt
	 * @return String[]. Array con cada una de las filas de texto por casilla.
	 * @throws IOException
	 */
	public static String[] readFile() throws IOException {
		
			File doc = new File(PATH);

		  BufferedReader obj = new BufferedReader(new FileReader(doc));
		  ArrayList<String> linesList = new ArrayList<String>();

		  //leer y almacenar las filas del archivo de texto
		  String line;
		  while ((line = obj.readLine()) != null) {
		    linesList.add(line);
		  }
		  
		  obj.close();
		  
		  return linesList.toArray(new String[linesList.size()]); //convertir lista a array
	}

    public boolean isNumber(String str){
        boolean flag = true;

        try{
            int n = Integer.parseInt(str);
        }catch (NumberFormatException e){
            flag = false;
        }

        return flag;
    }

    public void getNodes(){
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] lineArray = line.split(" ");

            for (String word: lineArray) {
                if((nodeArray.contains(word) == false)&&(isNumber(word)==false)){
                    nodeArray.add(word);
                }
            }
        }

        findFile(); /*Resetea el Scanner*/
    }


    public void doMatrix(){
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] array = line.split(" ");

            int index1 = nodeArray.indexOf(array[0]);
            int index2 = nodeArray.indexOf(array[1]);
            int index3 = nodeArray.indexOf(array[2]);

            matrix[index1][index2] = Integer.parseInt(array[2]);
            matrix[index2][index1] = Integer.parseInt(array[2]);

            for(int i = 0; i < matrix.length; i++){
                matrix[i][i] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == null){
                    matrix[i][j] = 99999;
                }
            }
        }
    }

    public int[][] toPrimitive(){
        int len = matrix.length;
        int[][] primitive = new int[len][len];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    primitive[i][j] = matrix[i][j];
            }
        }
        return primitive;
    }

    public void printMatrix(Integer[][] matrix){
        for (Integer[] row: matrix) {
            for (Integer num: row) {
                System.out.print(num + "  ");
            }
            System.out.println("");
        }
    }






}
