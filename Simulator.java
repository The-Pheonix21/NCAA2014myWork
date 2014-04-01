public class Simulator {
	
	private static final int SIMULATIONS = 1000;

	public static void main(String[] args) {
		Bracket bracket = new Bracket();
		bracket.simulate(SIMULATIONS);
		bracket.printResults();
	}
}