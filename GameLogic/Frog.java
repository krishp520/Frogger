/*
 * Author: Krish Patel
 */
package GameLogic;

import java.awt.*;

// WRITE YOUR CODE HERE
public class Frog {
// WRITE YOUR CODE HERE

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return A Rectangle object defining the bounds of the frog
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x,currentPosition.y,30,30);
    }

// WRITE YOUR CODE HERE
  private String name;
  private Point currentPosition;
  // Default constructor
  public Frog(){}
  
  /**
     * Creates a new frog object given a name and starting position
     * @param name
     * @param currentPosition
     */
  public Frog(String name, Point currentPosition)
  {
    this.name = name;
    this.currentPosition = currentPosition;
  }

  /**
     * Creates a new frog object given a name and at position (0,0)
     * @param name
     */
  public Frog(String name)
  {
    this.name = name;
    this.currentPosition.setLocation(0,0);
  }

  /**
     * Returns the current position of the frog object
     * @return A Point object which is the currentPosition of the frog
     */
  public Point getCurrentPosition()
  {
    return currentPosition;
  }

  /**
     * Returns the name of the frog object
     * @return A String which is the name of the frog
     */
  public String getName()
  {
    return name;
  }

  /**
     * Translates the frog given an x and y translations, respectively
     * @param xTranslate
     * @param yTranslate
     * @return A Point object which is the currentPosition of the frog after translating it
     */
  public Point move(int xTranslate, int yTranslate)
  {
    // Translate (move) the current position by the specified amounts
    currentPosition.translate(xTranslate,yTranslate);
    return currentPosition;
  }

  /**
     * Computes the distance between the frog object and the point received as an argument
     * @param point
     * @return A double which is the distance between two points
     */
  public double distanceFromPoint(Point point)
  {
    // Calculating the distance using Distance Formula
    double xDifference = currentPosition.getX() - point.getX();
    double yDifference = currentPosition.getY() - point.getY();
    return Math.sqrt(yDifference*yDifference + xDifference*xDifference);
  }

  /**
     * Returns a string representation of the frog object
     * @return A String with the attributes of frog object
     */
  public String toString()
  {
    return "The frog named "+name+" is at ("+currentPosition.x+","+currentPosition.y+")";
  }
}
