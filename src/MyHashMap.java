public class MyHashMap<K, V> {

    static class Nodes<K, V> {
        private V value;
        private final K key ;
        Nodes<K, V> link = null;

        public Nodes(K key, V value) {
            this.value = value;
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setLink(Nodes<K, V> link) {
            this.link = link;
        }

        public Nodes<K, V> getLink() {
            return link;
        }
    }

    Nodes<K, V> end = null;
    private int size = 0;

    public void put(K key, V value){
        boolean keyCheck = false;
        if (end == null) {
            end = new Nodes<K, V>(key, value);
            size++;
        } else {
            Nodes<K, V> temp = end;
            for (int i = 0; i < size; i++) {
                if (temp.getKey().equals(key)) {
                    keyCheck = true;
                    temp.setValue(value);
                    break;
                }
                if(size>i) {
                    temp = temp.getLink();
                }
            }
            if(!keyCheck) {
                Nodes<K, V> element = new Nodes<>(key, value);
                element.setLink(end);
                end = element;
                size++;
            }
        }
    }

    public void remove(K key) {
        Nodes<K, V> temp = end;
        for (int i = 0; i < size; i++) {
            if (temp.getLink().getKey().equals(key)) {
                temp.setLink(temp.getLink().getLink());
                temp = temp.getLink();
                temp = null;
                break;
            }
            if(size>i) {
                temp = temp.getLink();
            }
        }
        size--;
    }

    public void clear(){
        for (int i = size; i > 0; i--) {
            end = end.getLink();
            size--;
        }
    }

    public int size(){
        return size;
    }

    public V get(K key){
        Nodes<K, V> temp = end;
        for (int i = 0; i < size; i++) {
            if (temp.getKey().equals(key)) {
                return temp.getValue();
            }
            if(size>i) {
                temp = temp.getLink();
            }
        }
        return null;
    }
}