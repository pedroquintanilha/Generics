package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import services.MaxService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		File file = new File(sc.nextLine());
		List<Product> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line = br.readLine();
			
			while(line!=null) {
				String[] str = line.split(",");
				list.add(new Product(str[0], Double.parseDouble(str[1])));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.print("Error reading file: "+ e.getMessage());
		}
		
		Product p = MaxService.max(list);
		System.out.println();
		System.out.print(p);
		
		sc.close();

	}

}
