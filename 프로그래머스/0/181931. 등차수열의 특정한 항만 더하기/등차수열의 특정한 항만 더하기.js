function solution(a, d, included) {
    var answer = 0;
    included.map((each) => {
        if(each) answer += a;
        a += d ;
    })
    return answer;
}