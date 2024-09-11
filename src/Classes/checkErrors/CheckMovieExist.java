package Classes.checkErrors;

import java.util.Scanner;

public class CheckMovieExist {
    Scanner input = new Scanner(System.in);
    
    int moviesLength;
    int movieChoice;
    
    public CheckMovieExist(int moviesLength) {
        this.moviesLength = moviesLength;
    }
    
    // 존재하는 영화 번호인지 확인
    public void checkMovieNumExist() {
        try {
            movieChoice = Integer.parseInt(input.next()); // 문자를 int로 변환
            
            if (!(movieChoice >= 1 && movieChoice <= moviesLength)) {
                System.out.print("존재하는 영화 번호를 선택해 주세요: ");
                checkMovieNumExist();
            }
        } catch (NumberFormatException e) {
            System.out.print("존재하는 영화 번호를 선택해 주세요: ");
            checkMovieNumExist();
        }
    }
    
    
    
    public int getSelectedMovie() {
        return movieChoice - 1;
    }
}
