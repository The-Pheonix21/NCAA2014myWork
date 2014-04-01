import java.util.*;
import java.io.*;
public class Game {
private Team team1;
private Team team2;
private int winnerIndex;
	public Game(Team team1,Team team2){
		this.team1 = team1;
		this.team2 = team2;
		this.winnerIndex = calcwinner();
	}
	public int winnerIndex(){
		return winnerIndex;
	}
	public int calcwinner(){
		double wincalc;
		double winrand;
		wincalc = (this.team1.wp()-(this.team1.wp()*this.team2.wp()))/(this.team1.wp()+this.team2.wp()-(2.*this.team1.wp()*this.team2.wp()));
		winrand = Math.random();
		if (winrand <= wincalc) {
			return 1;
		}else{
		return 2;
		}
	}
}