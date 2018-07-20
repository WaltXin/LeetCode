package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class J118_Pascals_Triangle {
    //pascal's triangle
	/*{
	 *     [1]
	 *   [1][1]
	 *  [1][2][1]
	 * [1][3][3][1]
	 *[1][4][6][4][1]
	 *
	 }*/
    public List<List<Integer>> generate(int numRows) {

        //n rows
        //ignore 1 and 2 first or n < 1;
        //n >= 3
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> dynamicList = new ArrayList<Integer>();
        if (numRows < 1) {
            return resList;
        }
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                resList.add(list);
            }
            if (i == 2) {
                dynamicList.add(1);
                dynamicList.add(1);
                resList.add(dynamicList);
            }
            if (i >= 3) {
                List<Integer> list = new ArrayList<Integer>();
                //get up level list
                list.add(1);
                for (int j = 1; j < dynamicList.size(); j++) {
                    int val = dynamicList.get(j - 1) + dynamicList.get(j);
                    list.add(val);
                }
                list.add(1);
                resList.add(list);
                dynamicList = list;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new J118_Pascals_Triangle().generate(5);
        System.out.println();
    }
}
