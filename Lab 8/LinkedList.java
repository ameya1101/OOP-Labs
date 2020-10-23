public class LinkedList <T>{
    public Node<T> first;

    static class Node <T>{
        public Node<T> next;
        public Object data;

        public Node(Object data){
            this.data = (T) data;
            this.next = null;
        }
    }

    public static LinkedList append (LinkedList list, Object data){
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
        }

        return list;
    }

    public static LinkedList delete (LinkedList list, int pos){
        
        if(pos == 1){
            list.first = null;
            return list;
        }

        int ctr = 1;
        Node delNode = list.first;
        while(ctr < pos - 1){
            delNode = delNode.next;
            ctr++;
        }

        delNode.next = delNode.next.next;

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

    public static void print(LinkedList list){
        Node current = list.first;

        while(current.next != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        
        System.out.println(current.data);
    }
}
