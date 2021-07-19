public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
  /**
   * print the number of times "number1" are inside the matrix
   */
  public int getCount(int number1)
  {
	  int numCols = matrix[0].length;
	    int count = 0;
	    for (int row = 0; row < matrix.length; row++)
	    {
	      for (int col = 0; col < numCols; col++)
	      {
	    	if(matrix[row][col]== number1) {
	        count++;
	      }
	    }
	    }
	    return count;
	  
  }
  /**
   * print the largest value inside the matrix
   */
  public int getLargest()
  {
	  int largestValue = Integer.MIN_VALUE;
	  
	 for(int i=0; i<matrix.length; i++)
	  {
		  for(int k=0; k< matrix[i].length; k++)
		  {
			  if(matrix[i][k]> largestValue)
			  {
				  largestValue = matrix[i][k];
			  }
		  }
	  }
	 return largestValue;
  }
  
  /**
   * print the total values for the columns in the matrix
   */
  public int getColTotal(int columNum)
  {
	  int columTotal = 0; 
	  for(int i=0; i<matrix.length; i++)
	  {
		  columTotal += matrix[i][columNum];
	  }
	  return columTotal; 
  }
  }
 
 
