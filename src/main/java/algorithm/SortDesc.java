package algorithm;

public class SortDesc {

    public int[] sortDesc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int value = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = value;
            }
        }
        return array;
    }
}
