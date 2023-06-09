// Joy Schwarting
// CS 145
// Lion.java
 
import java.awt.*; 
import java.util.*; 
 
 public class Lion extends Critter { // "extends" for inheritence between superclass and subclass
 
      private int colorMoves; // private because every critter moves differently
       
      Color lionColor;
       
      Random rand = new Random(); // Random class

      public String toString() {
            return "L"; 
      } // end String toString
            
      public Lion() {
            // define colorMoves, color assignment is 0 = red, 1 = green, 2 = blue 
            colorMoves=0;
            getColor(); 
      } // end Lion
      
      public Color getColor() { 
      // Picks random color (red, green or blue) for 3 moves then randomly assigns new color
            if (colorMoves%3==0) {
            // if number of moves divided by 3 is 0, then new random color assignment
               int x=0; // assign integer to 0
               while (x==0) { 
                  int i=rand.nextInt(3); // 0 = red, 1 = green and 2 = black 
                  
                  if (i==0 && this.lionColor!=Color.RED) { 
                     this.lionColor= Color.RED;
                     x++; 
                  } if (i==1 && lionColor!=Color.GREEN) {
                     this.lionColor=Color.GREEN;
                     x++;
                  } if (i==2 && lionColor!=Color.BLUE) { 
                     this.lionColor=Color.BLUE; 
                     x++; 
                  }
               }
            } 
            return lionColor;
      } // end Color getColor
      
      public Action getMove(CritterInfo info) { 
      // always infect if an enemy is in front, if a wall is in front or to the right, then turn left, 
      // if a Lion is in front, then turn right, otherwise hop. 
            colorMoves++; 
            if (info.getFront()==Neighbor.OTHER) {
                  return Action.INFECT; 
            } else if (info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL) {
                  return Action.LEFT; 
            } else if (info.getFront()==Neighbor.SAME) {
                  return Action.RIGHT;
            } else { return Action.HOP; 
            } 
      } // end Action getMove
  } // end Lion Critter subclass