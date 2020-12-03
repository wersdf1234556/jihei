package org.tonzoc.controller.params;

import org.tonzoc.annotation.Operator;

public class AerialPhotographyLocationQueryParams {

    @Operator(value = "eq", field = "aerialPhotographyGuid")
    private String aerialPhotographyGuid;

    public AerialPhotographyLocationQueryParams() {

    }

    public String getAerialPhotographyGuid() {
        return aerialPhotographyGuid;
    }

    public void setAerialPhotographyGuid(String aerialPhotographyGuid) {
        this.aerialPhotographyGuid = aerialPhotographyGuid;
    }
}
