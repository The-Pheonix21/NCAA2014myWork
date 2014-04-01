import java.util.*;
public class Region {
	private ArrayList<String> tr = new ArrayList<String>();
	private String name;
	public Region(String name) {
		this.name =name;
	}
	public String name(){
		return name;
	}

	public void addTeam(String team){
		this.tr.add(team);
	}
	public boolean checkTeam(String team){
		if (tr.indexOf(team)==-1) {
			return false;
		}else{
			return true;
		}
	}
}