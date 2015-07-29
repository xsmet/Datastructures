package datastructures;

class Node
{
	public Node leftChild;
	public Node rightChild;
	public int value;
	public Node(int value, Node left, Node right)
	{
		this.value = value;
		this.leftChild = left;
		this.rightChild = right;
	}
}

class BinaryTree
{
	public Node root;
	
	// Returns 'True' when 'value' is found in this Tree, false otherwise.
	public boolean Contains(int value)
	{
            if (this.root == null) return false;

            Node currentNode = this.root;
            while (currentNode.value != value)
            {
                if (value > currentNode.value)
                {
                    currentNode = currentNode.rightChild;
                }
                else
                {
                    currentNode = currentNode.leftChild;
                }
                if (currentNode == null)
                {
                    break;
                }
            }
            return currentNode != null;
	}

	// Guarantees that 'value' shall be kept in the Tree
	public void Insert(int value)
	{
            if (this.root == null)
            {
                this.root = new Node(value, null, null);
            }
            else
            {
                Node currentNode = this.root;
                while (currentNode != null)
                {
                    if (value > currentNode.value)
                    {
                        if (currentNode.rightChild == null) {
                            currentNode.rightChild = new Node(value, null, null);
                            break;
                        }
                        else
                            currentNode = currentNode.rightChild;
                    }
                    else if (value < currentNode.value)
                    {
                        if (currentNode.leftChild == null) {
                            currentNode.leftChild = new Node(value, null, null);
                            break;
                        }
                        else
                            currentNode = currentNode.leftChild;
                    }
                    else //if (value == currentNode.value)
                    {
                            break; // Already exists
                    }
                }
            }
	}
}


/**
 *
 * @author xaviersmet
 */
public class Datastructures {

    /**
     * @param args the command line arguments
     */
    static void Test(boolean value, boolean shouldBe)
    {
        if (value == shouldBe) { System.out.println("Ok"); }
        else { System.out.println("Oops"); }
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        BinaryTree boom = new BinaryTree();
        boom.Insert(5);
        boom.Insert(3);
        boom.Insert(7);
        Test(boom.Contains(6), false);
        Test(boom.Contains(3), true);
    }
    
}