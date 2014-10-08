package br.com.ab.registrations.check;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.ab.registrations.attendees.Attendee;

public class CheckTest {
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test
	public void shouldNotCheckDuplicatesWithoutSource() {
		expected.expect(IllegalStateException.class);
		expected.expectMessage("Source and target are required");
		Check check = new Check(new ArrayList<Attendee>(), new ArrayList<Attendee>());
		check.gimmeDuplicates();
	}
	
	@Test
	public void shouldNotCheckDuplicatesWithoutTarget() {
		expected.expect(IllegalStateException.class);
		expected.expectMessage("Source and target are required");
		Attendee attendee = new Attendee("foo", "bar", "foo@bar.com.br");
		List<Attendee> source = new ArrayList<Attendee>(Arrays.asList(attendee));
		Check check = new Check(source, new ArrayList<Attendee>());
		check.gimmeDuplicates();
	}
	
	@Test
	public void shouldReturnDuplicatesByName() {
		Attendee matheus = new Attendee("matheus", "martins", "matheus@martins.com.br");
		Attendee erica = new Attendee("erica", "barbosa", "erica@barbosa.com.br");
		Attendee celso = new Attendee("celso", "martins", "celso@martins.com.br");
		Attendee marcio = new Attendee("marcio", "martins", "marcio@martins.com.br");
		Attendee marilene = new Attendee("marilene", "martins", "marilene@martins.com.br");
		Attendee paulo = new Attendee("paulo", "silveira", "paulo@silveira.com.br");
		Attendee rodrigo = new Attendee("rodrigo", "yoshima", "rodrigo@yoshima.com.br");
		Attendee luca = new Attendee("luca", "bastos", "luca@bastos.com.br");
		Attendee pauloOutroEmail = new Attendee("paulo", "silveira", "silveira@paulo.com");
		
		List<Attendee> source = new ArrayList<Attendee>(Arrays.asList(celso, matheus, erica, paulo));
		List<Attendee> target = new ArrayList<Attendee>(Arrays.asList(erica, matheus, marcio, marilene, pauloOutroEmail, rodrigo, luca));
		Check check = new Check(source, target);
		assertEquals(new ArrayList<Attendee>(Arrays.asList(matheus, erica, paulo)), check.gimmeDuplicates());
	}
}