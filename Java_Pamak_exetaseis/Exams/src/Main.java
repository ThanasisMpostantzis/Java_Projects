import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		//---------Provider and subscribers-------------
		Provider newEnergy = new Provider("New Energy");
		Subscriber sub1 = new Subscriber("Papadopoulos", 9840);
		GreenSubscriber greenSub1 = new GreenSubscriber("Nikolaou", 10340, "Katerini");
		
		//---------Provider and subscribers-------------
		Provider powerTech = new Provider("Power Tech");
		Subscriber sub2 = new Subscriber("Hliadis", 10800);
		GreenSubscriber greenSub2 = new GreenSubscriber("Georgiou", 9730, "Thessaloniki");
		
		//---------Provider and subscribers-------------
		Provider greenAndClean = new Provider("Green and Clean");
		Subscriber sub3 = new Subscriber("Symeonidis", 11210);
		GreenSubscriber greenSub3 = new GreenSubscriber("Mitroudis", 7890, "Veroia");
		
		//---------ArrayList of Providers-------------
		ArrayList<Provider> providers = new ArrayList<>();
		providers.add(newEnergy);
		providers.add(powerTech);
		providers.add(greenAndClean);
		
		//---------Adding subscribers to providers-------------
		newEnergy.addSubscriber(sub1);
		newEnergy.addSubscriber(greenSub1);
		powerTech.addSubscriber(sub2);
		powerTech.addSubscriber(greenSub2);
		greenAndClean.addSubscriber(sub3);
		greenAndClean.addSubscriber(greenSub3);
		
		//---------Adding panels to greenSubscribers-------------
		SolarPanel sp1 = new SolarPanel("SunPower", 480);
		SolarPanel sp2 = new SolarPanel("Panasonic", 550);
		SolarPanel sp3 = new SolarPanel("RECSolar", 490);
		
		greenSub1.addSolarPanel(sp1);
		greenSub1.addSolarPanel(sp1);
		
		greenSub2.addSolarPanel(sp2);
		greenSub2.addSolarPanel(sp2);
		
		greenSub3.addSolarPanel(sp3);
		greenSub3.addSolarPanel(sp3);
		
		//--------Calculate profit for each company-------------
		HashMap<String, String> profit = readFile("EnergyPrices.txt");
		
		double sum = 0;
		System.out.println("----------Calculate profit for each company------------");
		for(Provider p : providers) {
			sum = p.calculateTotalNetEnergy();
			String n = profit.get(p.getCoName());
			
			System.out.println(p.getCoName() + ", " + "Profit: " + (sum * Double.parseDouble(n)));
			
		}
		
		
		ProfitCalculator frame = new ProfitCalculator(providers);
	}

	public static HashMap<String, String> readFile(String fileName) {
		
		HashMap<String, String> results = new HashMap<>();

		try {
			FileReader fileIn = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fileIn);
			
			String line;

			while( (line = in.readLine()) != null) {
				String[] parts = line.split(",");
				results.put(parts[0],parts[1]);
			}
		
			in.close();
			fileIn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return results;		
	}

}
