/*
 * Author: Krish Patel
 */
package GameLogic;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

// WRITE YOUR CODE HERE
public class Game {
// WRITE YOUR CODE 
  private Frog player;
  private ArrayList<Car> cars;

  public Game(){}

  /**
     * Creates a new Frogger game, instantiates a new player given its name and starting position. 
     * It adds four cars to the ArrayList
     * @param name
     * @param position
     */
  public Game(String name, Point position)
  {
    // Creating Frog object and an ArrayList
    player  = new Frog(name, position);
    cars = new ArrayList<>();
    // Adding cars to the ArrayList
    cars.add(new Car(new Point(100,400),Color.black,10,120,75,false));
    cars.add(new Car(new Point(0,300),Color.blue,30,200,75,false));
    cars.add(new Car(new Point(100,150),Color.black,10,120,75,true));
    cars.add(new Car(new Point(0,80),Color.black,20,120,75,true));
  }

  /**
     * Returns the player object of the Frog class
     * @return A player object of the Frog class
     */
  public Frog getPlayer()
  {
    return player;
  }

  /** 
     * Returns the ArrayList car 
     * @return An ArrayList cars 
     */
  public ArrayList<Car> getCars()
  {
    return cars;
  }

  /**
     * Responds to keyboard events by moving the player int in the x or y direction.
     * The first int represents keys from the keyboard
     * The second int represents the step (in pixels) of how much the player is going to move at each keypress
     * @param keyCode
     * @param step
     */
  public void movePlayer(int keyCode, int step)
  {
    // Use a switch statement to handle different keyCodes representing arrow key presses
    switch(keyCode)
    {
      // If the UP arrow key is pressed, move the player up by 'step' units
      case KeyEvent.VK_UP:
        player.move(0,-step);
        break;
      // If the DOWN arrow key is pressed, move the player down by 'step' units
      case KeyEvent.VK_DOWN:
        player.move(0,step);
        break;
      // If the LEFT arrow key is pressed, move the player up left 'step' units
      case KeyEvent.VK_LEFT:
        player.move(-step,0);
        break;
      // If the RIGHT arrow key is pressed, move the player right by 'step' units
      case KeyEvent.VK_RIGHT:
        player.move(step,0);
        break;
    }
  }

  /**
     * Moves every car in the game by calling their move method. 
     * The method receives an int representing the edge of the game area.
     * @param edge
     */
  public void moveCars(int edge)
  {
    for(Car car : cars)
    {
      car.move();
      // Check if the car is moving left
      if(car.isMoveLeft())
      {
        // If the car reaches 0, moving it back to right edge
        if(car.getCurrentPosition().x < 0)
        {
          car.getCurrentPosition().setLocation(edge, car.getCurrentPosition().y);
        }
      }
      else
      {
        // If the car reaches edge, moving it back to 0
        if(car.getCurrentPosition().x > edge)
        {
          car.getCurrentPosition().setLocation(0, car.getCurrentPosition().y);
        }
      }
    }
  }

  /**
     * Returns true if the player was hit by a car
     * @return A boolean checking whether player was hit by a car
     */
  public boolean isPlayerHit()
  {
    for(Car car : cars)
    {
      // Check if collision bounds of player(Frog) intersects the collision bounds of car
      if(player.getCollisionBounds().intersects(car.getCollisionBounds()))
      {
        return true;
      }
    }
    return false;
  }

  /**
     * Returns true if the player won the game. 
     * The player wins the game if the y coordinate of the player is less than 20, included.
     * @return A boolean checking whether player's position is less than 20
     */
  public boolean hasPlayerWon()
  {
    return player.getCurrentPosition().getY()<=20;
  }
}
