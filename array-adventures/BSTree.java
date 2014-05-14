/**
 * This class is to run a main menu for a binary tree.
 * @Author Roger Mayo
 * @Version AB30.1 Binaray Search Tree
 * @Period 8
 * @Feedback yes
 */

import java.util.Scanner;
import java.io.*;

public class BSTree
{
    //variables
    Scanner in;
    
    //constructor(s)
    public BSTree ( )
    {
        in = new Scanner(System.in);
    }//ends the constructor
    
    //methods
    @SuppressWarnings("unchecked")
    public void loadData( BinarySearchTree temp )
    {
        Scanner inFile;
        String fileName = new String ( "fileA.txt" );
        //int id, inv;
        String strValue;
        try
        {
            inFile = new Scanner ( new File ( fileName ) );
            while ( inFile.hasNext() )
            {
                strValue = new String (inFile.nextLine());
                //id = inFile.nextInt();
                //inv = inFile.nextInt();
                //temp.insert( new Item ( id, inv ) );
                temp.insert( strValue );
            }//ends the while loop
        }//ends the try
        catch ( IOException e )
        {
            System.out.println( "Error: " + e.getMessage() );
        }//ends the catch
    }//ends the loadData method
    
    public void menu ( BinarySearchTree parent )
    {
        int choice = 0;
        do
        {
            System.out.println("Binary Tree Menu\n");
            System.out.println("1. Read data from disk");
            System.out.println("2. Preorder output");
            System.out.println("3. Print the tree in inorder");
            System.out.println("4. Postorder output");
            System.out.println("5. Count the nodes in the tree");
            System.out.println("6. Count the leaves of the tree");
            System.out.println("7. Find the height of the tree");
            System.out.println("8. Find the width of the tree");
            System.out.println("9. Clear the tree");
            System.out.println("10 Interchange the tree(mirror image)");
            System.out.println("11 Print level");
            System.out.println("12 isAncestor");
            System.out.println("13 Quit\n");
            
            choice = in.nextInt();
            
            switch ( choice )
            {
                case 1:
                    loadData( parent );
                    break;
                case 2: //Preorder output
                    parent.printPreOrder();
                    break;
                case 3:
                    //parent.printInOrder(); AB30.1
                    parent.printInOrderNotRecursive();//AB31.1
                    break;
                case 4: //Postorder output
                    parent.printPostOrder();
                    break;   
                case 5:
                    System.out.println("There are " 
                         + parent.countNodes() 
                         + " nodes in this tree." );
                    break;
                case 6: // count leaves of the tree.
                    System.out.println("There are " 
                         + parent.countLeaves() 
                         + " leaves in this tree." );
                    break;
                case 7: //Height
                    System.out.println("The height of the tree is" 
                         + parent.height() + "." );
                    break;
                case 8: //Width
                    System.out.println("The width of the tree is" 
                         + parent.width() + "." );
                    break;
                case 9: //Clear
                    parent.clearTree();
                    System.out.println("The tree has been deleted: ");
                    parent.printInOrder() ;
                    break;
                case 10: //Mirror
                    parent.mirrorTree();
                    System.out.println("The tree is a mirror image");
                    parent.printInOrder();
                    break;
                case 11: //print level
                    //Scanner inLevel = new Scanner ( System.in );
                    //System.out.print ( "Enter the level you would like to print: " );
                    //int level = in.nextInt();
                    //parent.printLevel( level );
                    parent.printByLevelQ();
                    break;
                case 12: //isAncestor
                    break;
                    
//                     //Finding one node                     
//                     Scanner inFind = new Scanner( System.in );
//                     int id = 0;
//                     System.out.println("Enter the ID you are looking for: " );
//                     id = inFind.nextInt();
//                     System.out.println( parent.find( new Item( id, 0 ) ) );
//                     break;

//                     //Deleting a specific node
//                     Scanner inDelete = new Scanner( System.in );
//                     int idToDelete;
//                     System.out.println("Enter the id to delete: " );
//                     idToDelete = inDelete.nextInt();
//                     Item dItem = new Item( idToDelete, 0 );
//                     if ( parent.find ( dItem ) == null )
//                     {
//                         System.out.println( "No such part." );
//                     }
//                     else
//                     {
//                         parent.delete( dItem );
//                         System.out.println( "The Item was deleted." );
//                     }
            }//ends the switch
            
        }while( choice != 13 );
        
    }//ends the menu method
    
    
}//ends the BSTree class