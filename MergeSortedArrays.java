import java.util.*;


class MergeSortedArrays {

  public static int[] mergeArrays(int[] firstArray, int[] secondArray) {

    int firstArraySize = firstArray.length;
    int secondArraySize = secondArray.length;

    // Minor optimization
    if (firstArraySize == 0) {
      return secondArray;
    } else if (secondArraySize == 0) {
      return firstArray;
    }

    int[] mergedArray = new int[firstArraySize + secondArraySize];
    int mergeIndex = 0;
    int firstIndex = 0;
    int secondIndex = 0;

    // Iterate through both arrays until we reach the end of one of the arrays
    int firstNum, secondNum;
    while (firstIndex < firstArraySize && secondIndex < secondArraySize) {
      firstNum = firstArray[firstIndex];
      secondNum = secondArray[secondIndex];

      if (firstNum < secondNum) {
        mergedArray[mergeIndex] = firstArray[firstIndex];
        firstIndex++;
      } else {
        mergedArray[mergeIndex] = secondArray[secondIndex];
        secondIndex++;
      }
      mergeIndex++;
    }

    // Transfer the remaining numbers
    if (firstIndex == firstArraySize) {
      for (int i = secondIndex; i < secondArray.length; i++) {
        mergedArray[mergeIndex] = secondArray[i];
        mergeIndex++;
      }
    } else {
      for (int i = firstIndex; i < firstArray.length; i++) {
        mergedArray[mergeIndex] = firstArray[i];
        mergeIndex++;
      }
    }

    return mergedArray;
  }

  public static void main(String[] args) {
    int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
    int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

    System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
  }
}
