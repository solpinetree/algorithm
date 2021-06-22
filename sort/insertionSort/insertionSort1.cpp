//given a sorted list with an unsorted number 3 in the rightmost cell. 
//make it remain sorted by inserting e into the array
//1. start at the rightmost index. Store the value of arr[n-1]
//2. compare the value to each element to the left until a smaller value is reached. 


void insertionSort1(int n, vector<int> arr) {
  
  int num=arr[n-1];//1. 
  
  for(int i=n-2;i>=0;i--){
      if(arr[i]>num){
        arr[i+1]=arr[i];
        for(int j=0;j<n;j++)  {cout << arr[j] << " ";}
        cout << endl;
      }else{
        arr[i+1]=num;
        break;
      }
  }
   if(arr[0]>num)//num이 최소값이라 insertion이 안 된 경우 고려해야함
       arr[0]=num;
    
   for(int j=0;j<n;j++)  {cout << arr[j] << " ";}
   cout << endl;
}
