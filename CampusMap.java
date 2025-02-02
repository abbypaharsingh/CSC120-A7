import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;
    // ArrayList<House> houses;
    // ArrayList<Library> libraries;
    // ArrayList<Cafe> cafes;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
        // houses = new ArrayList<House>();
        // libraries = new ArrayList<Library>();
        // cafes = new ArrayList<Cafe>();
    
    
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Hopkins House", "112 Elm St, Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new House("Cutter House", "10 Prospect St, Northampton, MA 01060", 4, true,true));
        myMap.addBuilding(new House("Comstock House", "1 Mandelle Rd, Northampton, MA 01063", 4,true,true));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 1));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5, true));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr, Northampton, MA 01060", 5));
        myMap.addBuilding(new Building("Stoddard Hall", "23 Elm St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Mwangi Cultural Center", "12 Prospect St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm St, Northampton, MA 01060", 2));
        myMap.addBuilding(new House("Parsons Annex", "24 Henshaw Ave, Northampton, MA 01060", 4,false,false));
        System.out.println(myMap);
    }
    
}
