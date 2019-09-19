package com.example.oderfoods;

public class Foods {
    int cost;
    boolean check;

    public Foods(boolean check) {
        this.check = check;
    }

    public Foods(int cost, boolean check) {
        this.cost = cost;
        this.check = check;
    }

    public Foods() {

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
