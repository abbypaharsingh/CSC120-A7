/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator;


  /**
   * Constructor for cafe class
   * @param name
   * @param address
   * @param nFloors
   * @param hasElevator
   */
  public Cafe(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors); // Call the parent constructor
      this.nCoffeeOunces = 2000;
      this.nSugarPackets = 500;
      this.nCreams = 200 ;
      this.nCups = 150;
  }

  /**
   * Constructor for cafe class
   * @param name
   * @param address
   * @param nFloors
   */
  public Cafe(String name, String address, int nFloors) {
    super(name, address, nFloors); // Call the parent constructor
    this.nCoffeeOunces = 2000;
    this.nSugarPackets = 500;
    this.nCreams = 200 ;
    this.nCups = 150;
}

  /**
   * Sells coffee to customers by removing products from inventory
   * @param size
   * @param nSugarPackets
   * @param nCreams
   */
  public void sellCoffee(int size, int nSugarPackets, int nCreams){
      this.nCoffeeOunces -= size;
      this.nSugarPackets -= nSugarPackets;
      this.nCreams -= nCreams;
      this.nCups -=1;
  }
  /**
   * Sells coffee to customers by removing products from inventory
   * @param size
   * @param nSugarPackets
   * @param nCreams
   */
  public void sellCoffee(double size,double nSugarPackets, double nCreams){
    this.nCoffeeOunces -= size;
    this.nSugarPackets -= nSugarPackets;
    this.nCreams -= nCreams;
    this.nCups -=1;
}

  /**
   * Restocks the store by adding produce to the stock
   * @param nCoffeeOunces
   * @param nSugarPackets
   * @param nCreams
   * @param nCups
   */
  private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
  }
/**
* Prints the methods available for use
*/
  public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + sellCoffee() \n + restock()");
  }
  
/**
 * Gives various responses and performs various functions related to changing floors in the building
 */
  public void goToFloor(int floorNum) {
    
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if(this.nFloors == 1){
        throw new RuntimeException("This Building only has one floor.");
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
        Cafe compassCafe= new Cafe("Compass Cafe","Neilson Drive",3, false);
        compassCafe.sellCoffee(12.5, 3, 2);
        compassCafe.restock(12, 3, 2, 1);
        compassCafe.showOptions();
        compassCafe.enter();
        compassCafe.goUp(2);
    }
    
}

