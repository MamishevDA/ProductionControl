/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ProductionControl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class DAO {

    public static void deleteRecipe(int id) {
        Iterator<Recipe> it = recipes.iterator();
        while (it.hasNext()) {
            Recipe one = it.next();
            if (one.getId() == id) {
                recipes.remove(one);
            }
        }
    }

    public static List<Recipe> getRecipes() {
        recipes.clear();
        String sql = "SELECT \"Id\", \"Name\", \"Description\", \"MainIngredient\"\n"
                + "  FROM \"ProductionControl\".\"Recipe\" order by \"Id\"";
        try {
            ResultSet rs = ConnectDB.getDBQuery(sql);
            DAO.getColumnName(rs);
            Recipe recipe;
            while (rs.next()) {
                recipe = new Recipe();
                recipe.setId(rs.getInt("Id"));
                recipe.setName(rs.getString("Name"));
                recipe.setMainIngredient(rs.getString("MainIngredient"));
                recipe.setDescription(rs.getString("Description"));
                recipes.add(recipe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recipes;
    }

    public static List<Product> getProducts() {
        products.clear();
        String sql = "select \"Id\",\n"
                + "\"Name\",\n"
                + "\"Description\",\n"
                + "\"Classification\",\n"
                + "\"DateCook\",\n"
                + "\"IdRecipe\",\n"
                + "\"IdFermentation\",\n"
                + "\"IdDistillation\",\n"
                + "\"RatingCurrentDistillation\",\n"
                + "\"StartInfusionDate\",\n"
                + "\"EndInfusionDate\",\n"
                + "\"RatingEndProduct\",\n"
                + "\"DescriptionEndProduct\"\n"
                + " from \"ProductionControl\".\"Product\" order by 1";
        try {
            ResultSet rs = ConnectDB.getDBQuery(sql);
            DAO.getColumnName(rs);
            Product product;
            while (rs.next()) {
                product = new Product(rs);
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public static void loadRecipt() {
        //ConnectDB.getConnection()
    }

    public static boolean insertRecipe(Recipe recipe) {
        boolean isInserted = false;
        //recipes.add(new Recipe(recipes.size() + 1, a, b));
        isInserted = ConnectDB.addRecipt(recipe);
        return isInserted;
    }

    static void getColumnName(ResultSet rs) {
        StringBuilder columnName = new StringBuilder();
        try {
            ResultSetMetaData md = rs.getMetaData();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                if (i == 6 || i == 7 || i == 8) {
                    continue;
                }
                columnName.append(md.getColumnName(i));
                columnName.append(";");
            }
            DAO.columnName = columnName.toString().split(";");

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static List<Recipe> recipes = new ArrayList<Recipe>();
    private static List<Product> products = new ArrayList<Product>();

    public static String[] columnName;

    public static void main(String... ewe) {
        DAO.getProducts();
        System.out.println(products);
        System.out.println(columnName[2]);
    }
}
