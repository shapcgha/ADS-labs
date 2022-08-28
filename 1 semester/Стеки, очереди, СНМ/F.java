//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class A {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        int n = sc.nextInt();
        int count =1;
        for(int i=0; i<n;i++){
            int temp = sc.nextInt();
            arr.add("push");
            stack.push(temp);
            if(temp==count){
                stack.pop();
                count++;
                arr.add("pop");
                while (true){
                    if (!stack.empty() && stack.peek()==count){
                        count++;
                        stack.pop();
                        arr.add("pop");
                    } else {
                        break;
                    }
                }
            }
        }
        if(stack.empty()){
            for (String str : arr) {
                System.out.println(str);
            }
        } else {
            System.out.println("impossible");
        }
    }

    static class Scanner {
        private Reader reader;
        private char[] buf = new char[8192];
        private boolean hasNext = true;
        private int pos = 0;
        private int len = 0;

        public Scanner(InputStream is) {
            reader = new BufferedReader(new InputStreamReader(is));
            read();
        }

        public Scanner(Reader reader) {
            this.reader = reader;
            read();
        }

        public Scanner(String str) {
            reader = new StringReader(str);
            read();
        }


        public boolean hasNext() {
            nextChar();
            pos--;
            return hasNext;
        }

        public String next() {
            skipWhiteSpace();
            StringBuilder sb = new StringBuilder();
            while (hasNext()) {
                char c = nextChar();
                if (Character.isWhitespace(c)) {
                    break;
                }
                sb.append(c);
            }
            return sb.toString();
        }

        public String nextLine() {
            StringBuilder sb = new StringBuilder();
            char c;
            while (hasNext()) {
                c = nextChar();
                if (c == '\n') {
                    break;
                }
                sb.append(c);
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        private void skipWhiteSpace() {
            if (hasNext()) {
                char c = nextChar();
                while (hasNext && Character.isWhitespace(c)) {
                    c = nextChar();
                }
            }
            pos--;
        }


        private void read() {
            try {
                len = reader.read(buf);
                while (len == 0) {
                    len = reader.read(buf);
                }

                if (len == -1) {
                    hasNext = false;
                }
                pos = 0;
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        private char nextChar() {
            if (pos >= len) {
                read();
            }
            return buf[pos++];
        }
    }
}