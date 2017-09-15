public class ArrayDeque<Item>{
	private Item[] items;
	private int size;

	private static int RFactor = 2;

	public ArrayDeque(){
		items = (Item []) new Object[8];
		size = 0;
	}
	public int getReservedMemLength(){
		return items.length;
	}
	private void resizeInflate(){
		
		Item[] a = (Item []) new Object[size*RFactor];
		System.arraycopy(items,0,a,0,size);
		items = a;

	}
	private void resizeCollapse(){
		Item[] a = (Item []) new Object[items.length/RFactor];
		System.arraycopy(items,0,a,0,size);
		items = a;
	}

	public void addFirst(Item x){
		if(size == items.length){
			resizeInflate();
		}
		for(int i = size; i > 0; i--){
			items[i] = items[i-1];
		}
		items[0] = x;
		size = size + 1;
	}

	public void addLast(Item x){
		if(size == items.length){
			resizeInflate();
		}
		items[size] = x;
		size = size + 1;
	}

	public boolean isEmpty(){
		return (size==0);
	}
	public int size(){
		return size;
	}
	public void printDeque(){
		for(int i = 0;i < size; i++){
			System.out.print(get(i)+" ");
		}
		System.out.println();
	}
	public Item removeFirst(){
		if(isEmpty()==true) return null;
		if(size-1<items.length/4 && items.length>15){
			resizeCollapse();
		}
		Item temp = items[0];
		for(int i = 0;i<size;i++){
			items[i] = items[i+1];
		}
		size = size - 1;
		return temp;
	}
	public Item removeLast(){
		if(isEmpty()==true) return null;
		if(size-1<items.length/4 && items.length>15){
			resizeCollapse();
		}
		Item temp = items[size-1];
		items[size-1] = null;
		size = size - 1;
		return temp;
	}
	public Item get(int index){
		return items[index];
	}

}