import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Fleet> fl = new ArrayList<>();
		
		Fleet f1 = new Fleet("Hrakleio");
		Fleet f2 = new Fleet("Rethymno");
		
		Taxi tx1 = new ElectricalTaxi("XYS771", "thanasis", 40);
		Taxi tx2 = new ElectricalTaxi("XYS981", "Panos", 50);
		Taxi tx3 = new GasolineTaxi("EPO971", "George", 50, 5);
		Taxi tx4 = new GasolineTaxi("EPO111", "John", 90, 7);
		
		f1.storeTaxi(tx1);
		f1.storeTaxi(tx3);
		f2.storeTaxi(tx2);
		f2.storeTaxi(tx4);
		

		fl.add(f1);
		fl.add(f2);

		
		new taxiFrame(fl);
		
	}

}
