package com.xjn.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortData {
    private static final Integer[] DATA = new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, 77, 66, -2, 9, 29, 87, 78, 5, 4};
    private static final Integer[] DATA2 = new Integer[]{12, 78, 23, 56, 24, 0, 5, -7, 77, 66, -2, 9, 29, 87, 78, 5, 4};
    private static final List<Integer[]> BASE_DATA_LIST = new ArrayList<>();
    private static final List<Integer[]> DATA_LIST = new ArrayList<>();
    private static final List<double[]> DOUBLE_DATA_LIST = new ArrayList<>();

    static {
        // 所有待排序元素都不含null元素
        BASE_DATA_LIST.add(new Integer[]{});
        BASE_DATA_LIST.add(new Integer[]{1});
        BASE_DATA_LIST.add(new Integer[]{1, -2});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9, 29});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9, 29, 87});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9, 29, 87, 78});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9, 29, 87, 78, 5});
        BASE_DATA_LIST.add(new Integer[]{12, 78, 23, 56, 99, 1, 3, 8, 24, 0, 5, -7, -23, -11, 54, 77, 66, -2, 9, 29, 87, 78, 5, 4});
        DATA_LIST.addAll(BASE_DATA_LIST);
        for (int i = 1; i < 1000; i++) {
            Integer[] data = new Integer[i];
            for (int j = 0; j < i; j++) {
                data[j] = (int) (Math.random() * Integer.MAX_VALUE);
            }
            DATA_LIST.add(data);
        }

        DOUBLE_DATA_LIST.add(new double[]{});
        DOUBLE_DATA_LIST.add(new double[]{1.7});
        DOUBLE_DATA_LIST.add(new double[]{1.7, -2.5});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9, 99.98});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9, 99.98, 87.3});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9, 99.98, 87.3, 78.2});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9, 99.98, 87.3, 78.2, 5.7});
        DOUBLE_DATA_LIST.add(new double[]{12.8, 78.2, 23.0, 56.3, 99.9, 1.8, 3.7, 8.3, 24.5, 0.1, 5.7, -7.7, -23.3, -11.21, 54.8, 77.3, 66.6, -2.90, 99.9, 99.98, 87.3, 78.2, 5.7, 24.5});
    }

    public static Integer[] getData() {
        return Arrays.copyOf(DATA, DATA.length);
    }


    public static Integer[] getData2() {
        return Arrays.copyOf(DATA2, DATA2.length);
    }

    public static List<Integer[]> getDataList() {
        return new ArrayList<>(DATA_LIST);
    }

    public static List<Integer[]> getBaseDataList() {
        return new ArrayList<>(BASE_DATA_LIST);
    }

    public static List<double[]> getDoubleDataList() {
        return new ArrayList<>(DOUBLE_DATA_LIST);
    }
}
