package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.common.ExcelPersonHelper;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.mapper.PersonMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.support.ReturnPersonModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IPersonCategoryService;
import org.tonzoc.service.IPersonService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class PersonService extends BaseService<PersonModel> implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IPersonTypeService personTypeService;

    @Autowired
    private ExcelPersonHelper excelPersonHelper;

    public List<String> listAreaCode(){
        return personMapper.listAreaCode();
    }

    public PersonModel listBySign(String sign, Integer flag) throws Exception {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        if (flag==0){//用身份证号登陆
            sqlQueryParams.add(new SqlQueryParam("idCard", sign, "eq"));
        }else if (flag==1){//用手机号登陆
            sqlQueryParams.add(new SqlQueryParam("mobile", sign, "eq"));
        }

        List<PersonModel> list = this.list(sqlQueryParams);
        if (list.size()==0){
            throw new NotFoundException("不存在该人员");
        }else if (list.size()>1){
            throw new NotOneResultFoundException("该人员识别字段不唯一，存在多条");
        }

        return list.get(0);
    }


    @Override
    public List<PersonModel> listByTenderName(String tenderName) {
        return personMapper.listByTenderName(tenderName);
    }

    public PersonModel login(String sign, String password,Integer flag) throws Exception {
        /**
         * create by: fang
         * description:本方法用于人员登录手机端，验证密码是否正确
         * create time: 9:37 2021-1-5
         *
          * @Param: sign  人员的唯一标识
        * @Param: password   传过来的登录密码
         * @return org.tonzoc.model.PersonModel
         */
        PersonModel personModel = listBySign(sign,flag);
        String patchPassword = personModel.getPassword();
        if (!password.equals(patchPassword)){
            throw new NotMatchException("输入的密码（Password: " + password + "）不正确");
        }
        return personModel;
    }

    public void insertStack(PersonModel personModel) throws Exception {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", personModel.getIdCard(), "eq"));
        List<PersonModel> list = this.list(sqlQueryParams);
        if (list.size()>0){
            throw new NotOneResultFoundException("该人员已存在，请检查身份证号是否正确");
        }
        List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
        sqlQueryParams2.add(new SqlQueryParam("mobile", personModel.getMobile(), "eq"));
        List<PersonModel> list2 = this.list(sqlQueryParams);
        if (list2.size()>0){
            throw new NotOneResultFoundException("该人员已存在，请检查手机号是否正确");
        }
        personModel.setPassword("123456");
        personModel.setCategoryGuid(personTypeService.get(personModel.getPersonTypeGuid()).getCategoryGuid());
        save(personModel);
    }

    public void updateStack(PersonModel personModel) throws Exception {
        if (personModel.getIdCard() != null || !"".equals(personModel)){
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
            sqlQueryParams.add(new SqlQueryParam("idCard", personModel.getIdCard(), "eq"));
            sqlQueryParams.add(new SqlQueryParam("guid", personModel.getGuid(), "neq"));
            List<PersonModel> list = this.list(sqlQueryParams);
            if (list.size() > 0){
                throw new NotOneResultFoundException("该人员已存在，请检查身份证号是否正确");
            }
        }
        if (personModel.getPhoto() != null || !"".equals(personModel)) {
            List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
            sqlQueryParams2.add(new SqlQueryParam("mobile", personModel.getMobile(), "eq"));
            sqlQueryParams2.add(new SqlQueryParam("guid", personModel.getGuid(), "neq"));
            List<PersonModel> list2 = this.list(sqlQueryParams2);
            if (list2.size() > 0){
                throw new NotOneResultFoundException("该人员已存在，请检查手机号是否正确");
            }
        }

        //不修改密码
        personModel.setPassword(null);
        System.out.println("personModel" + personModel);
        System.out.println(personModel.getPersonTypeGuid() + "a");
        personModel.setCategoryGuid(personTypeService.get(personModel.getPersonTypeGuid()).getCategoryGuid());
        update(personModel);
    }

    public void upFile(String guid, MultipartFile file, Integer flag) {
        String url = "/人员/";
        if (flag == 0){//人员照片
            url = url + "人员照片/";
        }else if (flag == 1){//证书照片
            url = url + "证书照片/";
        }

        intelliSiteProperties.setFileUrl(url);
        String[] str = fileHelper.fileUpload(file, "", "");
        String uuid = fileHelper.newGUID();
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(uuid);
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setFileType("0");
        attachmentModel.setQualityTraceabilityGuid("");

        attachmentService.save(attachmentModel);
        PersonModel personModel = get(guid);

        if (flag == 0){
            if (personModel.getPhoto() != null && !"".equals(personModel.getPhoto())) {
                attachmentService.deleteFile(personModel.getPhoto());
            }
            personModel.setPhoto(attachmentModel.getGuid());
        }else if (flag == 1){
            if (personModel.getCertificatePic() != null && !"".equals(personModel.getCertificatePic())) {
                attachmentService.deleteFile(personModel.getCertificatePic());
            }
            personModel.setCertificatePic(attachmentModel.getGuid());
        }
        update(personModel);

        intelliSiteProperties.setFileUrl("/");
    }

    // 模板导入
    @Override
    public List<ReturnPersonModel> addPerson(MultipartFile file) throws Exception {

       return excelPersonHelper.excel(file);
    }

}
