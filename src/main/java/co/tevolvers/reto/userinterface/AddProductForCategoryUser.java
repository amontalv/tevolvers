package co.tevolvers.reto.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class AddProductForCategoryUser {

    public static final Target BTN_MENU_PHONES = Target.the("button for menu phones").locatedBy("//a[text()='Phones']");
    public static final Target BTN_MENU_LAPTOPS = Target.the("button for menu laptops").locatedBy("//a[text()='Laptops']");
    public static final Target BTN_MENU_MONITORS = Target.the("button for menu monitors").locatedBy("//a[text()='Monitors']");
    public static final Target BTN_OPTION_PRODUCT = Target.the("button select product").locatedBy("//a[contains(.,'{0}')]");
    public static final Target BTN_ADD_TO_CART = Target.the("button add to cart").locatedBy("//a[contains(.,'Add to cart')]");
    public static final Target BTN_HOME = Target.the("Button home").locatedBy("//a[text()='Home ']");
    public static final Target COUNT_RESULT = Target.the("products in the cart").locatedBy("//tr[@class ='success']");
    public static final Target BTN_CART = Target.the("button cart").locatedBy("//a[text()='Cart']");
}
