package br.com.ab.registrations.attendees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AttendeeParser {
	
	public static List<Attendee> parsePaid(File file, String encoding) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
			List<Attendee> allAttendees = new ArrayList<Attendee>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				Attendee attendee = new Attendee(parts[9].replaceAll("\"", "").trim(), parts[10].replaceAll("\"", "").trim(), parts[11]);
				allAttendees.add(attendee);
			}
			return allAttendees;
		} finally {
			reader.close();
		}
	}
	
	public static List<Attendee> parseUnpaid(File file, String encoding) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
			List<Attendee> allAttendees = new ArrayList<Attendee>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] parts = line.split(",");
					Attendee attendee = new Attendee(parts[1].trim(), parts[0].trim(), "");
					allAttendees.add(attendee);
				}
			}
			return allAttendees;
		} finally {
			reader.close();
		}
	}
}