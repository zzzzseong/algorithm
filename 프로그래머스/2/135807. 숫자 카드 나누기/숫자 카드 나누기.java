import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> listA = new ArrayList<>();
        getDivisors(listA, getMin(arrayA));
        trueFilter(arrayA, listA);
        falseFilter(arrayB, listA);
        
        List<Integer> listB = new ArrayList<>();
        getDivisors(listB, getMin(arrayB)); 
        trueFilter(arrayB, listB);
        falseFilter(arrayA, listB);
        
        if(listA.isEmpty() && listB.isEmpty()) return 0;
        
        for(int n : listB) {
            listA.add(n);
        }
        
        Collections.sort(listA);
        
        return listA.get(listA.size()-1);
    }
    
    public void falseFilter(int[] array, List<Integer> list) {
        for(int i=list.size()-1; i>=0; i--) {
            int divisor = list.get(i);
            
            for(int j=0; j<array.length; j++) {
                if(array[j] % divisor == 0) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
    
    public void trueFilter(int[] array, List<Integer> list) {
        for(int i=list.size()-1; i>=0; i--) {
            int divisor = list.get(i);
            
            for(int j=0; j<array.length; j++) {
                if(array[j] % divisor != 0) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
    
    public void getDivisors(List<Integer> list, int min) {
        double sqrt = Math.sqrt(min);
        for(int i=2; i<=sqrt; i++) {
            if(min % i == 0) {
                list.add(i);
                list.add(min/i);
            }
        }
        list.add(min);
        
        Collections.sort(list);        
    }
    
    public int getMin(int[] array) {
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
}