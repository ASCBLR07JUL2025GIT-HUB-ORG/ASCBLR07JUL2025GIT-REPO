package com.demo.gallery;

//
class GalleryApp {
    public static void main(String args[]) {
        System.out.println("Welcome to WrokDen Gallery!");
        // Create a reference
        Photograph hdPhoto;
        // Create the instance
        hdPhoto = new Photograph();
        // Access the object
        // Set the name
        // Accessing the property
        hdPhoto.name = "Nandhi Hills";
        System.out.println(hdPhoto.name);
        // Access the methods
        hdPhoto.hang();
        hdPhoto.changeOrientation("Landscape!");

        boolean isIlluminated = hdPhoto.illuminate();
        if(isIlluminated) {
            System.out.println("Glowing Photo!");
        }
        hdPhoto.autograph();
    }
}

//Implement the rooted Tree.
// Implement your own system which you identified in the morning.