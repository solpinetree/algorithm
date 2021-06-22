//print the array after each iteration of the insertion sort. 

void insertionSort2(int n, vector<int> arr) {
  if(n==1) return;
  
  int temp;
  int i=1;
  int j;
  while(i<arr.size()){
    j=i;
    while(j>=0){
      if(arr[j]<arr[j-1]){
        temp=arr[j-1];
        arr[j-1]=arr[j];
        arr[j]=temp;
      }
      j--;
    }
    i++;
    for(auto& a: arr) cout << a << " ";
    cout << endl;
  }
}
