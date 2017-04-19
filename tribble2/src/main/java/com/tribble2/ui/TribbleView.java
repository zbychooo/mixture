package com.tribble2.ui;


import com.tribble2.db.AttributeDefinitionRepository;
import com.tribble2.db.TypeDefinitionRepository;
import com.tribble2.model.TypeDefinition;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Item;
import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("reindeer") //TODO:
public class TribbleView extends UI {

    public static final String DISPLAY_NAME = "displayName";
    private TypeDefinitionRepository typeRepo;
    private AttributeDefinitionRepository attrRepo;
    private HorizontalLayout layout;
    private TypeDefinitionEditView editView;
    private Tree tree;

    @Autowired
    public TribbleView(TypeDefinitionRepository typeRepo, AttributeDefinitionRepository attrRepo) {
        this.typeRepo = typeRepo;
        this.attrRepo = attrRepo;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setupMainLayout();
        setupLeftPanel();
        layout.addComponent(editView);
    }

    private void setupMainLayout() {

        layout = new HorizontalLayout();
        layout.setSpacing(true);
        setContent(layout);

        editView = new TypeDefinitionEditView();
        editView.setVisible(false);
    }

    private void setupLeftPanel() {

        tree = new Tree("Tree");
        tree.setIcon(FontAwesome.INBOX);
        tree.addContainerProperty(DISPLAY_NAME, String.class, "");
//        tree.addContainerProperty("hw_PROPERTY_ICON", ThemeResource.class,
//                new ThemeResource("../runo/icons/16/document.png"));
        tree.setItemCaptionPropertyId(DISPLAY_NAME);
        typeRepo.getRootTypes().stream().forEach(root -> {
            assignChild(null, root);
        });

        tree.addExpandListener(event -> {
            TypeDefinition parent = (TypeDefinition) event.getItemId();
            typeRepo.getChildrenTypes(parent.getId()).stream().forEach(child -> {
                if (tree.getItem(child) == null) {
                    assignChild(parent, child);
                }
            });
        });

        tree.addItemClickListener(event -> {
            loadRightTop(event.getItemId());
        });


        Button addButton = new Button("Add");
        addButton.setIcon(FontAwesome.PLUS);
        layout.addComponent(addButton);
        layout.addComponent(tree);
    }

    private void assignChild(TypeDefinition parent, TypeDefinition child) {
        Item item = tree.addItem(child);
        item.getItemProperty(DISPLAY_NAME).setValue(child.getDisplayName());
//        item.getItemProperty("hw_PROPERTY_ICON").setValue(               FontAwesome.FILE);
        tree.setParent(child, parent);
    }

    private void loadRightTop(Object object) {

        if (!(object instanceof TypeDefinition)) {
            Notification.show("Something went wrong!", Notification.Type.ERROR_MESSAGE);
        }

        TypeDefinition typeDefinition = (TypeDefinition) object;

        if (!editView.isVisible()) {
            editView.setVisible(true);
        }
        editView.update(typeDefinition);
    }


    private class TypeDefinitionEditView extends FormLayout {

        private final TextField internalName;
        private final TextField displayName;
        private final TextArea description;
        private final TextField iconPath;
        private final CheckBox instantiable;
        private final FieldGroup fieldGroup;

        private final Button editButton;
        private final Button deleteButton;

        private TypeDefinitionEditView() {

            internalName = new TextField("Internal Name");
            internalName.setEnabled(false);


            displayName = new TextField("Display Name");
            description = new TextArea("Description");
            iconPath = new TextField("Icon Path");
            instantiable = new CheckBox("Instantiable");
            fieldGroup = new FieldGroup();
            editButton = new Button("Edit");
            editButton.setIcon(FontAwesome.EDIT);
            editButton.addClickListener(clickEvent -> {

                Item itemDataSource = fieldGroup.getItemDataSource();


                System.out.println("edit: " + itemDataSource);
            });
            deleteButton = new Button("Delete");
            deleteButton.setIcon(FontAwesome.REMOVE);
            deleteButton.addClickListener(clickEvent -> {
                System.out.println("delete: " + clickEvent.getSource());
            });

            setSpacing(true);

            addComponents(editButton, deleteButton, internalName, displayName, description, iconPath, instantiable);
        }

        public void update(TypeDefinition typeDefinition) {
            fieldGroup.setItemDataSource(new BeanItem<>(typeDefinition));
            fieldGroup.setBuffered(false);
            fieldGroup.bindMemberFields(this);

        }

    }

}
