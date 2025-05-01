import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if("end".equals(line)) break;

            char[] board = line.toCharArray();

            int xCnt = 0, oCnt = 0;
            for (char c : board) {
                if(c == 'X') xCnt++;
                if(c == 'O') oCnt++;
            }

            if(oCnt > xCnt || xCnt >= oCnt + 2) {
                answer.append("invalid").append("\n");
                continue;
            }

            if(isValidBoard(board, xCnt, oCnt)) answer.append("valid").append("\n");
            else answer.append("invalid").append("\n");
        }

        System.out.println(answer);
    }

    public static boolean isValidBoard(char[] board, int xCnt, int oCnt) {
        String bingo = "";

        // 가로 빙고
        if(board[0] == board[1] && board[1] == board[2] && board[0] != '.') bingo += board[0];
        if(board[3] == board[4] && board[4] == board[5] && board[3] != '.') bingo += board[3];
        if(board[6] == board[7] && board[7] == board[8] && board[6] != '.') bingo += board[6];

        // 세로 빙고
        if(board[0] == board[3] && board[3] == board[6] && board[0] != '.') bingo += board[0];
        if(board[1] == board[4] && board[4] == board[7] && board[1] != '.') bingo += board[1];
        if(board[2] == board[5] && board[5] == board[8] && board[2] != '.') bingo += board[2];

        // 대각선 빙고
        if(board[0] == board[4] && board[4] == board[8] && board[0] != '.') bingo += board[0];
        if(board[2] == board[4] && board[4] == board[6] && board[2] != '.') bingo += board[2];

        int bingoCnt = bingo.length();
        if(bingoCnt == 0) return xCnt + oCnt == 9;
        else if(bingoCnt == 1) {
            if("X".equals(bingo) && xCnt != oCnt) return true;
            return "O".equals(bingo) && xCnt == oCnt;
        }
        else {
            char c1 = bingo.charAt(0);
            char c2 = bingo.charAt(1);
            return c1 != 'O' && c1 == c2;
        }
    }
}