/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ProductionControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmitriy.mamishev
 */
public  class DAO {

    public static List<Recipe> recipes = new ArrayList<>();

    static {

    }

    public static List<Recipe> getRecipes(){
        recipes.clear();
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
            Recipe recipe;
            while (rs.next()) {
                recipe = new Recipe();
                recipe.setId(rs.getInt("Id"));
                recipe.setMainIngredient(rs.getString("Description"));
                recipe.setDescription(rs.getString("Name"));
                recipes.add(recipe);
                
            }
            recipes.add(new Recipe(2, "from DAO", "76% of alcogol"));
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
