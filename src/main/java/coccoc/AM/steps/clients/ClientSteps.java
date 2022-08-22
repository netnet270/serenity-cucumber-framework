package coccoc.AM.steps.clients;

import coccoc.AM.common.Common;
import coccoc.AM.page.clients.ClientsPage;

public class ClientSteps extends Common {
    public void selectTab(String tab) {
        clickOnElement(String.format(ClientsPage.xpathTab, tab));
    }

    public void searchClients(String clients) {
        inputDataToFieldWithLabel("ID, Email, Phone", clients);
        clickOnButton("Filter");
    }

    public void clickClientName(String clients) {
        clickOnLinkWithLabel(clients);
    }
}
