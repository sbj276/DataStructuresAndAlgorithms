class RotatingSortArray{
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,8,9};
		int key =8;
		//find the pivot index
		int p = getPivotIndex(arr,0,arr.length-1);
		System.out.println("pivot index with value:"+p+"\t"+arr[p]);
		//then find the key
		if(arr[p] >= key && arr[0] <= key)
			System.out.println(getKeyUsingBinarySearch(arr, 0, p, key));
		else
			System.out.println(getKeyUsingBinarySearch(arr, p, arr.length-1, key));
	}

	public static int getKeyUsingBinarySearch(int[] arr, int start, int end, int key){
		int mid = ((start+1)+end)/2;
		if(start <= end){
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key){
				return getKeyUsingBinarySearch(arr, start, mid-1,key);
			}else if(arr[mid] < key){
				return getKeyUsingBinarySearch(arr, mid+1, end,key);
			}
		}
		return -1;
	}
	public static int getPivotIndex(int[] arr, int start, int end){
		int mid =(start+end)/2;		
		if(start < end){
			if(arr[mid-1] > arr[mid]){
				return mid-1;
			}else if( arr[mid+1]<arr[mid]){
				return mid;
			}else{
				return getPivotIndex(arr, mid,end);
			}
		}
		return -1;
	}
}