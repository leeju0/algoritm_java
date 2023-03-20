import java.util.Arrays;

public class MergeSort {

    // 배열을 정렬하는 sort 메소드
    public void sort(int[] arr) {
        // 입력된 배열이 null이거나 길이가 1 이하인 경우 정렬할 필요 없음
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 배열을 반으로 나누기 위한 중간값 계산
        int mid = arr.length / 2;
        // 중간값을 기준으로 왼쪽과 오른쪽 배열 생성
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        // 왼쪽 배열에 값을 할당
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        // 오른쪽 배열에 값을 할당
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        // 왼쪽 배열과 오른쪽 배열을 재귀적으로 정렬
        sort(left);
        sort(right);
        // 정렬된 왼쪽 배열과 오른쪽 배열을 병합
        merge(left, right, arr);
    }

    // 두 개의 배열을 정렬하면서 하나의 배열로 병합하는 merge 메소드
    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            // 왼쪽 배열 값이 오른쪽 배열값보다 작거나 같으면, 왼쪽 배열의 값을 arr[]에 넣어줌
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                // 왼쪽 배열 값이 오른쪽 배열값보다 크면, 오른쪽 배열 값을 arr[]에 넣어줌
                arr[k++] = right[j++];
            }
        }
        // 왼쪽 배열이나 오른쪽 배열 중 하나가 먼저 정렬되었다면, 남은 값들을 마저 배열에 복사
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }



        public static void main(String[] args){
            int[] arr = {8, 2, 6, 4, 7, 3, 9 ,5};
            MergeSort mergesort = new MergeSort();
            mergesort.sort(arr);
            System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 6, 9]
        }
    }
