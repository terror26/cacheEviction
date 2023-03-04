package cacheEviction.algorithm;

public class Node<K,V> {
	public K key;
	public V value;
	public Node<K, V> pre;
	public Node<K, V> nxt;

	public Node() {
		pre = null;
		nxt = null;
	}
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
