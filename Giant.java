// Joy Schwarting
// CS 145
// Giant.java

import java.awt.*;
 
 public class Giant extends Critter {  // "extends" for inheritence between superclass and subclass
 
      private int moves; // moves private because each critters behavior is different!
      
      
      public Giant() { 
            moves=1;
            getColor(); 
      }
      
      
      public String toString() { 
      //"fee" for 6 moves, "fie" for 6 moves, "foe" for 6 moves, "fum" for 6 moves, then repeat. 
            if (moves<=6){ 
                  return "fee"; 
            } else if (moves<=12) { 
                  return "fie"; 
            } else if (moves<=18) { 
                  return "foe"; 
            } else { 
                  return "fum"; 
            } 
      } // end toString
      
      
      public Color getColor () { 
      // this overrides the getColor superclass for the Giant critter
            return Color.GRAY;
      }      
      
      
      public Action getMove(CritterInfo info) { 
      // always infect if an enemy is in front, hop if possible, otherwise turn right 
      // also keeps track of move count for possible reset from "fum" to "fee"
            if (info.getFront()==Neighbor.OTHER) { 
                  countMoves(); 
                  return Action.INFECT;
            } else if(info.getFront()==Neighbor.EMPTY) {
                  countMoves();
                  return Action.HOP; 
            } else {
                  countMoves();
                  return Action.RIGHT; 
            }
      } // end Action getMove
      
      
      public void countMoves() { 
      // countMoves makes sure number of moves resets so string resets back to "fee"
            if (moves==24) { 
                  moves=1; 
            } else {
                  moves++;
            }
      } //end countMoves
 } // end Giant Critter subclass