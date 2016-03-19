package enteryourmealsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import Exceptions.AlreadyExistingIngredientException;

public class DataManagement {
	public static void writeFile(String fichier, ArrayList<String> ListOfLines) throws IOException{
		FileWriter fw = new FileWriter(fichier, false);
		BufferedWriter bw = new BufferedWriter (fw);
		PrintWriter fichierSortie = new PrintWriter (bw);
		try {
			for(int i = 0; i< ListOfLines.size(); i++){
				fichierSortie.println(ListOfLines.get(i));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			fichierSortie.close();
		}
		
	}
	
	@SuppressWarnings("finally")
	public static ArrayList<String> readfile(String fichier) throws IOException{
		InputStream ips=new FileInputStream(fichier); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String line;
		ArrayList<String> arrayList = new ArrayList<String>();
		try{
			while ((line=br.readLine())!=null){
				arrayList.add(line);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			br.close();
			return (arrayList);
		}
		
	}
	
}
