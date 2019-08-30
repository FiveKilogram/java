package practice;

public class YueSefu {
    public static void main(String[] args) {
        boolean array[] = new boolean[500];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }

        int index = 0;
        int count = 0;
        int left = array.length;
        while (left>1){

           if(array[index]){
               count++;
               if(count==3){
                   count = 0;
                   array[index] = false;
                   left--;
               }
           }
            index++;
            if(index==array.length){
                index = 0;
            }

        }

        for (int i = 0; i < array.length; i++) {
            if(array[i]){
                System.out.println(i);
            }

        }

    }
}
