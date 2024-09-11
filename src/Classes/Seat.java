package Classes;

public class Seat {
    private final int seatNumber;
    private boolean isBooked;
    
    // Seat 클래스의 기본 생성자
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }
    
    // 예약된 자리의 기본 매소드
    public boolean isBooked() {
        return isBooked;
    }
    
    // 예약된 자리를 표시할 때
    public void bookSeat() {
        this.isBooked = true;
    }
    
    // 자리 번호 getter
    public int getSeatNumber() {
        return seatNumber;
    }
}
