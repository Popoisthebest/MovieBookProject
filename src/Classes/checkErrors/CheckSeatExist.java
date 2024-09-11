package Classes.checkErrors;

import java.util.Scanner;

public class CheckSeatExist {
    Scanner input = new Scanner(System.in);
    
    int seat;
    int seatsLength;
    
    public CheckSeatExist(int seatsLength) {
        this.seatsLength = seatsLength;
    }
    
    public void checkSeatNumExist() {
        try {
            seat = Integer.parseInt(input.next());
            
            // 존재하는 자리인지 검사
            if (!(seat >= 1 && seat <= seatsLength)) {
                System.out.print("존재하지 않는 자리입니다. 다시 자리를 선택해 주세요: ");
                checkSeatNumExist();
            }
        } catch (NumberFormatException e) {
            System.out.print("존재하지 않는 자리입니다. 다시 자리를 선택해 주세요: ");
            checkSeatNumExist();
        }
    }
    
    public int getSeat() {
        return seat;
    }
}
