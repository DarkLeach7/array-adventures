/**
 * An enemy to test the game battle sequence
 * 
 * @author Kyle Leach (DarkLeach7)
 * @version 1a
 */
public class TestEnemy implements Enemy{
    private int health;
    private int attack;
    private int defence;
    private int speed;
    private int luck;

    /**
     * Constructor for objects of class TestEnemy
     */
    public TestEnemy(int levelModifier){
       
    }

    /**
     * Used for when the player needs to attack an enemy
     * @param playerAttack
     * @param playerLuck
     * @return nothing
     */
    public void attack(){
    }

    /**
     * Used for when the player needs to defend an attack from an enemy
     * @param playerDefense
     * @param playerLuck
     * @return amount of health player will lose
     */
    public int defend(){
        return 0;
    }//end method defend

    /**
     * Used for when the player needs to run away from an enemy
     * @param playerSpeed the players speed stat
     * @param playerLuck the players luck stat
     * @return result of run algorithm
     */
    public boolean run(){
        return true;
    }//end method run
}//end TestEnemy Class
