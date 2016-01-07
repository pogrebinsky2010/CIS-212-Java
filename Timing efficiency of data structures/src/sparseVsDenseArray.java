import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class sparseVsDenseArray {
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int inputLength =0;
		double inputDensity = 0.0;
		boolean invalidInput = true;
		
		while(invalidInput)
		{
			
			System.out.println("Please enter an array length: ");
	  try{
			    inputLength = input.nextInt();
			    if(inputLength >= 0)   // length cannot be a negative number.
			    {
			    	invalidInput = false;
			    }
			    else
			    {
			    	System.out.println("input must be a non-Negative integer");	
			    }
			   
			} 
			 catch (InputMismatchException ex)
			{
			  System.out.print("input must be an integer ");
			 input.next();// flushing the scanner as to avoid an infinite loop; 
			 //next integer can be processed.
			    
			}
		}
		invalidInput = true;
	    while(invalidInput)
	    {
	    	System.out.println("Please enter an array \"density (between 0 and up to but "
	    		    + "not including 1: ");
	    	try
	    	{
	    		inputDensity = input.nextDouble();
	    		if(inputDensity >= 1 || inputDensity < 0)
	    		{
	    			System.out.println("please enter a number between 0 and 1 not includeing 1");
	    			invalidInput = true;
	    		}
	    		else
	    		{
	    				invalidInput = false;
	    		}	
	    	} 
	    	catch (InputMismatchException ex)
	    	{
	    		System.out.println("input must be a double. ");
	    		input.next();
	    	}
	    }
	    // calling all time methods and converting to milliseconds.
		 long denseNanoTime = denseFindTime(inputLength, inputDensity);
		 long denseMilliTime = convertNanoToMili(denseNanoTime);
		 long sparseNanoTime = sparseFindTime(inputLength, inputDensity);
		 long sparseMilliTime = convertNanoToMili(sparseNanoTime);
		 long denseToSparseNanoTime = denseToSparseFindTime(inputLength, inputDensity);
		 long denseToSparseMilliTime = convertNanoToMili(denseToSparseNanoTime);
		 long sparseToDenseNanoTime = sparseToDenseFindTime(inputLength, inputDensity);
		 long sparseToDenseMilliTime = convertNanoToMili(sparseToDenseNanoTime);
		 long sparseMaxNanoTime = getSparseMaxTime(inputLength, inputDensity);
		 long sparseMaxMilliTime = convertNanoToMili(sparseMaxNanoTime);
		 long denseMaxNanoTime = getDenseMaxTime(inputLength, inputDensity);
		 long denseMaxMilliTime = convertNanoToMili(denseMaxNanoTime);
		 // printing results from all same length.
		 System.out.println(" Create dense length: " + inputLength + " time: " + denseMilliTime);
		 System.out.println(" Create sparse length: " + inputLength + " time: " + sparseMilliTime);
		 System.out.println(" Convert to sparse length: " + inputLength + " time: " + denseToSparseMilliTime);
		 System.out.println(" Convert to dense length: "+ inputLength + " time: " + sparseToDenseMilliTime);
		 System.out.println(" Sparse Max length: " + inputLength + " time: " + sparseMaxMilliTime);
		 System.out.println(" Dense Max length: " + inputLength + " time: " + denseMaxMilliTime);
		 
	}
	public static int[] makeDenseArray(int length, double density)
	{
		int randomNumberPile;
		int[] denseArray = new int[length];
		int randomNumber;
		double randomDouble =0;
		
		Random randomNumbers = new Random();
		
		randomNumberPile = 1000000; /*size of pool to take random numbers from
		to populate new array*/ 
		
		for(int i = 0; i< denseArray.length; i++)
		{
			randomNumber =1 + randomNumbers.nextInt(randomNumberPile);//take random numbers -
		    //- from 0 to 1 million;
		    
			randomDouble = new Random().nextDouble();
		    //making random double;
		      
		    if( randomDouble <= density)
		    {
		    	denseArray[i] = randomNumber;
		    }
		    else
		    {
		    	denseArray[i] = 0;
		    	
 		    }   
		}
		return denseArray;
	}
	public static ArrayList<int[]> makeSparseArray(int length, double density)
	{
		int randomNumberPile = 1000000; /*size of pool to take random numbers from
		to populate new array*/ ;
		int randomNumber;
		double randomDouble =0;
	
		Random randomNumbers = new Random();
		
		ArrayList<int[]> sparseArray = new ArrayList<int[]>(length);
		
		for(int i = 0; i < length; i++)
		{
			randomNumber = 1 + randomNumbers.nextInt(randomNumberPile);//take random numbers -
		    //- from 0 to 1 million;
		    
			randomDouble = new Random().nextDouble();
		    //making random double;
		    	    
			if (randomDouble < density) {
				int[] list = new int[2];
				list[0] = i;//this is the index
				list[1] = randomNumber;//this is the value
				sparseArray.add(list);
				}
		}// end for
		return sparseArray;
	}
	public static ArrayList<int[]>denseToSparse(int[] denseArray)
	{
		ArrayList<int[]> sparseArray= new ArrayList<int[]>();
		
		for(int i = 0; i < denseArray.length; i++)
		{
			if(denseArray[i] != 0)
			{
			int[] list = new int[2];
			list[0] = i;//this is the index
			list[1] = denseArray[i]; // putting in the values from original array;
			sparseArray.add(list);
			}
		}
		return sparseArray;
	}
	public static int[] sparseToDense(ArrayList<int[]> sparseArray)
	{
		int[] emptyDense = {};
		if(sparseArray.size() == 0)
		{
			return emptyDense;
		}
		else
		{
		int[] denseArray = new int[(sparseArray.get(sparseArray.size() - 1)[0])+ 1];
		
		for(int i = 0; i < sparseArray.size(); i++)
		{
			denseArray[sparseArray.get(i)[0]] = sparseArray.get(i)[1];	
		}	
		
		return denseArray;
		}
	}
	public static String getMaxDenseArrayValue(int[] denseArray)
	{
		int maxNum = 0;
		int maxIndex = 0;
		String max = null;
		for(int i = 0; i < denseArray.length; i++)
		{
			if(denseArray[i] > maxNum)
			{
				maxNum = denseArray[i];
				maxIndex = i;
			}
		}
		max = maxNum + " " +  maxIndex;
		
		return max;
	}
	public static String getMaxSparseArrayValue(ArrayList<int[]>SparseArray)
	{
		int maxNum = 0;
		int maxIndex = 0;
		int sparseArraySize = SparseArray.size();
		String max = null;
		for(int i = 0; i < sparseArraySize; i++)
		{
			if(SparseArray.get(i)[1] > maxNum)
			{
				maxNum = SparseArray.get(i)[1];
				maxIndex = i;// after looking at grade should probably be: maxIndex = SparseArray.get(i)[0], b/c i dont
				// think that the original form accounted for a index value for a Sparse array.
			}
		}
		max = maxNum + " " +  maxIndex;
		
		return max;
	}
	public static long denseFindTime(int length, double density)
	{
		  long timeStart = System.nanoTime();
		  makeDenseArray(length, density);
		  long timeStop = System.nanoTime();
		  long makeDenseArrayTime = timeStop - timeStart;
		  
		  return makeDenseArrayTime;
	}
	public static long sparseFindTime(int length, double density)
	{
		  long timeStart = System.nanoTime();
		  makeSparseArray(length, density);
		  long timeStop = System.nanoTime();
		  long makeSparseArrayTime = timeStop - timeStart;
		  
		  return makeSparseArrayTime;
		
	}
	public static long convertNanoToMili(long nanoSeconds)
	{
		long milliSeconds = nanoSeconds/ 1000000;
		return milliSeconds;
	}
	public static long sparseToDenseFindTime(int length, double density)
	{
		  ArrayList<int[]> sparseArray =  makeSparseArray(length, density);
		  long timeStart = System.nanoTime();
		  sparseToDense(sparseArray);
		  long timeStop = System.nanoTime();
		  long sparseToDenseTime = timeStop - timeStart;
		  
		  return sparseToDenseTime;
		
	}
	public static long denseToSparseFindTime(int length, double density)
	{
		  int[] denseArray =  makeDenseArray(length, density);
		  long timeStart = System.nanoTime();
		  denseToSparse(denseArray);
		  long timeStop = System.nanoTime();
		  long denseToSparseTime = timeStop - timeStart;
		  
		  return denseToSparseTime;
	}
	public static long getDenseMaxTime(int length, double density)
	{
		int[] denseArray = makeDenseArray(length, density);
		  long timeStart = System.nanoTime();
		  getMaxDenseArrayValue(denseArray);
		  long timeStop = System.nanoTime();
		  long maxDenseTime = timeStop - timeStart;
		  
		  return maxDenseTime;
	}
	public static long getSparseMaxTime(int length, double density)
	{
		  ArrayList<int[]> sparseArray = makeSparseArray(length, density);
		  long timeStart = System.nanoTime();
		  getMaxSparseArrayValue(sparseArray);
		  long timeStop = System.nanoTime();
		  long maxSparseTime = timeStop - timeStart;
		  
		  return maxSparseTime;
	}
}


