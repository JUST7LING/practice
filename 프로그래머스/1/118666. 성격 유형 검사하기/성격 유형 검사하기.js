/*
    1. 성격 지표 관리하는 방법
        * 2차원 배열로 관리 
        * [[R, T],[C, F], [J, M], [A, N]]
    2. 점수 합산하는 방식
        * 좀 더 빠르게 -> Map에 key, value 집어넣고 index return되도록 짜면 됨
    3. '4'번을 선택한 경우 0점 -> 4와 몇 점 차이인지 계산하여 합산
*/

function solution(survey, choices) {
    // 2차원 배열 만들고 0으로 채우기
    let types = Array.from({length: 4}, () => Array(2).fill(0))
    const typeChar = [["R", "T"], ["C", "F"], ["J", "M"], ["A", "N"]]
    const typeMap = new Map()
    typeMap.set("R", [0, 0])
    typeMap.set("T", [0, 1])
    typeMap.set("C", [1, 0])
    typeMap.set("F", [1, 1])
    typeMap.set("J", [2, 0])
    typeMap.set("M", [2, 1])
    typeMap.set("A", [3, 0])
    typeMap.set("N", [3, 1])
    
    let index = 0;
    for(question of survey){
        const choice = choices[index]
        let target
        if(choice < 4) {
            target = typeMap.get(question[0]) 
            types[target[0]][target[1]] += 4 - choice % 4
        }
        if(choice > 4) {
            target = typeMap.get(question[1])
            types[target[0]][target[1]] += choice % 4
        }
        index++
    }
    
    let result = ""
    for(let i = 0; i<types.length; i++){
        types[i][0] < types[i][1] ? result += typeChar[i][1] : result += typeChar[i][0]
    }
    
    return result
}

