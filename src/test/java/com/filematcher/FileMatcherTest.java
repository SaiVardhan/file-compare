package com.filematcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.filematcher.matcher.FileMatcher;
import com.filematcher.model.PersonName;

public class FileMatcherTest {
	private List<PersonName> firstFileList;
	private List<PersonName> secondFileList;
	private FileMatcher fileMatcher;
	private PersonName p5, p1, p2, p3, p4;

	@Before
	public void setUp() {
		fileMatcher = new FileMatcher();

		p1 = new PersonName("ABC ccc XYZ");
		p2 = new PersonName("AbC www ee ff xYZ");
		p3 = new PersonName("abc");
		p4 = new PersonName("xyz abc");
		p5 = new PersonName("ABc");
		firstFileList = new ArrayList<PersonName>();
		secondFileList = new ArrayList<PersonName>();
	}

	@Test
	public void testMatchListWithEqualFirstAndLastName() {
		firstFileList.add(p1);
		secondFileList.add(p2);

		List<PersonName> expected = new ArrayList<PersonName>();
		expected.add(new PersonName("ABC XYZ"));

		List<PersonName> actual = fileMatcher.matchList(firstFileList,
				secondFileList);
		assertEquals(expected, actual);
	}

	@Test
	public void testMatchListWithOnlyFirstNameEqual() {
		firstFileList.add(p1);
		secondFileList.add(p3);

		List<PersonName> matchedList = fileMatcher.matchList(firstFileList,
				secondFileList);

		assertTrue(matchedList.size() == 1);
	}

	@Test
	public void testMatchListWithFirstNameLastNameReversed() {
		firstFileList.add(p1);
		secondFileList.add(p4);

		List<PersonName> matchedList = fileMatcher.matchList(firstFileList,
				secondFileList);

		assertTrue(matchedList.size() == 1);
	}

	@Test
	public void testMatchListWithOnlyFirstNameEqualAndNoLastName() {
		firstFileList.add(p3);
		secondFileList.add(p5);

		List<PersonName> expected = new ArrayList<PersonName>();
		expected.add(new PersonName("ABC"));

		List<PersonName> actual = fileMatcher.matchList(firstFileList,
				secondFileList);

		assertEquals(expected, actual);
	}

}
