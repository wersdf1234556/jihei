package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.support.ReturnPersonModel;
import org.tonzoc.service.IPersonService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, PersonQueryParams personQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<PersonModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(personQueryParams);

        List list = personService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid PersonModel personModel ) throws Exception {
        this.personService.insertStack(personModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid PersonModel personModel) throws Exception {
        this.personService.updateStack(personModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.personService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        personService.removeMany(guids);
    }
    /*
    手机端登录验证
    */
    @PostMapping(value = "login")
    public PersonModel login(String sign,String password,Integer flag) throws Exception {
        return personService.login(sign,password,flag);
    }

    //人员上传证书照片/人员照片
    @PostMapping(value = "upFile")
    public void upFile(String guid, MultipartFile file, Integer flag) {
        personService.upFile(guid,file,flag);
    }


    // 模板导入
    @PostMapping(value = "addPerson")
    public List<ReturnPersonModel> addPerson(MultipartFile file) throws Exception {

       return personService.addPerson(file);
    }

    @PatchMapping(value = "password")
    public void password(String personGuid, String oldPassword, String newPassword) {
        PersonModel personModel = this.personService.get(personGuid);
        personModel.setPassword(newPassword);
        this.personService.update(personModel);
    }

    @GetMapping(value = "attendanceCount")
    public PageResponse attendanceCount(PageQueryParams pageQueryParams, String tenderGuid, String name, String idCard, String mobile) throws PageException {

        Page<PersonModel> page = parsePage(pageQueryParams);

        List<PersonModel> list = personService.attendanceCount(tenderGuid, name, idCard, mobile);

        return new PageResponse(page.getTotal(), list);
    }
}
