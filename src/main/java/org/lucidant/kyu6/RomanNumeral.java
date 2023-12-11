/**
 *
 */
package org.lucidant.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author chrisfaulkner
 *
 */
public class RomanNumeral {

	static int decode(final String roman) {
		final List<String> numerals = Arrays.stream(roman.toUpperCase().split("")).toList();
		int total = 0;
		int lastValue = -1;
		boolean decrement = true;
		for (String character : numerals) {
			final int thisValue = Numeral.getValue(character);
			if (!decrement) {
				if (thisValue <= lastValue) {
					total = total + lastValue;
				} else {
					decrement = true;
					total = total + (thisValue - lastValue);
				}
			} else {
				decrement = false;
			}
			lastValue = thisValue;
		}

		return !decrement ? total + lastValue : total;
	}

	private final static TreeMap<Integer, String> map = new TreeMap<>();

	static {

		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

	}

	protected static String toRoman(int number) {
		int l = map.floorKey(number);
		if (number == l) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number - l);
	}
}

enum Numeral {

	M(1000), D(500), C(100), L(50), X(10), V(5), I(1);

	private final int value;

	Numeral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static int getValue(final String letter) {
		final Numeral numeral = Numeral.valueOf(letter.toUpperCase());
		for (Numeral num : Numeral.values()) {
			if (num == numeral) {
				return numeral.getValue();
			}

		}
		return -1;
	}

}
