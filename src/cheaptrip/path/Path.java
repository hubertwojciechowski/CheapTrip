package cheaptrip.path;

import java.util.ArrayList;

public class Path {
	
	/**
	 * Sciezka wynikowa
	 */
	private ArrayList<Segment> path;
	
	public ArrayList<Segment> getPath(){
		return this.path;
	}
	
	/**
	 * Kosz calkowity
	 */
	private Float totalCost;
	
	public Float getTotalCost(){
		return this.totalCost;
	}
	
	public Path(){
		this.path = new ArrayList<Segment>();
		this.totalCost = 0.0f;
	}
	
	public void Add(Segment s) {
		this.path.add(s);
		this.totalCost += s.GetCost();
	}
	
}
