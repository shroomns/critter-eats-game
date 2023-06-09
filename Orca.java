// Joy Schwarting
// CS 145
// Orca.java

import java.awt.*;
 
 public class Orca extends Critter { // "extends" for inheritence between superclass and subclass
 
      private int moves; // moves private because each critters behavior is different!
      
      
      public Orca() { 
            moves=1; // define moves!
            getColor(); 
      } // end Orca
      
      
      public String toString() { 
      // "Or" for 6 moves, then "Ca" for 6 moves, then repeat. 
            if (moves<=6) { 
                  return "Or"; 
            } else {
                  return "Ca"; 
            }   
      } // end String toString
      
      
      public Color getColor () {
            return Color.PINK;
      } // end Color getColor
      
      
      public Action getMove(CritterInfo info) { 
      // always infect if an enemy is in front, hop if possible, otherwise turn right 
      // keep track of number of moves with countMoves() 
            if (info.getFront()==Neighbor.OTHER){ 
                  countMoves(); 
                  return Action.INFECT;
            } else if (info.getFront()==Neighbor.WALL||info.getLeft()==Neighbor.WALL) {
                  return Action.RIGHT;
            } else if (info.getFront()==Neighbor.SAME) {
                  return Action.LEFT;  
            } else if (info.getFront()==Neighbor.EMPTY) {
                  countMoves();
                  return Action.HOP; 
            } else {
                  countMoves();
                  return Action.HOP; 
            }
      } // end Action getMove
      
      
      public void countMoves() { 
            if (moves==12){ 
                  moves=1; 
            } else {
                  moves++;
            }
      } // end countMoves
 } // end Orca Critter subclass