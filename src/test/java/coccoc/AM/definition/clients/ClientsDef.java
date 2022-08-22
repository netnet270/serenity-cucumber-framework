package coccoc.AM.definition.clients;

import coccoc.AM.steps.clients.ClientSteps;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ClientsDef {
    @Steps
    ClientSteps clientSteps;
    @Then("select client {string}")
    public void select_client(String clients) {
        clientSteps.selectTab("All");
        clientSteps.searchClients(clients);
        clientSteps.clickClientName(clients);
    }
}
