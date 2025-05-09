function solution(schedules, timelogs, startday) {
    // startday가 6이거나 7이면 로직과 관계 없음
    let answer = 0;
    for(let i = 0; i<schedules.length; i++){
        const temp = new Schedule(schedules[i], timelogs[i]) 
        if(temp.hasGift(startday)) answer++;
    }
    return answer;
}

class Schedule {
    constructor(due, schedules){
        this.due = new Time(due)
        this.due.add(10) // 10분 준다 
        this.logs = []
        for(let t of schedules){
            this.logs.push(new Time(t))
        }
        
    }
    
    hasGift(day){
        for(let i = 0; i<this.logs.length; i++){
            if((day+i)%7 == 0 || (day+i)%7 == 6) continue;
            if(!this.due.isSafe(this.logs[i])) return false;
        }
        return true
    }
}

class Time {
    constructor(t){
        this.hour = Math.floor(t / 100)
        this.min = t % 100
    }
    
    add(mins){
        this.min += mins
        if(this.min >= 60){
            this.hour++
            this.min -= 60
        }
    }
    
    isSafe(newT){
        // 일찍 온다는 것은? newT.??(실제 출근 시간)이 this.??(기준 시간)보다 작다
        if(newT.hour > this.hour) return false
        else if(newT.hour == this.hour) {
            if(newT.min > this.min) return false
            return true
        }
        return true
    }
}