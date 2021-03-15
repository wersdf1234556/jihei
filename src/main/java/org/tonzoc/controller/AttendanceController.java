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
import org.tonzoc.model.support.AttDateStatModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.model.support.PersonLocationDataModel;
import org.tonzoc.model.support.StatTotalModel;
import org.tonzoc.service.IAttendanceService;
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
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(attendanceQueryParams);
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

//    @GetMapping(value = "statAttendanceData")
//    public List<Object> statAttendanceData(String date,Integer flag){
//        return attendanceService.statAttendanceData(date,flag);
//    }
    //疫情防控右上、右下根据日期查考勤数及体温
    @GetMapping(value = "statByMonth")
    public List<AttDateStatModel> statByMonth(String date){
        return attendanceService.statByMonth(date);
    }

    //疫情防控左上角按a、b、s、z的标段类型进行考勤统计查询
    @GetMapping(value = "statByTenderType")
    public List<AttendanceStatModel> statByTenderType(String date){
        return attendanceService.statByTenderType(date);
    }

    //人员模块查询每个人指定日期最后一条定位信息
    @GetMapping(value = "listLocationDatas")
    public List<PersonLocationDataModel> listPersonLocationDatas(String categoryGuid,String date){
        return attendanceService.listPersonLocationDatas(categoryGuid,date);
    }
    //人员右上饼图统计数据
    @GetMapping(value = "statAll")
    public StatTotalModel statAll(String categoryGuid, String date){
        return attendanceService.statAll(categoryGuid,date);
    }
    //疫情左上角按市统计人员饼图
    @GetMapping(value = "countPersonByCity")
    public List<AttendanceStatModel> countPersonByCity(){
        return attendanceService.countPersonByCity();
    }
    //疫情左上角按风险等级统计人数
    @GetMapping(value = "countByRisk")
    public List<AttendanceStatModel> countByRisk(){
        return attendanceService.countByRisk();
    }
}
