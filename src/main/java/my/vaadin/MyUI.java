package my.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    // Add the next two lines:
    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);
    private TextField filterText = new TextField();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

//        final TextField name = new TextField();
//        name.setCaption("Type your name here:");

//        Button button = new Button("Click Me");
//        button.addClickListener(e -> {
//            layout.addComponent(new Label("Thanks " + name.getValue()
//                    + ", it works!"));
//        });
//
//        layout.addComponents(name, button);

        filterText.setPlaceholder("filter by name...");
        filterText.addValueChangeListener(e -> updateList());
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        grid.setColumns("firstName", "lastName", "email");

        // add Grid to the layout
        layout.addComponents(filtering, grid);

        updateList();

        setContent(layout);

//        AdminLayout admin = new AdminLayout();
//        admin.addComponents(admin.getCheck(), admin.getChuj(), admin.getKurwa(), admin.getStonka());
//        setContent(admin);
    }

    public void updateList() {
        // fetch list of Customers from service and assign it to Grid
        List<Customer> customers = service.findAll(filterText.getValue());
        grid.setItems(customers);
    }

    //Button admin = new Button("Go to admin");

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
