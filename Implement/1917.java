import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int[][] board = new int[6][6];
    static int[][][] templates;
    static int[][][] longest;
    static int[] Y = {0,0,1,-1}, X = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        templates = new int[][][]{
                {{1,0,0,0},{1,1,1,1},{1,0,0,0}},
                {{0,0,0,1},{1,1,1,1},{0,0,0,1}},

                {{0,1,0,0},{1,1,1,1},{1,0,0,0}},
                {{0,0,1,0},{1,1,1,1},{0,0,0,1}},
                {{1,0,0,0},{1,1,1,1},{0,1,0,0}},
                {{0,0,0,1},{1,1,1,1},{0,0,1,0}},

                {{0,0,1,0},{1,1,1,1},{1,0,0,0}},
                {{0,1,0,0},{1,1,1,1},{0,0,0,1}},
                {{1,0,0,0},{1,1,1,1},{0,0,1,0}},
                {{0,0,0,1},{1,1,1,1},{0,1,0,0}},

                {{0,0,0,1},{1,1,1,1},{1,0,0,0}},
                {{1,0,0,0},{1,1,1,1},{0,0,0,1}},

                {{0,1,0,0},{1,1,1,1},{0,1,0,0}},
                {{0,0,1,0},{1,1,1,1},{0,0,1,0}},

                {{0,0,1,0},{1,1,1,1},{0,1,0,0}},
                {{0,1,0,0},{1,1,1,1},{0,0,1,0}},

                {{0,0,1,1},{0,1,1,0},{1,1,0,0}},
                {{1,1,0,0},{0,1,1,0},{0,0,1,1}},

                {{0,0,1,1},{1,1,1,0},{1,0,0,0}},
                {{1,1,0,0},{0,1,1,1},{0,0,0,1}},
                {{1,0,0,0},{1,1,1,0},{0,0,1,1}},
                {{0,0,0,1},{0,1,1,1},{1,1,0,0}},

                {{1,1,0,0},{0,1,1,1},{0,1,0,0}},
                {{0,0,1,1},{1,1,1,0},{0,0,1,0}},
                {{0,1,0,0},{0,1,1,1},{1,1,0,0}},
                {{0,0,1,0},{1,1,1,0},{0,0,1,1}},

                {{0,1,0,0},{1,1,1,0},{0,0,1,1}},
                {{0,0,1,0},{0,1,1,1},{1,1,0,0}},
                {{0,0,1,1},{1,1,1,0},{0,1,0,0}},
                {{1,1,0,0},{0,1,1,1},{0,0,1,0}}
        };
        longest = new int[][][]{
                {{0,0,1,1,1}, {1,1,1,0,0}},
                {{1,1,1,0,0}, {0,0,1,1,1}}
        };
        for(int i=0;i<6;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isPF());
        for(int i=0;i<6;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isPF());
        for(int i=0;i<6;i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(isPF());
    }
    public static String isPF(){
        int[][] form;
        ArrayList<int[]> hist = new ArrayList<>();
        int ylen=0,xlen=0,ymin=6,xmin=6,ymax=0,xmax=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(board[i][j]==1) {
                    hist.add(new int[]{i, j});
                    if (ymin > i) ymin = i;
                    if (ymax < i) ymax = i;
                    if (xmin > j) xmin = j;
                    if (xmax < j) xmax = j;
                }
            }
        }
        ylen = ymax-ymin+1; xlen = xmax-xmin+1;
        if(!((ylen==3 && xlen==4) || (ylen==4 && xlen==3) || (ylen==2 && xlen==5) || (ylen==5 && xlen==2)))
            return "no";
        int[] tmp;
        if(ylen<=xlen) {
            form = new int[ylen][xlen];
            boolean flag = true;
            for(int i=0;i<hist.size();i++){
                tmp = hist.get(i);
                form[tmp[0]-ymin][tmp[1]-xmin] = 1;
            }
            if(ylen==2){
                for(int k=0;k<2;k++) {
                    flag = true;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 5; j++)
                            if (longest[k][i][j] != form[i][j]){
                                flag = false;
                                break;
                            }
                        if(!flag)
                            break;
                    }
                    if(flag)
                        return "yes";
                }
                return "no";
            }else{
                for(int k=0;k< templates.length;k++){
                    flag = true;
                    for(int i=0;i<3;i++){
                        for(int j=0;j<4;j++){
                            if(templates[k][i][j]!=form[i][j]){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag)
                            break;
                    }
                    if(flag)
                        return "yes";
                }
                return "no";
            }
        }
        else { // y,x --> x,y
            form = new int[xlen][ylen];
            boolean flag = true;
            for(int i=0;i<hist.size();i++){
                tmp = hist.get(i);
                form[tmp[1]-xmin][tmp[0]-ymin] = 1;
            }
            if(xlen==2){
                for(int k=0;k<2;k++) {
                    flag = true;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 5; j++)
                            if (longest[k][i][j] != form[i][j]){
                                flag = false;
                                break;
                            }
                        if(!flag)
                            break;
                    }
                    if(flag)
                        return "yes";
                }
                return "no";
            }else{
                for(int k=0;k< templates.length;k++){
                    flag = true;
                    for(int i=0;i<3;i++){
                        for(int j=0;j<4;j++){
                            if(templates[k][i][j]!=form[i][j]){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag)
                            break;
                    }
                    if(flag)
                        return "yes";
                }
                return "no";
            }
        }
    }
}