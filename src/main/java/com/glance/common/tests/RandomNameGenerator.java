package com.glance.common.tests;

import java.util.Random;

public class RandomNameGenerator {

	static String[] array1 = { "La", "De", "Si", "Jo", "Hu", "Je", "Ai", "Geo", "Ja", "Ji", "Yo", "El", "Ru", "Sa" };

	static String[] array2 = { "b", "c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z",
			"ch", "bl", "br", "fl", "gl", "gr", "kl", "pr", "st", "sh", "th", "ne", "rg", "li", "tu" };

	static String[] array3 = { "b", "d", "f", "g", "h", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "z", "ch", "gh",
			"nn", "st", "sh", "th", "tt", "ss", "pf", "nt" };

	public static String getName() throws Exception {

		String gen = "";
		try {
			Random ran = new Random();
			gen = array1[ran.nextInt(array1.length)] + array2[ran.nextInt(array2.length)]
					+ array3[ran.nextInt(array3.length)];

		} catch (Exception e) {
			throw new Exception(e);
		}

		return gen;

	}

}
