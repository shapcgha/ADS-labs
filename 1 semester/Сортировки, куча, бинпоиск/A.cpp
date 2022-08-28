#include<stdio.h>
void merge (int *a, int l, int mid, int r){
	int i=0,j=0,x;
	int b[r-l];
	while (l+i<mid && mid+j<r){
		if(a[i+l]<a[j+mid]){
			b[i+j]=a[i+l];
			i++;
		}
		else{
			b[i+j]=a[j+mid];
			j++;
		}
	}
	while (i+l<mid){
		b[i+j]=a[i+l];
		i++;
	}
	while (j+mid<r){
		b[i+j]=a[j+mid];
		j++;
	}
	for (int x=0; x<r-l;x++)
		a[x+l]=b[x];
}
void sort(int *a,int l, int r){
	if ((r-l)<=1)
		return;
	sort(a,l,(l+r)/2);
	sort(a,(l+r)/2,r);
	merge(a, l, (l+r)/2,r);
}

int main(){
	int b;
	scanf("%d",&b);
	int a[b];
	for (int i=0; i<b; i++)
		scanf("%d",&a[i]);
	sort(a,0,b);
	for (int i=0; i<b;i++)
		printf("%d ",a[i]);
}