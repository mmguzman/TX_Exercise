package ui.pages;

import ui.components.TopMenu;

public class MyStoreHomePage extends BasePageObject{

    private TopMenu topMenu;

    public MyStoreHomePage() {
        topMenu = new TopMenu();
    }

    @Override
    public void waitUntilPageIsLoaded() {
    }

    /**
     * Gets the TopMenu page
     * @return
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }
}
