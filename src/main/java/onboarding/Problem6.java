package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();
        List<String> nicknameList = new ArrayList<>();
        HashMap<String,Integer> nicknamePatternMap = new HashMap<>();

        makeNickNameList(forms,nicknameList);
        savePatternAtMap(nicknameList,nicknamePatternMap);
        checkDuplication(nicknameList,nicknamePatternMap);

        return answer;
    }
    public static void makeNickNameList(List<List<String>> originList,List <String> nickname){
        for(int i = 0 ; i < originList.size(); i++){
            nickname.add(originList.get(i).get(1));
        }
    }

    //각 pattern들을 map에 저장
    public static void savePatternAtMap(List <String> nickname,HashMap <String,Integer> nicknamePattern){
        String key = "";
        for(int i = 0 ; i < nickname.size(); i++){
            for(int j = 0 ; j < nickname.get(i).length()-1; j++){
                key = nickname.get(i).substring(j,j+2);
                nicknamePattern.put(key, 0);
            }
        }
    }

    //중복되는 패턴발견시 관련 value 증가
    public static void checkDuplication(List <String> nickname,HashMap <String,Integer> nicknamePattern){
        String key ="";
        int value = 0;

        for(int i = 0 ; i < nickname.size(); i++){
            for(int j = 0 ; j < nickname.get(i).length()-1; j++){
                key = nickname.get(i).substring(j,j+2);
                value = nicknamePattern.get(key);
                if(nicknamePattern.containsKey(key)){
                    nicknamePattern.put(key,value+1);
                }
            }
        }
    }
}
