package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Gen {
	private List<List<Integer>> gen;
	
	public Gen(Sudokux sudo) {
		gen=generarFormato(sudo);
	}
	public Gen(Gen other) {
		gen=other.copy().getGen();
	}
	private Gen (List<List<Integer>> genCopy) {
		gen=genCopy;
	}
	private List<List<Integer>> generarFormato(Sudokux sudo) {
		int fil=0;
		int[] completo=sudo.getPuzzle();
		List<List<Integer>> sol=new ArrayList<>();
		sol.add(new ArrayList<>());
		for(int i=0; i<Sudokux.getBoardSize();i++) {
			if(i%9==0 && i!=0) {
				fil++;
				sol.add(new ArrayList<>());
			}
			if(completo[i]==0) {
				sol.get(fil).add(0);
			}	
		}
		//System.out.print(sol.toString());
		return sol;
	}
	public Gen copy() {
		List<List<Integer>> genCopy=new ArrayList<>();
		for(int f=0; f<gen.size();f++) {
			genCopy.add(new ArrayList<>());
			for(int c=0; c<gen.get(f).size();c++) {
				genCopy.get(f).add(gen.get(f).get(c));
			}
		}
		return new Gen(genCopy);
	}
	public List<List<Integer>> getGen() {
		return gen;
	}
	public Integer get(int f, int c) {
		return gen.get(f).get(c);
	}
	@Override
	public String toString() {
		return gen.toString();
	}
	
}
