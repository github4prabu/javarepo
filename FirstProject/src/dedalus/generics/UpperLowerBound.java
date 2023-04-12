package dedalus.generics;

import java.util.*;

public class UpperLowerBound {

	//Integer is Lowerbound
	public static void addNumToList(List<? super Number> lblist)
	{
		for(int i=0;i<10;i++)
		{
			lblist.add(i);
		}
		System.out.println(lblist);
	}
	
	//Number is the Upperbound
	public static void smallNum(List<? extends Number> ublist)
	{
		double d =0;
		for(Number n : ublist)
		{
			d=d+n.doubleValue();
		}
		System.out.println(d);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Object> l1 = new ArrayList<Object>();
		addNumToList(l1);
		List<Number> l2 = new ArrayList<Number>();
		addNumToList(l2);

		List<Integer> a = Arrays.asList(1,2,3);
		smallNum(a);
		List<Double> b = Arrays.asList(1.1,2.1,3.1);
		smallNum(b);
	}

}
