import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;



public class Main {


    static int k = 3;
    static int[] numbers = new int[]{3, 7, 2, 8, 6, 4, 5,1};
    static boolean[] visited;

    public static boolean check(){
        for (int i = 0; i < numbers.length-1; i++){
            if (Math.abs(numbers[i] - numbers[i+1]) > k ){
                return false;
            }
        }
        return true;
    }
    public static boolean swap(int depthDest,int depthCurr) {
        if (depthDest== depthCurr){
            if (check()){
                return true;
            }
            return false;
        }
        for (int i = 0; i < numbers.length; i++){
            if (visited[i] == false){
                visited[i] = true;
                for (int j = i+1;j< numbers.length;j++){
                    if (visited[j] == false){
                        int tempNumber = numbers[i];

                        visited[j] = true;
                        numbers[i] = numbers[j];
                        numbers[j] = tempNumber;
                        if (swap(depthDest,depthCurr+1)){
                            System.out.println(Arrays.toString(numbers));
                            return true;
                        }else{
                            tempNumber = numbers[i];
                            numbers[i] = numbers[j];
                            numbers[j] = tempNumber;
                            visited[j] = false;
                        }
                    }
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        visited = new boolean[numbers.length];
        Arrays.fill(visited,false);
        System.out.println("visited = " + Arrays.toString(visited));
        for (int depthDest = 1; depthDest < numbers.length / 2 + 1; depthDest++) {
            if (swap(depthDest, 0)) {
                System.out.println("depthDest = " + depthDest);
                return  ;
            }

        }
        System.out.println("numbers.length/2 = " + numbers.length/2);
        



    }

}

class Point {
    private int loc;
    private int time;


    public Point(int loc, int time) {
        this.loc = loc;
        this.time = time;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
class VisitedPoint{
    private int x;
    private int y;

    public VisitedPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//
//
//public class Main {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static HashSet<Integer> answer = new HashSet<>();
//    static HashMap<Integer, ArrayList<Point>> dict = new HashMap<>();
//    static HashMap<Integer, Boolean> answer2 = new HashMap<>();
//    static int n = 6;
//    static int k = 17;
//    static int[][] roads = new int[][] {{5,4,6},{5,2,5},{0,4,2},{2,3,3},{1,2,7},{0,1,3}};;
//    public static void main(String[] args) throws IOException {
//        for (int i = 0; i< n; i++ ){
//            dict.put(i, new ArrayList<>());
//        }
//        for (int i = 0; i< roads.length; i++ ){
//            int x = roads[i][0];
//            int y = roads[i][1];
//            int d = roads[i][2];
//            dict.get(x).add(new Point(y,d));
//            dict.get(y).add(new Point(x,d));
//        }
//
//        System.out.println("args = " + args);
//        Queue<Point> need_visit = new LinkedList<>();
//        need_visit.add(new Point(0, k));
//        while( !need_visit.isEmpty()){
//            Point current = need_visit.poll();
//            int loc = current.getLoc();
//            int time = current.getTime();
//            for (Point next: dict.get(loc) ){
//                int nextLoc = next.getLoc();
//                int nextTime = next.getTime();
//                if (time - nextTime >= 0){
//                    if (time-nextTime == 0){
//                        answer.add(nextLoc);
//                        continue;
//                    }
//                    need_visit.add(new Point(nextLoc, time - nextTime));
//                }
//
//            }
//
//        }
//        System.out.println(answer);
//
//
//
//    }
//
//}
//
//class Point {
//    private int loc;
//    private int time;
//
//
//    public Point(int loc, int time) {
//        this.loc = loc;
//        this.time = time;
//    }
//
//    public int getLoc() {
//        return loc;
//    }
//
//    public void setLoc(int loc) {
//        this.loc = loc;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//}
//class VisitedPoint{
//    private int x;
//    private int y;
//
//    public VisitedPoint(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//}
//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//
//
//public class Main {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static int n;
//    static int m;
//    static int answer = -1;
//    static int[][] board;
//    static ArrayList<ArrayList<int[]>> visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        board = new int[n][m];
//        visited = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            st = new StringTokenizer(br.readLine());
//            String temp = st.nextToken();
//            visited.add(new ArrayList<>());
//            for (int j = 0; j < temp.length(); j ++ ){
//                board[i][j] =  Integer.parseInt(String.valueOf(temp.charAt(j))) ;
//                visited.get(i).add(new int[] {0,0});
//            }
//        }
//        bfs();
//        System.out.println(answer);
//    }
//    public static void bfs(){
//        Queue<Point> need_visit = new LinkedList<Point>();
//        need_visit.add(new Point(0, 0, 0));
//        while (!need_visit.isEmpty()){
//            Point node = need_visit.poll();
//            if (node.getX() == n - 1 && node.getY() == m - 1) {
//                answer = visited.get(node.getX()).get(node.getY())[node.getZ()] + 1;
//                return;
//            }
//            for (int i = 0; i < 4; i++ ){
//                int nx = node.getX() + dx[i];
//                int ny = node.getY() + dy[i];
//                if ( 0 <= nx && nx < n && 0 <= ny && ny < m){
//                    if (board[nx][ny] == 0 && visited.get(nx).get(ny)[node.getZ()] == 0){
//                        visited.get(nx).get(ny)[node.getZ()] = visited.get(node.getX()).get(node.getY())[node.getZ()] + 1;
//                        need_visit.add(new Point(nx, ny, node.getZ()));
//                    }
//                    if ( board[nx][ny] == 1 && node.getZ() == 0){
//                        visited.get(nx).get(ny)[1] = visited.get(node.getX()).get(node.getY())[node.getZ()] + 1;
//                        need_visit.add(new Point(nx, ny, 1));
//
//                    }
//                }
//            }
//        }
//
//
//    }
//}
//
//class Point {
//    private int x;
//    private int y;
//    private int z;
//
//    public Point(int x, int y,int z) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//    }
//    public int getY() {
//        return y;
//    }
//    public int getX() {
//        return x;
//    }
//    public int getZ() {
//        return z;
//    }
//
//}
//class VisitedPoint{
//    private int x;
//    private int y;
//
//    public VisitedPoint(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//}




//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//class Point {
//    private int x;
//    private int y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//    public int getY() {
//        return y;
//    }
//
//
//}
//
//
//
//public class Main {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static int answer = 0;
//
//    static LinkedList<LinkedList<Point>> combList = new LinkedList<>();
//    static int[][] board;
//    static int zeroNum = 0;
//    static ArrayList<Point> zeroList = new ArrayList<Point>();
//    static ArrayList<Boolean> zeroListVisited = new ArrayList<>();
//    static LinkedList<Point> virusList = new LinkedList<>();
//    static LinkedList<Point> tempCombList = new LinkedList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        board = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < m; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//                if (temp == 0){
//                    zeroList.add(new Point(i, j));
//                    zeroListVisited.add(false);
//                    zeroNum += 1;
//                }
//                if (temp == 2){
//                    virusList.add(new Point(i, j));
//                }
//                board[i][j] = temp;
//            }
//        }
//
//        combination(0,  0);
//        for (LinkedList<Point> points : combList) {
//            checkZeroCount(points);
//        }
//        System.out.println(answer);
//
//
//
//
//    }
//    public static void checkZeroCount(LinkedList<Point> wallList){
//        int tempZeroNum = zeroNum;
//        int[][] tempBoard = getNewBoard();
//        for (Point point : wallList) {
//            int x = point.getX();
//            int y = point.getY();
//            tempBoard[x][y] = 1;
//            tempZeroNum -= 1;
//        }
//        LinkedList<Point> tempVirusList = (LinkedList<Point>) virusList.clone();
//        while (!tempVirusList.isEmpty()){
//            Point a = tempVirusList.poll();
//            int x = a.getX();
//            int y = a.getY();
//            for (int i =0; i< 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if ( 0 <= nx && nx < tempBoard.length && 0 <= ny && ny < tempBoard[0].length){
//                    if (tempBoard[nx][ny] == 0){
//                        tempBoard[nx][ny] = 2;
//                        tempVirusList.add(new Point(nx, ny));
//                        tempZeroNum -= 1;
//                    }
//                }
//            }
//        }
//        if (tempZeroNum > answer) answer = tempZeroNum;
//
//    }
//
//    public static int[][] getNewBoard(){
//        int[][] newBoard = new int[board.length][board[0].length];
//        for(int i =0; i < board.length; i ++){
//            for (int j = 0; j < board[0].length; j++) {
//                newBoard[i][j] = board[i][j];
//            }
//        }
//        return newBoard;
//    }
//    public static void combination(int depth,  int startIndex){
//        if (depth == 3){
//            LinkedList<Point> temp = (LinkedList<Point>) tempCombList.clone();
//            combList.add(temp);
//            return;
//        }
//        for(int i = startIndex; i < zeroList.size(); i++){
//            tempCombList.add(zeroList.get(i));
//            combination(depth+1, i+1);
//            tempCombList.pollLast();
//
//        }
//        return;
//    }
//
//
//}


//import java.io.IOException;
//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main {
//    static long current;
//    static long answer = 0;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());;
//        long n = Long.parseLong(st.nextToken());
//        current = n;
//        for (long i = 1; i < n; i++) {
//            if ( i <= current ){
//                current -= i;
//                answer += 1;
//                continue;
//            }
//            break;
//
//        }
//        System.out.println(answer);
//
//    }
//
//}



//import java.io.IOException;
//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main {
//    static long current;
//    static long answer = 0;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());;
//        long n = Long.parseLong(st.nextToken());
//        current = n;
//        for (long i = 1; i < n; i++) {
//            if ( i <= current ){
//                current -= i;
//                answer += 1;
//                continue;
//            }
//            break;
//
//        }
//        System.out.println(answer);
//
//    }
//
//}
//

//import java.io.IOException;
//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int n;
//    static int l;
//    static Deque<Integer> q = new LinkedList<>();
//    static int[] board;
//    static int answer= 1;
//    static int current;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st ;
//
//        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        l = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        board = new int[n];
//        for (int i = 0 ; i < n;i ++ ){
//            int temp = Integer.parseInt(st.nextToken());
//            q.add(temp);
//            board[i] = temp;
//        }
//        Arrays.sort(board);
//        current = board[0];
//        for (int i = 1; i < board.length; i++) {
//            int temp = board[i];
//            if (temp < current +  l - 0.5){
//                continue;
//            }
//            else{
//                current = temp;
//                answer += 1;
//            }
//        }
//        System.out.println(answer);
//
//    }
//
//}

//import java.io.IOException;
//import java.util.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int n;
//    static int k;
//    static boolean[] visited = new boolean[100001];
//
////    static Queue<Integer[]> q = new LinkedList<>();
//    static Deque<int[]> q = new LinkedList<>();
//    static int answerCount = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//        Arrays.fill(visited, Boolean.FALSE);
//        sol();
//        System.out.println(answerCount);
//
//    }
//    public static void sol(){
//        q.add(new int[]{0, n});
//        while (!q.isEmpty()){
//            int[] a = q.pollFirst();
//            int count = a[0];
//            int loc = a[1];
//            if (loc == k){
//                return;
//            }
//            visited[loc] = true;
//            int[] tempLocList = {loc * 2, loc + 1, loc - 1};
//            for (int tempLoc: tempLocList){
//                if (tempLoc == loc * 2 && tempLoc == k){
//                    answerCount = count;
//                    return;
//                }else if ((tempLoc == loc +1 || tempLoc == loc -1) && tempLoc == k){
//                    answerCount = count + 1;
//                    return;
//                }else{
//                    if (0 <= tempLoc && tempLoc < 100001 && visited[tempLoc] == false){
//                        if (tempLoc == loc * 2){
//                            q.addFirst(new int[] {count, tempLoc});
//                        }else{
//                            q.add(new int[] {count+1, tempLoc});
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}



//import java.util.*;
//
//public class Main {
//    static int N, K;
//    static Queue<Integer[]> q = new LinkedList<>();
//    static int ANSWER_COUNT = Integer.MAX_VALUE;
//    static int ANSWER_NUM = 0;
//    static boolean[] visited = new boolean[100001];
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        N = scan.nextInt();
//        K = scan.nextInt();
//        bfs2();
//        System.out.println(ANSWER_COUNT);
//        System.out.println(ANSWER_NUM);
//
//    }
//    public static void bfs(){
//        q.add(new Integer[] {N,0});
//        while (!q.isEmpty()){
//            Integer[] a = q.remove();
//            Integer loc = a[0];
//            Integer count = a[1];
//            visited[loc] = true;
//            if (loc == K){
//                ANSWER_COUNT = 0;
//                ANSWER_NUM = 1;
//                return;
//            }
//            if (count >= ANSWER_COUNT) continue;
//            Integer[] temp_loc = {loc - 1, loc + 1, loc * 2};
//            for (Integer i : temp_loc){
//                if (i == K && count +1 <= ANSWER_COUNT){
//                    ANSWER_COUNT = count + 1;
//                    ANSWER_NUM += 1;
//                }else{
//                    if( 0 <= i && i < 100001 && visited[i] == false && ANSWER_COUNT > count){
//                        q.add(new Integer[]{i, count + 1});
//                    }
//
//                }
//            }
//
//
//        }
//    }
//    public static void bfs2(){
//        q.add(new Integer[] {N,0});
//        while (!q.isEmpty()){
//            Integer[] a = q.remove();
//            Integer loc = a[0];
//            Integer count = a[1];
//            visited[loc] = true;
//            if (loc == K){
//                ANSWER_COUNT = 0;
//                ANSWER_NUM = 1;
//                return;
//            }
//            if (count >= ANSWER_COUNT) continue;
//            Integer[] temp_loc = {loc - 1, loc + 1, loc * 2};
//            for (Integer i : temp_loc){
//                if (i == K && count +1 <= ANSWER_COUNT){
//                    ANSWER_COUNT = count + 1;
//                    ANSWER_NUM += 1;
//                }else{
//                    if( 0 <= i && i < 100001 && visited[i] == false && ANSWER_COUNT > count){
//                        q.add(new Integer[]{i, count + 1});
//                    }
//
//                }
//            }
//
//
//        }
//    }
//}

