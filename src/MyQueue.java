public class MyQueue<K> {
    static class Element<K> {
        K value = null;
        Element<K> link = null;

        public Element(K value, Element<K> link) {
            this.value = value;
            this.link = link;
        }

        public void setLink(Element<K> link) {
            this.link = link;
        }

        public K getValue() {
            return value;
        }

        public Element<K> getLink() {
            return link;
        }
    }

    Element<K> start = null;
    Element<K> end = null;
    private int size = 0;

    public void add(K value){
        Element<K> element = new Element<>(value, null);
        if(start == null){
            start = element;
            end = element;
        }
        else{
            end.setLink(element);
            end = element;
        }
        size++;
    }

    public void clear() {
        for (int i = 2; i < size; i++) {
            start = start.getLink();
        }
        start = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public K peek(){
        return start.getValue();
    }

    public K poll(){
        K temp = start.getValue();
        start = start.getLink();
        size--;
        return temp;
    }
}