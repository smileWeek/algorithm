package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 이진트리 순회(넓이우선탐색 : 레벨탐색)
 *
 * 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
 *
 * 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
 *
 * 2022.07.12 해결
 */
public class Question7 {
    static class Node{
        int data;
        Node rt,lt;

        public Node(int val) {
            data = val;
            rt = lt = null;
        }
    }

    Node root;
    public static void main(String[] args) throws Exception {
        Question7 tree = new Question7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }

    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node curr = queue.remove();
                System.out.print(curr.data + " ");
                if(curr.lt != null) queue.offer(curr.lt);
                if(curr.rt != null) queue.offer(curr.rt);
            }
            System.out.println();
        }
    }
}