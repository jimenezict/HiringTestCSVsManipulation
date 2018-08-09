package datumize.cctest.service;

/**
 * Enum to control the values of the different zones
 * 
 * @author Esteban
 *
 */

public enum Zone {
	
	GRYFFINDOR("Gryffindor", 0), HUFFLEPUFF("Hufflepuff", 1), RAVENCLAW("Ravenclaw", 2), SLYTHERIN("Slytherin", 3);
	
	private String name;
	private int value;
	
	private Zone(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
	return name;
	}
	
	public int getValue() {
		return value;
	}

	public static Zone getZone(String nameZone) {
		
		for(Zone zone:Zone.values()) {
			
			if(nameZone.equalsIgnoreCase(zone.getName())) return zone;
		}
		return null;
	}
	
	public static Zone getZone(int value) {
		
		for(Zone zone:Zone.values()) {
			
			if(zone.getValue()==value) return zone;
		}
		return null;
	}

	

}
