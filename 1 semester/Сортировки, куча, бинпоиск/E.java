//package com.company;

import java.io.*;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

public class Main {
    public static long findNumder(long[] arr, long n, int length, int flag) {
        long l = -1, r = length, m;
        if (flag == 1) {
            while (r - l > 1) {
                m = (r + l) / 2;
                if (arr[(int) m] <= n) {
                    l = m;
                } else {
                    r = m;
                }
            }
        } else {
            while (r - l > 1) {
                m = (r + l) / 2;
                if (arr[(int) m] < n) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }

        if (r == length) {
            r--;
        } else if (r == -1) {
            r++;
        }

        return r;
    }

    public static void merge(long[] arr, int l, int mid, int r) {
        int i = 0, j = 0;
        long[] b = new long[r - l];
        while (l + i < mid && mid + j < r) {
            if (arr[i + l] < arr[j + mid]) {
                b[i + j] = arr[i + l];
                i++;
            } else {
                b[i + j] = arr[j + mid];
                j++;
            }
        }
        while (i + l < mid) {
            b[i + j] = arr[i + l];
            i++;
        }
        while (j + mid < r) {
            b[i + j] = arr[j + mid];
            j++;
        }
        for (int x = 0; x < r - l; x++)
            arr[x + l] = b[x];
    }

    public static void sort(long[] arr, int l, int r) {
        if ((r - l) <= 1)
            return;
        sort(arr, l, (l + r) / 2);
        sort(arr, (l + r) / 2, r);
        merge(arr, l, (l + r) / 2, r);
    }

    public static void main(String[] args) {
        Scanner1 sc = new Scanner1(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        sort(arr, 0, n);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            long l = sc.nextInt(), r = sc.nextInt();
            long lindex = (findNumder(arr, l, n, 0));
            long rindex = (findNumder(arr, r, n, 1));
            if (l <= arr[(int) lindex] && r >= arr[(int) rindex]) {
                System.out.print(Long.toString((rindex - lindex + 1) )+ " ");
            } else if (l <= arr[(int) lindex] || r >= arr[(int) rindex]) {
                System.out.print(Long.toString(rindex - lindex) + " ");
            } else {
                if ((rindex - lindex - 1) < 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(Long.toString(rindex - lindex - 1) + " ");
                }
            }
        }
    }
}
class Scanner1 {
    private Reader reader;
    private char[] buf = new char[8192];
    private boolean hasNext = true;
    private int pos=0, len=0;

    public Scanner1(InputStream is) {
        reader = new BufferedReader(new InputStreamReader(is));
        read();
    }

    public Scanner1(Reader reader) {
        this.reader = reader;
        read();
    }

    public Scanner1(String str) {
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

    public char nextChar() {
        if(pos>=len){
            read();
        }
        return buf[pos++];
    }

    public String nextWord() {
        skipWhiteSpace();
        StringBuilder sb = new StringBuilder();
        while (hasNext()) {
            char c = nextChar();
            if ((c == '\'' || Character.getType(c) == Character.DASH_PUNCTUATION || Character.isAlphabetic(c))){
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
}
 