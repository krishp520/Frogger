/*
 * Author: Krish Patel
 */
package GameLogic;

import java.awt.*;

// WRITE YOUR CODE HERE
public class Car {
// WRITE YOUR CODE HERE

  /**
   * Returns the bounds of the car object which can be used to detect collision
   * @return A Rectangle object defining the bounds of the car
   */
  public Rectangle getCollisionBounds(){
    return new Rectangle(currentPosition.x, currentPosition.y,xSize,ySize);
  }

  private Point currentPosition;
  private Color bodyColour;
  private int movementSpeed;
  private int xSize;
  private int ySize;
  private boolean moveLeft;
  // Default constructor
  public Car(){}

  /**
     * Creates a new car given a start position, colour,
     * movement speed, sizes in x and y, and set if it should move from right to left or left to
     * right
     * @param currentPosition
     * @param bodyColour
     * @param movementSpeed
     * @param xSize
     * @param ySize
     * @param moveLeft
     */
  public Car(Point currentPosition, Color bodyColour, int movementSpeed, int xSize, int ySize, boolean moveLeft)
  {
    this.currentPosition = currentPosition;
    this.bodyColour = bodyColour;
    this.movementSpeed = movementSpeed;
    this.xSize = xSize;
    this.ySize = ySize;
    this.moveLeft = moveLeft;
  }

  /**
     * Returns the current position of the car
     * @return A Point object defining the currentPosition of the car
     */
  public Point getCurrentPosition() {
    return currentPosition;
  }

  /**
     * Returns the body colour of the car
     * @return A Color object defining the bodyColour of the car
     */
  public Color getBodyColour() {
    return bodyColour;
  }

  /**
     * Returns the movement speed of the car
     * @return An int value for the movementSpeed of the car
     */
  public int getMovementSpeed() {
    return movementSpeed;
  }

  /**
     * Returns the width of the car on the X Axis
     * @return An int value for xSize of the car
     */
  public int getXSize() {
    return xSize;
  }
  
  /**
     * Returns the height of the car on the Y Axis
     * @return An int value for ySize of the car
     */
  public int getYSize() {
    return ySize;
  }

  /**
     * Return true/false if the car car is moving left or not
     * @return A boolean moveLeft value of the car
     */
  public boolean isMoveLeft() {
    return moveLeft;
  }

  /**
     * Moves the car in the X direction using movementSpeed as the step/value. 
     * It takes into account the moveLeft variable to define if it should move from left to right or
     * right to left
     */
  public void move()
  {
    // Checking if the object moves left or not. If moving left, decrementing X-coordinate, or else incrementing X-coordinate
    if(moveLeft)
    {
      currentPosition.x -= movementSpeed;
    }
    else
    {
      currentPosition.x += movementSpeed;
    }
  }
}
