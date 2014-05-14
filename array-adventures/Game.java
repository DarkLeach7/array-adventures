import java.util.*;
/**
 * Contains most of the game logic as well as the running methods etc.
 * 
 * @author Kyle Leach (DarkLeach7) 
 * @version 1a
 */
public class Game{
    char[][] map;
    Stack <Enemy> enemyStack;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        map = new char[20][20];
        enemyStack = new Stack <Enemy>();
    }//ends constructor 0 args

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void generateStack(){
        for(int i=0; i <= 20; i++){
            enemyStack.push(new TestEnemy(0));
        }//end for loop
    }
}
