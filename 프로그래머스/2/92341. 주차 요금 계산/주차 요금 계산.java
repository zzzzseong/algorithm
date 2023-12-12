import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //[ 예외사항 ]
        //입차된 후 출차된 내역이 없다면 23:59에 출차된 것으로 간주
        //초과한 시간이 13분일때는 20분 요금을 받음
        Map<String, String> recordMap = new HashMap<>();
        Map<String, Integer> minCountMap = new HashMap<>();
        List<String> carList = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if(record[2].equals("IN")) { //입차 로직
                recordMap.put(record[1], record[0]);

                if(!carList.contains(record[1])) {
                    carList.add(record[1]);
                }
            } else { //출차 로직
                int totalMin = getMinute(recordMap.get(record[1]), record[0]); //시간 계산
                recordMap.remove(record[1]); //출차한 차량번호 삭제

                //차량번호별 요금 추가
                if(minCountMap.containsKey(record[1])) {
                    minCountMap.put(record[1], minCountMap.get(record[1]) + totalMin);
                } else {
                    minCountMap.put(record[1], totalMin);
                }
            }
        }

        if(!recordMap.isEmpty()) {
            recordMap.forEach((key, value) -> {
                int totalMin = getMinute(value, "23:59");
                if(minCountMap.containsKey(key)) {
                    minCountMap.put(key, minCountMap.get(key) + totalMin);
                } else {
                    minCountMap.put(key, totalMin);
                }
            });
        }

        Collections.sort(carList);
        System.out.println(carList.toString());
        int[] answer = new int[carList.size()];

        for (int i = 0; i < carList.size(); i++) {
            int fee = getFee(fees, minCountMap.get(carList.get(i).toString()));
            answer[i] = fee;
        }

        //차량번호를 오름차순으로 정렬하여 int[] 형식으로 return
        return answer;
    }

    public int getFee(int[] fees, int totalMin) {
        if(totalMin <= fees[0]) { //기본 요금
            return fees[1];
        }

        totalMin -= fees[0];
        if(totalMin%fees[2] == 0) {
            return fees[1] + (totalMin/fees[2])*fees[3];
        } else {
            return fees[1] + ((totalMin/fees[2])+1)*fees[3];
        }
    }

    public int getMinute(String sTime, String eTime) {
        String[] sTimeArr = sTime.split(":");
        String[] eTimeArr = eTime.split(":");

        int hour = Integer.parseInt(eTimeArr[0]) - Integer.parseInt(sTimeArr[0]);
        int min = Integer.parseInt(eTimeArr[1]) - Integer.parseInt(sTimeArr[1]);
        if(min < 0) {
            hour--;
            min += 60;
        }

        return hour*60 + min;
    }
}