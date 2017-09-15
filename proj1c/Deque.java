public interface Deque<Item>{
	public void addFirst(Item x);
	public void addLast(Item x);
	public boolean isEmpty();
	public int size();
	public Item get(int i);
	public Item removeFirst();
	public Item removeLast();
	public void printDeque();
	//public void getRecursive(int i);
}