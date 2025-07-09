package com.demo.gallery;

class Photograph {
    // properties
    byte frameWidth;
    String colorPhoto;
    String frameMaterial;
    String name;

    // behaviour
    void hang() {
        System.out.println("Hang on the rear wall");
    }

    // The inputs a function is passed as parameters.
    void changeOrientation(String orientation) {
        System.out.println("Orientation changed to : "
                + orientation);
    }

    boolean illuminate() {
      System.out.println("Switched on!");
        return true;
    }

    void autograph() {
        System.out.println("Autograph sing Syreyas" );
    }

}