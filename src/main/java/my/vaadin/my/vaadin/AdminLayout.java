package my.vaadin.my.vaadin;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.TextField;

/**
 * !! DO NOT EDIT THIS FILE !!
 * <p>
 * This class is generated by Vaadin Designer and will be overwritten.
 * <p>
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class AdminLayout extends VerticalLayout {
    private Button kurwa;
    private Image stonka;
    private CheckBox check;
    private TextField chuj;

    public AdminLayout() {
        Design.read(this);
    }

    public Button getKurwa() {
        return kurwa;
    }

    public Image getStonka() {
        return stonka;
    }

    public CheckBox getCheck() {
        return check;
    }

    public TextField getChuj() {
        return chuj;
    }

}
