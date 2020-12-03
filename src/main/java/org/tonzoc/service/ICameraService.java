package org.tonzoc.service;

import org.tonzoc.model.CameraModel;

public interface ICameraService extends IBaseService<CameraModel> {
    void insertStack(CameraModel cameraModel);
}
