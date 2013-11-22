package tic_tac_toe_minmax;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mahfuz
 */
class game {
    
    int tic[][] = new int[10][10];
    int rec[][] = new int[10][10];
    int k = 0;
    int count = 0;
    int score = 0;
    int best_score = 5;
    int u = 2222, v = 2222;
    int flag[][] = new int[20][20];
    int fu,fa;
    ArrayList x = new ArrayList();
    
    public game() {
        run();
    }
    
    private void run() {
        int i;
        while (!game_end()) {
            human_move();
            copy();
            computer_move();
            //break;
            //while(!x.isEmpty())
                //System.out.println("best move " + x);

        }
        
        for (i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tic[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    private boolean game_end() {
        if (pc_win(tic) || human_win(tic) || board_finish(tic)) {
            if (pc_win(tic)) {
                System.out.println("PC WIN");
            } else if (human_win(tic)) {
                System.out.println("HUMAN WIN");
            } else if (board_finish(tic)) {
                System.out.println("DRAW");
            }
            return true;
        } else {
            return false;
        }
    }
    
    private boolean pc_win(int tic[][]) {
        
        if (tic[0][0] == 1 && tic[1][1] == 1 && tic[2][2] == 1) {
            return true;
        }
        if (tic[0][2] == 1 && tic[1][1] == 1 && tic[2][0] == 1) {
            return true;
        }
        if (tic[0][1] == 1 && tic[1][1] == 1 && tic[2][1] == 1) {
            return true;
        }
        if (tic[1][0] == 1 && tic[1][1] == 1 && tic[1][2] == 1) {
            return true;
        }
        
        if (tic[0][0] == 1 && tic[0][1] == 1 && tic[0][2] == 1) {
            return true;
        }
        if (tic[0][0] == 1 && tic[1][0] == 1 && tic[2][0] == 1) {
            return true;
        }
        if (tic[0][2] == 1 && tic[1][2] == 1 && tic[2][2] == 1) {
            return true;
        }
        if (tic[2][0] == 1 && tic[2][1] == 1 && tic[2][2] == 1) {
            return true;
        }
        return false;
    }
    
    private boolean human_win(int tic[][]) {
        if (tic[0][0] == 2 && tic[1][1] == 2 && tic[2][2] == 2) {
            return true;
        }
        if (tic[0][2] == 2 && tic[1][1] == 2 && tic[2][0] == 2) {
            return true;
        }
        if (tic[0][1] == 2 && tic[1][1] == 2 && tic[2][1] == 2) {
            return true;
        }
        if (tic[1][0] == 2 && tic[1][1] == 2 && tic[1][2] == 2) {
            return true;
        }
        
        if (tic[0][0] == 2 && tic[0][1] == 2 && tic[0][2] == 2) {
            return true;
        }
        if (tic[0][0] == 2 && tic[1][0] == 2 && tic[2][0] == 2) {
            return true;
        }
        if (tic[0][2] == 2 && tic[1][2] == 2 && tic[2][2] == 2) {
            return true;
        }
        if (tic[2][0] == 2 && tic[2][1] == 2 && tic[2][2] == 2) {
            return true;
        }
        return false;
        
    }
    
    private void human_move() {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        while (tic[p][q] != 0 || (p > 2 || p < 0) || (q > 2 || q < 0)) {
            p = sc.nextInt();
            q = sc.nextInt();
        }
        tic[p][q] = 2;
    }
    
    private void computer_move() {
        copy();
        int p = min_max(rec, 0, 'c');
        System.out.println("BEST score: " + p);
        
    }
    
    private int min_max(int rec[][], int level, char player) {
        int i, j = 0;
        
        System.out.println("+++++++++++MIn+++++++++++++++");
        System.out.println(score);
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(rec[i][j] + " ");
            }
            System.out.println();
        }
        
        level = level + 1;
        if(level > 4) return score;
        
        if (board_finish(rec)) {
            return 0;
        }
        if (human_win(rec)) {
            return -10;
        }
        if (pc_win(rec)) {
            return 10;
        }
        
        if (player == 'c') {
            
            set_flag(flag);
            
            System.out.println("COMPUTER");
            
            
            for(i = 0; i< 3; i ++)
            {
                for(j=0;j<3;j++)
                {
                    flag[i][j] = rec[i][j];
                }
            }
            
            for(i = 0; i< 3; i ++)
            {
                for(j=0;j<3;j++)
                {
                    if(flag[i][j] == 0)
                    {
                        flag[i][j] = 1;
                        rec[i][j] = 1;
                        x.add(k, i);
                        x.add(k,j);
                        score = min_max(rec, level, 'h');
                        x.add(k++, score);
                        rec[i][j] = 0;
                        set_flag(flag);
                        set_flag(glag);
                    }
                }
            }
                if (score > best_score) {
                    best_score = score;
                    fu = i;
                    fa = j;
                    
                }
                return best_score;
        } else {
            //set_flag(glag);
            System.out.println("HUMAN");
            
            for(i = 0; i< 3; i ++)
            {
                for(j=0;j<3;j++)
                {
                    glag[i][j] = rec[i][j];
                }
            }
            
            for(i = 0; i< 3; i ++)
            {
                for(j=0;j<3;j++)
                {
                    if(glag[i][j] == 0)
                    {
                        glag[i][j] = 2;
                        rec[i][j] = 2;
                        score = min_max(rec, level, 'c');
                        rec[i][j] = 0;
                        set_flag(glag);
                    }
                }
            }
            //options_y(rec);
                
            //score = min_max(rec, level, 'c');
            if (score < best_score) {
                best_score = score;
            }
            return best_score;
            
        }
    }
    
    private boolean board_finish(int rec[][]) {
        int i, j, t = 1;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (rec[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
        
    }
    int glag[][] = new int[10][10];
    
    private void options_x(int rec[][]) {
        int i, j, t = 1;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                flag[i][j] = rec[i][j];
            }
        }
        //copy();
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (flag[i][j] == 0) {
                    flag[i][j] = 1;
                    rec[i][j] = 1;
                    return;
                }
            }
        }
    }
    
    private void set_flag(int flag[][]) {
        int i, j, t = 1;
        
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                flag[i][j] = tic[i][j];                
            }
        }
    }
    
    private void options_y(int rec[][]) {
        int i, j, t = 1;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                glag[i][j] = rec[i][j];
            }
        }
        //copy();
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (glag[i][j] == 0) {
                    glag[i][j] = 2;
                    rec[i][j] = 2;
                    return;
                }
            }
        }
    }
    
    private void copy() {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                rec[i][j] = tic[i][j];
                //flag[i][j] = tic[i][j];
            }
        }
        
    }
    
    private void clear_flag() {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                //rec[i][j] = tic[i][j];
                flag[i][j] = 0;
                glag[i][j] = 0;
            }
        }
        
    }
}
