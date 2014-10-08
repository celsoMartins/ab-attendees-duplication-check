package br.com.ab.registrations.check;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CheckTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void shouldNotCheckDuplicatesWithoutSource() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Source is required");
		Check check = new Check();
		check.gimmeDuplicates();
	}
}