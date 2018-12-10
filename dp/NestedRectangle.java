/*
* 有n个矩形，每个矩形可以用两个整数a,b描述，表示它的长和宽。
* 矩形X(a,b)可以嵌套在矩形Y(c,d)中当且仅当a<c,b<d,或者b<c,a<d(相当于把矩形X旋转90°)。
* 例如(1,5)可以嵌套在(6,2)内，但不能嵌套在(3,4)内。
* 你的任务是选出尽可能多的矩形排成一行。使得除了最后一个之外，每个矩形都可以嵌套在下一个矩形内。
输入：

10
1 2
2 4
5 8
6 10
7 9
3 1
5 8
12 10
9 7
2 2
输出：  
5
*/
import java.util.*;

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
      if((width < another.getWidth() && length < another.getLength()) ||
        (width < another.getLength() && length < another.getWidth())){
        return true;
      }
      return false;
    }
  }

  Rectangle getRectangle(int width, int length){
    return new Rectangle(width, length);
  }

  static int getMostNestedRectangle(List<Rectangle> rectangleLst){
    int[][] matrix = new int[rectangleLst.size()][rectangleLst.size()];
    buildDAG(rectangleLst, matrix);

    boolean[] visited = new boolean[rectangleLst.size()];
    int[] numOfNestedRectangle = new int[rectangleLst.size()];
    for(int i = 0; i < rectangleLst.size(); ++i){
      numOfNestedRectangle[i] = 0;
      visited[i] = false;
    }

    visitDAG(matrix, visited, numOfNestedRectangle);
    int max = 0;
    for(int i = 0; i < rectangleLst.size(); ++i){
      max = numOfNestedRectangle[i] < max ? max : numOfNestedRectangle[i];
    }
    return max;
  }

  static void buildDAG(List<Rectangle> rectangleLst, int[][] matrix){
    for(int i = 0; i < rectangleLst.size(); ++i){
     	for(int j = 0; j < rectangleLst.size(); ++j){
     	  matrix[i][j] = 0;
     	  if(rectangleLst.get(i).canBeNestedBy(rectangleLst.get(j))){
     	    matrix[i][j] = 1;
     	  }
     	}
    }
  }

  private static void visitDAG(int[][] matrix, boolean[] visited, int[] numOfNestedRectangle){
    for(int i = 0; i < matrix.length; ++i){
      visit(matrix, visited, numOfNestedRectangle, i);
    }
  }

  private static void visit(int[][] matrix, boolean[] visited, int[] numOfNestedRectangle, int row){
    if(!visited[row]){
      visited[row] = true;
      int max = 0;
      for (int j = 0; j < matrix.length; ++j) {
        if(matrix[row][j] == 1){
          visit(matrix, visited, numOfNestedRectangle, j);
          max = numOfNestedRectangle[j] < max ? max : numOfNestedRectangle[j];
        }
      }
      numOfNestedRectangle[row] = max + 1;
    }
  }

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of rectangles : ");
    String nStr = sc.nextLine();
    
    NestedRectangle nestedRectangle = new NestedRectangle();
    List<Rectangle> lst = new ArrayList<Rectangle>();
    for(int n = Integer.valueOf(nStr); n > 0; --n){
      String[] strs = sc.nextLine().split(" ");
      int length = Integer.valueOf(strs[0]);
      int width = Integer.valueOf(strs[1]);
      NestedRectangle.Rectangle r = nestedRectangle.getRectangle(width,length);
      lst.add(r);
    }
    System.out.println("Input finished, please wait...");
    int max = NestedRectangle.getMostNestedRectangle(lst);
    System.out.println(max);
  }
}