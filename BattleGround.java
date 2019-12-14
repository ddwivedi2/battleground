package battle.armies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BattleGround {
	public static Map<Integer, Integer> maxL;

	public static void main(String[] args) {
		maxL = new HashMap<Integer, Integer>();
		//Setting max Values for DoesLengaburuWin
		maxL.put(0, 100);
		maxL.put(1, 50);
		maxL.put(2, 10);
		maxL.put(3, 5);
		Army f = new Army(250, 50, 20, 15);
		boolean res = DoesLengaburuWin(f);
		System.out.println("Does DoesLengaburuWin?: " + res);
	}
	
	public static boolean DoesLengaburuWin(Army f) {
		Army l = new Army(0, 0, 0, 0);
		Set<Integer> s = new HashSet<Integer>();
		int ans = ConstructLengaburu(s, f, 0, 0, l);
		if(ans == 0) {
			return true;
		}
		return false;
		
	}
	
	public static int ConstructLengaburu(Set<Integer> s, Army f, int level, int carry, Army l) {
		if(level > 3) {
			return carry;
		}
		int unit = 0;
		switch(level) {
			case 0: unit = f.getHorses();
			break;
			case 1: unit = f.getElephants();
			break;
			case 2: unit = f.getTanks();
			break;
			case 3: unit = f.getGuns();
			break;
		}
		
		unit = unit + carry;
		
		int lUnitRequired;
		if(unit % 2 == 0) {
			lUnitRequired = unit/2;
		}else {
			lUnitRequired = (unit/2) + 1;
		}
		
		int lUnitPossible = Math.min(lUnitRequired, maxL.get(level));
		
		carry = lUnitRequired - lUnitPossible;
		if(lUnitPossible == maxL.get(level)) {
			s.add(level);
		}

		switch(level) {
			case 0: l.setHorses(lUnitPossible);
			break;
			case 1: l.setElephants(lUnitPossible);
			break;
			case 2: l.setTanks(lUnitPossible);
			break;
			case 3: l.setGuns(lUnitPossible);
			break;
		}
		
		if(carry > 0 && level > 0 && !s.contains(level-1)) {
			s.add(level);
			return ConstructLengaburu(s, f, level-1, carry /2, l);
		}
		
		int maxUnvisited = level + 1;
		carry = carry *2;
		while(s.contains(maxUnvisited)) {
			maxUnvisited++;
			carry = carry *2;
		}
		
		
		return ConstructLengaburu(s, f, maxUnvisited, carry, l);
	}
}