package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class SecurityRuleQueryParams {

    @Operator(value = "like", field = "rules")
    private String rules;

    @Operator(value = "eq", field = "guid")
    private String guid;

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
