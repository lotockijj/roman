package task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class RumorsTest {
	Rumors rumors;
	public int NUMBER_GESTS = 5;

	@Before
	public void setUp() throws Exception {
		rumors = new Rumors(NUMBER_GESTS);
	}

	@Test
	public void testRumors() {
		assertEquals(NUMBER_GESTS, rumors.friends.size());
		assertNotNull(rumors.r);
		for(Friend f : rumors.friends) {
			assertFalse(f.countRumors == 1);
		}
	}

	@Test
	public void testStartRumor() {
		rumors.startRumor();
		boolean bobHasHeard = false;
		for(Friend f : rumors.friends) {
			if(f.countRumors == 1) {
				bobHasHeard = true;
				break;
			}
		}
		assertTrue(bobHasHeard);
	}

	@Test
	public void testContinueRumors() {
		rumors.startRumor();
		rumors.continueRumors();
		for(Friend f : rumors.friends) {
			assertTrue(f.countRumors >= 1);
		}
	}

	@Test
	public void testGetRandomFriend() {
		Set<Friend> allFriends = new HashSet<>();
		for(int i = 0; i < 100; i++) {
			allFriends.add(rumors.getRandomFriend(rumors.friends));
		}
		assertEquals(NUMBER_GESTS, allFriends.size());
	}

	@Test
	public void testGetRandomFriendNotNotifiedByMe() {
		List<Friend> notifiedByMe = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			notifiedByMe.add(rumors.friends.get(i));
		}
		Friend randomNotNotified = rumors.getRandomFriendNotNotifiedByMe(notifiedByMe);
		boolean notNotified = notifiedByMe.contains(randomNotNotified);
		assertFalse(notNotified);
	} 
	
	@Test
	public void testIfThereIsAnyOneHeardFirstTime() {
		rumors.startRumor();
		assertTrue(rumors.hasEveryOneHeard());
	}
	

}
