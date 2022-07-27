package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1764
 */
public class BaekJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        Iterator<String> itr = map.keySet().iterator();
        List<String> answer = new ArrayList<>();
        while(itr.hasNext()){
            String key = itr.next();
            if(map.get(key) == 2) answer.add(key);
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        answer.stream().forEach(System.out::println);
    }
}