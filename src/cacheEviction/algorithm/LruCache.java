package cacheEviction.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class LruCache<K, V> {

	private DoubleLinkedList<K, V> queue;
	private Map<K, Node<K, V>> map = new HashMap<>(); // Eager initialization
	private final int MAX_CAPACITY;

	public LruCache(int size) {
		MAX_CAPACITY = size;
		queue = new DoubleLinkedList<K, V>(); // queue size
		map = new HashMap<>();

	}

	public V getValueForKey(K key) {
		Node<K, V> n = map.get(key);
		if (n == null) { // not in map
			return null;
		}
		n = new Node<>(key, n.value);

		map.remove(n);
		queue.removeElement(n);
		queue.addElementInBegin(n);
		map.put(key, n);
		return n.value;
	}

	public void addKeyValue(K key, V value) {
		System.out.println("adding Key = " + key);
		Node<K, V> evict = null;
		if (map.get(key) != null) { // int map so evict this
			evict = map.get(key);
		} else if (queue.getSize() >= MAX_CAPACITY) {
			evict = queue.getLast();
		}
		

		if (evict != null) {
			System.out.println("evicting " + evict.key);
			queue.removeElement(evict);
			map.remove(evict.key);
		}
		Node<K, V> newNode = new Node<K, V>(key, value);
		queue.addElementInBegin(newNode);
		map.put(key, newNode);

	}

	public void printKeys() {
		List<Pair<K,V>> list = new ArrayList<>();
		Set<Entry<K, Node<K, V>>> entrySet = map.entrySet();
		for(Entry<K, Node<K, V>> entry : entrySet) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue().value);
		}
	}

}
