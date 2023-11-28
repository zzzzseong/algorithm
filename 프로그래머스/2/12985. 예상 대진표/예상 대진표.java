class Solution
{
    public int solution(int n, int a, int b)
    {           
        return getPower(n, 0) - getRound(n, a, b, 1, 0);
    }
    
    public int getRound(int n, int a, int b, int sIdx, int depth) {
        int mIdx = (sIdx+n-1)/2;
        int eIdx = n;
        
        if(a >= sIdx && a <= mIdx) {
            if(b >= mIdx+1 && b <= eIdx) return depth;
            else return getRound(mIdx, a, b, sIdx, depth+1);
        }
        if(a >= mIdx+1 && a <= eIdx) {
            if(b >= sIdx && b <= mIdx) { 
                return depth;
            }
            else return getRound(eIdx, a, b, mIdx+1, depth+1);
        }
        
        return depth;
    }
    
    public int getPower(int n, int depth) {
        if(n == 2) return depth+1;
        else return getPower(n/2, depth+1);
    }
}