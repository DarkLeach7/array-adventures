public class ListNode
{
    //variables
    private Object value;
    private ListNode next;
    
    public ListNode(Object v, ListNode n)   
    {
        value = v;
        next = n;
    }
    //getters
    public Object getValue()
    {
        return value;
    }//end getValue
    public ListNode getNext()
    {
        return next;
    }//end getNext
    //setters
    public void setValue(Object v)
    {
        value = v;
    }//ends setValue
    public void setNext(ListNode n)
    {
        next = n;
    }//ends setNext
}//ends class ListNode