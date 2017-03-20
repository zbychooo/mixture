package com.tribble2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeDefinition implements Tribbleable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "internal_name", nullable = false)
    private String internalName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "icon_path")
    private String iconPath;

    @Column(name = "instantiable", nullable = false, columnDefinition = "boolean default true")
    private boolean instantiable;

    @Column(name = "columnId")
    private Long parentId;

    public TypeDefinition() {}

    public TypeDefinition(String internalName, String displayName, String description, String iconPath, boolean instantiable, Long parentId) {
        this.internalName = internalName;
        this.displayName = displayName;
        this.description = description;
        this.iconPath = iconPath;
        this.instantiable = instantiable;
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public boolean isInstantiable() {
        return instantiable;
    }

    public void setInstantiable(boolean instantiable) {
        this.instantiable = instantiable;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TypeDefinition{" +
                "id=" + id +
                ", internalName='" + internalName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", instantiable=" + instantiable +
                ", parentId=" + parentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeDefinition that = (TypeDefinition) o;

        if (instantiable != that.instantiable) return false;
        if (!id.equals(that.id)) return false;
        if (!internalName.equals(that.internalName)) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (iconPath != null ? !iconPath.equals(that.iconPath) : that.iconPath != null) return false;
        return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + internalName.hashCode();
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (iconPath != null ? iconPath.hashCode() : 0);
        result = 31 * result + (instantiable ? 1 : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}
