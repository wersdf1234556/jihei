package org.tonzoc.provider;

import org.apache.ibatis.builder.annotation.ProviderContext;

public interface IBaseProvider {

    String sql(ProviderContext providerContext);
}
