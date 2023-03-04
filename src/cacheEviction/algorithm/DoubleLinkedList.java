package cacheEviction.algorithm;

import javafx.util.Pair;

public class DoubleLinkedList<K, V> {
	private Node<K, V> head;
	private Node<K, V> tail;
	int size =0;

	public DoubleLinkedList() {
		head = new  Node<>();
		tail = new  Node<>();
		head.nxt = tail;
		tail.nxt = head;
	}

	public void addElementInBegin(Node<K,V> ele) { // element added to last
		ele.nxt = head.nxt;
		head.nxt.pre = ele;
		head.nxt = ele;
		ele.pre = head;
		size++;
	}

	public void removeElement(Node<K,V> node) {
		node.pre.nxt = node.nxt;
		node.nxt.pre = node.pre;
		size--;
	}
	public int getSize() {
		return size;
	}
	
	public Node<K,V> getLast() {
		if(tail.pre == head) {
			return null;
		}
		return tail.pre;
	}

}
