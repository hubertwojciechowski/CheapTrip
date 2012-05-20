package cheaptrip.path;

import java.util.ArrayList;
import java.util.Random;

/**
 * Trasa o okreslonej precyzji 
 * Zawierajaca trase na temat odcinkow
 * @author Clint-Eastwood
 *
 */
public class PathCreator {

	/**
	 * Pelna trasa podzielona na odcinki
	 */
	private Path resultPath;
	

	public Path getPath(){
		return this.resultPath;
	}
	
	private ArrayList<String> shortTownList;

	/**
	 * Konstruktor
	 * @param rawList - lista miast
	 * @param precision - precyzja  oznacza ile miast bedziemy uzywac w wyznaczaniu trasy wspolczynnik -  (1/x)*100 %
	 */
	public PathCreator(ArrayList<String> rawList, int precision) {

		this.resultPath = new Path();
		this.shortTownList = new ArrayList<String>();
		final int rawPathLength = rawList.size();

		// Musimy posiadac minimum 2 miasta
		if (rawPathLength < 2) {
			return;
		}

		// Precyzja  1 - 100% wszystkie miasta, precyzja 4 - 25% miast 
		if (precision < 1) {
			return;
		}

		// Skracamy liste - bierzemy tylko co n-ty element z listy
		for (int i = 0; i < rawPathLength; i += precision) {
			this.shortTownList.add(rawList.get(i));
		}

		// Dodajemy miasto koncowe - jesli nie zostalo uwzglednione
		if (this.shortTownList.get(this.shortTownList.size() - 1) != rawList
				.get(rawList.size() - 1)) {
			this.shortTownList.add(rawList.get(rawList.size() - 1));
		}
		
		// Tworzymy odcinki
		this.build();
		
	}

	private void build() {

		final int shortListLength = this.shortTownList.size();

		String from = this.shortTownList.get(0);
		String to;

		float min = Float.MAX_VALUE;
		float tmp = 0;
		Segment.TransportType transportType = null;

		// Dodajemy miasto poczatkowe - koszt 0
		this.resultPath.Add(new Segment(from,from,transportType));

		// Wyznaczamy trase - oceniajac odcinki
		for (int i = 1; i < shortListLength; i++) {

			from = shortTownList.get(i - 1);
			to = shortTownList.get(i);

			// Sprawdzamy srodki transportu
			tmp = this.getRandomBus();
			if (tmp < min) {
				min = tmp;
				transportType = Segment.TransportType.Bus;
			}
			tmp = this.getRandomTrain();
			if (tmp < min) {
				min = tmp;
				transportType = Segment.TransportType.Train;
			}

			tmp = this.getRandomPlane();
			if (tmp < min) {
				min = tmp;
				transportType = Segment.TransportType.Plane;
			}

			if (min == Float.MAX_VALUE) {
				System.out
						.println("Nie znaleziono zadnych polaczen z jednego miasta do drugiego");
				break;
			}

			this.resultPath.Add(new Segment(from,to,transportType,min));
		}

	}

	// Odwolania do agentow, aby wyznaczyly trase
	public float getRandomBus() {
		return new Random().nextFloat();
	}

	public float getRandomTrain() {
		return new Random().nextFloat();
	}

	public float getRandomPlane() {
		return new Random().nextFloat();
	}

}
