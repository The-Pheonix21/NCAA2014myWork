import java.io.*;
import java.util.*;

public class Bracket {
	
 private Team [][] tournTeams;
 private Team [][] roundOf32;
 private Team [][] sweet16;
 private Team [][] elite8;
 private Team [][] final4;
 private Team [] theFinals;
 private Team [] winners;
 private Region [] nRegion;
 private int tRounds;
 private Game myGame;
 private ArrayList<ArrayList<String>> totalSim= new ArrayList<ArrayList<String>>();
public Bracket() {
	tournTeams = new Team [4][16];
}
public void simulate(int x){
	//Bracket winners write to simfirst arraylist and move to next array in tournTeams to process.
	ArrayList<String> simfirst = new ArrayList<String>();
    tournTeams = new Team [4][16];  // to reset the wins for new simulation
    nRegion = new Region[4];
    winners = new Team [64];
	ReadNCAA();
for (int l = 0; l < x; l++){
	//loop for simulations
	
    roundOf32 = new Team [4][8];
	sweet16 = new Team [4][4];
	elite8 = new Team [4][2];
	final4 = new Team [4][1];
	theFinals = new Team [2];
	
	simfirst = new ArrayList<String>();
		//Round of 32

		simfirst.add("Winner Bracket " + Integer.toString(1) + "  on to Round of 32");
		
		for (int j = 0; j < (tournTeams.length); j++){
			//loop for teams in round
			int countNextb = 0;
			simfirst.add("  Region: " + nRegion[j].name());
			 //System.out.println("Region: " + nRegion[j].name());
				for (int i = 0; i < tournTeams[j].length-1; i += 2 ){
					myGame=new Game(tournTeams[j][i],tournTeams[j][i+1]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("    Team "+ tournTeams[j][i].name() + " Wins " + (tournTeams[j][i].wins()+1));
					//	System.out.println(" Team "+ tournTeams[k][j][i].name() + " Wins " + tournTeams[k][j][i].wins());
						roundOf32[j][countNextb]=new Team(tournTeams[j][i].name(), tournTeams[j][i].seed(), tournTeams[j][i].wp());
						roundOf32[j][countNextb].win();
					 //	 System.out.println("k+1="+(k+1)+" j =" + j +" countNextb= "+countNextb + " Team " + tournTeams[k+1][j][countNextb].name());
					 }	else {
						simfirst.add("    Team "+ tournTeams[j][i+1].name() + " Wins " + (tournTeams[j][i+1].wins()+1));
					//	System.out.println(" Team "+ tournTeams[k][j][i+1].name() + " Wins " + tournTeams[k][j][i+1].wins());
						roundOf32[j][countNextb]=new Team(tournTeams[j][i+1].name(), tournTeams[j][i+1].seed(), tournTeams[j][i+1].wp());
						roundOf32[j][countNextb].win();
						 // System.out.println("k+1="+(k+1)+" j =" + j +" countNextb= "+countNextb + " Team " + tournTeams[k+1][j][countNextb].name());
					}
					countNextb++;
				}
		}
	
		//  Sweet 16
		simfirst.add("Winner Bracket " + Integer.toString(2) + " on to Sweet 16");
		for (int j = 0; j < (roundOf32.length); j++){
			//loop for teams in round
			int countNextb = 0;
			simfirst.add("  Region: " + nRegion[j].name());
			 //System.out.println("Region: " + nRegion[j].name());
				for (int i = 0; i < roundOf32[j].length-1; i += 2 ){
					myGame=new Game(roundOf32[j][i],roundOf32[j][i+1]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("    Team "+ roundOf32[j][i].name() + " Wins " + (roundOf32[j][i].wins()+1));
						sweet16[j][countNextb]=roundOf32[j][i];
						sweet16[j][countNextb].win();
					 }	else {
						simfirst.add("    Team "+ roundOf32[j][i+1].name() + " Wins " + (roundOf32[j][i+1].wins()+1));
						sweet16[j][countNextb]=roundOf32[j][i+1];
						sweet16[j][countNextb].win();
					}
					countNextb++;
				}
		}
		//  Elite 8
		simfirst.add("Winner Bracket " + Integer.toString(3) + " on to Elite 8");
		for (int j = 0; j < (sweet16.length); j++){
			//loop for teams in round
			int countNextb = 0;
			simfirst.add("  Region: " + nRegion[j].name());
			 //System.out.println("Region: " + nRegion[j].name());
				for (int i = 0; i < sweet16[j].length-1; i += 2 ){
					myGame=new Game(sweet16[j][i],sweet16[j][i+1]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("    Team "+ sweet16[j][i].name() + " Wins " + (sweet16[j][i].wins()+1));
						elite8[j][countNextb]=sweet16[j][i];
						elite8[j][countNextb].win();
					 }	else {
						simfirst.add("    Team "+ sweet16[j][i+1].name() + " Wins " + (sweet16[j][i+1].wins()+1));
						elite8[j][countNextb]=sweet16[j][i+1];
						elite8[j][countNextb].win();
					}
					countNextb++;
				}
		}
		//  Final 4
		simfirst.add("Winner Bracket " + Integer.toString(4) + " on to Final 4");
		for (int j = 0; j < (elite8.length); j++){
			//loop for teams in round
	
			simfirst.add("  Region: " + nRegion[j].name());
			 //System.out.println("Region: " + nRegion[j].name());
				for (int i = 0; i < elite8[j].length-1; i += 2 ){
					myGame=new Game(elite8[j][i],elite8[j][i+1]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("    Team "+ elite8[j][i].name() + " Wins " + (elite8[j][i].wins()+1));
						final4[j][0]=elite8[j][i];
						final4[j][0].win();
					 }	else {
						simfirst.add("    Team "+ elite8[j][i+1].name() + " Wins " + (elite8[j][i+1].wins()+1));
						final4[j][0]=elite8[j][i+1];
						final4[j][0].win();
					}
					
				}
		}
//  Final 2
		simfirst.add("Winner Bracket " + Integer.toString(5) + " on to Finals");
			//loop for teams in round
			 //System.out.println("Region: " + nRegion[j].name());
					myGame=new Game(final4[0][0],final4[1][0]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("  Region: "+ getRegionTeam(final4[0][0].name()));
						simfirst.add("    Team "+ final4[0][0].name() + " Wins " + (final4[0][0].wins()+1));
						theFinals[0]= final4[0][0];
						theFinals[0].win();
					 }	else {
					 	simfirst.add("  Region: "+ getRegionTeam(final4[1][0].name()));
						simfirst.add("    Team "+ final4[1][0].name() + " Wins " + (final4[1][0].wins()+1));
						theFinals[0]=final4[1][0];
						theFinals[0].win();
					}
					myGame=new Game(final4[2][0],final4[3][0]);
					if (myGame.winnerIndex() == 1){
						simfirst.add("  Region: "+ getRegionTeam(final4[2][0].name()));
						simfirst.add("    Team "+ final4[2][0].name() + " Wins " + (final4[2][0].wins()+1));
						theFinals[1]= final4[2][0];
						theFinals[1].win();
					 }	else {
					 	simfirst.add("  Region: "+ getRegionTeam(final4[3][0].name()));
						simfirst.add("    Team "+ final4[3][0].name() + " Wins " + (final4[3][0].wins()+1));
						theFinals[1]=final4[3][0];
						theFinals[1].win();
					}

// The Winner
		simfirst.add("Winner Bracket " + Integer.toString(6) + " on to The Finals");
		myGame=new Game(theFinals[0],theFinals[1]);
		if (myGame.winnerIndex() == 1){
			simfirst.add("  Region: "+ getRegionTeam(theFinals[0].name()));
			simfirst.add("    Team "+ theFinals[0].name() + " Wins " + (theFinals[0].wins()+1));
			for (int k = 0; k < winners.length; k++){
				if(winners[k].name().equals(theFinals[0].name()))winners[k].win();
			}
			}	else {
				simfirst.add("  Region: "+ getRegionTeam(theFinals[1].name()));
				simfirst.add("    Team "+ theFinals[1].name() + " Wins " + (theFinals[1].wins()+1));
				for (int k = 0; k < winners.length; k++){
					if(winners[k].name().equals(theFinals[0].name()))winners[k].win();
				}
		}


	totalSim.add(simfirst);
	//arraylist of the winner array list - all simulations stored together
   }
}
public void printResults(){
	int simcount = 1;
	String TempVal = "";
  for(ArrayList<String> s : totalSim) //use for-each loop - first get the arraylist for the total array list
  {
  	TempVal = "SIMULATION NO:  " + Integer.toString(simcount);
  	writeToFile(TempVal);
  	// System.out.println("SIMULATION NO: " + simcount);
	for(String t : s){  // now get the string from the inner array list
	TempVal = "  " + t + "  ";
	writeToFile(TempVal);
    // System.out.println(" " + t + " ");
	}
	simcount++;
	if (simcount%100 == 0){
		System.out.println("  "+simcount+ "  brackets written so far.");
	}
  }
  	Team t;
  	for (int i = 0;i < winners.length-1;i++) {
  		for (int k =0;k < winners.length;k++) {
  			if (winners[i].wins() > winners[k].wins()) {
  				t = winners[i];
  				winners[i] = winners[k];
  				winners[k] = t;
  			}
  		}
  	}
  for (int k=0; k < winners.length; k++){
  	if (winners[k].wins()>0){
  		TempVal = "Team: " + winners[k].name() + " Wins: " + winners[k].wins();
  		System.out.println("Team :"+winners[k].name()+ " Wins: " + winners[k].wins());
  		writeToFile(TempVal);
  	}
  }

}
 public static void writeToFile(String text) {
                try {
                	
                        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("BracketandWinner.txt"), true));
                        bw.write(text);
                        bw.newLine();
                        bw.close();
                } catch (Exception e) {
                }
        }
public void ReadNCAA () {
        int countTeam = 0;
        int countRegion= 0;
        int countTotTeam =  0;
        try{
		Scanner reader = new Scanner(new File("ncaa2014.csv"));

		while (reader.hasNextLine()) {
			String next = reader.nextLine();
			// System.out.println(next);
			if (!(next.equals(""))){
				String[] values = next.split(",");
				if (values.length == 1)
					{
						// System.out.println("Values equals 1");
						String tval = values[0];

						nRegion[countRegion] = new Region(tval);  // store region name in region array
						countRegion ++;
						countTeam = 0;
					}else if (values.length > 1){
						// System.out.println("Values is greater than 1");
						double wpvalue = Double.parseDouble(values[2]);
						int tseed = Integer.parseInt(values[1]);
						tournTeams[countRegion-1][countTeam]=new Team(values[0], tseed, wpvalue); 
						nRegion[countRegion-1].addTeam(values[0]); //assign teams to array of Teams - first round
						winners[countTotTeam]=new Team(values[0], tseed, wpvalue);
						countTeam ++;
						countTotTeam ++;
					}
			}
		}
		// System.out.println(" Total No of teams: " + (tournTeams[0].length*tournTeams[0][0].length));
	} catch (FileNotFoundException e){
		System.err.println("FileNotFoundException: " + e.getMessage());
	}
	}
  // public int noRounds(){
  // 	int totalteams = tournTeams.length * tournTeams[0].length;
  // 	int teams_halved = totalteams;
  // 	int cntRounds=0;
  // 	while (teams_halved > 0){
  //    teams_halved=teams_halved/2;
  //    cntRounds++;
 	// }
 	// return cntRounds+1;  //determine how many rounds will be played.
  // }
  public String getRegionTeam(String teamname){
  	for (int i=0;i<nRegion.length;i++){
  		if (nRegion[i].checkTeam(teamname)){
  			return nRegion[i].name();
  		}
  	}
  	return "";
  }
}