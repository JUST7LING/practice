function solution(players, callings) {
    const findByName = new Map()
    const findByOrder = new Map()
    
    for(let i = 0; i<players.length; i++){
        findByName.set(players[i], i)
        findByOrder.set(i, players[i])
    }
    
    for(let call of callings){
        let calledOrder = findByName.get(call) - 1
        let overtakenName = findByOrder.get(calledOrder)
        let overtakenOrder = findByName.get(overtakenName) + 1
        findByName.set(call, calledOrder)
        findByOrder.set(calledOrder, call)
        findByName.set(overtakenName, overtakenOrder)
        findByOrder.set(overtakenOrder, overtakenName)
        
        players[overtakenOrder] = overtakenName
        players[calledOrder] = call
    }
    
    return players;
}