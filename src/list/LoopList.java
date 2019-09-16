package list;

public class LoopList<T> {
    class Node<T>{
        private Node<T> next;
        private T data;
    }
    Node<T> header ;
    public LoopList(){
        header = new Node<T>();
        header.data = null;
        header.next = header;
    }
    public void add(T t){
        if(header.next == header){
            Node<T> node = new Node<T>();
            node.data = t;
            header.next = node;
            node.next = header;
        }
    }
}
