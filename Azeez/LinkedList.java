public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public void setCurrent(Node<T> current) {
		this.current = current;
	}

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findfirst() {
		current = head;
	}

	public void findnext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public Node<T> getCurrent() {
		return current;
	}

	public void update(T val) {
		current.data = val;
	}

	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	public void delete(T data) {
		if (head == null) {
			return;
		}

		if (head.getData().equals(data)) {
			head = head.getNext();
			return;
		}

		Node<T> current = head;
		Node<T> prev = null;

		while (current != null && !current.getData().equals(data)) {
			prev = current;
			current = current.getNext();
		}

		if (current == null) {
			return;
		}

		prev.setNext(current.getNext());
	}
	

	public boolean contains(T data) {
		current = head;
		while (current != null) {
			if (current.getData() == data) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public void remove(T data) {
		if (head == null) {
			return;
		}

		if (head.getData() == data) {
			head = head.getNext();
			return;
		}

		Node<T> current = head;
		while (current.getNext() != null) {
			if (current.getNext().getData() == data) {
				current.setNext(current.getNext().getNext());
				return;
			}
			current = current.getNext();
		}
	}

	public void sortAlphabetically() {
		if (head == null || head.getNext() == null) {
			return;
		}

		boolean swapped;
		do {
			swapped = false;
			Node<T> current = head;
			while (current.getNext() != null) {
				if (compareNodes(current, current.getNext()) > 0) {
					swapNodes(current, current.getNext());
					swapped = true;
				}
				current = current.getNext();
			}
		} while (swapped);
	}

	private int compareNodes(Node<T> node1, Node<T> node2) {
		Node<T> current = head;
		while (current != null) {
			if (current.getData() == node1.data) {
				return 1;
			}
			current = current.getNext();
		}
		return 0;
	}

	private void swapNodes(Node<T> node1, Node<T> node2) {
		T temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}



	public T search(String value, String field) {
		Node<T> current = head;
		while (current != null) {
			T data = current.getData();
			if (getFieldValue(data, field).equals(value)) {
				return data;
			}
			current = current.getNext();
		}
		return null;
	}

	private String getFieldValue(T data, String field) {
		if (data instanceof Contact) {
			Contact contact = (Contact) data;
			switch (field) {
				case "name":
					return contact.getName();
				case "phoneNumber":
					return contact.getPhoneNumber();
				case "email":
					return contact.getEmailAddress();
				default:
					throw new IllegalArgumentException("Invalid field: " + field);
			}
		} else if (data instanceof Event) {
			Event event = (Event) data;
			switch (field) {
				case "title":
					return event.getTitle();
				case "startTime":
					return event.getStartTime();
				case "endTime":
					return event.getEndTime();
				default:
					throw new IllegalArgumentException("Invalid field: " + field);
			}
		} else {
			throw new IllegalArgumentException("Invalid data type: " + data.getClass().getName());
		}
	}

	public void printAll() {
		Node<T> current = head;
		while (current != null) {
			System.out.println(current.getData().toString());
			current = current.getNext();
		}
	}
}