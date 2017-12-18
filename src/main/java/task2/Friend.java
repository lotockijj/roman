package task2;

import java.util.ArrayList;
import java.util.List;

public class Friend{
	int id;
	int countRumors;
	List<Friend> thisNotified;
	List<Friend> friends;
	Rumors rum;
	static int numberFriends = 0;

	public Friend(List<Friend> friends, Rumors rum) {
		countRumors = 0;
		thisNotified = new ArrayList<>();
		thisNotified.add(this);
		numberFriends++;
		id = numberFriends;
		this.friends = friends;
		this.rum = rum;
	}

	public void giveRumor() {
		Friend friend = rum.getRandomFriendNotNotifiedByMe(thisNotified);
		if(friend != null) {
			thisNotified.add(friend);
			friend.thisNotified.add(this);
			if(friend.countRumors == 1) {
				friend.countRumors++;
			} else {
				friend.countRumors++;
			}
		}
	}

	@Override
	public String toString() {
		return "\n" + id + ", heard " + countRumors + " times";
		//+ ", from: " + fromWhomHeard + " my list: " + thisNotified;
	}
	
	public String myToString() {
		return id + ": list: " + thisNotified;
	}

}