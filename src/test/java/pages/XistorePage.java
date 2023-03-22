package pages;

public class XistorePage {
    public static final String URL ="https://xistore.by/";
    public static final String BTN_ENTER = "//a[@class='navigation-cabinet-link']";
    public static final String INPUT_MAIL = "//input[@name='USER_LOGIN']";
    public static final String INPUT_PASSWORD = "//input[@type='password']";
    public static final String BTN_INTER_SUBMIT = "//input[@value='ВОЙТИ']";
    // public static final String BTN_CHECK_REGISTRATION = "//a[@aria-expanded='true']";
    public static final String BTN_CHECK_REGISTRATION ="/html/body/div[2]/div[1]/div/div/div/nav[3]/ul";
    public static final String LINK_MAIL ="//span[@href='/personal/']";
    public static final String LOGIN_WRONG_MAIL = "(//p//font[@class='errortext'])[1]";
    // public static final String BTN_CATALOG_PHONE = "//li[@class='hover']/a[@href='/catalog/telefony/']";
    public static final String BTN_CATALOG_PHONE = "(//a[@href='/catalog/telefony/'])[2]";
    // public static final String SELECTION_PHONE = "//*[@id='bx_2080272952_88441']/div/a[15]";
    public static final String SELECTION_PHONE = "(//div[@class='accessories__block']/div)[1]";
    public static final String NAME_PHONE = "//*[@id='bx_2369550383_88441']/div/div[1]/div[3]/div[1]/div[1]/div[1]/h1";
    public static final String BTN_PLACE_AN_ORDER_CART = "//a[@id='bx_2369550383_88441_buy_link']";
    public static final String BTN_CLOSE = "//a[@class='close js-close-popapBuy']";
    public static final String BTN_INPUT_CART ="//a[@class='top-panel-basket-link']";
    public static final String NAME_PHONE_IN_CART ="//div[@class='bx_ordercart_itemtitle mbw-name']";
}
