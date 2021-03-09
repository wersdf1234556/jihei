package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class PersonNucleicInfoQueryParams {
    @Operator(value = "eq", field = "guid")
    private String guid;
    private String isRisk; //是否
}
