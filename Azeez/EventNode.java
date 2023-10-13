public class EventNode<T> {
        public T data;
        public EventNode<T> next;
    
        public EventNode () {
            data = null;
            next = null;
        }
    
        public EventNode (T val) {
            data = val;
            next = null;
        }
    
        public T getData() {
            return data;
        }
    
        public void setData(T data) {
            this.data = data;
        }
    
        public EventNode<T> getNext() {
            return next;
        }
    
        public void setNext(EventNode<T> next) {
            this.next = next;
        }
    
    
    }
    
