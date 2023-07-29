package com.java8.end;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortHashMapNoJava8 {
	public static void main(String... args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Jenny", 76);
		map.put("losy", 70);
		map.put("Ezhil", 86);
		map.put("Daniel", 96);
		map.put("Queen", 90);

		Map<String, Integer> tree = new TreeMap<String, Integer>(map);
		for (Entry<String, Integer> entry : tree.entrySet()) {
			System.out.println(entry);

		}

		Map<String, Integer> treereverse = new TreeMap<String, Integer>(Collections.reverseOrder());
		treereverse.putAll(map);
		for (Entry<String, Integer> entry : treereverse.entrySet()) {
			System.out.println(entry);

		}

		Map<String, Integer> treeComp = new TreeMap<String, Integer>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length()) {
					return 1;
				} else
					return -1;
			}
		});
		treeComp.putAll(map);
		System.out.println(treeComp);
		for (Entry<String, Integer> entry : treeComp.entrySet()) {
			System.out.println(entry);
		}

	}
}
