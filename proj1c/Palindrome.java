public class Palindrome{
	public static Deque<Character> wordToDeque(String word){
		Deque<Character> chars = new LinkedListDequeSolution<Character>();
		int L = word.length();
		for(int i = 0;i < L;i++){
			chars.addLast(word.charAt(i));
		}
		return chars;
	}
	public static boolean isPalindrome(String word){
		return isPalindromeHelper(word,0,word.length()-1);
	}
	public static boolean isPalindromeHelper(String word,int f, int l){
		if((l-f)<1){
			return true;
		}
		else if(word.charAt(f)==word.charAt(l)){
			return isPalindromeHelper(word, f+1, l-1);
		}
		else{
			return false;
		}
	}

	public static boolean isPalindrome(String word, CharacterComparator cc){
		return isPalindromeHelper(word,0,word.length()-1,cc);
	}

	public static boolean isPalindromeHelper(String word,int f,int l,CharacterComparator cc){
		if((l-f)<1)
			return true;
		else if(cc.equalChars(word.charAt(f),word.charAt(l))){
			return isPalindromeHelper(word,f+1,l-1,cc);
		}
		else return false;
	}
}