package services;

import java.util.List;



public class MaxService{
	
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		
		
		if(list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		
		T max = list.get(0);
		for(T element : list) {
			
			if(max.compareTo(element)<0) {
				 max = element;
			}
		}
		return max;
		
	}
}



