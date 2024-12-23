function solution(ineq, eq, n, m) {
    return calc(typeClassy(ineq, eq), n, m) ? 1 : 0
}

const typeClassy = (ineq, eq) => {
    const ret = ineq === ">" ? eq === "=" ? 0 : 1 : eq === "=" ? 2 : 3
    return ret
}

const calc = (tc, n, m) => {
    switch(tc){
      case 0: return n >= m 
      case 1: return n > m  
      case 2: return n <= m 
      case 3: return n < m        
    }
}

