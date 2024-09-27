public class MyLinkedList<K> {
    static class Node<K> {
        private final K value;
        private Node<K> next = null;
        private Node<K> previous = null;

        public Node(K value, Node<K> next){
            this.value = value;
            this.next = next;
        }

        public K getValue() {
            return value;
        }

        public void setNext(Node<K> next) {
            this.next = next;
        }

        public void setPrevious(Node<K> previous) {
            this.previous = previous;
        }

        public Node<K> getNext() {
            return next;
        }

        public Node<K> getPrevious() {
            return previous;
        }
    }

    private int node;
    Node<K> start = null;
    Node<K> end = null;

    MyLinkedList() {
        node = 0;
    }

    public void add(K value) {
        node++;
        Node<K> element = new Node<K>(value, null);
        if (start == null) {
            start = element;
            end = element;
        } else {
            element.setPrevious(end);
            end.setNext(element);
            end = element;
        }
    }

    public void remove(int index) {
        Node<K> temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        Node<K> right = temp.getPrevious();
        Node<K> left = temp.getNext();
        right.setNext(left);
        left.setPrevious(right);
        node--;
    }

    public void clear() {
        for (int i = 2; i < node; i++) {
            start = start.getNext();
        }
        start = null;
        node = 0;
    }

    public int size(){
        return node;
    }

    public Object get(int index) {
        Node<K> temp = start;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }
}