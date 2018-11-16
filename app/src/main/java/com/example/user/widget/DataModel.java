package com.example.user.widget;

import android.content.ComponentName;

public class DataModel {

    String label;
    String pkgName;

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    ComponentName provider;
    ComponentName configure;
    int icon;
    int previewImage;
    int widgetCategory;

    public DataModel(String label,String pkgName, ComponentName provider, ComponentName configure, int icon, int previewImage, int widgetCategory) {
        this.label = label;
        this.pkgName = pkgName;
        this.provider = provider;
        this.configure = configure;
        this.icon = icon;
        this.previewImage = previewImage;
        this.widgetCategory = widgetCategory;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ComponentName getProvider() {
        return provider;
    }

    public void setProvider(ComponentName provider) {
        this.provider = provider;
    }

    public ComponentName getConfigure() {
        return configure;
    }

    public void setConfigure(ComponentName configure) {
        this.configure = configure;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(int previewImage) {
        this.previewImage = previewImage;
    }

    public int getWidgetCategory() {
        return widgetCategory;
    }

    public void setWidgetCategory(int widgetCategory) {
        this.widgetCategory = widgetCategory;
    }
}
