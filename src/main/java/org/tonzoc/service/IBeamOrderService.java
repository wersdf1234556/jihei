package org.tonzoc.service;

import org.tonzoc.model.BeamOrderModel;

public interface IBeamOrderService extends IBaseService<BeamOrderModel> {

    void add (BeamOrderModel beamOrderModel);
}
