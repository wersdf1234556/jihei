package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AttendanceQueryParams;
import org.tonzoc.controller.params.CameraTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.CameraTypeModel;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.service.ICameraTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("attendance")
public class AttendanceController extends BaseController {

    @Autowired
    private IAttendanceService attendanceService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AttendanceQueryParams attendanceQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println(pageQueryParams.getOrder());
        Page<AttendanceModel> page = parsePage(pageQueryParams);
        AttendanceQueryParams sqlQueryParamList = new AttendanceQueryParams();
        if (attendanceQueryParams.getGuid() != null && !attendanceQueryParams.getGuid().equals("")) {
            sqlQueryParamList.setGuid(attendanceQueryParams.getGuid());
        }if (attendanceQueryParams.getIdCard() != null && !attendanceQueryParams.getIdCard().equals("")) {
            sqlQueryParamList.setIdCard(attendanceQueryParams.getIdCard());
        }if (attendanceQueryParams.getAttDate() != null && !attendanceQueryParams.getAttDate().equals("")) {
            sqlQueryParamList.setAttDate(attendanceQueryParams.getAttDate());
        }

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(sqlQueryParamList);
        List list = attendanceService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AttendanceModel attendanceModel) {
        this.attendanceService.save(attendanceModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AttendanceModel attendanceModel) {
        this.attendanceService.update(attendanceModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.attendanceService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        attendanceService.removeMany(guids);
    }

}
