/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ProductionControl;

/**
 *
 * @author dmitriy.mamishev
 */
public class Recipe {
    int id;
    String mainIngredient;
    String description;

    public Recipe(){
        
    }
    public Recipe(int id, String mainIngredient, String description) {
        this.id = id;
        this.mainIngredient = mainIngredient;
        this.description = description;
    }

    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", mainIngredient=" + mainIngredient + ", description=" + description + '}';
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
