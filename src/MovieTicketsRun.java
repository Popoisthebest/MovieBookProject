import Classes.MovieModel;
import Classes.MovieTicket;
import Classes.Receipt;
import Classes.SelectOther.SelectOtherSeats;
import Classes.checkErrors.CheckMovieExist;
import Classes.checkErrors.CheckSeatExist;
import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class MovieTicketsRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 영화 목록 생성
        MovieModel[] movies = {new MovieModel("듄"), new MovieModel("아바타"), new MovieModel("기생충")};
        
        // 환영 인사
        System.out.println("👋영화 예메 프로그램에 오신것을 환영합니다.👋");
        
        // 영화 선택
        for (int i = 1; i < movies.length + 1; i++) {
            System.out.println("[" + i + "]" + " " + movies[i - 1].getTitle()); // MovieMedel클레스에서 getMovie를 통해 위에서 설정된 영화를 받아옴.
        }
        System.out.print("🍿원하시는 영화의 숫자를 선택해 주세요: ");
        
        // 존재하는 영화의 번호인지 검사
        CheckMovieExist checkMovieExist = new CheckMovieExist(movies.length); // CheckMovieExist생성자
        
        checkMovieExist.checkMovieNumExist(); // 존재하는 영화 번호인지 검사
        MovieModel selectedMovie = movies[checkMovieExist.getSelectedMovie()]; // 선택한 영화 지정
        
        // 영화 티켓 객체 생성
        MovieTicket ticket = new MovieTicket(selectedMovie, 30);
        
        System.out.println("🍿" + ticket.getSelectedMovie().getTitle() +"(이)가 선택되었습니다.");
        
        // 좌석 선택 및 예약
        CheckSeatExist checkSeatExist = new CheckSeatExist(ticket.getSeats());
        
        ticket.printSeats();
        System.out.print("원하시는 좌석의 번호를 선택해 주세요: ");
        checkSeatExist.checkSeatNumExist();
        ticket.bookSeat(checkSeatExist.getSeat());
        
        // 추가 자리 선택 여부
        SelectOtherSeats selectOtherSeats = new SelectOtherSeats(ticket, ticket.getSeats());
        selectOtherSeats.otherSeat();
        
        // 중복자리일때
        do {
            checkSeatExist.checkSeatNumExist();
            ticket.bookSeat(checkSeatExist.getSeat());
            ticket.printSeats();
        } while (ticket.getBookedSeat());
        
        // 최종 추가 자리 여부
        do {
            selectOtherSeats.otherSeat();
            checkSeatExist.checkSeatNumExist();
            ticket.bookSeat(checkSeatExist.getSeat());
            ticket.printSeats();
        } while (selectOtherSeats.getOtherSeatFlag());
        
        // 영수증 출력
        Receipt receipt = new Receipt();
        receipt.printReceipt(ticket);
        
        input.close();
    }
}
