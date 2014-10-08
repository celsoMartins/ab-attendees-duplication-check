package br.com.ab.registrations.check;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CheckTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void shouldNotCheckDuplicatesWithoutSource() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Source and target are required");
		Check check = new Check(new ArrayList<String>(), new ArrayList<String>());
		check.gimmeDuplicates();
	}
	
	@Test
	public void shouldNotCheckDuplicatesWithoutTarget() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Source and target are required");
		List<String> source = new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		Check check = new Check(source, new ArrayList<String>());
		check.gimmeDuplicates();
	}
	
	@Test
	public void shouldReturnDuplicates() {
		List<String> source = new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		List<String> target = new ArrayList<String>(Arrays.asList("A","C","D","F"));
		Check check = new Check(source, target);
		assertEquals(new ArrayList<String>(Arrays.asList("A", "C", "D")), check.gimmeDuplicates());
	}
}