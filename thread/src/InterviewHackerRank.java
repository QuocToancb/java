import java.util.ArrayList;
import java.util.List;

public class InterviewHackerRank {
    public static void main(String[] args) {
        print(7);

    }

    static private void print(int numOfLine){

        int currentloop = 0;

        List<Integer> currentList = new ArrayList<>();
        currentList.add(1);

        List<Integer> nextList = new ArrayList<>();

        System.out.println(currentList);
        while(currentloop < numOfLine) {
            int count = 0;
            int currentValue = currentList.get(0);
            for (int i = 0; i < currentList.size(); i++) {

                int item = currentList.get(i);
                if(currentValue == item){
                    count++;
                    if(i == currentList.size() -1){
                        nextList.add(count);
                        nextList.add(currentValue);
                    }
                } else {
                    nextList.add(count);
                    nextList.add(currentValue);
                    currentValue = item;
                    count = 1;

                    if(i == currentList.size() -1){
                        nextList.add(count);
                        nextList.add(currentValue);
                    }
                }
            }

            System.out.println(nextList);

            currentList = nextList;
            nextList = new ArrayList<>();
            currentloop++;
        }
    }
}
//Cho input X là 1 số integer, thể hiện số dòng cần in ra
//Cho Dòng 1 mặc định là 1.

//In ra X dòng tiếp theo theo quy luật
// dòng dưới thể hiện số lần hiển thị liên tiếp của một giá trị ở dòng trên.

//Ví dụ.
//Dong 1 [ 1 ]
//Dong 2 [ 1 1]  (Số 1 hiển thị liên tiếp 1 lần)
//Dòng 3 [ 2 1]  (Số 1 hiển thị liên tiếp 2 lần)
//Dòng 4 [ 1 2 1 1]  (Số 2 hiển thị liên tiếp 1 lần, số 1 hiển thị liên tiếp 1 lần)
//.......


//Đáp án
//        1
//        1 1
//        2 1
//        1 2 1 1
//        1 1 1 2 2 1
//        3 1 2 2 1 1
//...