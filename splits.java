package main;

import java.util.*;

public class Main {

    static class TreeNode<E> {
        TreeNode parent;
        E val;
        LinkedList<TreeNode> children;

        public TreeNode(E val) {
            this.val = val;
            this.children = new LinkedList<>();
        }

        public TreeNode(TreeNode<E> parent, E val) {
            this.parent = parent;
            this.val = val;
            this.children = new LinkedList<>();
        }

        public void addChild(E val) {
            if(val ==  null) {
                return;
            }
            TreeNode child = new TreeNode(this, val);
            this.children.add(child);
        }

        public void traversal() {
            this.traversalInner(0);
        }

        public void traversalInner(int depth) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < depth; i++) {
                sb.append("|    ");
            }

            if(depth > 0) {
                sb.append("|----");
            }
            sb.append(this.val.toString());
            System.out.println(sb.toString());
            for(TreeNode child : this.children) {
                child.traversalInner(depth+1);
            }
        }

    }

    static String query = "ABCDAFEG";
    static String[] doe = {"AB", "BA", "DF", "AD"};

    public static void main(java.lang.String[] args) {
        TreeNode<String> path = new TreeNode<>("root");
        splitQuery(query, Arrays.asList(doe), path);
//        path.traversal();
    }



    public static void splitQuery(String query, List<String> DoE, TreeNode<String> path) {
        for(int j = 0; j < DoE.size(); j++) {
            String entry = DoE.get(j);
            String left = matchAndRemove(query, entry);
            if(left.equals(query)) {
                // left和query相等，说明没匹配上
            } else {
                path.addChild(entry);

                LinkedList<TreeNode> stack = new LinkedList<>();
                for(TreeNode t = path; t != null && !t.val.toString().equals("root"); t = t.parent) {
                    stack.push(t);
                }

                while(stack.size() > 0) {
                    TreeNode t = stack.pop();
                    System.out.printf("%s, ", t.val.toString());
                }

                System.out.printf("%s | ", entry);
                System.out.printf("%s\n", left);
                splitQuery(left, DoE, path.children.getLast());
            }
        }
        return;
    }

    public static String matchAndRemove(String query, String entry) {
        boolean match = isSubSequence(entry, query);
        if(match) {
            LinkedList<Integer> pos = new LinkedList<>();
            int remPos = 0;
            for(int j = 0; j < entry.length(); j++) {
                for(int i = remPos;i < query.length(); i++) {
                    if(query.charAt(i) == entry.charAt(j)) {
                        pos.add(i);
                        remPos = i;
                        break;
                    }
                }
            }
            String result = "";
            for(int i = 0; i < query.length(); i++) {
                if(!pos.contains(i)) {
                    result += query.charAt(i);
                }
            }
            return result;
        } else {
            return query;
        }
    }

    public static boolean isSubSequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
}
