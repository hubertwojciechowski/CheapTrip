package cheaptrip.path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainTownFilter {

	/**
	 * Lista z glownymi miastami
	 */
	private ArrayList<String> mainTowns;

	/**
	 * Sciezka do pliku z miastami
	 */
	private String dataFileName = "mainTowns.txt";

	
	/**
	 * Konstruktor
	 */
	public MainTownFilter()  {
		// Wczytujemy miasta
		
		try {
			this.loadMainTowns();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	/**
	 * Metoda wczytuje liste miast z pliku
	 * @throws Exception 
	 */
	private void loadMainTowns() throws Exception {

		
		this.mainTowns = new ArrayList<String>();
		BufferedReader br;
		String line;
		
		// Otwieramy plik
		try {
			br = new BufferedReader(new FileReader(this.dataFileName));
			while ((line = br.readLine()) != null) {
				// Dodajemy miasta do listy
				this.mainTowns.add(line.trim().toLowerCase());	
			}
		} catch (Exception e) {
			throw e;
		}
		
		// Sortujemy liste - niezbedne do wyszukiwania
		Collections.sort(this.mainTowns);
	}
	
	/**
	 * 
	 * @param towns lista miast do przefiltrowania
	 * @return lista zawierajaca tylko glowne miasta
	 */
	public ArrayList<String> getFilteredList(ArrayList<String> towns) {
		
		// Lista wynikowa
		ArrayList<String> resultList = new ArrayList<String>();
		
		// Wyszkukiwanie miast 
		int index;
		for (String town : towns) {
			
			index = Collections.binarySearch(this.mainTowns, town.trim().toLowerCase());
			// Jesli jest na liscie glownych miast dodajemy do listy wynikowej
			if (index > 0 ) {
				resultList.add(this.mainTowns.get(index));
			}
		}
		return resultList;
	}
	
	
}
