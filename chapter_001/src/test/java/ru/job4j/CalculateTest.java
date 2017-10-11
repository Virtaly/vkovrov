package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author Vitaly Kovrov (mailto:virtaly@ya.ru)
* @version 0.1
* @since 0.1
*/
public class CalculateTest {
	
	/**
	* Test echo
	*/
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Vitaly Kovrov";
		String expect = "Echo, echo, echo : Vitaly Kovrov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}