package cheaptrip;

import java.util.ArrayList;

import cheaptrip.path.MainTownFilter;
import cheaptrip.path.PathCreator;
import cheaptrip.path.Segment;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Przykladowa trasa jaka otrzymamy do rozpatrenia
		ArrayList<String> myTowns = new ArrayList<String>();

		// Transa przefiltorwana gotowwa do przeszkuania
		ArrayList<String> filteredTowns = new ArrayList<String>();

		// Filtr tras
		cheaptrip.path.MainTownFilter townFiler = new MainTownFilter();

		// Dodajemy przykladowe miasta - to dostaniemy od agenta zwracajacego miasta
		myTowns.add("Warszawa");
		myTowns.add("Łódź");
		myTowns.add("Gdańsk");
		myTowns.add("Chojnice");
		myTowns.add("Toruń");
		myTowns.add("Rzeszów");
		myTowns.add("Kraków");
		myTowns.add("jelitkowo");

		// Filtrowanie
		filteredTowns = townFiler.getFilteredList(myTowns);

		for (String town : filteredTowns) {
			System.out.println(town);
		}

		// Przesylanie przefiltorwanej trasy do agentow
		
			// Praca agenta wyznaczjacego trase - 1
			PathCreator pcreator = new PathCreator(filteredTowns, 2);
			for (Segment seg: pcreator.getPath().getPath()){
				System.out.println(seg);
			}
			System.out.println("Koszt calkowity :" + pcreator.getPath().getTotalCost());
			
		
			// Praca agenta wyznaczjacego trase - 2
			PathCreator pcreator2 = new PathCreator(filteredTowns, 3);
			for (Segment seg: pcreator2.getPath().getPath()){
				System.out.println(seg);
			}
			System.out.println("Koszt calkowity :" + pcreator2.getPath().getTotalCost());
			
		// Odbieranie trasy od agentow
		

	}

}
