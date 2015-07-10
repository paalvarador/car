package com.semillasec.carmaintenance;

import android.graphics.drawable.Drawable;

/**
 * Created by root on 03/07/15.
 */
public class TypeMaintenance {
    protected Drawable icon;
    protected String title;
    protected String description;
    protected int id;

    public TypeMaintenance(Drawable icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public TypeMaintenance(Drawable icon, String title, String description, int id) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.id = id;
    }

    // Getters & Setters

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
