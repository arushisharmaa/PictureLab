/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /** Method to test grayScale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }
  
  /** Method to test fixUnderWater */
  public static void testFixUnderWater()
  {
	  Picture beach = new Picture("water.jpg");
	    beach.explore();
	    beach.fixUnderwater();
	    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  /** Method to test mirrorVerticalRighttoLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture motor = new Picture("redMotorcycle.jpg");
    motor.explore();
    motor.mirrorVerticalRightToLeft();
    motor.explore();
  }
  /** Method to test mirroHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture motor = new Picture("redMotorcycle.jpg");
    motor.explore();
    motor.mirrorHorizontal();
    motor.explore();
  }
  /** Method to test mirrorBotToTheTop*/
  public static void testMirrorBotToTop()
  {
    Picture motor = new Picture("redMotorcycle.jpg");
    motor.explore();
    motor.mirrorHorizontalBotToTop();
    motor.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture temple = new Picture("snowman.jpg");
    temple.explore();
    temple.mirrorArms();
    temple.explore();
  }
  /** Method to test mirrorGulls */
  public static void testMirrorGulls()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorGulls();
    temple.explore();
  }
   
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test myCollage */
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  /** Method to test anotheredgeDetection */
  public static void testSecondEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.secondEdgeDetection(20);
    swan.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testNegate();
    //testGrayscale();
    testFixUnderWater();
    //testMirrorVertical();
    testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    testMirrorGulls();
    //testMirrorDiagonal();
    //testCollage();
    testMyCollage();
    //testCopy();
    //testEdgeDetection();
    //testSecondEdgeDetection();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}