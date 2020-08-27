
import java.util.HashMap;
import java.util.LinkedList;

public class programmers_42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> userList = new HashMap<>();
        String logList[] = new String[record.length];
        String logId[]= new String[record.length];

        int count = 0;
        for (int i = 0; i < record.length; i++) {
            //  for문을 돌면서 유저리스트 만들기, 결과배열 만들기
            String[] log = record[i].split(" ");
            switch (log[0]) {
                case "Enter":
                    logList[count] = "님이 들어왔습니다.";
                    logId[count] = log[1];
                    userList.put(log[1], log[2]);
                    count++;
                    break;
                case "Leave":
                    logList[count] = "님이 나갔습니다.";
                    logId[count] = log[1];
                    count++;
                    break;
                case "Change":
                    userList.put(log[1], log[2]);
                    break;
                default:
                    break;
            }
        }

        String result[] = new String[count];

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(userList.get(logId[i])).append(logList[i]);
            result[i] = sb.toString();
        }
        return result;
    }
}
