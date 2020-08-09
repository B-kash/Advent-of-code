 public class Day4 {
 public static void main(String []args){
        int count = 0;
        for(int i = 234208 + 1 ; i < 765869; i++){
            boolean hasRepeat = false;
            boolean decreasing = false;
            String value = String.valueOf(i);
            for(int j = 0 ; j < value.length()-1; j++){
                int currentValue = Integer.parseInt(value.substring(j,j+1));
                int nextValue = Integer.parseInt(value.substring(j+1, j+2));
                if(currentValue == nextValue){
                    hasRepeat = true;
                }
                if(nextValue < currentValue){
                    decreasing = true;
                    break;
                }
            }
            if(!decreasing && hasRepeat){
                count++;
            }
        }
        System.out.println("count is "+ count);
    }
    }
