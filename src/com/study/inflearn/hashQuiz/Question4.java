package com.study.inflearn.hashQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/***
 * 4. 모든 아나그램 찾기
 * 설명
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 *
 * 예시 입력 1
 * bacaAacba
 * abc
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 *
 * 2022.07.07 해결
 */
public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String aStr = br.readLine();
        String bStr = br.readLine();
        System.out.println(solution(aStr, bStr));
    }

    private static int solution(String aStr, String bStr) {
        int answer = 0;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        for(char b : bStr.toCharArray()){
            bMap.put(b, bMap.getOrDefault(b, 0) + 1);
        }
        for(int lt = 0; lt < bStr.length()-1; lt++){
            aMap.put(aStr.charAt(lt), aMap.getOrDefault(aStr.charAt(lt), 0) + 1);
        }
        int lt = 0;
        for(int rt = bStr.length()-1; rt < aStr.length(); rt++){
            aMap.put(aStr.charAt(rt), aMap.getOrDefault(aStr.charAt(rt), 0) + 1);
            if(aMap.equals(bMap)) answer++;
            aMap.put(aStr.charAt(lt), aMap.get(aStr.charAt(lt))-1);
            if(aMap.get(aStr.charAt(lt)) == 0) aMap.remove(aStr.charAt(lt));
            lt++;
        }
        return answer;
    }
}
