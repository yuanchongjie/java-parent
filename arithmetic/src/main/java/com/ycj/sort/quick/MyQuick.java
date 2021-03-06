package com.ycj.sort.quick;

import com.google.common.base.Stopwatch;
import com.ycj.sort.Sort;
import com.ycj.util.ArrayDataUtil;
import org.springframework.util.Assert;

import java.util.Arrays;

public class MyQuick implements Sort<Integer> {
    @Override
    public void sort(Integer[] a) {

        quickSort(a, 0, a.length-1);
    }

    public void quickSort(Integer[] a, int l, int h) {
        if (l>=h) {
            return;
        }

        int resultIndex = partition(a, l, h);
        quickSort(a, l, resultIndex);
        quickSort(a, resultIndex + 1, h);


    }

    public int partition(Integer[] a, int l, int h) {


        int p = a[l];
        int low = l;
        int high = h+1;
        while(true){


            while(a[++low]<p){
                if(low==h){
                    break;
                }
            }
            while(a[--high]>p){
                if(high==l){
                    break;
                }
            }
            if(low>=high){
                break;
            }
            exch(a,low,high);
        }
        exch(a,l,high);
        return high;

    }

    public static void main(String[] args) {

        Integer[] source = ArrayDataUtil.getUniqueRandomIntArray(10000, 100000);
        System.out.println(Arrays.toString(source));
        Stopwatch stopwatch = Stopwatch.createStarted();
        MyQuick quick = new MyQuick();
        quick.sort(source);
        Assert.isTrue(quick.isSorted(source), "数组不是有序");
        System.out.println(Arrays.toString(source));
        System.out.println(stopwatch.elapsed()
                                    .toMillis());

    }
}
