import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class AC{
    private boolean isReversed;
    private int t; // 테스트 케이스
    private int n; // 배열에 들어 있는 수 개수
    private String p; // 수행할 함수
    private Deque<Integer> numbers; // 배열 저장
    private BufferedReader br;
    private StringBuilder sb;

    public AC() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
    }

    public int getT() { return t; }

    public void inputInfo() throws IOException {
        sb = new StringBuilder();
        isReversed = false;

        p = br.readLine();  // 수행 함수 입력
        n = Integer.parseInt(br.readLine());  // 수 개수 입력
        numbers = new LinkedList<>();

        for (String s: br.readLine().replaceAll("[\\[\\]]", "").split(",")){
            if(!s.equals("")){
                numbers.add(Integer.parseInt(s));
            }
        }
    }
    public void printResult() {
        sb.append("[");
        while(!numbers.isEmpty()) {
            if(isReversed){
                sb.append(numbers.removeLast());
            }
            else if(!isReversed) {
                sb.append(numbers.removeFirst());
            }
            if(!numbers.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]\n");
        System.out.print(sb.toString());
    }

    public void run() throws IOException {
        inputInfo();
        for(char c : p.toCharArray()) {
            if(c == 'R') {
                isReversed = !isReversed;
            }
            else if (c == 'D' && numbers.size() == 0) { // 리스트에 요소가 없을 때 error
                System.out.print("error\n");
                return;
            }
            else if(c == 'D' && numbers.size() > 0 && isReversed == false) { // R이 수행되지 않았을 때 앞 요소를 삭제
                numbers.removeFirst();
            }
            else if(c == 'D' && numbers.size() > 0 && isReversed == true) { // R이 수행됐을 때 뒷 요소 삭제
                numbers.removeLast();
            }

        }
        printResult();
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            AC ac = new AC();
            int testTime = ac.getT();

            while (testTime-- > 0) {
                ac.run();
            }
        } catch (IOException e) {
            return;
        }
    }
}
