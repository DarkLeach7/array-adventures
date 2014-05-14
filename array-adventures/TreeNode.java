public class TreeNode
{
  private Object value;
  private TreeNode left;
  private TreeNode right;

  public TreeNode(Object initValue, 
                  TreeNode initLeft,
                  TreeNode initRight) 
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }
  public Object getValue()
  {
    return value;
  }

  public TreeNode getLeft()
  {
    return left;
  }

  public TreeNode getRight()
  {
    return right;
  }

  public void setValue(Object value) 
  {
    this.value = value;
  }

  public void setLeft(TreeNode leftNode) 
  {
    this.left = leftNode;
  }

  public void setRight(TreeNode rightNode) 
  {
    this.right = rightNode;
  }
  
  public String toString()
  {
    return "\nTree Node value: " + this.getValue();    
  }
}



