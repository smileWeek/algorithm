package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/1181
 */
public class BaekJoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        };
        TreeSet<String> set = new TreeSet<>(comp);
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        List<String> list = set.stream().collect(Collectors.toList());
        list.stream().forEach(i -> System.out.print(i + " "));
    }
}