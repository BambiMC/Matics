package algorithms;

import java.awt.Color;
import java.awt.Frame;

public class Algs implements Runnable{
	
	
	static int[] arr1; 
	static Color[] arr2; 
	static Frame f;
	static int timeDelay;
	
	
	public Algs(int[] arr1, Color[] arr2, Frame f, int newTimeDelay) {
		
		Algs.arr1 = arr1;
		Algs.arr2 = arr2;
		Algs.f = f;
		Algs.timeDelay = newTimeDelay;
		
		
	}
	
	
	

	public static void InsertionSort() throws InterruptedException {
		
		int j = 1;
		int i = 1;
		
		int temp1;
		Color temp2;
		
		while (i < arr1.length) {
			
			j = i;
			
			while (j > 0 && arr1[j-1] > arr1[j]) {
				
				
				temp1 = arr1[j];
				temp2 = arr2[j];
				
				arr1[j] = arr1[j-1];
				arr2[j] = arr2[j-1];
				
				
				arr1[j-1] = temp1;
				arr2[j-1] = temp2;
				
				j--;
				
			}
			
			
			i++;
			
			
			f.repaint();
			Thread.sleep(timeDelay);
					
		}
		
		
		
		
	}

	public static void SelectionSort() {
		
		

		int i,j;

		int n; 


		

		

		for (j = 0; j < n-1; j++)

		{

		    


		    

		    int iMin = j;

		    

		    for (i = j+1; i < n; i++)

		    {

		        

		        if (a[i] < a[iMin])

		        {

		            iMin = i;
		        }
		    }

		    if (iMin != j) 

		    {
		        swap(a[j], a[iMin]);
		    }
		}
	}
	
	
	
	@Override
	public void run() {
		
		try {
			InsertionSort();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
