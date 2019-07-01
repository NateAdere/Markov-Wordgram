
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Natnael Adere
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = "";
		myHash = 5;
		
		for(int k = start; k < source.length; k++) {
			if (myWords[myWords.length - 1] != null) {
		          break;
		     }
			int nk = k-start;
			myWords[nk] = source[k];
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return the number of words that are not null values in myWords
	 */
	public int length(){
		int num = 0;
		for (int k = 0; k < myWords.length; k++) {
			if (myWords[k] != null) {
				num += 1;
			}
		}
		return num;
	}


	@Override
	public boolean equals(Object o) {
		boolean ans = false;
		if (! (o instanceof WordGram) || o == null){
			ans = false;
		}
		if (o instanceof WordGram) {
			
			WordGram wg = (WordGram) o;
			if (this.myWords.length == wg.myWords.length) {
				for (int k = 0; k < this.myWords.length; k += 1) {
					if(this.myWords[k].equals(wg.myWords[k])) {
						ans = true;
					}
					else {
						ans = false;
					}
				}
			}

		}

	    // TODO: 
		return ans;
	}

	@Override
	public int hashCode(){
		myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return A new WordGram object with k entries (where k is the order of this WordGram) 
	 * whose first k-1 entries are the same as the last k-1 entries of this WordGram, 
	 * and whose last entry is the parameter last. 
	 */
	public WordGram shiftAdd(String last) {
		int newsize = myWords.length + 1;
		int newstart = 1;
		String[] a = new String[newsize];
		for (int k = 0; k < myWords.length; k++) {
			a[k] = myWords[k];
		}
		a[a.length -1] = last;
		WordGram wg = new WordGram(a,newstart,myWords.length);
			
		return wg;
	}

	@Override
	public String toString(){
		String myToString = String.join(" ", myWords);	
		return myToString;
	}
}
