import java.util.*;
import java.io.*;
/**@author Michael Lance(Unsaving)
 *@date: 5/14/14
 *@version - N/A
 */
public class BinarySearchTree
{
    private TreeNode myRoot;
    /**@author Michael Lance(Unsaving)
     *@param- none
     *@return none
     */
    public BinarySearchTree ()
    {
        myRoot = null;
    }//ends the BinarySearchTree constructor

    @SuppressWarnings("unchecked")
    public void insert ( Comparable next )
    {
        myRoot = insertHelper ( myRoot, next ); 
    }//ends the insert method

    /**
    * This method is the Helper for the insert method.
    * @param: parentNode, next
    * @return: parentNode
    */
    @SuppressWarnings("unchecked")
    private TreeNode insertHelper ( TreeNode parentNode, Comparable next )
    {
        if ( parentNode == null ) //(adds root)
        {
            parentNode = new TreeNode( next, null, null );
        }//ends the if 
        else if ( next.compareTo( parentNode.getValue() ) < 0 )//adds left -
        {
            parentNode.setLeft(insertHelper(parentNode.getLeft(), next ) );            
        }//ends the else if
        else //adds right 0 +
        {
            parentNode.setRight(insertHelper(parentNode.getRight(), next ) );           
        }//ends the else if
        return parentNode;
    }//ends the insertHelper method
    /**
     * This method prints the Binary Tree Pre Order
     * @param: none
     * @return: none
     */
    public void printPreOrder ( )
    {
        printPreOrderHelper ( myRoot );
    }//ends the print
    /**
     * This method is the Helper for printPreOrder() method.
     * @param: parent
     * @return: none
     */
    private void printPreOrderHelper ( TreeNode parent )
    {
        if ( parent != null )
        {
            System.out.println ( parent.getValue() );
            printPreOrderHelper ( parent.getLeft() );
            printPreOrderHelper ( parent.getRight() );
        }//ends the if
    }//ends the printInOrder method
    /**
    * This method will find a target.
    * @param: target
    * @return: none
    */
    public Object find(Comparable target)
    {
        return this.findHelper( myRoot, target );
    }
    /**
    * This method is the Helper for the find method.
    * @param: parent, target
    * @return: none.
    */
    @SuppressWarnings("unchecked")
    private Object findHelper(TreeNode parent, Comparable target)
    {
        int compareResult; 
        if ( parent == null )
        {
            return null;
        }//ends if
        compareResult = target.compareTo( parent.getValue() );

        if ( compareResult == 0 )
        {
            return parent.getValue();
        }//ends the if base case
        else if( compareResult < 0 )//left
        {
            return findHelper( parent.getLeft(), target);
        }//ends the elseif
        else //Right
        {
            return findHelper( parent.getRight(), target);
        }//ends the else

    }
    /**
    * This method is the delete.
    * @param: target
    * @return: none
    */
    @SuppressWarnings("unchecked")
    public void delete(Comparable target)
    {
        try
        {

            myRoot = deleteHelper( myRoot, target );
        }
        catch ( NoSuchElementException e )
        {
            System.out.println( "Error: That element is not in the array" );
        }
    }
    /**
    * This method is the Helper for the delete method.
    * @param: parentNode, next
    * @return: parent
    */
    @SuppressWarnings("unchecked")
    private TreeNode deleteHelper(TreeNode parent, Comparable target)
    {
        if ( parent == null )
        {
            System.out.println( "Not Found" );  //add a try catch to handle this throw
            throw new NoSuchElementException();
        }//ends if
        else if ( target.equals( parent.getValue() ) )
        {
            System.out.println( "Is equal and should be deleted: " + target.equals(parent.getValue() ) );
            return this.deleteTargetNode( parent ); //found it so delete it
        }
        else if ( target.compareTo( parent.getValue()) < 0 ) //left
        {
            System.out.println( "Target is less than parent go left: " + (target.compareTo( parent.getValue()) < 0) );

            parent.setLeft(this.deleteHelper( parent.getLeft(), target ) );
            return parent;
        }
        else //Right
        {
            System.out.println( "Target is Greater than parent go Right: " + (target.compareTo( parent.getValue()) > 0 ) );
            parent.setRight( this.deleteHelper ( parent.getRight(), target ) );
            return parent;
        }

    }
    /**
    * This method is the deleteTargetNode 
    * @param: target
    * @return: target
    */
    private TreeNode deleteTargetNode ( TreeNode target )
    {
        if ( target.getRight() == null )
        {
            System.out.println( "Deletes Root" ); 
            return target.getLeft();
        }//ends the if
        else if ( target.getLeft() == null )
        {
            System.out.println( "Make Right the new root" );
            return target.getRight();
        }//ends the elseif
        else if ( target.getRight().getLeft() == null )
        {
            target.setValue( target.getRight().getValue() );
            target.setRight( target.getRight().getRight() );
            return target;
        }//ends the else if
        else 
        {
            System.out.println( "" );
            TreeNode marker = target.getRight();
            while ( marker.getLeft().getLeft() != null )
            {
                marker = marker.getLeft();
            }//ends the while
            target.setValue( marker.getLeft().getValue() );
            marker.setLeft( marker.getLeft().getRight() );
            return target;
        }//ends the else
    }//ends the deleteTargetNode method
    /**
    * This method is the max value method.
    * @param: a, b
    * @return: b
    */
    public int max ( int a, int b )
    {
        if ( a > b ) return a;
        else return b;

    }//ends the max method

    public void clearTree()
    {
        myRoot = null;
    }

    public void printLevel ( int level )
    {
        printLevel( myRoot, level );    
    }//ends teh printLevel method

    public void printLevel ( TreeNode parent, int level )
    {
        if ( (parent != null ) && ( level >= 0 ) )
        {
            if ( level == 0 )
            {
                System.out.print ( parent.getValue() + " " );
            }//ends the if
            else
            {
                printLevel( parent.getLeft(), level - 1 );
                printLevel( parent.getRight(), level - 1 );
            }
        }//ends the if
    }//ends the printLevel method

    public void printByLevelQ( )
    {
        printByLevelQ( myRoot );
    }//ends the printByLevelQ method

    public void printByLevelQ( TreeNode parent ) //31.2 NonRecursive use a LinkedList<TreeNode>
    {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode temp = parent;
        if(parent != null)
        {
            q.add(parent);
            while(q.size()>0)
            {
                temp = (TreeNode)q.remove();
                System.out.println(temp.getValue());
                if(temp.getLeft()!=null)
                {
                    q.add(temp.getLeft());
                }//end if left
                if(temp.getRight()!=null)
                {
                    q.add(temp.getRight());
                }//end if right
            }//end while
        }//end if
    }//ends the printByLevelQ method 
}//ends the BinarySearchTree class

