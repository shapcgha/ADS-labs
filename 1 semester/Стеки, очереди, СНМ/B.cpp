#include <iostream>
#include <cmath>
#include<stack>

using namespace std;

int main() {
	stack<int> stack;
	int n;
	int count=0;
	int temp = -1;
	scanf_s("%d", &n);
		for (int i = 0; i < n; i++) {
			int x;
			scanf_s("%d", &x);
			if(x!=temp) {
				temp = -1;
				if (stack.size() > 1) {
					int temp1, temp2;
					temp1 = stack.top();
					stack.pop();
					temp2 = stack.top();
					if (x == temp1 && x == temp2) {
						count += 3;
						temp = temp2;
						stack.pop();
					}
					else {
						stack.push(temp1);
						stack.push(x);
					}
				}
				else {
					stack.push(x);
				}
			}
			else {
				count++;
			}
		}
		printf("%d", count);
	}
 