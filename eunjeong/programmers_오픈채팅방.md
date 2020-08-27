# 프로그래머스 오픈 채팅방

## 실패
![image-20200827195439079](/Users/eunjeong/Library/Application Support/typora-user-images/image-20200827195439079.png)

- 실패코드

```java
package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class pg_42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> userList = new HashMap<>();
        LinkedList<String> logList = new LinkedList<>();


        for (int i = 0; i < record.length; i++) {
            //  for문을 돌면서 유저리스트 만들기, 결과배열 만들기
            String[] log = record[i].split(" ");
            switch (log[0]) {
                case "Enter":
                    logList.add(log[1]+"/"+"님이 들어왔습니다.");
                    userList.put(log[1], log[2]);
                    break;
                case "Leave":
                    logList.add(log[1]+"/"+"님이 나갔습니다.");
                    break;
                case "Change":
                    userList.put(log[1], log[2]);
                    break;
                default:
                    break;
            }
        }

        String result[] = new String[logList.size()];

        for (int i = 0; i < logList.size() ; i++) {
            String temp[] = logList.get(i).split("/");
            result[i] = userList.get(temp[0]) + temp[1];
        }


        return result;
    }
}

```



## 해결

- StringBuilder 쓰는 습관을 들이자.. 메모리 너무 많이 쓴다 

```java
package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class pg_42888 {
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

```

