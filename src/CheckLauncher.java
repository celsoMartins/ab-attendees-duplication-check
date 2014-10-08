import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.ab.registrations.attendees.Attendee;
import br.com.ab.registrations.attendees.AttendeeParser;
import br.com.ab.registrations.check.Check;

public class CheckLauncher {

	public static void main(final String[] args) {
		
		try {
			List<Attendee> unpaid = AttendeeParser.parseUnpaid(new File("csv/attendees_unpaid.csv"), "UTF-8");
			List<Attendee> paid = AttendeeParser.parsePaid(new File("csv/attendees_paid.csv"), "ISO-8859-1");
			Check check = new Check(paid, unpaid);
			
			List<Attendee> intersection = check.gimmeDuplicates();
			int count = 0;
			for (Attendee attendee : intersection) {
				count++;
				System.out.println(count + " - " + attendee.getFirstName() + " " + attendee.getLastName() + " ---- " + attendee.getEmail());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
