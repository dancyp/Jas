public class OffByN implements CharacterComparator{
	int n;
	public OffByN(int N){
		this.n = N;
	}
	public boolean equalChars(char a, char b){
		if((a-b)==n) return true;
		else return false;
	}
}