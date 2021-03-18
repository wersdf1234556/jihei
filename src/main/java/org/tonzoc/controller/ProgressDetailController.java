package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProgressDetailQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.model.support.ProgressStatModel;
import org.tonzoc.service.IProgressDetailService;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("progressDetail")
public class ProgressDetailController extends BaseController {

    @Autowired
    private IProgressDetailService progressDetailService;
    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProgressDetailQueryParams progressDetailQueryParams,String accounType, String flag)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProgressDetailModel> page = parsePage(pageQueryParams);
        // 监理
        if (accounType != null) {
            if (accounType.equals("2") && "0".equals(flag)){
                // flag = 0 施工单位查到未提交，监理查不到
                progressDetailQueryParams.setStatus("submitted,unFinish,finish");
            }else if (accounType.equals("0") && "1".equals(flag)){
                progressDetailQueryParams.setStatus("submitted,unFinish,finish");
            }
        }

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(progressDetailQueryParams);

        List list = progressDetailService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProgressDetailModel progressDetailModel) {
        this.progressDetailService.insertStack(progressDetailModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProgressDetailModel progressDetailModel) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        this.progressDetailService.updateStack(progressDetailModel,userModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        this.progressDetailService.removeStack(guid,userModel);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        progressDetailService.batchRemoveStack(guids,userModel);
    }

    @GetMapping(value = "statCurrentMonth")
    public List<ProgressStatModel> statCurrentMonth(String tender,String date){
        return progressDetailService.statCurrentMonth(tender,date);
    }

    //提交
    @PostMapping(value = "submit")
    public void submit(String progressGuid){
        progressDetailService.submit(progressGuid);
    }
    //审批
    @PostMapping(value = "approval")
    public void approval(String progressGuid,Integer flag) throws Exception {
        progressDetailService.approval(progressGuid,flag);
    }

    //批量审批
    @PostMapping(value = "batchApproval")
    public void batchApproval(String progressGuids,Integer flag) throws Exception{
        progressDetailService.batchApproval(progressGuids,flag);
    }
}
