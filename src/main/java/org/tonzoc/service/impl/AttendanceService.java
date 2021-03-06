package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.mapper.AttendanceMapper;
import org.tonzoc.mapper.PersonMapper;
import org.tonzoc.model.*;
import org.tonzoc.model.support.*;
import org.tonzoc.service.*;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service(value = "attendanceService")
public class AttendanceService extends BaseService<AttendanceModel> implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private IPersonTypeService personTypeService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private ITenderService tenderService;
    @Autowired
    private IPersonCategoryService personCategoryService;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private IAreaDataService areaDataService;

    public List<AttendanceModel> listBySignAndDate(String sign, String createdAt) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("personGuid", sign, "eq"));
        sqlQueryParams.add(new SqlQueryParam("createdAt", createdAt, "dateLike"));
        List<AttendanceModel> list = this.list(sqlQueryParams);

        return list;
    }

    //添加闸机数据
    public Integer insertGateData(AttendanceModel attendanceModel) {

        if (attendanceModel.getIdCard() != null) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("idCard", attendanceModel.getIdCard(), "eq"));
            List<PersonModel> personModels = personService.list(sqlQueryParams);
            if (personModels.size() != 0) {
                PersonModel personModel = personModels.get(0);
                attendanceModel.setPersonGuid(personModel.getGuid());
                if (attendanceModel.getSign() == null) {
                    attendanceModel.setSign(0);
                } else {
                    attendanceModel.setSign(1);
                }

                if (attendanceModel.getSign() == 0) {
                    TenderModel tenderModel = tenderService.get(personModel.getTenderGuid());
                    attendanceModel.setLng(tenderModel.getLng());
                    attendanceModel.setLat(tenderModel.getLat());
                }

//                    if (attendanceModel.getSign() == 0) {
//                        List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
//                        sqlQueryParams1.add(new SqlQueryParam("name", attendanceModel.getAddress(), "eq"));
//                        List<TenderModel> tenderModels = this.tenderService.list(sqlQueryParams1);
//                        if (tenderModels.size() == 1) {
//                            TenderModel tenderModel = tenderModels.get(0);
//                            attendanceModel.setLng(tenderModel.getLng());
//                            attendanceModel.setLat(tenderModel.getLat());
//                        }
//                    }

                if (new BigDecimal(attendanceModel.getTemperature()).compareTo(new BigDecimal("37.3")) > 0) { // 大于37.3
                    attendanceModel.setStatus(1);
                } else {
                    attendanceModel.setStatus(0);
                }
                save(attendanceModel);
                return 0;
            }
        }
        return 1;

    }


    //限制每天只能打一次卡
//    public void insertStack(AttendanceModel attendanceModel) throws Exception {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = formatter.format( new Date());
//        System.out.println(dateString);
//        List<AttendanceModel> list = listBySignAndDate(attendanceModel.getPersonGuid(),dateString);
//        System.out.println(list.toString());
//        if (list.size()!=0){
//            throw new NotOneResultFoundException("今天已经有该人员（"+attendanceModel.getPersonName()+"）的打卡数据了，本次打卡未添加上");
//        }
//        save(attendanceModel);
//    }

    //真实打卡数据统计（左上角）
    public StatTotalModel statAll(String categoryGuid, String date) {
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        List<AttendanceModel> list = attendanceMapper.listAttByCategory(categoryGuid, date);
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("categoryGuid", categoryGuid, "eq"));
        List<PersonModel> enterNum = personService.list(sqlQueryParams)
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(PersonModel::getIdCard))), ArrayList::new));
        Integer total = personTypeService.list(sqlQueryParams).stream()
                .map(PersonTypeModel::getPersonCount)
                .reduce(0, Integer::sum);
        Integer attNum = list.size();
        Integer noAttNum = total - attNum;
        Object percent = "0.0";
        if (total != 0) {
            percent = (float) attNum / total * 100;
        }
        StatTotalModel statTotalModel = new StatTotalModel();
        statTotalModel.setTotal(total.toString());
        statTotalModel.setEnterNum(String.valueOf(enterNum.size()));
        statTotalModel.setAttNum(attNum.toString());
        statTotalModel.setNoAttNum(noAttNum.toString());
        statTotalModel.setPercent(percent.toString());
        return statTotalModel;
    }

    //真实打卡数据统计（左上角）：将5大类别都列出来
    public List<StatTotalModel> statAllCategory(String date) {
        List<StatTotalModel> list = new ArrayList<>();
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("display", "0", "eq"));
        List<PersonCategoryModel> personCategoryModels = personCategoryService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonCategoryModel::getSortId)).collect(Collectors.toList());
        for (PersonCategoryModel personCategoryModel : personCategoryModels) {
            List<AttendanceModel> attendanceModels = attendanceMapper.listAttByCategory(personCategoryModel.getGuid(), date);
            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("categoryGuid", personCategoryModel.getGuid(), "eq"));
            List<PersonModel> enterNum = personService.list(sqlQueryParams1)
                    .stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(PersonModel::getIdCard))), ArrayList::new));
            Integer total = personTypeService.list(sqlQueryParams1).stream()
                    .map(PersonTypeModel::getPersonCount)
                    .reduce(0, Integer::sum);
            Integer attNum = attendanceModels.size();
            Integer noAttNum = total - attNum;
            Object percent = "0.0";
            if (total != 0) {
                percent = (float) attNum / total * 100;
            }
            StatTotalModel statTotalModel = new StatTotalModel();
            statTotalModel.setName(personCategoryModel.getName());
            statTotalModel.setTotal(total.toString());
            statTotalModel.setAttNum(attNum.toString());
            statTotalModel.setEnterNum(String.valueOf(enterNum.size()));
            statTotalModel.setNoAttNum(noAttNum.toString());
            statTotalModel.setPercent(percent.toString());
            list.add(statTotalModel);
        }
        return list;
    }

    //人员左下角按人员类别统计打卡
    public List<AttendanceStatModel> statByPersonCategory(String categoryGuid, String date) {
        List<AttendanceStatModel> list = new ArrayList<>();
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("categoryGuid", categoryGuid, "eq"));
        List<PersonTypeModel> personTypeModels = personTypeService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
        for (PersonTypeModel personType : personTypeModels) {
            Integer total = personTypeService.get(personType.getGuid()).getPersonCount();
            List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
            sqlQueryParams2.add(new SqlQueryParam("categoryGuid", categoryGuid, "eq"));
            sqlQueryParams2.add(new SqlQueryParam("personTypeGuid", personType.getGuid(), "eq"));
            List<PersonModel> enterNum = personService.list(sqlQueryParams2)
                    .stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(PersonModel::getIdCard))), ArrayList::new));
            AttendanceStatModel statModel = new AttendanceStatModel();
            statModel.setTypeName(personType.getFormattedName());
            statModel.setTotal(String.valueOf(total));
            statModel.setEnterNum(String.valueOf(enterNum.size()));
            List<AttendanceModel> attNum = attendanceMapper.listAttByType(personType.getGuid(), date);
            statModel.setAttNum(String.valueOf(attNum.size()));
            BigDecimal percent = BigDecimal.valueOf(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
            if (total != 0) {
                percent = new BigDecimal((float) (attNum.size()) / total * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
            statModel.setPercent(String.valueOf(percent));

            list.add(statModel);
        }
        return list;

    }

    //人员信息统计
    public List<Object> statAttendanceData(String date, Integer flag) {
        List<Object> statModels = new ArrayList<>();
        if (flag == 0) {
            statModels.add(sumAtt(null, date));
        } else if (flag == 1) {
            List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
            List<TenderModel> tenderModels = tenderService.list(sqlQueryParams2).stream().sorted(Comparator.comparing(TenderModel::getSortId)).collect(Collectors.toList());
            for (TenderModel tender : tenderModels) {
                AttStatTenderModel statModel = new AttStatTenderModel();
                statModel.setTenderGuid(tender.getGuid());
                statModel.setTenderName(tender.getName());
                statModel.setStatModels(sumAtt(tender.getGuid(), date));
                statModels.add(statModel);
            }
        }
        return statModels;
    }

    //疫情：按日期统计打卡人数
    public List<AttDateStatModel> statByMonth(String date) {
        int year = Integer.valueOf(date.substring(0, date.indexOf("-")));
        int month = Integer.valueOf(date.substring(date.indexOf("-") + 1));
        Integer days = getDaysByYearMonth(year, month);
        List<AttDateStatModel> list = new ArrayList<>();
        String day = "";
        for (int i = 1; i <= days; i++) {
            if (i < 10) {
                day = "0" + i;
            } else {
                day = String.valueOf(i);
            }
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("enterAreaTime", date + "-" + day, "like"));
            List<PersonModel> personModels = personService.list(sqlQueryParams)
                    .stream()
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(PersonModel::getIdCard))), ArrayList::new));
            AttDateStatModel findMaxAndMinTemp = attendanceMapper.findMaxAndMinTemp(date + "-" + day);
            AttDateStatModel attDateStatModel = new AttDateStatModel();
            attDateStatModel.setDate(String.valueOf(i));
            attDateStatModel.setEnterNum(String.valueOf(personModels.size()));
            if (findMaxAndMinTemp == null) {
                attDateStatModel.setMaxTemp("0");
                attDateStatModel.setMinTemp("0");
            } else {
                attDateStatModel.setMaxTemp(findMaxAndMinTemp.getMaxTemp());
                attDateStatModel.setMinTemp(findMaxAndMinTemp.getMinTemp());
            }
            list.add(attDateStatModel);
        }
        return list;
    }

    //根据a、b、s、z标来统计人数和考勤数
    public List<AttendanceStatModel> statByTenderType(String date) {
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        System.out.println(date);
        List<AttendanceStatModel> list = new ArrayList<>();
        String[] strings = {"项目办", "A", "B", "S", "Z"};
        for (String tenderType : strings) {
            AttendanceStatModel statModel = new AttendanceStatModel();
            if (tenderType.equals("项目办")) {
                tenderType = "Y";
                statModel.setTypeName("项目办");
            } else {
                statModel.setTypeName(tenderType + "标");
            }
            Integer attNum = attendanceMapper.countByTenderType(date, tenderType);
            Integer total = personService.listByTenderName(tenderType).size();
            BigDecimal percent = BigDecimal.valueOf(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
            if (!total.equals(0)) {
                percent = new BigDecimal((float) attNum / total * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
            statModel.setAttNum(attNum.toString());
            statModel.setTotal(total.toString());
            statModel.setPercent(percent.toString());
            list.add(statModel);
        }

        return list;
    }


    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static Integer getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        Integer maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    public List<AttendanceStatModel> sumAtt(String tenderGuid, String date) {
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<PersonTypeModel> personTypeModels = personTypeService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
        List<AttendanceStatModel> statModels = new ArrayList<>();
        for (PersonTypeModel personType : personTypeModels) {
            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("personTypeGuid", personType.getGuid(), "eq"));
            List<PersonModel> personModels;
            List<AttendanceModel> listByType;
            if (tenderGuid == null) {
                //查询所有标段该类型的考勤总数
                listByType = attendanceMapper.listByTypeAndDate(personType.getGuid(), date)
                        .stream().distinct().collect(Collectors.toList());
                personModels = personService.list(sqlQueryParams1);
                AttendanceStatModel statModel = new AttendanceStatModel();
                statModel.setTypeName(personType.getName());
                statModel.setTotal(String.valueOf(personModels.size()));
                statModel.setAttNum(String.valueOf(listByType.size()));
                statModels.add(statModel);
            } else {
                listByType = attendanceMapper.listByTypeAndDate(personType.getGuid(), date)
                        .stream().distinct().filter(s -> s.getTenderGuid() == tenderGuid).collect(Collectors.toList());
                sqlQueryParams1.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
                personModels = personService.list(sqlQueryParams1);

                AttendanceStatModel statModel = new AttendanceStatModel();
                statModel.setTypeName(personType.getName());
                statModel.setTotal(String.valueOf(personModels.size()));
                statModel.setAttNum(String.valueOf(listByType.size()));
                statModels.add(statModel);
            }
        }
        return statModels;

    }

    public List<PersonLocationDataModel> listPersonLocationDatas(String categoryGuid, String date) {
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        if (categoryGuid == null || categoryGuid.isEmpty()) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("flag", "1", "eq"));
            List<PersonCategoryModel> personCategoryModels = personCategoryService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonCategoryModel::getSortId)).collect(Collectors.toList());
            if (personCategoryModels.size() != 0) {
                categoryGuid = personCategoryModels.get(0).getGuid();
            }
        }
        return attendanceMapper.listPersonLocationDatas(categoryGuid, date);
    }

    //统计各市人数情况
    public List<AttendanceStatModel> countPersonByCity() {
        List<AttendanceStatModel> list = new ArrayList<>();
        List<String> listAreaCodes = personService.listAreaCode();
        for (String areaCode : listAreaCodes) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("departurePlaceCode", areaCode, "eq"));
            List<PersonModel> personNucleicInfoModels = personService.list(sqlQueryParams);
            AreaDataModel areaDataModel = areaDataService.listByCode(areaCode).get(0);
            AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
            attendanceStatModel.setTotal(String.valueOf(personNucleicInfoModels.size()));
            attendanceStatModel.setTypeName(areaDataModel.getName());
            list.add(attendanceStatModel);
        }
        return list;
    }

    public List<AttendanceStatModel> countByRisk() {
        List<AttendanceStatModel> list = new ArrayList<>();
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<PersonModel> total = personService.list(sqlQueryParams);
        String isRisks[] = {"0", "1", "2"};
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (String isRisk : isRisks) {
            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("isRisk", isRisk, "eq"));
            List<PersonModel> personModels = personService.list(sqlQueryParams1);
            AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
            attendanceStatModel.setTotal(String.valueOf(personModels.size()));
            BigDecimal percent = new BigDecimal(personModels.size()).divide(new BigDecimal(total.size()), 4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

            if (isRisk.equals("0")) {
                attendanceStatModel.setTypeName("低风险");
                attendanceStatModel.setPercent(percent.toString());

            } else if (isRisk.equals("1")) {
                attendanceStatModel.setTypeName("中风险");
                attendanceStatModel.setPercent(percent.toString());

            } else if (isRisk.equals("2")) {
                attendanceStatModel.setTypeName("高风险");
                attendanceStatModel.setPercent(new BigDecimal(100).subtract(bigDecimal).toString());

            }
            bigDecimal = percent.add(bigDecimal);

            list.add(attendanceStatModel);
        }

        return list;
    }

    //安全模块左下角安全员打卡统计
    public List<AttendanceStatModel> statBySecurity(String date) {
        if (date == null || date.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(new Date());
        }
        List<AttendanceStatModel> list = new ArrayList<>();
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("flag", "1", "eq"));
        List<PersonTypeModel> personTypeModels = personTypeService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());

        BigDecimal percent = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
        for (PersonTypeModel typeModel : personTypeModels) {
            AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
            attendanceStatModel.setTypeName(typeModel.getFormattedName());

            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("personTypeGuid", typeModel.getGuid(), "eq"));
            List<PersonModel> personModels = personService.list(sqlQueryParams1);

            attendanceStatModel.setTotal(String.valueOf(personModels.size())); // 人员表数量

            Integer arrivePerson = attendanceMapper.arrivePerson(typeModel.getGuid(), date);
            attendanceStatModel.setAttNum(String.valueOf(arrivePerson)); // 打卡人数

            if (personModels.size() != 0) {
                percent = new BigDecimal((float) arrivePerson / personModels.size() * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
            }

            attendanceStatModel.setPercent(String.valueOf(percent));
            list.add(attendanceStatModel);
        }
        return list;
    }

    // 预警信息
    public List<AttendanceModel> warningInformation() {

        return attendanceMapper.warningInformation();
    }

    // 测温情况
    public List<ReturnPersonModel> temperature() {

        return attendanceMapper.temperature();
    }

    // 统计超温的测温人的guid
    public List<String> temperaturePersonGuid() {

        return attendanceMapper.temperatureNumber(TimeHelper.dateToString(new Date()));
    }

    // 统计超温的测温人数
    public String temperatureNumber() {

        return this.temperaturePersonGuid().size() + "";
    }

    // 超温的人员
    public List<PersonModel> temperaturePerson() {

        List<String> list = this.temperaturePersonGuid();
        List<PersonModel> list1 = new ArrayList<>();
        if (list.size() > 0) {
            for (String li : list) {
                list1.add(personService.get(li));
            }
        }

        return list1;
    }

    // 按照人员类别查询当天打卡人数
    public List<ReturnModel> listByAttTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());

        return attendanceMapper.listByAttTime(date);
    }

    // 安全人员统计是否打卡
    public List<PersonModel> securityPerson(String name, String personTypeGuid, String tenderGuid, Integer flag, String categoryGuid) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());
        return attendanceMapper.securityPerson(date, name, personTypeGuid, tenderGuid, flag, categoryGuid);
    }
}
