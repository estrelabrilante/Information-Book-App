package com.example.informationbook;
//created a Model class called ModelClass.java for defining the data to be populated on the Recycle View.
public class ModelClass {

    private String imageName;
    private String categoryName;
    //Full Constructor---not an empty constructor.
    public ModelClass( String imageName, String categoryName ) {
        this.imageName = imageName;
        this.categoryName = categoryName;
    }
    //no need of SET method as data not gonna change.

    //GET method
    public String getImageName() {
        return imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
