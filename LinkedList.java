//A circular doubly-linked list that contains polygons inside nodes.
//has head, tail, current and count. 
//contains methods to add nodes to the list in various locations, as well as remove nodes and sort the list. Has a method for returning the list as a string for printing.
//Completed 17/03/24 Matthew Sefton
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException; 

class LinkedList<T> implements Iterable<T> {

    protected  Node<T> head, tail;
    protected int count;
    protected int modCount = 0;

    //constructor
    public LinkedList()
    {
        head=null;
        tail=null;
        count=0;

        //create a sentinel node with nothing in it
        prepend(null);
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    //prepend: insert items to the head of the list (current item will be the new first in list). Takes a polygon as parameter and returns a node.
    public Node<T> prepend(T data)
    {
        Node<T> newNode = new Node<>(data);
        //if list is empty, head and tail will point to new node
        if (count == 0){
            head = tail = newNode;
            newNode.setPrev(newNode);
            newNode.setNext(newNode);
        }
        else  {       //otherwise add new node to head of the list. Update accordingly.  
            newNode.setNext(head);
            newNode.setPrev(tail);
            head.setPrev(newNode);
            tail.setNext(newNode);
            head = newNode;
        }

        count++;
        modCount++;
        return newNode;
    }

    //append: insert items into the tail of the list
    public Node<T> append(T data)
    {
        Node<T> newNode = new Node<>(data);
        //if list is empty, head and tail will point to new node
        if (count == 0){
            head = tail = newNode;
            newNode.setPrev(newNode);
            newNode.setNext(newNode);
        }
        else  {       //otherwise add new node to tail of the list. Update accordingly.  
            newNode.setNext(head);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            head.setPrev(newNode);
            tail = newNode;
        }

        count++;
        modCount++;
        return newNode;
    }

    //insert: updated to direct to append
    public Node<T> insert(T data){
    return append(data);
    }

    // next: This method is now invalid.
    public Node<T> next() {
        throw new UnsupportedOperationException("Operation is unsuported.");
    }

    // reset: This method is now invalid
    public Node<T> reset() {
        throw new UnsupportedOperationException("Operation is unsuported.");
    }

    //remove: remove an item from the head of the list.
    public Node<T> remove()
    {
        //If there are no nodes to remove (or only sentinel)
        if (head == null || head.getNext() == head) {
            return null; 
        }
        
        Node<T> nodeToRemove = head;

        head.getNext().setPrev(head.getPrev());     //set head's next's previous to head's previous (confusing I know)
        head.getPrev().setNext(head.getNext());      //set head's previous' next to head's next
        head = head.getPrev();
        
        count--;
        modCount++;
        return nodeToRemove;
    }

    //returns all polygons in the list as a string, current remains the same at the end (we circle around the list)
    public String returnListAsString()
    {
        String listString = "";
        Iterator<T> it= iterator();

        while (it.hasNext()){
                listString += it.next().toString(); 
                listString += "\n";
            }
    
        return listString;
    }
/* 
    //Sorts the list from smallest  to largest
    public void sortList()
    {
        //Create an array which is then populated with all the nodes in our list
        Node[] nodeArray = new Node[count];
        for (int i=0; i <count; i++) {
        nodeArray[i]=current;
        next();
        }

        //sort the array using a simple bubble sort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (nodeArray[j].getData()!=null)
                if (!nodeArray[j].getData().ComesBefore(nodeArray[j + 1].getData())) {
                    //swap the nodes
                    Node temp = nodeArray[j];
                    nodeArray[j] = nodeArray[j + 1];
                    nodeArray[j + 1] = temp;
                }
            }
        }

        //Remove all the nodes in our list
        for (int i=0; i <nodeArray.length; i++)
        remove();

        //append with array
        for (int i=0; i<nodeArray.length; i++)
            prepend(nodeArray[i].getData());
    }
    */

    private class LinkedListIterator implements Iterator<T>
    {
        private Node<T> current;
        private int expectedMod;
        
        public LinkedListIterator()
        {
            this.current = head;
            this.expectedMod = modCount;
        }

        @Override
        public boolean hasNext(){
            // Continues until it loops back to the head
            return current.getNext()!= head && current.getNext()!= null;
        }
       
        @Override
        public T next(){
            if (modCount != expectedMod)
            {
                throw new ConcurrentModificationException("Error: modified during operation");
            }
            if (!hasNext()){
                throw new NoSuchElementException("Error: no more elements");
            }

            current = current.getNext();
            T data = current.getData();
            return data;
        }
    }
}