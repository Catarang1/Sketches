import java.util.*;

/**
* Sketch of Collection where output of get and result of put methods
* are looping within bounds of defined capacity at instantiation.
*/

public class ArrayLoop<T>{
	
	private ArrayList<T> array;
	private int capacity;
	private int writePointer = 0;
	private int readPointer = 0;
	private boolean allowRewriteElements = true;
	private enum Pointer{Read, Write;}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("ArrayLoop // capacity: "+  capacity+"\n");
		string.append("Pointer position currently: read: "+readPointer + " write: "+ writePointer+"\n");
		string.append("Rewriting elements allowed: "+allowRewriteElements+"\n");
		return string.toString();
	}

	public ArrayLoop(int capacity) {
		this.capacity = capacity;
		array = new ArrayList<>(capacity);
	}
	
	public boolean put(T element) {
		if (array.size() < capacity) {
			array.add(element);
			return true;
		} else if (allowRewriteElements) {
			array.add(writePointer, element);
			writePointer++;
			checkPointers();
			return true;
		} else {
			return false;
		}
	}
	
	public T getNext() {
		if (readPointer > array.size() - 1) readPointer = 0;
		T element = array.get(readPointer);
		readPointer++;
		checkPointers();
		return element;
	}
	
	private void checkPointers() {
		if (writePointer > capacity) writePointer = 0;
		if (readPointer > capacity) readPointer = 0;
	}
	
	public void levelPointersTo(Pointer p) {
		if (p == Pointer.Read) writePointer = readPointer;
		if (p == Pointer.Write) readPointer = writePointer;
	}
	
	public void levelPointersTo(int p) {
		if (p > capacity) return;
		writePointer = p;
		readPointer = p;
	}
	
	
	

}
