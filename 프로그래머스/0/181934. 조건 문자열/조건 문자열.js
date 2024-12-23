function solution(ineq, eq, n, m) {
    switch(typeClassy(ineq, eq)){
        case 0: return n >= m ? 1 : 0
        case 1: return n > m ? 1 : 0
        case 2: return n <= m ? 1 : 0
        case 3: return n < m ? 1 : 0
    }
}

const typeClassy = (ineq, eq) => {
    if(ineq === ">"){
        if(eq === "=") return 0
        return 1
    }else{
        if(eq === "=") return 2
        return 3
    }
}

