package Classes.SelectOther;

import Classes.MovieTicket;
import Classes.Receipt;
import Classes.checkErrors.CheckSeatExist;


import java.util.Scanner;

public class SelectOtherSeats {
    Scanner input = new Scanner(System.in);
    
    MovieTicket ticket;
    int seatsLength;
    boolean flag;
    
    CheckSeatExist checkSeatExist = new CheckSeatExist(seatsLength);
    Receipt receipt = new Receipt();
    
    public SelectOtherSeats(MovieTicket ticket, int seatsLength) {
        this.ticket = ticket;
        this.seatsLength = seatsLength;
    }
    
    public void otherSeat() {
        System.out.print("자리를 추가로 선택하시겠습니까?(y/n): ");
        
        char addSeat = input.next().charAt(0);
        
        if (addSeat == 'y') {
            flag = true;
            System.out.print("원하시는 자리의 번호를 선택해 주세요: ");
        } else if (addSeat == 'n') {
            flag = false;
            receipt.printReceipt(ticket);
        } else {
            System.out.print("다시 입력해 주세요: ");
            otherSeat();
        }
    }
    
    public boolean getOtherSeatFlag() {
        return flag;
    }
}
