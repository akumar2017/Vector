import java.util.Iterator;

public class Vector<E> implements Iterable<E>
{
	private Object[] data;

	private int capacity;

	private int size;

	public Vector()
	{
		this(10);
	}

	public Vector(int initCapacity)
	{
		if(initCapacity <= 0)
			throw new IllegalArgumentException("Initial capacity cannot be less than or equal to zero:" + initCapacity);
		data = new Object[initCapacity];
		capacity = initCapacity;
		size = 0;
	}

	public Vector(Vector<E> other)
	{
		if(other == null)
			throw new IllegalArgumentException("cannot copy an empty vector");
		data = new Object[other.size()];
		for(int i = 0; i <other.size(); i++)
		{
			data[i] = other.get(i);
		}
		capacity = data.length;
		size = other.size();
	}

	public void add(E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		data[size] = toAdd;
		size++;
	}

	public void add(int index, E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		if((index > size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to add a value to position " + index + ", but the size of array is " + size);
		size++;
		for(int i = index; i < size; i++)
		{
			E temp = get.(i);
			data[i] = toAdd;
			toAdd = temp;
		}
	}

	private void increaseCapacity()
	{
		Object[] temp = data;
		data = new Object[capacity * 2];
		for(int i = 0; i < temp.length; i++)
		{
			data[i] = temp[i];
		}
		capacity = data.length;
	}

	public String toString()
	{
		String s = "";
		for(int i = 0; i < size; i++)
		{
			s += "[" + data[i] + ']' + " ";
		}
		return s;
	}
}