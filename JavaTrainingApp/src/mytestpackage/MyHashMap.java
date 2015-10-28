package mytestpackage;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMap
{
    class DataNode
    {
        String key;
        Object value;
        DataNode next;
    }

    DataNode[] hashMapDataNodes;
    int mCapacity;

    MyHashMap(int capacity)
    {
        mCapacity = capacity;
        hashMapDataNodes = new DataNode[capacity];
    }

    public void put(String key, Object value)
    {
        int index = key.hashCode() % mCapacity;

        DataNode currentNode = hashMapDataNodes[index];
        if (currentNode == null)
        {
            currentNode = new DataNode();
            currentNode.key = key;
            currentNode.value = value;
            hashMapDataNodes[index] = currentNode;
        } else
        { // already have a node!!

            // if key is same, replace it.
            DataNode replaceNode = findNodeMatchKey(currentNode, key);

            if (replaceNode == null)
            {
                DataNode last = findLastDataNode(currentNode);
                DataNode newNode = new DataNode();
                newNode.key = key;
                newNode.value = value;
                last.next = newNode;
                // nothing to replace, just add a new node as last node

            } else
            {
                // replace the node value (but the key is already the same)
                replaceNode.value = value;
            }

            // if key is different, use linklist node

        }

    }

    DataNode findLastDataNode(DataNode fromNode)
    {

        if (fromNode == null) return fromNode;

        DataNode node = fromNode;

        while (node.next != null)
        {
            node = node.next;
        }
        // now this node's next is null, so this node is the last node
        return node;
    }

    DataNode findNodeMatchKey(DataNode fromNode, String findKey)
    {
        DataNode node = null;
        if (fromNode == null) return null;
        node = fromNode;
        do
        {
            if (node.key.equals(findKey))
            {
                return node;
            } else
            {
                node = node.next;
            }

        } while (node != null);
        return node;
    }

    public Object get(String key)
    {
        int index = key.hashCode() % mCapacity;

        DataNode node = hashMapDataNodes[index];

        node = findNodeMatchKey(node, key);

        return node.value;
    }

    static public void test()
    {
        MyHashMap hmap = new MyHashMap(2);
        hmap.put("a", "AAA");
        assertEquals("AAA", hmap.get("a"));

        hmap.put("b", "BBB");
        assertEquals("BBB", hmap.get("b"));

        //AAA is not replaced by BBB
        assertEquals("AAA", hmap.get("a"));

        hmap.put("c", "CCC");
        assertEquals("CCC", hmap.get("c"));

        hmap.put("d", "DDD");
        assertEquals("DDD", hmap.get("d"));

        assertEquals("AAA", hmap.get("a"));
        
        hmap.put("a", "AA2");
        assertEquals("AA2", hmap.get("a"));
        
        assertEquals("DDD", hmap.get("d"));
        
        assertEquals("AA2", hmap.get("a"));
        assertEquals("BBB", hmap.get("b"));
        assertEquals("CCC", hmap.get("c"));
        assertEquals("DDD", hmap.get("d"));
        
    }
}
