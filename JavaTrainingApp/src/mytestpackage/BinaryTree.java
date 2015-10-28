package mytestpackage;

public class BinaryTree
{
    BinTreeNode root;

    void accessData(String data)
    {
        System.out.print(data+" ");

    }

    public void addLeftChild(BinTreeNode parentNode, BinTreeNode newChildNode)
    {
        parentNode.leftChild = newChildNode;
    }

    public void addRightChild(BinTreeNode parentNode, BinTreeNode newChildNode)
    {
        parentNode.rightChild = newChildNode;
    }

    public void addRoot(BinTreeNode newRootNode)
    {
        this.root = newRootNode;
    }

    public void traverseDeepFirst(BinTreeNode node)
    {
        if (node == null)
        {
            return;
        }
        accessData(node.mData);

        // access current node data

        if (node.leftChild != null)
        {
            traverseDeepFirst(node.leftChild);
        }

        if (node.rightChild != null)
        {
            traverseDeepFirst(node.rightChild);
        }

    };

    public void traverseBreadthFirst(BinTreeNode node)
    {
        if (node == null)
        {
            return;
        }

        MyQueue queue = new MyQueue(20);

        queue.enqueue(node);

        while (!queue.isQueueEmpty())
        {
            BinTreeNode tempNode = (BinTreeNode) queue.dequeue();

            this.accessData(tempNode.mData);

            if (tempNode.leftChild != null)
            {
                queue.enqueue(tempNode.leftChild);
            }

            if (tempNode.rightChild != null)
            {
                queue.enqueue(tempNode.rightChild);
            }

        }

    };

    public void makeDefaultBinTree()
    {
       BinTreeNode root = new BinTreeNode("Root"); 
       this.addRoot(root);
       
       BinTreeNode left1 = new BinTreeNode("L1");
       BinTreeNode right1 = new BinTreeNode("R1");
       
       this.addLeftChild(root, left1 );
       this.addRightChild(root, right1);
       
       this.addLeftChild(left1, new BinTreeNode("L1L2"));
       this.addRightChild(left1, new BinTreeNode("L1R2"));
       
       this.addLeftChild(right1, new BinTreeNode("R1L2"));
       this.addRightChild(right1, new BinTreeNode("R1R2"));
       
    }

}

class BinTreeNode
{
    String mData;

    BinTreeNode leftChild;

    BinTreeNode rightChild;
    
    BinTreeNode(String data)
    {
        mData = data;
    }
    
};
