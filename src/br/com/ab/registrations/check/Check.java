package br.com.ab.registrations.check;

import java.util.ArrayList;
import java.util.List;

public class Check {

	private List<String> source = new ArrayList<String>();
	private List<String> target = new ArrayList<String>();

	public Check(List<String> source, List<String> target) {
		this.source = source;
		this.target = target;
	}

	public List<String> gimmeDuplicates() {
		if (source.isEmpty() || target.isEmpty()) throw new IllegalArgumentException("Source and target are required");
		List<String> intersection = new ArrayList<String>(source);
		intersection.retainAll(target);
		return intersection;
	}
}
