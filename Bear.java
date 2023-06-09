// Joy Angel Schwarting
// CS 145
// Bear.java
 
import java.awt.*; 
 
public class Bear extends Critter { // "extends" for inheritence between superclass and subclass
 
      private boolean polar;  
      private int moves; // moves will be different for each critter so: private!
      
      
      // switch between forward and back slash depending on move number
      public String toString() {
            // modulus to divide by 2, if even number of moves then "/" if not then "\"
            if (moves%2==0){ 
                  return "/";
            } else { 
                  return "\\"; 
            }
      } // end toString 
      
      public Bear(boolean polar) { 
            this.polar=polar; // using "this.polar" for current object
            getColor(); 
      } // end Bear boolean
      
      
      // white for a polar bear, black for any other bear (black bear)
      public Color getColor() { 
         if (this.polar) { 
             return Color.WHITE; 
         } else { 
             return Color.BLACK;
         }
      } // end getColor
      
      
      // infect if an enemy is in front, hop if possible, otherwise turn left
      public Action getMove(CritterInfo info) {  
         moves++; 
         if(info.getFront()==Neighbor.OTHER) { 
            return Action.INFECT; 
         } else if (info.getFront()==Neighbor.EMPTY) { 
            return Action.HOP; 
         } else { 
            return super.getMove(info); 
         }
       } // end action getMove    
 } // end Bear Critter subclass