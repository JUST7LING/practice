class Solution {
    public boolean nIsGreaterThanM (String ineq) {
        if(ineq.equals(">")) return true;
        return false;
    }
    
    public boolean nIsSameWithM (String eq) {
        if(eq.equals("=")) return true;
        return false;
    }
    
    public int solution(String ineq, String eq, int n, int m) {
        boolean val = false;
        if(nIsGreaterThanM(ineq)){
            if(nIsSameWithM(eq) && n >= m) val = true;
            else if(!nIsSameWithM(eq) && n > m) val = true;
        }else{
            if(nIsSameWithM(eq) && n <= m) val = true;
            else if(!nIsSameWithM(eq) && n < m ) val = true;
        }
        return val ? 1 : 0;
    }
}