/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import controllers.CategoriesController;
import javax.swing.JOptionPane;
import sources.Category;
import views.categories.List;
import views.main.ApplicationView;

/**
 *
 * @author nyko-
 */
public class CategoryForm {

    protected final Category category;
    protected final String action;

    public CategoryForm(int id) {
        this.action = "update";
        this.category = new CategoriesController().find(id);
    }

    public CategoryForm() {
        this.action = "create";
        this.category = new Category();
    }

    public String getName() {
        return this.category.getName();
    }

    public boolean isInactive() {
        return this.category.isInactive();
    }

    public boolean isActive() {
        return this.category.isActive();
    }

    public void save(String name, boolean active) {
        Category newCategory = new Category(name, active);

        String errors;

        if ("update".equals(this.action)) {
            errors = new CategoriesController().update(this.category.getId(), newCategory);
        } else {
            errors = new CategoriesController().create(newCategory);
        }

        if (errors == null || errors.isEmpty()) {
            goBackToList();
        } else {
            JOptionPane.showMessageDialog(null, errors);
        }
    }

    public void cancel() {
        goBackToList();
    }

    private void goBackToList() {
        List frame = new List();
        ApplicationView.changeInternalFrame(frame);
    }
}
