//package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Map;

public class A {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int count = 0;
        int minesCount = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                int temp = sc.nextInt();
                queue.addLast(temp);
                map.put(temp,count);
                count++;
            } else if (x == 2) {
                queue.pollFirst();
                minesCount++;
            } else if (x == 3) {
                queue.pollLast();
                count--;
            } else if (x == 4) {
                System.out.println(map.get(sc.nextInt()) - minesCount);
            } else if (x == 5) {
                System.out.println(queue.peekFirst());
            }
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