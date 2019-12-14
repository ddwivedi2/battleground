package battle.armies;

public class Army {
	
	
	int horses;
	int elephants;
	int tanks;
	int guns;
	
	public Army(int horses, int elephants, int tanks, int guns) {
		this.horses = horses;
		this.elephants = elephants;
		this.tanks = tanks;
		this.guns = guns;
	}
	
	public void setHorses(int horses) {
		this.horses = horses;
	}
	
	public void setElephants(int elephants) {
		this.elephants = elephants;
	}
	
	public void setTanks(int tanks) {
		this.tanks = tanks;
	}
	
	public void setGuns(int guns) {
		this.guns = guns;
	}
	

	public int getHorses() {
		return this.horses;
	}
	
	public int getElephants() {
		return this.elephants;
	}
	
	public int getTanks() {
		return this.tanks;
	}
	
	public int getGuns() {
		return this.guns;
	}
}
