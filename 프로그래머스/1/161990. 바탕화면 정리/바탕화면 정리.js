function solution(wallpaper) {
    // 얼핏 최단거리? 어려워보이지만 사실은 max값 갱신을 통한 단순구현
    // 만약 역으로 거리를 주고 최대한 많은 파일을 선택하라고 했다면 오히려 골치아팠을 것 
    
    // 로직은 간단하다. 
    // 각 상하좌우 max, min값을 구해서 좌표를 도출하면 됨
    // 드래그를 할 때는 x로나 y로나 증가하는 방향으로만 기능하므로
    // 왼쪽, 위에 있는 요소는 min값을, 오른쪽, 아래에 있는 요소는 max값을 이용해 구하면 된다.
    // 다만 인덱스에 파일이 있는 게 아니고 인덱스 사이에 파일이 있는 구조이므로 인덱싱에 유의.
    
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