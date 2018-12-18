package me.PsionicTemplar.templarcasino.Util;

import java.util.HashMap;

public enum CardType {
	SPADE, CLUB, DIAMOND, HEART;
	
	private static HashMap<CardType, Integer> loadCardDeck() {
		HashMap<CardType, Integer> deck = new HashMap<CardType, Integer>();
		for(CardType ct : CardType.values()) {
			for(int i = 1; i < 13; i++) {
				deck.put(ct, i);
			}
		}
		return deck;
	}
	
	public static HashMap<CardType, Integer> getCardDeck() {
		return loadCardDeck();
	}
}
