import java.util.*;
/**
 * Basic Interface for all enemies in the game
 * 
 * @author Kyle Leach (DarkLeach7)
 * @version 1a
 */
public interface Enemy{
    /**
     * Used for when the player needs to attack an enemy
     * @param playerAttack
     * @param playerLuck
     * @return nothing
     */
    public void attack();
    /**
     * Used for when the player needs to defend an attack from an enemy
     * @param playerDefense
     * @param playerLuck
     * @return amount of health player will lose
     */
    public int defend();
    /**
     * Used for when the player needs to run away from an enemy
     * @param playerSpeed the players speed stat
     * @param playerLuck the players luck stat
     * @return result of run algorithm
     */
    public boolean run();
}//end enemy interface
