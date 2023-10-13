
public class LinkedList<T extends Comparable<T>> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList () {
		head = current = null;
	}

	public boolean empty () {
		return head == null;
	}

	public boolean last () {
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findfirst () {
		current = head;
	}
	public void findnext () {
		current = current.next;
	}
	public T retrieve () {
		return current.data;
	}
	public Node<T> getCurrent() {
		return current;
	}

	public void update (T val) {
		current.data = val;
	}
    public void insert(T val) {  
        
        Node<T> tmp;  
        if (empty()) {  
                current = head = new Node<T>(val);  
        }  
        else {  
            if ( head.getData().compareTo(val) >0)  
            {  
                tmp = new Node<T>(val);  
                tmp.setNext(head);  
                head = tmp;  
            }  
            else  
            {  
                Node<T> prev = null;  
                current = head;  
                  
                while (( current != null ) && ( current.getData().compareTo(val) <= 0))  
                {  
                    prev = current;  
                    current = current.getNext();  
                }  
                tmp = new Node<T> (val);  
                if ( current != null)  
                {  
                    tmp.next = current;  
                    prev.next = tmp;  
                    current = tmp;  
                }  
                else  
                    current = prev.next =tmp;  
            }  
        }  
       
         
}  
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

	
	 
	
}
