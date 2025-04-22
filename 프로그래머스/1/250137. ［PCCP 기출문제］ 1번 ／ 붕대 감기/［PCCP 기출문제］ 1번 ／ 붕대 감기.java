class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Heal game = new Heal(bandage, health);
        int prev = 0; // 직전 공격 시간을 나타냄
        
        for(int[] ouch : attacks){
            game.heal(ouch[0] - prev -1);
            prev = ouch[0];
            if(!game.attack(ouch[1])) return -1;
        }
    
        return game.health;
    }
}

class Heal {
    int time, sec, extra, health, max;
    Heal(int[] arr, int health){
        time = arr[0]; // 시전 시간
        sec = arr[1]; // 초당 회복량
        extra = arr[2]; // 추가 회복량
        this.health = max = health; // 최대 체력(초기 체력)
    }
    
    boolean attack(int damage) {
        health -= damage;
        if(health <= 0) {
         //   printOut();
            return false;
        }
     //   printOut();
        return true;
    }
    
    void printOut(){
        System.out.printf("Let me tell you bout' my condition : %d\n", health);
    }
    
    void heal(int seconds) { // n초 동안 heal
        health += seconds * sec;
        if(seconds >= time) health += seconds / time * extra;
        if(health > max) health = max; // 최대 체력 이상으로는 회복할 수 없다.
    //    printOut();
    }
    
}