//A simple node class that takes generic type T
class Node<T> {
   private T data; 
   private Node<T> next; 
   private Node<T> prev; 

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    //getters
    public T getData(){
        return data;
    }
    
    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    //setters
    public void setData(T data){
        this.data= data;
    }
    
    public void setNext(Node<T> node){
        this.next= node;
    }

    public void setPrev(Node<T> node){
        this.prev = node;
    }

}