#include <stdio.h>
int main (){
	int n;
	scanf("%d",&n);
	int arr[n];
	int arr1[11];
	int arr2[11];
	for (int i=0; i<n; i++){
		scanf("%d", &arr[i]);
	}
	for (int i=0; i<10; i++){
		arr1[i]=0;
	}
	for (int i=0; i<11; i++){
		arr2[i]=0;
	}
	for (int i=0; i<n; i++){
		arr1[arr[i]%10+1]++;
		arr2[arr[i]/10+1]++;
	}
	for (int i=1; i<10; i++){
		arr1[i]+=arr1[i-1];
	}
	for (int i=1; i<11; i++){
		arr2[i]+=arr2[i-1];
	}
	int arr3[n];
	for (int i=0; i<n; i++){
		arr3[arr1[arr[i]%10]]=arr[i];
		arr1[arr[i]%10]++;
	}
	for (int i=0; i<n; i++){
		arr[arr2[arr3[i]/10]]=arr3[i];
		arr2[arr3[i]/10]++;
	}
	for (int i=0; i<n; i++){
		printf("%d ", arr[i]);
	}
}