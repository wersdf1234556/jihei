package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class BeamPedestalProvider {

    public String selectByNum(@Param(value = "name") String name,
                              @Param(value = "num") String num) {

        StringBuilder stringBuilder = new StringBuilder("select * from beamPedestals as MainTable where " + name + " = " + num);

        return stringBuilder.toString();
    }
}
