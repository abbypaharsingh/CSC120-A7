import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  
 
/**
 * Constructor for the House Class
 * @param name
 * @param address
 * @param nFloors
 * @param hasElevator
 */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); // Call the parent constructor
    this.residents = new ArrayList<String>();
    
  }

/**
 * Tells user whether house has a dining room or not.
 * @return boolean
 */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
}

/**
 * Tells user the number of residents in the house.
 * @return int
 */
  public int nResidents() {
    return this.residents.size();
}
/**
 * Adds a residents name to the list when they move in to the house.
 * @param name
 */
  public void moveIn(String name){
    this.residents.add(name);
  }

/**
 * Removes the name of the person who moved out and returns it.
 * @param name
 * @return String
 */
  public String moveOut(String name){ 
    this.residents.remove(name);
    return name;
    
  } 
  
/**
 * Tells user if the person they are looking for lives in that house.
 * @param person
 * @return boolean
 */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  /**
  * Prints the methods available for use
  */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn(n)\n + moveOut(n)\n + isResident(n)");
}

/**
 * Gives various responses and performs various functions related to changing floors in the building
*/
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    //if the person wants to move more than 1 storey up or down
    if ((floorNum-this.activeFloor)>1 ||(floorNum-this.activeFloor)<-1){
      if(this.hasElevator = true){
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
      else{
        throw new RuntimeException("This building does not have an elevator you may only go to an adjacent floor");
    }
      }
    else {
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
    }
    

}
/* Navigation methods */
/**
 * Allows person to go to a floor above
 * @param numberOfFloors
 */
  public void goUp(int numberOfFloors) {
    this.goToFloor(this.activeFloor + numberOfFloors);
  }

/**
 * Allows person to go 1 floor up
 */
  public void goUp() {
    this.goToFloor(this.activeFloor + 1);
  }

/**
 * Allows person to go to a floor below
 * @param numberOfFloors
 */
  public void goDown(int numberOfFloors) {
    this.goToFloor(this.activeFloor - numberOfFloors);
  }
/**
 * Allows person to go 1 floor down
 */
  public void goDown() {
    this.goToFloor(this.activeFloor - 1);
  }

  public static void main(String[] args) {
     House hopkinsHouse = new House("Hopkins", "Elm Street",3, false, true);
     hopkinsHouse.moveIn("Abby");
     hopkinsHouse.moveIn("Sena");
     hopkinsHouse.moveIn("Anna");
     System.out.println(hopkinsHouse.nResidents());
     hopkinsHouse.moveOut("Anna");
     System.out.println(hopkinsHouse.isResident("Abby"));
     System.out.println(hopkinsHouse.isResident("Maria"));
     System.out.println(hopkinsHouse.nResidents());
     hopkinsHouse.showOptions();
     hopkinsHouse.enter();
     hopkinsHouse.goUp(1);
     hopkinsHouse.goDown();
     

     
  }

}