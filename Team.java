public class Team {

	private String name;
	private double wp;
	private int seed;
	private int wins;

	public Team(String name, int seed, double wp) {
		this.name = name;
		this.seed = seed;
		this.wp = wp;
		this.wins = 0;
	}

	public void win() {
		wins++;
	}

	public int wins() {
		return wins;
	}

	public double wp() {
		return wp;
	}

	public int seed() {
		return seed;
	}

	public String name() {
		return name;
	}

}