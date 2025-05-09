function solution(wallpaper) {
    // 각 상하좌우 max, min값을 구해서 좌표를 도출
    
    let minR, minC, maxR, maxC;
    minR = minC = Number.MAX_SAFE_INTEGER
    maxR = maxC = 0
    
    for(let i = 0; i<wallpaper.length; i++){
        for(let j = 0; j<wallpaper[0].length; j++){
            if(wallpaper[i][j] === "#"){
                if(i > maxR) maxR = i
                if(i < minR) minR = i
                if(j > maxC) maxC = j
                if(j < minC) minC = j
            }
        }
    }
    
    var answer = [minR, minC, maxR+1, maxC+1];
    return answer;
}