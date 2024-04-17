import java.util.Iterator;

class SortedLinkedList<T extends PlanarShape> extends LinkedList<T> {

public SortedLinkedList(){  //constructor same as LinkedList
    head=null;
    tail=null;
    count=0;
    prepend(null);
}

public Node<T> insertInOrder(T data) {
    if (data == null) throw new NullPointerException("Cannot insert null data.");

    Node<T> newNode = new Node<>(data);
    if (count <=1) {   
        // if empty, we jsut need to append 
        System.out.println("empty" );
        return append(data);
    } else {
        Node<T> current = head;
        if (current.getData()==null)
            current=current.getNext();

        do {
            if (data.compareTo(current.getData()) >0) { 
                System.out.println("PosFound" );
                Node<T> prevNode = current.getPrev();
                newNode.setNext(current);
                newNode.setPrev(prevNode);
                prevNode.setNext(newNode);
                current.setPrev(newNode);

                count++;
                modCount++;
                return newNode;
            }
            else
            {current = current.getNext();}
            
        } while (current != head);

        // Append at the end if no suitable position was found
        System.out.println("No Pos" );
        newNode.setNext(head);
        newNode.setPrev(tail);
        tail.setNext(newNode);
        head.setPrev(newNode);
        tail = newNode;  // Update tail
        count++;
        modCount++;
        return newNode;
    }
}
}