#include <iostream>
#include <cmath>
#include<stack>

using namespace std;

int main() {
	stack<int> stack1;
	stack<int> stackMin;
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int x;
		scanf_s("%d", &x);
		if (x == 1) {
			scanf_s("%d", &x);
			stack1.push(x);
			if (stackMin.empty()) {
				stackMin.push(x);
			}
			else {
				if (x <= stackMin.top()) {
					stackMin.push(x);
				}
			}
		}
		else if (x == 2) {
			x = stack1.top();
			stack1.pop();
			if (x == stackMin.top()) {
				stackMin.pop();
			}
		}
		else if (x == 3) {
			printf("%d\n", stackMin.top());
		}
	}
}