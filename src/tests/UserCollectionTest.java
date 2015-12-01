/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Test cases for UserCollection
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.UserCollection;

public class UserCollectionTest {


	@Test
	public void testValidateStudents() {
		UserCollection uc = new UserCollection();
		assertTrue(uc.validateStudent("Chris", "1"));
	}
	
	@Test
	public void testGetUserByID(){
		UserCollection uc = new UserCollection();
		assertEquals("Chris", uc.get("Chris").getId());
	}
}
