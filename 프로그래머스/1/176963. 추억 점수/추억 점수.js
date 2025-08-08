function solution(name, yearning, photo) {
    var answer = [];
    for(let j = 0; j<photo.length; j++){ // 사진마다
        let miniSum = 0;
        for(let k = 0; k<photo[j].length; k++){ // 인물마다
            for(let i = 0; i<name.length; i++){ // 이름 찾기
                if(name[i] === photo[j][k]) {
                    miniSum += yearning[i];
                    break;
                }
            }       
        }
        answer[j] = miniSum;
    }
    return answer;
}