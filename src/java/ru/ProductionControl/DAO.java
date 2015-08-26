/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ProductionControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitriy.mamishev
 */
public  class DAO {

    public static Set<Recipe> recipes = new HashSet<>();

    static {

    }

    public static Set<Recipe> getRecipes(){
        DAO.getRecips();
        return recipes;
    }

    public static void deleteRecipe(int id) {
        Iterator<Recipe> it = recipes.iterator();
        while (it.hasNext()) {
            Recipe one = it.next();
            if (one.getId() == id) {
                recipes.remove(one);
            }
        }
    }

    public static void getRecips() {
        try {
            ResultSet rs = ConnectDB.getDBQuery("111");
            Recipe recipe = new Recipe();
            while (rs.next()) {
                recipe.setId(rs.getInt("Id"));
                recipe.setMainIngredient("none");
                recipe.setDescription(rs.getString("Name"));
                recipes.add(recipe);
                
            }
            recipes.add(new Recipe(11, "solod", "fine thing"));
            recipes.add(new Recipe(2, "sahar", "76% of alcogol"));
            recipes.add(new Recipe(3, "hmel", "like beer"));
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadRecipt() {
        //ConnectDB.getConnection()
    }

    public static void insertRecipe(String a, String b) {
        recipes.add(new Recipe(recipes.size() + 1, a, b));
    }
    public static void main(String... ewe){
        DAO.getRecips();
        System.out.println(recipes);
    }
}
