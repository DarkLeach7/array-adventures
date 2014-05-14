import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class BinarySearchTree
{
    private TreeNode myRoot;

    public BinarySearchTree ()
    {
        myRoot = null;
    }//ends the BinarySearchTree constructor

    @SuppressWarnings("unchecked")
    public void insert ( Comparable next )
    {
        myRoot = insertHelper ( myRoot, next ); 
    }//ends the insert method

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

    public void printPreOrder ( )
    {
        printPreOrderHelper ( myRoot );
    }//ends the print

    private void printPreOrderHelper ( TreeNode parent )
    {
        if ( parent != null )
        {
            System.out.println ( parent.getValue() );
            printPreOrderHelper ( parent.getLeft() );
            printPreOrderHelper ( parent.getRight() );
        }//ends the if
    }//ends the printInOrder method

    public void printInOrder ( )
    {
        printInOrderHelper ( myRoot );
    }//ends the print

    private void printInOrderHelper ( TreeNode parent )
    {
        if ( parent != null )
        {
            printInOrderHelper ( parent.getLeft() );
            System.out.println ( parent.getValue() );
            printInOrderHelper ( parent.getRight() );
        }//ends the if
    }//ends the printInOrder method

    public void printInOrderNotRecursive()//AB31.1
    {
        printInOrderNotRecursive( myRoot );
    }//ends the printInOrderNotRecursive method 0-arg

    private void printInOrderNotRecursive( TreeNode parent )//AB31.1 Use a stack
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = myRoot;
        do
        {
            while(temp!=null)//fill stack    
            {
                stack.push(temp);
                temp = temp.getLeft();
            }//end while
            
            if(!(stack.isEmpty()))
            {
                temp = stack.pop();
                System.out.println((Item)temp.getValue());
                temp = temp.getRight();
            }//end if
        }//end do
        while((temp != null) || !(stack.isEmpty()));
    }//ends the printInOrderNotRecursive method 1-arg

    public void printPostOrder ( )
    {
        printPostOrderHelper ( myRoot );
    }//ends the print

    private void printPostOrderHelper ( TreeNode parent )
    {
        if ( parent != null )
        {
            printPostOrderHelper ( parent.getLeft() );
            printPostOrderHelper ( parent.getRight() );
            System.out.println ( parent.getValue() );
        }//ends the if
    }//ends the printInOrder method

    public int countNodes()
    {
        return countNodesHelper ( myRoot );
    }

    private int countNodesHelper( TreeNode parent )
    {
        if ( parent == null )
        {
            return 0;
        }//ends if base case
        else
        {
            return countNodesHelper( parent.getLeft()) 
            + 1
            + countNodesHelper( parent.getRight());
        }//end the else recursive
    }

    @SuppressWarnings("unchecked")
    public Object find(Comparable target)
    {
        return this.findHelper( myRoot, target );
    }

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

    public int countLeaves ( )
    {
        return countLeavesHelper( myRoot );
    }//ends the countLeaves method

    public int countLeavesHelper( TreeNode parent )
    {
        if ( parent == null )
        {
            return 0;
        }//ends the base case no tree
        else if ( ( parent.getRight() == null) && ( parent.getLeft() == null ) )
        {
            return 1;
        }//ends the base case leaf
        else
        {
            return countLeavesHelper( parent.getRight() ) + countLeavesHelper ( parent.getLeft() );
        }//ends the else
    }//ends the countLeavesHelper

    public int height()
    {
        return heightHelper( myRoot );    
    }//ends teh height method

    public int heightHelper ( TreeNode parent )
    {
        if ( parent == null )
        {
            return 0;
        }//ends the if
        else
        {
            return (max( 1 + heightHelper( parent.getLeft() ), 1 + heightHelper( parent.getRight() ) ) );
        }//ends the else
    }//ends the heightHelper method

    public int max ( int a, int b )
    {
        if ( a > b ) return a;
        else return b;

    }//ends the max method

    public int width ( )
    {
        return widthHelper( myRoot );
    }//ends the width method

    public int widthHelper( TreeNode parent )
    {
        int temp;
        if ( parent == null )
        {
            return 0;
        }
        temp = heightHelper( parent.getLeft() ) + 1 + heightHelper( parent.getRight() );
        temp = max( temp, widthHelper( parent.getLeft() ) );
        temp = max( temp, widthHelper( parent.getRight() ) );
        return temp;
    }//ends the widthHelper method

    public void clearTree()
    {
        myRoot = null;
    }

    public void mirrorTree()
    {
        mirrorTree ( myRoot );
    }//ends the mirrorTree method 0-arg

    public void mirrorTree ( TreeNode parent )
    {
        if ( parent != null )
        {
            TreeNode temp = parent.getLeft();
            parent.setLeft( parent.getRight() );
            parent.setRight( temp );

            mirrorTree ( parent.getLeft() );
            mirrorTree ( parent.getRight() );
        }//ends the if
    }//ends the mirrorTree method 1-arg

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

    public boolean isAncestor ( Comparable ancestor, Comparable desendent )
    {
        return isAncestor( myRoot, ancestor, desendent );
    }//ends the isAncestor method

    public boolean isAncestor ( TreeNode parent, Comparable ancestor, Comparable desendent )
    {
        //pass in target to find()
        if (  findHelper ( (TreeNode) findHelper ( parent , ancestor ) , desendent ) != null )
        {
            return true;
        }//ends the if 
        else 
        {
            return false; 
        }//ends the else
    }//ends the isAncestor method
}//ends the BinarySearchTree class





