package com.tribble2.model;

import javax.persistence.*;

@Entity
@Table(name = "AttributeDefinition")
public class AttributeDefinition implements Tribbleable {

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

    @Column(name = "attribute_type", columnDefinition = "VARCHAR(255)")
    private AttributeType attributeType;

    public AttributeDefinition() {}

    public AttributeDefinition(String internalName, String displayName, String description, AttributeType attributeType) {
        this.internalName = internalName;
        this.displayName = displayName;
        this.description = description;
        this.attributeType = attributeType;
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

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeDefinition that = (AttributeDefinition) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (internalName != null ? !internalName.equals(that.internalName) : that.internalName != null) return false;
        if (displayName != null ? !displayName.equals(that.displayName) : that.displayName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return attributeType == that.attributeType;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (internalName != null ? internalName.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (attributeType != null ? attributeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttributeDefinition{" +
                "id=" + id +
                ", internalName='" + internalName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", attributeType=" + attributeType +
                '}';
    }
}