/*
* 有n个矩形，每个矩形可以用两个整数a,b描述，表示它的长和宽。
* 矩形X(a,b)可以嵌套在矩形Y(c,d)中当且仅当a<c,b<d,或者b<c,a<d(相当于把矩形X旋转90°)。
* 例如(1,5)可以嵌套在(6,2)内，但不能嵌套在(3,4)内。
* 你的任务是选出尽可能多的矩形排成一行。使得除了最后一个之外，每个矩形都可以嵌套在下一个矩形内。
*/


class NestedRectangle{
     class Rectangle{
         private final int width;
         private final int length;

         Rectangle(int width, int length){
         	this.width = width;
         	this.length = length;
         }

         int getWidth(){
         	return width;
         }
         int getLength(){
         	return length;
         }

         boolean canBeNestedBy(Rectangle another){
         	if(width < another.getWidth && length < another.getLength()){
         	    return true;
         	}
         	return false;
         }
     }

     public static List<Rectangle> getMostNestedRectangle(List<Rectangle> rectangleLst){
          int[][] matrix = buildDAG(rectangleLst);
          int[] numOfNestedRectangle = new int[rectangleLst.size()];
          for(int i = 0; i < rectangleLst.size(); ++i){
               numOfNestedRectangle[i] = 0;
          }
          for(int i = 0; i < rectangleLst.size(); ++i){
              for (int j = 0; j < rectangleLst.size(); ++j) {
                   
              }
          }
     }

     private static int[][] buildDAG(List<Rectangle> rectangleLst){
         int[][] matrix = new int[rectangleLst.size()][rectangleLst.size()];
         for(int i = 0; i < rectangleLst.size(); ++i){
         	for(int j = 0; j < rectangleLst.size(); ++j){
         	    matrix[i][j] = 0;
         	    if(rectangleLst.get(i).canBeNestedBy(rectangleLst.get(j))){
         	        matrix[i][j] = 1;
         	    }
         	}
         }
         return matrix;
     }
}