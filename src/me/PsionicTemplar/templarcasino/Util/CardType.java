package me.PsionicTemplar.templarcasino.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum CardType {
	SPADE, CLUB, DIAMOND, HEART;

	/**
	 * Creates a new hashmap with all the cards put inside of them.
	 * 
	 * @author Nicholas Braniff
	 * @return Hashmap with all 4 card types as keys and values for those keys as
	 *         list with 1-13. 1 = Ace, 11 = Jack, 12 = Queen, and 13 = King.
	 */

	public static HashMap<CardType, List<Integer>> getCardDeck() {
		HashMap<CardType, List<Integer>> deck = new HashMap<CardType, List<Integer>>();
		for (CardType ct : CardType.values()) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i < 14; i++) {
				list.add(i);
			}
			deck.put(ct, list);
		}
		return deck;
	}
}
