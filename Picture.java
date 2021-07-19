import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** GIVEN: Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  /**WRITEN: Method to set the red and green to 0 */
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj: rowArray)
		  {
	//written close to the zeroBlue method, but set the other two colors to 0		  
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  /**WRITTEN: Method to get rid of all of the color */
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj: rowArray)
		  {
   //get rid of all of the color that is in the picture
			  pixelObj.setRed(255- pixelObj.getRed());
   //use the pixelObject to get the orginal green color
			  pixelObj.setGreen(255- pixelObj.getGreen());
			  pixelObj.setBlue(255-pixelObj.getBlue());
		  }
	  }
  }
  /** Method to set the color to gray*/
  public void grayScale()
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj: rowArray)
		  {
			  //use the pixelObject to get all of the colors and divide them by three to make
			  //the normal color
			  pixelObj.setRed((pixelObj.getRed()+pixelObj.getRed()+pixelObj.getRed())/3);
			  pixelObj.setGreen((pixelObj.getRed()+pixelObj.getRed()+pixelObj.getRed())/3);
			  pixelObj.setBlue((pixelObj.getRed()+pixelObj.getRed()+pixelObj.getRed())/3);
		  }
	  }
  }
  /** BONUS: Method to see the fishes better*/
 public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D(); 
	  for(Pixel[] rowArray : pixels)
	  {
		  for(Pixel pixelObj: rowArray)
		  {
			  //honestly just used random numbers until I could see the fish more
			  //didn't want to add more blue bc that would make it harder to see
			  pixelObj.setRed(124+pixelObj.getRed());
			  pixelObj.setGreen(pixelObj.getGreen()-15);
		  }
	  }
	  
  }
  
  /**GIVEN: Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /**WRITTEN: Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from right to left instead of left to right */
  public void  mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width/2; col < 640; col++)
      {
    	//flip the picture 639 degrees in the col
    	//this will make it go right to left
        leftPixel = pixels[row][640-1-col];
        rightPixel = pixels[row][col];
       leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  /**WRITTEN: Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from left to right */
  public void  mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
    //flip the row and column values from the mirrorVertical
      for (int col = 0; col < width; col++) 
      {
       topPixel = pixels[row][col];
        bottomPixel = pixels[pixels.length-row-1][col];
       bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  /**WRITTEN: Method that  mirrors the picture around a mirror
placed horizontally from bottom to top */ 
  public void  mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width; col++) 
      {
       topPixel = pixels[row][col];
        bottomPixel = pixels[pixels.length-row-1][col];
       //set the color from the bottomPixel 
       topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  /** WRITTEN: Method that mirrors the picture around the snowman
   * the picture has four arms */
  public void  mirrorArms()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 165; row < 200; row++)
    {
      for (int col = 100; col < 300; col++) 
      {
       topPixel = pixels[row][col];
      //flip the picture from top to bottom using the width and the row values 
      //keeping the column value the same
        bottomPixel = pixels[300 + 100 -row-1][col];
       bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  /**WRITTEN: Method that mirrors the picture around the seagulls so there are
   * two seagulls next to each other */
  public void  mirrorGulls()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    int width = pixels[0].length;
    for (int row = 215; row < 325; row++)
    {
      for (int col = 220; col < 340; col++) 
      {
      leftPixel = pixels[row][col];
        rightPixel = pixels[row][width + 50-col];
       rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
 
 
  
  /**GIVEN: Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**GIVEN: copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
//WRITTEN: second copy methods
  public void copy(Picture fromPicture, int startRow, int startColum, int endColum, int endRow)
  {
	  	Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPicture.getPixels2D();
	    //added a few more paremters to make the copying method easier
	    for (int fromRow = 0, toRow = startRow; fromRow < endRow && toRow <toPixels.length; fromRow++, toRow++)
	    {
	      for (int fromColum = 0, toColum = startColum; fromColum  < endColum && toColum <toPixels[0].length; fromColum++, toColum++)
	      {
	        fromPixel = fromPixels[fromRow][fromColum];
	        toPixel = toPixels[toRow][toColum];
	        toPixel.setColor(fromPixel.getColor());
	      }
	    }  
  }
  /** GIVEN: Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
 //WRITTEN: Method to create a new college with fun photos from Greece
  public void myCollage()
  {
    Picture temple = new Picture("temple.jpg");
    Picture water = new Picture("barbaraS.jpg");
    Picture robot = new Picture("robot.jpg");
    this.copy(temple,0,0);
  //I liked the way the collage looked so I kept it 
    this.copy(water,100,0);
    Picture waterGrayScale = new Picture(water);
    water.grayScale();
    this.copy(waterGrayScale,100,0);
    this.copy(robot,200,0);
    this.copy(temple,200,0);
  //made a placed horizontally
    this.mirrorHorizontal();
    this.write("mycollage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
 //Method to make another edge distance
  public void secondEdgeDetection(int edgeDist)
  {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
   //used top and bottom pixels instead of left and right pixels
    	topPixel = pixels[row][col];
        bottomPixel = pixels[row+1][col];
        if (topPixel.colorDistance(bottomPixel.getColor()) > 
            edgeDist)
        	topPixel.setColor(Color.BLACK);
        else
         topPixel.setColor(Color.WHITE);
      }
    }
  }
 //new random edge dectection
  public void anotherEdgeDectection(int edgeDist)
  {
	  //wrote something fun i didn't test it though
	  this.grayScale();
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
 //new photo run in the main method
  public static void main(String[] args) 
  {
    Picture beach = new Picture("myPicture.jpg");;
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }


  
} // this } is the end of class Picture, put all new methods before this
