public class WaterCalculator {

    public static long calculateWaterAmount(int[] landscape)  {
        checkLandscape(landscape);

        int result = 0;

        int countInRow = getCntZeros(landscape);
        while (countInRow != -1) {
            result += countInRow;
            decRowBy1(landscape);
            countInRow = getCntZeros(landscape);
        }
        return result;
    }

    private static void decRowBy1(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = arr[i] - 1;
            }
        }
    }

    private static int getCntZeros(int[] arr) {
        int result = 0;
        int leftBorder = -1;
        int rightBorder = -1;
        boolean isZeroPrevious = false;
        int cntZeros = 0;
        for (int i = 0; i< arr.length; i++) {

            if (arr[i] == 0) {
                rightBorder = -1;
                isZeroPrevious = true;
                cntZeros++;
            } else {
                if (leftBorder == -1) {
                    leftBorder = i;
                }
                rightBorder = i;
                if (leftBorder != -1 && rightBorder != -1 && leftBorder != rightBorder) {
                    result += rightBorder - leftBorder - 1;
                }
                if (isZeroPrevious) {
                    rightBorder = -1;
                }
                isZeroPrevious = false;
                leftBorder = i;
            }
        }
        if (cntZeros == arr.length)
            return -1;
        else
            return result;
    }


    private static void checkLandscape(int[] landscape) {
        if (landscape == null ||
                landscape.length > 32000 ||
                landscape.length < 3) {
            throw new IllegalArgumentException();
        }
        for (int h : landscape) {
            if (h < 0 || h > 32000) {
                throw new IllegalArgumentException();
            }
        }
    }


}
