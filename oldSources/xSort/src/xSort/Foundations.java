package xSort;

import java.awt.Color;
import java.util.Random;

public class Foundations {

	static int ArraySize;
	static int NumberSizes;
	
	public Foundations(int newArraySize, int newNumberSizes) {
		
		
		ArraySize = newArraySize;
		NumberSizes = newNumberSizes;
	
	}
	
	
	
	
	public int[] CreateNumberArray() {
		
		int[] arr = new int[ArraySize];
		
		for (int i = 0; i < arr.length; i++) {
			
			double randomNumber = Math.random() * NumberSizes + 1;
			arr[i] = (int) randomNumber;
	
			
		}
		
				
		return arr;
		
	}
	
	
	public Color[] CreateColorArray() {
		
		Random rand = new Random();
		Color[] arr = new Color[ArraySize];
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

			
		}
		
				
		return arr;
		
	}
	
	
}
