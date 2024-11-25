package com.example.zapotrzebowaniedziennewody;

public class Zapotrzebowanie {
    public int waga;
    public int intensywnos;
    public boolean aktywny;

    public Zapotrzebowanie(int waga, int intensywnos, boolean aktywny) {
        this.waga = waga;
        this.intensywnos = intensywnos;
        this.aktywny = aktywny;
    }

    public double podajZapotrzebowanie(int waga, int intensywnos, boolean aktywny){

        if(aktywny){
            return (waga * 0.03) + (intensywnos/100 * 0.5);
        }
        else{
            return (waga * 0.03);

        }

    }


}
