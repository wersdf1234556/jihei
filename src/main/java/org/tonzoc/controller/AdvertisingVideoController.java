package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.AdvertisingVideoQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.service.IAdvertisingVideoService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("advertisingVideo")
public class AdvertisingVideoController extends BaseController{

    @Autowired
    private IAdvertisingVideoService advertisingVideoService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AdvertisingVideoQueryParams advertisingVideoQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AdvertisingVideoModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(advertisingVideoQueryParams);
        List<AdvertisingVideoModel> list = advertisingVideoService.list(sqlQueryParams);
        list = advertisingVideoService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AdvertisingVideoModel advertisingVideoModel) throws ParseException {

        advertisingVideoModel.setCurrentTime(TimeHelper.stringToDate(advertisingVideoModel.getCurrentDate()));
        this.advertisingVideoService.save(advertisingVideoModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AdvertisingVideoModel advertisingVideoModel) throws ParseException {

        advertisingVideoModel = advertisingVideoService.updateTime(advertisingVideoModel);
        this.advertisingVideoService.update(advertisingVideoModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.advertisingVideoService.remove(guid);
    }

    @DeleteMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        advertisingVideoService.removeMany(guids);
    }

    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, String currentTime) {

        return advertisingVideoService.upFile(file, currentTime);
    }
}
