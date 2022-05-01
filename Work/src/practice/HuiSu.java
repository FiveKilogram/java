package practice;


public class HuiSu {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean visited [] = new boolean[rows*cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(findPath(matrix,rows,i,cols,j,pathLength,visited,str)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean findPath(char[] matrix,int rows, int row, int cols, int col, int pathLength, boolean[] visited,char[] str){

//        if(pathLength==str.length){
//            return true;
//        }

        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[pathLength]&&visited[row*cols+col]==false){
            if(pathLength==str.length-1){
                return true;
            }

            pathLength++;
            visited[row*cols+col] = true;
            if(findPath(matrix, rows, row-1, cols, col,  pathLength, visited,str)
                    ||findPath(matrix, rows, row+1, cols, col,  pathLength, visited,str)
                    ||findPath(matrix, rows, row, cols, col-1,  pathLength, visited,str)
                    ||findPath(matrix, rows, row, cols, col+1,  pathLength, visited,str))
                return true;
            else {
                pathLength--;
                visited[row*cols+col] = false;
                return false;
            }

        }

        return false;
    }

}