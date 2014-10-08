package br.com.ab.registrations.check;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.ab.registrations.attendees.Attendee;

public class Check {

	private List<Attendee> source = new ArrayList<Attendee>();
	private List<Attendee> target = new ArrayList<Attendee>();

	public Check(List<Attendee> source, List<Attendee> target) {
		this.source = source;
		this.target = target;
	}
	
	public Check(List<Attendee> source) {
		this.source = source;
	}

	public List<Attendee> gimmeDuplicates() {
		if (source.isEmpty() || target.isEmpty()) throw new IllegalArgumentException("Source and target are required");
		List<Attendee> intersection = new ArrayList<Attendee>(source);
		intersection.retainAll(target);
		return intersection;
	}
	
	public List<Attendee> gimmeDuplicatesOnSource() {
		if (source.isEmpty()) throw new IllegalArgumentException("Source is required");
		Set<Attendee> setOfAttendees = new HashSet<Attendee>();
		List<Attendee> intersection = new ArrayList<Attendee>();
		for (Attendee attendee : source) {
			if (!setOfAttendees.add(attendee)) {
				intersection.add(attendee);
			}
		}
		return intersection;
	}
}
