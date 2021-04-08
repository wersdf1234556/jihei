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
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.support.*;
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

    @PostMapping(value = "insertGateData")
    public Integer insertGateData(@RequestBody @Valid AttendanceModel attendanceModel){
        return attendanceService.insertGateData(attendanceModel);
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

    @GetMapping(value = "statAllCategory")
    public List<StatTotalModel> statAllCategory(String date){
        return attendanceService.statAllCategory(date);
    }

    //人员左下角按categoryGuid统计personType人员考勤
    @GetMapping(value = "statByPersonCategory")
    public List<AttendanceStatModel> statByPersonCategory(String categoryGuid,String date){
        return attendanceService.statByPersonCategory(categoryGuid,date);
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

    //安全模块左下角安全员打卡统计
    @GetMapping(value = "statBySecurity")
    public List<AttendanceStatModel> statBySecurity(String date){
        return attendanceService.statBySecurity(date);
    }

    // 预警信息
    @GetMapping(value = "warningInformation")
    public List<AttendanceModel> warningInformation(){

        return attendanceService.warningInformation();
    }

    // 测温情况
    @GetMapping(value = "temperature")
    public List<ReturnPersonModel> temperature(){

        return attendanceService.temperature();
    }

    // 统计超温的测温人数
    @GetMapping(value = "temperatureNumber")
    public String temperatureNumber(){

        return attendanceService.temperatureNumber();
    }

    // 超温的人员
    @GetMapping(value = "temperaturePerson")
    public List<PersonModel> temperaturePerson(){

        return attendanceService.temperaturePerson();
    }
}
