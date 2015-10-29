package mytestpackage;

public class MyQueue
{
    int mMaxSize;

    int size;

    Object queueObjectsArray[];

    int mHead, mEnd;

    public MyQueue(int queueSize) {
        size = 0;
        mMaxSize = queueSize;
        queueObjectsArray = new Object[mMaxSize];
        mHead = 0;
        mEnd = 0;
    }

    // for test purpose
    void setHeadEnd(int head, int end)
    {
        mHead = head;
        mEnd = end;
    }

    /**
    * 
    */
    public boolean isQueueEmpty()
    {
        if (size <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
    * 
    */
    public boolean isQueueFull()
    {
        return size >= mMaxSize;

        /*
         * if(mEnd==mHead) { return false; }
         * 
         * if(mEnd>mHead) { return (mEnd-mHead+1)>=mMaxSize; }
         * 
         * 
         * if(mEnd<mHead) { return (mEnd+1)>=mHead; }
         * 
         * return false;
         */
    }
    /*
     * public void testIsQueueFull(int head, int end, boolean expectIsFull) {
     * setHeadEnd(head,end); boolean actualIsFull = isQueueFull();
     * if(actualIsFull == expectIsFull) { System.out.println("correct " +
     * " head: " + Integer.toString(head) + " end: "+ Integer.toString(end) +
     * " is full? " + expectIsFull); }else { System.out.println("Error! " +
     * " head: " + Integer.toString(head) + " end: "+ Integer.toString(end) +
     * " is full? Expect " + expectIsFull); } }
     * 
     * static public void testIsQueueFull() { Queue queue = new Queue(5);
     * queue.testIsQueueFull(0,0, false); queue.testIsQueueFull(1,3, false);
     * queue.testIsQueueFull(4,0, false); queue.testIsQueueFull(3,2, true);
     * queue.testIsQueueFull(4,0, false); queue.testIsQueueFull(3,3, false);
     * 
     * 
     * 
     * }
     */

    public int size()
    {
       return this.size;
    }
    /**
     * 
     * @return true if successful
     */
    public boolean enqueue(Object data)
    {

        if (!isQueueFull())
        {
            if (mEnd >= mMaxSize)
            {
                mEnd = mEnd - mMaxSize;
            }

            queueObjectsArray[mEnd] = data;
            mEnd++;
            this.size++;
            return true;
        }
        // queue already full
        return false;
    }

    /**
     * 
     * @return true if successful
     */
    public Object dequeue()
    {

        if (!isQueueEmpty())
        {
            Object obj = queueObjectsArray[mHead];
            mHead++;
            this.size--;

            return obj;
        }

        return null;
    }

    void printAll()
    {
        for(int i=0;i<this.size;i++)
        {
            int index = mHead+i;
            if(index >=mMaxSize)
            {
                index=index -mMaxSize;
            }    
            System.out.print(this.queueObjectsArray[index ].toString());
        }
        System.out.println();
    }
    
    static public void testQueue() 
    {
       MyQueue q = new MyQueue(5);
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");
        if( q.enqueue("F") )
        {
            System.out.print("Error, should return false");
        };
        q.printAll();
        
        System.out.println("");

        
        System.out.println("Dequeue A");
        q.dequeue();
        q.printAll();
        
        System.out.println("enequeue F");

        q.enqueue("F");
        q.printAll();

        q.dequeue();
        q.dequeue();
        
        q.printAll();
        q.enqueue("G");
        q.enqueue("H");
        q.printAll();
        if( q.enqueue("I") )
        {
            System.out.print("Error, should return false");
        };
    }    
     
        
}
