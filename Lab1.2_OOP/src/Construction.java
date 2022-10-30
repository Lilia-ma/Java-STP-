public class Construction {
    int[] valuesArr;
    int[] weightArr;
    int[] rangesArr;
    int sum = 0;

    public Construction(int[] values, int[] weight) {
        valuesArr = values;
        weightArr = weight;
        rangesArr = new int[valuesArr.length];
        
        sum = 0;
        int a = 0;

        for (int i = 0; i < weightArr.length; i++)
            sum += weightArr[i];


        for (int i = 0; i < rangesArr.length; i++) {
            rangesArr[i] = a;
            a += weightArr[i];
        }
    }


    public int getNumber() {
        int random = (int) (Math.random() * (sum - 1));

        int index = 0;
        for (int i = 0; i < rangesArr.length; i++) {
            if (rangesArr[i] > random)
                break;
            index = i;
        }

        return valuesArr[index];
    }
}