package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Rumors. Alice is throwing a party with N other guests, including Bob. Bob starts a rumor 
 * about Alice by telling it to one of the other guests. A person hearing this rumor for the 
 * first time will immediately tell it to one other guest, chosen at random from all the people 
 * at the party except Alice and the person from whom they heard it. If a person (including Bob) 
 * hears the rumor for a second time, he or she will not propagate it further. 
 * Write a program to estimate the probability that everyone at the party (except Alice) 
 * will hear the rumor before it stops propagating. 
 * Also calculate an estimate of the expected number of people to hear the rumor.
 */

public class Rumors {
	List<Friend> friends;
	Random r;

	public Rumors(int numberOfGuests) {
		friends = new ArrayList<>();
		r = new Random();
		for (int i = 0; i < numberOfGuests; i++) {
			friends.add(new Friend(friends, this));
		}
	}

	public void startRumor() {
		Friend bob = friends.get(0);
		bob.countRumors++;
	}

	public void continueRumors() {
		while(hasEveryOneHeard()) {
			Friend friend = getFriendHeardFirstTime();
			if(friend == null) {
				break;   
			} else {
				if(friend.countRumors == 1) {
					friend.giveRumor();
				}
			}
		}
	}

	private Friend getFriendHeardFirstTime() {
		List<Friend> list = new ArrayList<>();
		for (int i = 0; i < friends.size(); i++) {
			Friend f = friends.get(i);
			if(f.countRumors == 1) {
				list.add(f);
			}
		}
		return getRandomFriend(list);
	}

	public Friend getRandomFriend(List<Friend> randomFriend) {
		Friend friend = null;
		if(randomFriend.size() != 0) {
			int n = r.nextInt(randomFriend.size());
			friend = randomFriend.get(n);
		}
		return friend;
	}

	public Friend getRandomFriendNotNotifiedByMe(List<Friend> thisNotified) {
		List<Friend> substractList = new ArrayList<>();
		for (Friend f : friends) {  
			if (!thisNotified.contains(f)) {  
				substractList.add(f);
			}  
		}  
		return getRandomFriend(substractList);
	}

	public boolean hasEveryOneHeard() {
		for (Friend f : friends) {
			if(!(f.countRumors >= 1)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Rumors rumors = new Rumors(7);
		rumors.startRumor();
		System.out.println("After starting rummors: " + rumors.friends);
		rumors.continueRumors();
		System.out.println("After continue rumors: " + rumors.friends);
		for(int i = 0; i < rumors.friends.size(); i++) {
			System.out.println(rumors.friends.get(i).myToString());
		}
	}

} 