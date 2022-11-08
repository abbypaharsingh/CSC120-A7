import java.util.Hashtable;
import java.util.Set;

/* This is a stub for the Library class */
public class Library extends Building {
  private Hashtable<String, Boolean> collection= new Hashtable <String, Boolean>();
  private Hashtable<Long, String> collection_plus= new Hashtable <Long, String>();
  
  private boolean hasElevator;

/**
 * Constructor for the library class
 * @param name
 * @param address
 * @param nFloors
 */
  public Library(String name, String address, int nFloors, boolean hasElevator ) {
    super(name, address, nFloors); // Call the parent constructor
  
  }
  
/**
 * Adds book to collection
 * @param title
 */
 public void addTitle(String title){
  this.collection.put(title,true);
}

/**
 * Connects ISBN to title
 * @param title
 */
 public void addISBN(long isbn,String title){
  this.collection_plus.put(isbn,title);
}

/**
 * Removes book from Collection
 * @param title
 * @return
 */
 public String removeTitle(String title){ // return the title that we removed
    this.collection.remove(title);  
    return title; 
} 

/**
 * Checks out book from library
 * @param title
 */
 public void checkOut(String title){
  this.collection.replace(title, true, false);
}

/**
 * Returns book to library
 * @param title
 */
  public void returnBook(String title){
   this.collection.replace(title, false, true);
}
/**
 * Checks if the title appears as a key in the Libary's collection
 * @param title
 * @return boolean
 */
  public boolean containsTitle(String title){
   return this.collection.containsKey(title);
} 
/**
 * Checks if book is currently available in library
 * @param title
 * @return boolean
 */
  public boolean isAvailable(String title){
        return this.collection.get(title);
  }

/**
 * Checks if book is currenly available in library using the isbn instead of the title
 * @param title
 * @return boolean
 */
  public boolean isAvailable(Long isbn){
  return this.collection.get(this.collection_plus.get(isbn));
}


/**
* Prints out the entire collection in an easy-to-read way (including checkout status)
*/
  public void printCollection(){ 
    //for loop 
    Set<String> setOfKeys = this.collection.keySet();
    for (String key : setOfKeys){
      System.out.print(key + " is ");
      if(this.collection.get(key)== true){
        System.out.print("available.");
        System.out.println();
    }
    else{
      System.out.println("checked out.");
      System.out.println();
    }
    }
      
}
/**
* Prints the methods available for use
*/
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(n)\n + removeTitle(n)\n + checkOut(n)\n + returnBook(n)\n + containsTitle(n)\n + isAvailable(n)\n + printCollection()");
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
      if(hasElevator = true){
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
      Library neilsonLibrary= new Library("Neilson", "Neilson Drive", 5, false);
      neilsonLibrary.addTitle("Circe by Madeline Miller");
      neilsonLibrary.addISBN(9781408890042L, "Circe by Madeline Miller");
      System.out.println(neilsonLibrary.isAvailable("Circe by Madeline Miller"));
      System.out.println(neilsonLibrary.isAvailable(9781408890042L)); 
      neilsonLibrary.addTitle("Educated by Tara Westover");
      neilsonLibrary.addTitle("The Color Purple by Alice Walker");
      neilsonLibrary.printCollection();
      neilsonLibrary.checkOut("Circe by Madeline Miller");
      neilsonLibrary.printCollection();
      neilsonLibrary.returnBook("Circe by Madeline Miller");
      neilsonLibrary.printCollection();
      neilsonLibrary.showOptions();
      neilsonLibrary.enter();
      neilsonLibrary.goUp(3);
      neilsonLibrary.goDown(3);
      neilsonLibrary.exit();
    }
  
  }