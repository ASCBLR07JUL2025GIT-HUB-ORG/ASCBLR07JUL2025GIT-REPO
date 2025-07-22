package com.demo.inheritance;

public class DynamicPolymorphismEx {
    public static void main(String[] args) {
        Movie1 freeSolo = null;
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) {
            freeSolo = new Movie1();
            freeSolo.play();
        } else {
            freeSolo = new FourKMovie();
            freeSolo.play();
        }
    }
}


class Movie1 {

    public void play() {
        System.out.println("Playing movie");
    }
    public void play(String subtitle) {
        System.out.println("Playing movie with subtitle: " + subtitle);
    }
}

class FourKMovie extends Movie1 {

    public void play() {
        System.out.println("Playing  4k movie");
    }
    public void play(String subtitle) {
        System.out.println("Playing movie with subtitle and 4k: " + subtitle);
    }
}