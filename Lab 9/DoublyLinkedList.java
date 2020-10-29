public class DoublyLinkedList <T>{
    public Node<T> first;

    static class Node <T>{
        public Node<T> next;
        public Node<T> prev;
        public Object data;

        public Node(Object data){
            this.data = (T) data;
            this.next = null;
            this.prev = null;
        }
    }

    public static DoublyLinkedList append (DoublyLinkedList list, Object data){
        Node<?> newNode = new Node(data);
        
        if(list.first == null){
            list.first = newNode;
        }
        else{
            Node last = list.first;
            while(last.next != null){
                last = last.next;
            }

            last.next = newNode;
            newNode.prev = last;
        }

        return list;
    }

    public static DoublyLinkedList delete (DoublyLinkedList list, int pos){
        
        if (list.first == null){
            throw new IllegalArgumentException("Cannot delete nodes from an empty list.");
        }

        if(pos == 1){
            if(list.first.next == null){
                list.first = null;
            }

            else{
                list.first = list.first.next;
                list.first.prev = null;
            }

            return list;
        }

        int ctr = 1;
        Node delNode = list.first;

        while(ctr < pos){
            delNode = delNode.next;
            ctr++;
        }

        if(delNode.next != null)
        {
            delNode.next.prev = delNode.prev;
        }

        if(delNode.prev != null)
        {
            delNode.prev.next = delNode.next;
        }
        

        return list;
    }

    public int containsInteger(Integer num){
        int ctr = 0;
        Node<T> current = this.first;
        while(current.next != null){
            if(Integer.parseInt((String)current.data) == num)
                ctr++;
            current = current.next;
        }

        if(Integer.parseInt((String)current.data) == num){
            ctr++;
        }

        return ctr;
    }

    public static void print(DoublyLinkedList list){
        Node current = list.first;

        while(current.next != null){
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        
        System.out.println(current.data);
    }
}