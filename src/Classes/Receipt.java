package Classes;

public class Receipt {
    public void printReceipt(MovieTicket ticket) {
        System.out.println();
        System.out.println();
        System.out.println("-------------[🧾영수증🧾]-------------");
        System.out.println("영화 이름: " + ticket.getSelectedMovie().getTitle());
        ticket.printSeats();
        System.out.println("-------------------------------------");
        System.out.println("🙏구메해 주셔서 감사합니다.🙏");
    }
}
