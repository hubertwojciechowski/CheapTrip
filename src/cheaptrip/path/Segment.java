package cheaptrip.path;

/**
 * Odcinek laczacy dwie miescowosci
 * @author Clint-Eastwood
 *
 */
public class Segment {

	/**
	 * Nazwa miejscowosci poczatkowej
	 */
	private String to;
	/**
	 * Nazwa miejscowosci docelowej
	 */
	private String from;

	/**
	 * Typ transportu
	 */
	private TransportType type;
	
	/**
	 * Kosz transportu
	 */
	private Float cost;
	
	public float GetCost() {
		return this.cost;
	}
	
	/**
	 * Typ transportu
	 * @author Clint-Eastwood
	 */
	public static enum TransportType {
		Train,Bus,Plane
	};

	/**
	 * Konstruktor
	 * @param from
	 * @param to
	 * @param type
	 * @param cost - jesli nie podany przyjmuje wartosc 0.0f
	 */
	public Segment(String from, String to, TransportType type, Float cost) {
		this.from = from;
		this.to = to;
		this.type = type;
		this.cost = cost;
	}
	
	public Segment(String from, String to, TransportType type) {
		this.from = from;
		this.to = to;
		this.type = type;
		this.cost = 0.0f;
	}
	
	@Override
	public String toString(){
		return ("Z :"  + this.from + " Do :" + this.to + "(" + this.type  + ")"+ " Koszt :" + this.cost ); 
	}
	
	
}
