import java.util.ArrayList;
import java.util.List;

public class Result {
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr){
        int res = Integer.MIN_VALUE;    //Sets the result to the Integers minimum value.
        int rowSize = arr.size();       //Row size.
        int columnSize = arr.get(0).size(); //Column size.

        /*
         * The row index is set to 0.
         * Then it will iterate the size row minus 2.
         * */
        for(int rowIndex = 0; rowIndex<rowSize-2; rowIndex++){
            /*
             * The column index is set to 0.
             * Then it will iterate the size of column minus 2.
             * */
            for(int columnIndex = 0; columnIndex<columnSize-2; columnIndex++){

                //This sums the hourglass.
                int sum = (arr.get(rowIndex).get(columnIndex)   //arr.get(0).get(0)
                        + arr.get(rowIndex).get(columnIndex+1)  //arr.get(0).get(1)
                        + arr.get(rowIndex).get(columnIndex+2)) //arr.get(0).get(2)
                        + (arr.get(rowIndex+1).get(columnIndex+1))//arr.get(1).get(1)
                        + (arr.get(rowIndex+2).get(columnIndex) //arr.get(2).get(0)
                        + arr.get(rowIndex+2).get(columnIndex+1))//arr.get(1).get(1)
                        + (arr.get(rowIndex+2).get(columnIndex+2));//arr.get(2).get(2)
                /*
                 *⬆This will make a shape of an hourglass such as:
                 * ◉ ◉ ◉
                 *   ◉
                 * ◉ ◉ ◉
                 * */

                //It will find the largest item and set result.
                res = Math.max(res, sum);

            }

        }

        return res;
    }
    public static void main(String[] args) {
        String list = """
                1 1 1 0 0 0
                0 1 0 0 0 0
                1 1 1 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 0
                0 0 0 0 0 0""";
        List<List<Integer>> arr = new ArrayList<>();

        String[] split = list.split("\n");

        for(int i = 0; i<list.split("\n").length; i++){

            String[] space = split[i].split("\\s");
            List<Integer> hold = new ArrayList<>();
            for (String s : space) {
                hold.add(Integer.parseInt(s));
            }
            if(!hold.isEmpty())
                arr.add(hold);

        }
        System.out.println(hourglassSum(arr));

    }
}
