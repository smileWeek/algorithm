package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

/***
 * 5. 이진트리 순회(깊이우선탐색)
 *
 * 전위순회 출력 : 1 2 3 4 3 6 7
 * 중위순회 출력 : 4 2 5 1 6 3 7
 * 후위순회 출력 : 4 5 2 6 7 3 1
 *
 * 2022.07.12 해결
 */
public class Question5 {
    static class Node{
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
    Node root;
    public static void main(String[] args){
        Question5 tree = new Question5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }

    private void dfs(Node root) {
        if(root == null) return;
        else{
            System.out.print(root.data + " ");
            dfs(root.lt);
            dfs(root.rt);
        }
    }
}
