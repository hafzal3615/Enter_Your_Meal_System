package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import enteryourmealsystem.DataManagement;

/**
 * @author Pierre
 *
 *En tant que test de base, on vérifiera ici à la main qu'il y a bien eu écriture dans le fichier.
 *Pour les tests plus hauts dans la hiérarchie, on fera une comparaison à l'aide des méthodes write et read
 */
public class DataManagementTest {
	
	
	@Test
	public void testWriteFile() throws IOException{ 
	

	ArrayList<String> names_and_numbers = new ArrayList<String>();
	String bob = "bob";
	String nancy = "nancy";
	String jim = "jim";
	String claire = "claire";

	names_and_numbers.add( bob ); 
	names_and_numbers.add( nancy ); 
	names_and_numbers.add( jim );
	names_and_numbers.add( claire );
	DataManagement names = new DataManagement();
	names.writeFile("C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\testwriteinfile.txt", names_and_numbers);
	
	
	}
	
	@Test
	public void testReadFile() throws IOException{ 
	

	ArrayList<String> names_and_numbers = new ArrayList<String>();
	String bob = "bob";
	String nancy = "nancy";
	String jim = "jim";
	String claire = "claire";

	names_and_numbers.add( bob ); 
	names_and_numbers.add( nancy ); 
	names_and_numbers.add( jim );
	names_and_numbers.add( claire );
	DataManagement names = new DataManagement();
	names.writeFile("C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\testwriteinfile.txt", names_and_numbers);
	ArrayList<String> namesbis = new ArrayList<String>();
	boolean flag = false; 
	String s1 = "";
	String s2 = "";
	for (int i = 0; i<4; i++){
		namesbis.add(names.readfile("C:\\Users\\Pierre\\Documents\\GitHub\\Enter_Your_Meal_System\\testwriteinfile.txt").get(i));
		s1 = namesbis.get(i);
		s2 = names_and_numbers.get(i);
		if (!s1.equals(s2)){
			flag = true; // il y a une erreur
			System.out.println(namesbis.get(i));
			System.out.println(names_and_numbers.get(i));
		}
	}
	assertFalse(flag);
	
	
	}
}
