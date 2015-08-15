/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ProductionControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author dmitriy.mamishev
 */
public class DAO {
   static HashSet<Recipe> recipes = new HashSet<>();
   static {
   recipes.add(new Recipe(1,"solod","fine thing"));
   recipes.add(new Recipe(2,"sahar","76% of alcogol"));
   recipes.add(new Recipe(3,"hmel","like beer"));
           }
    public static HashSet<Recipe> getRecipes(){
        return recipes;
    }
    public static void deleteRecipe(int id){
        Iterator<Recipe> it = recipes.iterator();
        while(it.hasNext()){
            Recipe one = it.next();
            if(one.getId() == id){
                recipes.remove(one);
            }
        }
    }
    public static void insertRecipe(String a,String b){
        recipes.add(new Recipe(recipes.size()+1, a, b));
    }
}
